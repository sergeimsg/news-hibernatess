package it.academy.by.spring.service;

import java.util.List;

import com.google.protobuf.ServiceException;

import it.academy.by.spring.model.bean.NewsDataBeanGeneral;
import it.academy.by.spring.model.entity.NewsEntity;

public interface NewsService {

	public List<NewsEntity> findNews() throws ServiceException;
	
    List<NewsDataBeanGeneral> getNews() throws ServiceException;
	
	List<NewsDataBeanGeneral> getNews(String count) throws ServiceException;
	
	NewsEntity findById(String id) throws ServiceException;
	
	NewsEntity findToReadById(String id) throws ServiceException;
	
	void deleteSomeNews(String[] id) throws ServiceException;
	
	
	void saveUpdatedNews(NewsEntity newsEntity) throws ServiceException;
	
	void saveNewNews(NewsEntity newsEntity, String username) throws ServiceException;
	
	
}
