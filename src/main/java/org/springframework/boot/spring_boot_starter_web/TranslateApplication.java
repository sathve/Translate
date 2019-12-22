package org.springframework.boot.spring_boot_starter_web;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TranslateApplication 
{
	
	@Autowired
	EntityManagerFactory entityManagerFactory;
    public static void main( String[] args )
    {
    	SpringApplication.run(TranslateApplication.class, args);
    }
        
    @Bean
	public SessionFactory getSessionFactory() {
		SessionFactory sessFactory =  entityManagerFactory.unwrap(SessionFactory.class);;
		return sessFactory;
	}
    
    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
    	return builder.build();
    }
       
}
