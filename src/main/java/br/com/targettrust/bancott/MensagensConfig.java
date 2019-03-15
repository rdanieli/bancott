package br.com.targettrust.bancott;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class MensagensConfig {

	@Bean 
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource ms = 
				new ReloadableResourceBundleMessageSource();
		
		
		ms.setBasename("classpath:messages");
		ms.setDefaultEncoding("UTF-8");
		
		return ms;
	}
	
	
	@Bean
	public LocalValidatorFactoryBean factoryBean() {
		LocalValidatorFactoryBean b = new LocalValidatorFactoryBean();
		
		b.setValidationMessageSource(messageSource());
		
		return b;
	}
	
	
	
}
