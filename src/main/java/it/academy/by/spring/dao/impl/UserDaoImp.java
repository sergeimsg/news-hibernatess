package it.academy.by.spring.dao.impl;



import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.academy.by.spring.dao.UserDao;

import it.academy.by.spring.dao.exception.DAOException;

import it.academy.by.spring.model.entity.UserDetailsEntity;



@Repository
public class UserDaoImp implements UserDao {

  @Autowired
  private SessionFactory sessionFactory;

	  @Override
	  public UserDetailsEntity findUserByUserName(String username) throws DAOException {
		  
		  try {
			
			   Session session = sessionFactory.getCurrentSession(); 
		 
			   Query<UserDetailsEntity> query = session.createQuery("FROM UserDetailsEntity WHERE name = :name", UserDetailsEntity.class);
			   query.setParameter("name", username);
			   
			   System.out.println("+++++++++ userDetails = " + query.getResultList().toString());
			
			return Optional.of(query.getSingleResult()).get();
		
		 
				 
				 
		} catch (Exception e) {
			
			 throw new DAOException(e);
		}
		  
		
		 
	    
	  }

	@Override
	public void registration(UserDetailsEntity userDetailsEntity) throws DAOException {
		
		
		try {
			
			sessionFactory.getCurrentSession().saveOrUpdate(userDetailsEntity);
			
		} catch (Exception e) {
			
			throw new DAOException(e);
		}
		
		
		
		
		
	}

	

	


	

  
}
