package it.academy.by.spring.dao;

import it.academy.by.spring.dao.exception.DAOException;
import it.academy.by.spring.model.entity.User;
import it.academy.by.spring.model.entity.UserDetailsEntity;

public interface UserDao {
	
	
	
	  void registration(UserDetailsEntity userDetailsEntity) throws DAOException;
	  
	  	  
	  UserDetailsEntity findUserByUserName(String username) throws DAOException;
	  

}
