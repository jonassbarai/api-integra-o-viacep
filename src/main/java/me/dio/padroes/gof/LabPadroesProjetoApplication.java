package me.dio.padroes.gof;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LabPadroesProjetoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LabPadroesProjetoApplication.class, args);
	}

}
