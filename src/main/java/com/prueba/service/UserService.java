package com.prueba.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.Utils.AES256Util;
import com.prueba.Utils.DateUtil;
import com.prueba.Utils.Validation;
import com.prueba.dto.UserDto;
import com.prueba.exception.ExceptionMessage;
import com.prueba.mapper.UserMapper;
import com.prueba.model.LoginRequest;
import com.prueba.model.User;

@Service
@Transactional
public class UserService implements UserImplService {

	private List<User> users = new ArrayList<>();

	@Override
	public User byId(String id) {
		
		User user2 = new User();
		for (User u : users) {
			
			if (u.getId().equals(id)) {

				user2.setId(u.getId());
				user2.setName(u.getName());
				user2.setEmail(u.getEmail());
				user2.setPhone(u.getPhone());
				user2.setPassword(u.getPassword());
				user2.setTaxid(u.getTaxid());
				user2.setCreatedat(u.getCreatedat());
				user2.setAdress(u.getAdress());
			}
		}
		
		return user2;
	}

	@Override
	public UserDto createUser(User user) {
		
		for(User u: users) {
			if(u.getTaxid().equals(user.getTaxid())) {
				throw new ExceptionMessage("Usuario ya registrado");
			}
		}

		if (!Validation.isValidPhone(user.getPhone())) {
			throw new ExceptionMessage("número invalido");
		}

		if (!Validation.isValidRFC(user.getTaxid())) {
			throw new ExceptionMessage("rfc invalido");
		}

		String id = UUID.randomUUID().toString();

		user.setId(id);
		user.getName();
		user.getEmail();
		user.setCreatedat(String.valueOf(DateUtil.getCurrentMadagascarTime()));
		try {
			user.setPassword(AES256Util.encrypt(user.getPassword()));
		} catch (Exception e) {

			e.printStackTrace();
		}
		user.getAdress();

		users.add(user);

		UserDto user2 = UserMapper.userCreate(user);

		return user2;

	}

	@Override
	public UserDto updateUser(String id, User user) {
		User user2 = new User();
		
		if (!Validation.isValidPhone(user.getPhone())) {
			throw new ExceptionMessage("número invalido");
		}

		if (!Validation.isValidRFC(user.getTaxid())) {
			throw new ExceptionMessage("rfc invalido");
		}

		for (User u : users) {
			if (u.getId().equals(id)) {
				users.remove(u);
				user2.setId(u.getId());
				user2.setName(user.getName());
				user2.setEmail(user.getEmail());
				user2.setPhone(user.getPhone());
				user2.setPassword(user.getPassword());
				user2.setTaxid(user.getTaxid());
				user2.setCreatedat(u.getCreatedat());
				user2.setAdress(u.getAdress());
				users.add(user2);
				break;
			}

		}

		UserDto userDto = UserMapper.userUpdate(user2);

		return userDto;
	}

	@Override
	public boolean deleteUser(String id) {
		boolean b = false;
		for (User u : users) {
			if (u.getId().equals(id)) {
				users.remove(u);
				b = true;
				break;
			} else {
				b = false;
			}

		}
		
		return b;
	}

	@Override
	public boolean loginUser(LoginRequest login) {
		boolean b = false;
		try {

			for (User user : users) {
				String password = AES256Util.encrypt(login.getPassword());

				if (user.getTaxid().equals(login.getTaxId()) && user.getPassword().equals(password)) {

					b = true;
				} else {
					b = false;
				}
			}
		} catch (Exception e) {

		}

		return b;
	}

	@Override
	public List<User> getUserById(String sortedBy, String order) {
		 if (sortedBy == null || sortedBy.isEmpty()) {
	            return users;
	        }

	        Comparator<User> comparator;

	        switch (sortedBy) {
	            case "id":
	                comparator = Comparator.comparing(User::getId);
	                break;
	            case "email":
	                comparator = Comparator.comparing(User::getEmail);
	                break;
	            case "name":
	                comparator = Comparator.comparing(User::getName);
	                break;
	            case "phone":
	                comparator = Comparator.comparing(User::getPhone);
	                break;
	            case "tax_id":
	                comparator = Comparator.comparing(User::getTaxid);
	                break;
	            case "created_at":
	                comparator = Comparator.comparing(User::getCreatedat);
	                break;
	            default:
	                return users;
	        }

	        if ("desc".equalsIgnoreCase(order)) {
	            comparator = comparator.reversed();
	        }

	        return users.stream().sorted(comparator).collect(Collectors.toList());
	}
	
	public List<User> filterUsers(String filter) {
        if (filter == null || filter.isEmpty()) {
            throw new IllegalArgumentException("El parámetro filter no puede estar vacío");
        }

        String[] partes = filter.split("\\+");
        if (partes.length != 3) {
            throw new IllegalArgumentException("El parámetro filter debe tener formato atributo+operador+valor");
        }

        String attr = partes[0];
        String op = partes[1];
        String valor = partes[2];

        return users.stream().filter(user -> {
            String campo = null;
            switch (attr) {
                case "id": campo = String.valueOf(user.getId()); break;
                case "email": campo = user.getEmail(); break;
                case "name": campo = user.getName(); break;
                case "phone": campo = user.getPhone(); break;
                case "tax_id": campo = user.getTaxid(); break;
                case "created_at": campo = user.getCreatedat().toString(); break;
            }
            if (campo == null) return false;

            switch (op) {
                case "eq": return campo.equals(valor);
                case "co": return campo.contains(valor);
                case "sw": return campo.startsWith(valor);
                case "ew": return campo.endsWith(valor);
                default: return false;
            }
        }).collect(Collectors.toList());
    }

}
