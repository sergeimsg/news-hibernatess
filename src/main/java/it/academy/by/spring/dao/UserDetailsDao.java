package it.academy.by.spring.dao;



import it.academy.by.spring.model.entity.User;



public interface UserDetailsDao {
  
 
  
   User findUserByUsername(String username);
  
  
  
}
