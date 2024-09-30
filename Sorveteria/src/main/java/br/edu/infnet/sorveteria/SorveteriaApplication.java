package br.edu.infnet.sorveteria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SorveteriaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SorveteriaApplication.class, args);
    }

}
