package com.shop.service;

import java.util.ArrayList;

import com.shop.model.Address;
import com.shop.model.Role;
import com.shop.repository.UserDao;
import com.shop.model.DAOUser;
import com.shop.model.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder bcryptEncoder;

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		if ("javainuse".equals(username)) {
//			return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
//					new ArrayList<>());
//		} else {
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//	}

    public DAOUser getUser(long id) {
        return userDao.findById(id).get();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        DAOUser user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                new ArrayList<>());
    }

    public DAOUser save(UserDTO user) {
        DAOUser newUser = new DAOUser();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        System.out.println("@@ " + user.getUsername());
        System.out.println("@@ " + bcryptEncoder.encode(user.getPassword()));
        newUser.setRole(Role.USER);
        return userDao.save(newUser);
    }

    public DAOUser changeUsername(DAOUser user) {
        DAOUser daoUser = userDao.findById(user.getId()).get();
        daoUser.setUsername(user.getUsername());
        return userDao.save(daoUser);
    }

    public DAOUser changePassword(DAOUser user) {
        DAOUser daoUser = userDao.findById(user.getId()).get();
        daoUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        return userDao.save(daoUser);
    }

    public DAOUser changeAddress(DAOUser user, Address address) {
        DAOUser daoUser = userDao.findById(user.getId()).get();
        daoUser.setAddress(address);
        return userDao.save(daoUser);
    }
}