package it.academy.by.spring.dao.impl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.academy.by.spring.dao.NewsDao;
import it.academy.by.spring.dao.exception.DAOException;
import it.academy.by.spring.model.entity.NewsEntity;
import it.academy.by.spring.model.entity.UserDetailsEntity;


@Repository
public class NewsDaoImpl implements NewsDao {

	
	@Autowired
	private SessionFactory sessionFactory;
	
	public NewsDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<NewsEntity> findNews() throws DAOException{
		
		
		try {
			
			Session session = sessionFactory.getCurrentSession();
			Query<NewsEntity> query = session.createQuery("FROM NewsEntity ORDER BY createDate DESC", NewsEntity.class);
			
			System.out.println("we have something" + query.getResultList().toString());
				
		
		  //  System.out.println(sessionFactory.getCurrentSession().get(NewsEntity.class, "1").toString());
			
			
			return session.createQuery("FROM NewsEntity ORDER BY createDate DESC", NewsEntity.class).getResultList();	
			
			
		} catch (Exception e) {
			
			throw new DAOException(e);
			
		}
		
			
			
		
		
	}

	@Override
	public List<NewsEntity> getNews() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NewsEntity> getNews(int count) throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUpdatedNews(NewsEntity newsEntity) throws DAOException {
		
		try {
			
			Session session = sessionFactory.getCurrentSession();
			
			session.update(newsEntity);
			
			
		} catch (Exception e) {
			
			
			throw new DAOException(e);
		}
		
			
	}

	
	
	@Override
	public void saveNewNews(NewsEntity newsEntity, UserDetailsEntity userDetailsEntity) throws DAOException {
		
		try {
			
			Session session = sessionFactory.getCurrentSession();
			
			newsEntity.setUserDetailsEntity(userDetailsEntity);
			
			
			session.saveOrUpdate(newsEntity);
			
		} catch (Exception e) {
			
			
			throw new DAOException(e);
			
		}
		
		
	}

	
	@Override
	public NewsEntity findById(String count) throws DAOException {
		
		
		try {
			
			int id = Integer.parseInt(count);
		
		Session session = sessionFactory.getCurrentSession();
		
		NewsEntity newsEntity = session.get(NewsEntity.class, id);
		
			
		return newsEntity;
		
			
		} catch (Exception e) {
			
			throw new DAOException(e);
		}
             
		
	}

	@Override
	public NewsEntity finToReadById(String count) throws DAOException {
		
		
		try {
			
			int id = Integer.parseInt(count);
		
		Session session = sessionFactory.getCurrentSession();
		
		NewsEntity newsEntity = session.get(NewsEntity.class, id);
		
			
		return newsEntity;
		
			
		} catch (Exception e) {
			
			throw new DAOException(e);
		}
             
	}

	@Override
	public void deleteSomeNews(List<Integer> id) throws DAOException {
		
		
		try {
			
			System.out.println("list to delete " + id.toString());
			Session session = sessionFactory.getCurrentSession();
			
			Query<?> query = session.createQuery("DELETE FROM NewsEntity WHERE id IN (:id)");
			
			query.setParameterList("id", id).executeUpdate();
			
			session.flush();
			
			
			
			
		} catch (Exception e) {
			
			throw new DAOException(e);
		}
		
		
	}

	
	
	
}
