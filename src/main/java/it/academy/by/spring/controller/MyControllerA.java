package it.academy.by.spring.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.academy.by.spring.service.NewsService;


@Controller
public class MyControllerA {
	
	
		private final NewsService newsService;
		
		
	
	@Autowired	
	public MyControllerA(NewsService newsService) {
			super();
			this.newsService = newsService;
		}

	@GetMapping("/")
	  public String indexX(Model model, Principal principal) {
	//	System.out.println("Here I am&   @GetMapping(/ ??????  " + principal.getName());
		
	  //  model.addAttribute("message", "You are logged in as " + "kazanova" + "  or  " + principal.getName());
	    return "index";
	  }
	
	int i = 0; 
	@GetMapping("/login")
	  public String indexLogin(Model model, Principal principal) {
		
		System.out.println("Here I am  &   @  GetMapping(\"/login");
		
		
		System.out.println("try to local  i = " + i++);
		
	    model.addAttribute("message", "You are logged in as " + "kazanova" + "  or  ");
	    
	    
	    return "login";
	  }
	
	@PostMapping("/login")
	  public String indexLoginPost(Model model, Principal principal) {
		
		System.out.println("Here I am  &   @  POST  Mapping(\"/login");
		
		
		System.out.println("try to local  i = " + i++);
		
	    model.addAttribute("message", "You are logged in as " + "kazanova" + "  or  ");
	    
	    
	    return "login";
	  }
	
	@PostMapping("/loginX")
	  public String indexLoginPostX(Model model, Principal principal) {
		
		System.out.println("Here I am  &   @  POST XXX  Mapping(\"/login");
		
		
		System.out.println("try to local  i = " + i++);
		
	    model.addAttribute("message", "You are logged in as " + "kazanova" + "  or  ");
	    
	    
	    return "login";
	  }
	
	
	
	
	
	@GetMapping("/changeLocale")
	public String changeLocale(@RequestParam()  HttpServletRequest request, Locale locale) {
		String referer = request.getHeader("referer");
		return "redirect:" + getRequestURL(referer);
	}

	private String getRequestURL(String referer){
		try {
			URI uri = new URI(referer);
			String path = uri.getPath();
			if (uri.getQuery() != null) {
				path += "?" + uri.getQuery();
			}
			return "login?language=en";
		}
		catch (URISyntaxException e){
			throw new RuntimeException(e);
		}
	}

	
	
	
	
		@GetMapping("/loginAction")
	  public String indexGet(Model model, Principal principal) {
	    model.addAttribute("message", "You are logged in as " + "kazanova" + "  or  " + principal.getName());
	    
	    System.out.println("Here I am in  @GetMapping(\"/loginAction\")");
	    return "index";
	  }
	
			@PostMapping("/loginAction")
		  public String indexPostLogin(Model model, Principal principal) {
		    model.addAttribute("message", "You are logged in as " + "kazanova" + "  or  " + "No principal" );
		//    model.addAttribute("news", );
		    
		    System.out.println("Here I am & in   @PostMapping(\"/loginAction\")");
		    
		    
		//   System.out.println(newsService.findNews().toString()); 
		    
		    
		    return "index";
		  }
		
		
	
	  @PostMapping("/index")
	  public String indexPost(Model model, Principal principal) {
		  System.out.println("Here I am&   @PostMapping(\"/index\")");
	    model.addAttribute("message", "You are logged in as " + "POST" + "  or  " + principal.getName());
	    return "index";
	  }

	  
	  @PostMapping("/logout")
	  public String indexLogout(Model model, Principal principal) {
	    model.addAttribute("message", "You are logged in as " + "kazanova" + "  or  " + principal.getName());
	    return "header";
	  }
//	  
//	@PostMapping("/")
//	  public String index3(Model model, Principal principal) {
//	    model.addAttribute("message", "You are logged in as " + "kazanova" + "  or  " + principal.getName());
//	    return "index";
//	  }
//	
	
}
