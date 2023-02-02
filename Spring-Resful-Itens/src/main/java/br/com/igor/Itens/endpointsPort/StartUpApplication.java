package br.com.igor.Itens.endpointsPort;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartUpApplication.class, args);
		System.out.println(">>>>>>>>>>>>>>>>>>>O sistema foi iniciado aqui <<<<<<<<<<<<<<<<<<<<<<<");
	}

}
