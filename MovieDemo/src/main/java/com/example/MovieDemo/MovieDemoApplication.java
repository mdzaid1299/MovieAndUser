package com.example.MovieDemo;
import com.example.MovieDemo.filter.JWTFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MovieDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieDemoApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		FilterRegistrationBean filterregBean = new FilterRegistrationBean();
		filterregBean.setFilter(new JWTFilter());
		filterregBean.addUrlPatterns("/addMovie/*");
		return filterregBean;
	}
}
