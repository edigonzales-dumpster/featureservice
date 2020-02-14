package ch.so.agi.featureservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
public class SogisFeatureserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SogisFeatureserviceApplication.class, args);
	}

}
