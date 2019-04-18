package br.com.ufpe.agenda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AgendaCadastroServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaCadastroServerApplication.class, args);
	}

}
