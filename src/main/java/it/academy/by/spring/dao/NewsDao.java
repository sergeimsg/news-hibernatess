package it.academy.by.spring.dao;

import java.util.List;

import it.academy.by.spring.dao.exception.DAOException;
import it.academy.by.spring.model.entity.NewsEntity;
import it.academy.by.spring.model.entity.UserDetailsEntity;

public interface NewsDao {

	List<NewsEntity> findNews() throws DAOException;
	NewsEntity findById(String id) throws DAOException;
	NewsEntity finToReadById(String id) throws DAOException;
	
	void deleteSomeNews (List<Integer> id) throws DAOException;
	
	
	List<NewsEntity> getNews() throws DAOException;
	
	List<NewsEntity> getNews(int count) throws DAOException;
	
	void saveUpdatedNews(NewsEntity newsEntity) throws DAOException;
	
	void saveNewNews(NewsEntity newsEntity, UserDetailsEntity entity) throws DAOException;
	
	
	
}
