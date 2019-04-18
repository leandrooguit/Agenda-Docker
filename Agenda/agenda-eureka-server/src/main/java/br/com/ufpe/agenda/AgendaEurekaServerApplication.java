package br.com.ufpe.agenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AgendaEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaEurekaServerApplication.class, args);
	}

}
