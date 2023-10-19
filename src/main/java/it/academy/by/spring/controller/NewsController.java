package it.academy.by.spring.controller;


import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.google.protobuf.ServiceException;


import it.academy.by.spring.model.entity.NewsEntity;
import it.academy.by.spring.service.NewsService;

@Controller
@RequestMapping("/news")
public class NewsController {
	
	private final NewsService newsService;

	@Autowired
	public NewsController(NewsService newsService) {
		
		this.newsService = newsService;
	}
	
	
	
	@GetMapping("/goToBasePage")
	public String goToBasePage(Model model) {
		
		try {
			
						
		
			List<NewsEntity> newsEntity = newsService.findNews();
			  // System.out.println("printing news " + news.toString());
			
		   	System.out.println("we are in controller " + newsEntity.toString());
			 
			  model.addAttribute("news1", newsEntity);
			  model.addAttribute("action", "newsList");
			  
			  System.out.println("we are in goToBasePage - baseLayout/baseLayout");
			  
			  return "baseLayout/baseLayout";
			 
			
		} catch (ServiceException e) {
			
			System.out.println("we are in ServiceException - /news/errorPage");
			
				return "redirect:/news/errorPage";
				
		}
		
	
		
	}
	
			
		@GetMapping("/editNews")
	    public String editNews(@RequestParam("newsIdToEdit") String newsId, Model model, HttpSession session) {
			
			try {
				
				  				  
				  
				  NewsEntity newsEntity = (NewsEntity) newsService.findById(newsId);
				              	 			  				  
				  model.addAttribute("newsEntity", newsEntity);
				  model.addAttribute("action", "editNews");
				  
				 		  
				  return "baseLayout/baseLayout";
				 
				
			} catch (ServiceException e) {
				
								
					return "redirect:/news/errorPage";
	    
	          }
		
		}
		
		
		@GetMapping("/newsList")
	    public String newsList( Model model, HttpSession session) {
			
			try {
				
				  System.out.println("try started in news list");

					
				  List<NewsEntity> newsEntity = newsService.findNews();
												             	
				  				  
				  model.addAttribute("news1", newsEntity);
				  model.addAttribute("action", "newsList");
				  
				  				  
				  return "baseLayout/baseLayout";
				 
				
			} catch (ServiceException e) {
				
								
					return "redirect:/news/errorPage";
	    
	          }
		
		}
		
		
		
		@PostMapping("/saveUpdatedNews")
		public String updateNews(@ModelAttribute("newsEntity") NewsEntity theNewsEntity) {
			
			try {
				
				String newsPath;
	
				if (theNewsEntity.getImagePath().startsWith("/")  ) {
					
							newsPath = theNewsEntity.getImagePath();
	
					
				}  else {
					
					newsPath = "/resources/images/newsImages/"+theNewsEntity.getImagePath();
					
					
				}
				
				theNewsEntity.setImagePath(newsPath);
		
				newsService.saveUpdatedNews(theNewsEntity);
				
				
				return "redirect:/news/newsList";
				
			} catch (Exception e) {
				
				return  "redirect:/news/errorPage";
			}
			
		}
		
		
		
		@GetMapping("/readNews")
	    public String readNews(@RequestParam("newsIdToRead") String newsId, Model theModel, HttpSession session) {
	    	
			try {
				
				  
				  NewsEntity newsEntity = newsService.findToReadById(newsId);  
				  				  
				  theModel.addAttribute("newsEntity", newsEntity);
				  theModel.addAttribute("action", "readNews");
				  
				  System.out.println("we are in edit news - baseLayout/baseLayout");
				  
				  return "baseLayout/baseLayout";
				 
				
			} catch (ServiceException e) {
				
								
					return "redirect:/news/errorPage";
	    
	          }
	    	
	    }
		
		
		@GetMapping("/addNews")
	    public String addNews(Model theModel, HttpSession session) {
	    	
	    	
			
					
			try {
				
				System.out.println("add news ");
				NewsEntity newsEntity = new NewsEntity();
							
				theModel.addAttribute("newsEntity", newsEntity); 
				theModel.addAttribute("action", "addNews");
				
				return "baseLayout/baseLayout";
				
				
			} catch (Exception e) {
				
				return "redirect: /news/errorPage";
				
			}
			
			
	    
	    }
		
		
		@PostMapping("/saveNewNews")
		public String saveNewNews(@ModelAttribute("newsEntity") NewsEntity theNewsEntity, @RequestParam("username") String username) {
			
//			System.out.println("Save news started ");		
//			System.out.println("-------------------"+username+"from new news " + theNewsEntity.toString());
			
			try {
				
				String newsPath;
	
				if (theNewsEntity.getImagePath().startsWith("/")  ) {
					
							newsPath = theNewsEntity.getImagePath();
	
					
				}  else {
					
					newsPath = "/resources/images/newsImages/"+theNewsEntity.getImagePath();
					
					
				}
				
				theNewsEntity.setImagePath(newsPath);
				
		//		System.out.println("To save news" + theNewsEntity.toString());
		
			  	newsService.saveNewNews(theNewsEntity, username);
				
				
				return "redirect:/news/newsList";
				
			} catch (Exception e) {
				
				return  "redirect:/news/errorPage";
			}
			
		}
	   
		
		
		@PostMapping("/admin/doDeleteSomeNews")
		private String deleteNews (@RequestParam ("news") String[] news) {
			
			
			try {
				
					System.out.println("controller delete " + news.toString());
				newsService.deleteSomeNews(news);
				
				
				return "redirect:/news/newsList";
				
				
			} catch (Exception e) {
				
				return "redirect: /news/errorPage";
			}
			
			
			
			
		}
	
		@GetMapping("/changeLocale")
		public String changeClocale(HttpServletRequest request, Locale locale) {
			
			String refererFromHeader = request.getHeader("referer");
			
			//System.out.println( "Change locale works "+  refererFromHeader);
			
			return "redirect:" + getRequestURL(refererFromHeader);
								
		}
		
		private String getRequestURL(String referer) {
					
			URI uri;
			String path;
			
			try {
				
			//	System.out.println("we gave referer " + referer);
				
				uri = new URI(referer);
				
				path = uri.getPath();
				
			//	System.out.println(uri + " from uri Path before Query" + path);
				if (uri.getQuery() != null) {
					
					path = "http://localhost:8080"+path + "?" + uri.getQuery();
					
				}
				
				else {
					path = "http://localhost:8080" + path;
				}
				
			} catch (URISyntaxException e) {
				
				throw new RuntimeException(e);
				
			}
			
		//	System.out.println("path after where we go " + path);
			return path;		
			
		}
			
		
		@GetMapping("/goToNewsList")
		public String goToNewsList(Locale locale,
								   Model model) {
			try {
				List<NewsEntity> news = newsService.findNews();

				model.addAttribute("news", news);
				
				System.out.println(news.toString());
				model.addAttribute("action", "newsList");
				return "baseLayout/baseLayout";
			} 
			catch (ServiceException e) {
				return "redirect:/news/errorPage";
			}
			
		}	
	
		@GetMapping("/login")
		public String loginForm() {
			return "login";
			
			
		}
	
		
		@GetMapping("/errorPage")
		public String errorPage() {
			

			return "tiles/error";
			
			
		}
	
	
	

}
