package own.development.avengers;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
//@EnableResourceServer
@EnableEncryptableProperties
public class AvengersApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvengersApplication.class, args);
	}

}
