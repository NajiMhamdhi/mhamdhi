package com.seniorAdom.springmvc.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
/**
 * A Renseigner.
 * @author  : nmhamdi
 * @project : TEST REST WEB SERVICES
 * @package : com.springmvc.model
 * @date    : 22 nov. 2016 
 */
@Configuration
@Import(JpaConfiguration.class)
@EnableWebMvc
@ComponentScan(basePackages = "com.seniorAdom.springmvc")
public class AppConfig extends WebMvcConfigurerAdapter
{
   
   @Override
   public void configureViewResolvers( ViewResolverRegistry registry )
   {
      
      InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
      viewResolver.setViewClass( JstlView.class );
      viewResolver.setPrefix( "/WEB-INF/views/" );
      viewResolver.setSuffix( ".jsp" );
      registry.viewResolver( viewResolver );
   }
   
   @Override
   public void addResourceHandlers( ResourceHandlerRegistry registry )
   {
      registry.addResourceHandler( "/static/**" ).addResourceLocations( "/static/" );
   }
   
   @Bean
   public MessageSource messageSource()
   {
      ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
      messageSource.setBasename( "messages" );
      return messageSource;
   }
   
   @Override
   public void configurePathMatch( PathMatchConfigurer matcher )
   {
      matcher.setUseRegisteredSuffixPatternMatch( true );
   }
}
