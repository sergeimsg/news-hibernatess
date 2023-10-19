package it.academy.by.spring.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;


import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "it.academy.by.spring" })
public class WebConfig implements WebMvcConfigurer {
	
	
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("/WEB-INF/locale/local");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
		
	}
	
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		
		
		LocaleChangeInterceptor localeChangeInterceptor =  new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("language");
		return localeChangeInterceptor;
	}
	
	
	
	  @Override
		public void addInterceptors(InterceptorRegistry registry) {
			
			registry.addInterceptor(localeChangeInterceptor());
		}

	  @Bean
	  public SessionLocaleResolver localeResolver() {
		  
		  SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
		  sessionLocaleResolver.setDefaultLocale(Locale.ENGLISH);
		  return sessionLocaleResolver;
			 
		  }
		  
	 
	  
		@Override
		  public void configureViewResolvers(ViewResolverRegistry registry) {
		    registry.jsp().prefix("/WEB-INF/pages/").suffix(".jsp");
		  }


  
//		@Bean
//		public CommonsMultipartResolver multipartResolver() {
//			
//			return new CommonsMultipartResolver();
//		}


		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			
			 registry
	          .addResourceHandler("/resources/**")
	          .addResourceLocations("/resources/");	
			
		}
  
		
		
  
  
}
