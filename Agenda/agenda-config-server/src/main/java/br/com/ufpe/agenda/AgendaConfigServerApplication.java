package br.com.ufpe.agenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class AgendaConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaConfigServerApplication.class, args);
	}

}
