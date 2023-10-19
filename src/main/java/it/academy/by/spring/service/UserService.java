package it.academy.by.spring.service;

import com.google.protobuf.ServiceException;

import it.academy.by.spring.model.entity.UserDetailsEntity;

public interface UserService {
	
	 void registration(UserDetailsEntity userDetailsEntity) throws ServiceException;

}
