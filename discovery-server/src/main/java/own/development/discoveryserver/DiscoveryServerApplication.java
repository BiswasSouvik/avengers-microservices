package own.development.discoveryserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerApplication {

	@Value("${spring.profiles.active}")
	static String str;

	public static void main(String[] args) {
		System.out.println("The server is : " + str);
		SpringApplication.run(DiscoveryServerApplication.class, args);
	}

}
