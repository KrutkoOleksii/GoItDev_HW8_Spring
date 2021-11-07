package ua.goit.hw8Spring;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.core.userdetails.UserDetailsService;
import ua.goit.hw8Spring.service.UserDetailsServiceImpl;

@EnableJpaRepositories
@SpringBootApplication
public class Hw8SpringApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Hw8SpringApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Hw8SpringApplication.class);
	}

	@Bean
	public UserDetailsService getUserDetailsService(){
		return new UserDetailsServiceImpl();
	}

//	@Bean
//	@Lazy
//	public AWSCredentials amazonAWSCredentials(@Value("${aws.access.key.id}") String awsAccessKeyId,
//											   @Value("${aws.access.secret.key}") String awsAccessSecretKey) {
//		return new BasicAWSCredentials(awsAccessKeyId,awsAccessSecretKey);
//	}

}
