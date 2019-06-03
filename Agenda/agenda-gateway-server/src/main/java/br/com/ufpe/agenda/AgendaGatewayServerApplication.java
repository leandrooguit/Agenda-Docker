package br.com.ufpe.agenda;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import br.com.ufpe.agenda.configuration.GatewayFallBack;
import br.com.ufpe.agenda.service.ContatoServiceProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableFeignClients
public class AgendaGatewayServerApplication {

	@Autowired
	private ContatoServiceProxy proxyService;
	
	public static void main(String[] args) {
		SpringApplication.run(AgendaGatewayServerApplication.class, args);
	}
	
	@Bean
	public FallbackProvider defaultZuulFallbackProfider() {
		return new GatewayFallBack();
	}
	
	@PostConstruct
	public void consultaContatos() {
		proxyService.findAll();
	}

}
