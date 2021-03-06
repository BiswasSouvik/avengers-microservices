package own.development;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEncryptableProperties
@EnableEurekaClient
public class HeroApplication {
	public static void main(String[] args) {
		SpringApplication.run(HeroApplication.class, args);
	}
}
