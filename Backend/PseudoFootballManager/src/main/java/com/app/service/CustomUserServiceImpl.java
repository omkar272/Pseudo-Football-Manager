package com.app.service;

import static java.util.Collections.emptyList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.dao.IUserDao;
import com.app.pojos.Users;

@Service
@Transactional
public class CustomUserServiceImpl implements ICustomUserService {
	@Autowired
	IUserDao userDao;
	
	@Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
 
	 Users u=userDao.findByEmail(userName);
	
	 if(userName.equals(u.getEmail()))
	{
		 return new User(u.getEmail(),u.getPassword(),emptyList());
	}
	 else {
		 throw new UsernameNotFoundException(userName);
	 }
 }

}
