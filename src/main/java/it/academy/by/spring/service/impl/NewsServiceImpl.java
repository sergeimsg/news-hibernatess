package it.academy.by.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.protobuf.ServiceException;

import it.academy.by.spring.dao.NewsDao;
import it.academy.by.spring.dao.UserDao;

import it.academy.by.spring.dao.exception.DAOException;
import it.academy.by.spring.model.bean.NewsDataBeanGeneral;
import it.academy.by.spring.model.entity.NewsEntity;
import it.academy.by.spring.model.entity.UserDetailsEntity;
import it.academy.by.spring.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {
	
	
	private final NewsDao newsDao;
	private final UserDao userDao;
	
	
	@Autowired
	public NewsServiceImpl(NewsDao newsDao, UserDao userDao) {
		super();
		this.newsDao = newsDao;
		this.userDao = userDao;
	}



	@Transactional
	@Override
	public List<NewsEntity> findNews() throws ServiceException{
		
				
		try {
			return newsDao.findNews();
			
		} catch (DAOException e) {
			
			
			throw new ServiceException(e);
		}
	}



	@Transactional
	@Override
	public List<NewsDataBeanGeneral> getNews() throws ServiceException {
		// TODO Auto-generated method stub
		return null;
	}



	@Transactional
	@Override
    public      List<NewsDataBeanGeneral> getNews(String count) throws ServiceException {
		
		try {
			int countNews = Integer.parseInt(count);
			
			System.out.println("we are in news service countNews = " + countNews);
			
			List<NewsEntity> news = newsDao.getNews(countNews);
			
		//	System.out.println("From DAO " + news.toString());
			
			return getNewsDataBeanGeneral(news);
			
		} catch (DAOException e) {
			
			throw new ServiceException(e);
		}
		
				
		
	}
	
				
	private List<NewsDataBeanGeneral> getNewsDataBeanGeneral(List<NewsEntity> newsEntities){
		List<NewsDataBeanGeneral> newsList = new ArrayList<>(newsEntities.size());
		for (NewsEntity entity: newsEntities){
			NewsDataBeanGeneral news = new NewsDataBeanGeneral();
			news.setId(entity.getId());
			news.setTitle(entity.getTitle());
			news.setBrief(entity.getBriefNews());
			news.setCreateDate(entity.getCreateDate().toString());
			newsList.add(news);
		}
		return newsList;
	}



	@Transactional
	@Override
	public void saveUpdatedNews(NewsEntity newsEntity) throws ServiceException {
		
		
		try {
			
		          newsDao.saveUpdatedNews(newsEntity);
			
		} catch (DAOException e) {
			
			throw new ServiceException(e);
			
		}
		
	}



	@Transactional
	@Override
	public void saveNewNews(NewsEntity newsEntity, String username) throws ServiceException {
		
		try {
			
			
			UserDetailsEntity userDetailsEntity = userDao.findUserByUserName(username);
			newsDao.saveNewNews(newsEntity, userDetailsEntity);
			
		} catch (DAOException e) {
			
			throw new ServiceException(e);
			
		}
		
	}


	@Transactional
	@Override
	public NewsEntity findById(String id) throws ServiceException {
		
				
		
		try {
			
			 NewsEntity newsEntity = newsDao.findById(id);
		
				 
			 return newsEntity;
			
			
		} catch (DAOException e) {
			
				
			throw new ServiceException(e);
		}
	}


	@Transactional(readOnly = true)
	@Override
	public NewsEntity findToReadById(String id) throws ServiceException {
		
		
		try {
			
			NewsEntity newsEntity = newsDao.finToReadById(id);
			
			return newsEntity;
			
		} catch (DAOException e) {
			
			throw new ServiceException(e);
		}
		
		
		
	}

	

	

	@Transactional
	@Override
	public void deleteSomeNews(String[] id) throws ServiceException {
		
		try {
			
			System.out.println("service to delete " + id.toString());
			
			List<Integer> idList = new ArrayList<>(id.length);
			
			for (String idStr : id) {
				
				Integer n = Integer.parseInt(idStr);
				idList.add(n);
								
			}
						
			newsDao.deleteSomeNews(idList);
			
			
		} catch (DAOException e) {
			
			throw new ServiceException(e);
		}
		
		
	}
	
	
	

}
