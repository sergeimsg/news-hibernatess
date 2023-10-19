package it.academy.by.spring.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import javax.sound.midi.Soundbank;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.protobuf.ServiceException;

import it.academy.by.spring.model.entity.Authorities;
import it.academy.by.spring.model.entity.User;
import it.academy.by.spring.model.entity.UserDetailsEntity;
import it.academy.by.spring.service.UserService;



@Controller
@RequestMapping("/user")
public class UserController {

	
	private final UserService userService;

	
	@Autowired
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		
		
	}
	
	
	@GetMapping("/goToRegistrationPage")
	public String goToRegistrationPage(Model model) {
		
		model.addAttribute("action", "registrationPage");
		model.addAttribute("userDetails", new UserDetailsEntity());
		
		System.out.println("go to registration page");
		
		return "baseLayout/baseLayout";
	}
	
	@PostMapping("/doRegistrationUser")
	public String doRegistration(@Valid @ModelAttribute("userDetails") UserDetailsEntity userDetailsEntity, BindingResult bindingResult,
			Model theModel) {
		
		
		
		try {
			
			if (bindingResult.hasErrors()) {
				
				// System.out.println("Binding started" + bindingResult.toString());
				
				theModel.addAttribute("action", "registrationPage");
				return "baseLayout/baseLayout";
			}
				
			else {
				
				//String password = userDetailsEntity.getUser().getPassword();
				String login = userDetailsEntity.getUser().getUsername();
				// System.out.println("before " + userDetailsEntity.toString());
				String hashPassword = BCrypt.hashpw(userDetailsEntity.getUser().getPassword(), BCrypt.gensalt());
				Authorities authorities = new Authorities();
				
				User user = new User();
				
				user.setPassword(hashPassword);
				user.setUsername(login);
				user.setEnabled(true);
				
				authorities.setAuthority("ROLE_USER");
				authorities.setUser(user);
				
				user.getAuthorities().add(authorities);
				
				userDetailsEntity.setUser(user);
				
				
				// System.out.println(userDetailsEntity.toString());
				theModel.addAttribute("registered", "registered");
				userService.registration(userDetailsEntity);
				
				return "redirect:/news/goToBasePage";			
				
			}
			
			
			
		} catch (ServiceException e) {
			
			return "redirect: /news/errorPage"; 
		}
		
		
	}
	
	
	
	
	@PostMapping("/loginAction")
	public String goToBasePage(Model model, Principal principal) {
		
			model.addAttribute("login", "login+");
		
			
		return "index";
		
	}
	
	@GetMapping("/access-denied")
	public String getAccessDenied() {
		
		return "error-404";
	}
	
		
	

}
