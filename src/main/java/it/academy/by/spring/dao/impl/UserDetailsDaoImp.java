package it.academy.by.spring.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.academy.by.spring.dao.UserDetailsDao;
import it.academy.by.spring.model.entity.*;

@Repository
public class UserDetailsDaoImp implements UserDetailsDao {

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public User findUserByUsername(String username) {
    return sessionFactory.getCurrentSession().get(User.class, username);
  }
}
