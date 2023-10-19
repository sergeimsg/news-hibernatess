package it.academy.by.spring.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.protobuf.ServiceException;

import it.academy.by.spring.dao.UserDao;

import it.academy.by.spring.dao.exception.DAOException;

import it.academy.by.spring.model.entity.UserDetailsEntity;
import it.academy.by.spring.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	
	private final UserDao userDao;
	
	

		
	public UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}




	@Transactional
	@Override
	public void registration(UserDetailsEntity userDetailsEntity) throws ServiceException {
		
		
		try {
			userDao.registration(userDetailsEntity);
		} catch (DAOException e) {
			
			
			throw new ServiceException(e);
		}
		
		
		
	}
}
