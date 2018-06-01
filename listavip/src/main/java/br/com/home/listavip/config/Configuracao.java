package br.com.home.listavip.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

/*
 * ANOTAÇÕES ABAIXO SÃO NECESSÁRIAS EM CASOS QUE AS CLASSES DE REPOSITORY, ENTITY E CONTROLLER NÃO ESTEJAM NO MESMO PACOTE, OU PACOTE FILHOS DO ARQUIVO DE CONFIGURAÇÃO. 
 * NESSE CASO, SE O PACOTE DA CLASSE CONFIGURACAO FOSSE br.com.home.listavip, SEM O config, NÃO SERIAM NECESSÁRIAS AS ANOTAÇÕES, POIS A ANOTAÇÃO @SpringBootApplication JÁ CUIDARIA DISSO.
 *
 */ 
@EnableJpaRepositories("br.com.home.listavip.repository")
@EntityScan("br.com.home.listavip.model")
@ComponentScan({"br.com.home.listavip.controller", "br.com.home.listavip.service", "br.com.home.sendmail.service"})
public class Configuracao {
	
	public static void main(String[] args) {
		SpringApplication.run(Configuracao.class, args);
	}
	
/*	
 * Configuração do DataSource está sendo feita no arquivo application.properties
 * 
 * @Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/listavip");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}*/
	
}
