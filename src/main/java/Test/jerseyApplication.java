package Test;

import Entities.Compte;
import Entities.TypeCompte;
import Repository.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class jerseyApplication {
    public jerseyApplication() {
    }

    public static void main(String[] args) {
        SpringApplication.run(jerseyApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository) {
        return (args) -> {
            compteRepository.save(new Compte((Long)null, 9000.0, new Date(), TypeCompte.COURANT));
            compteRepository.save(new Compte((Long)null, 6000.0, new Date(), TypeCompte.EPARGNE));
            compteRepository.save(new Compte((Long)null, 3000.0, new Date(), TypeCompte.COURANT));
            compteRepository.findAll().forEach((c) -> {
                System.out.println(c.toString());
            });
        };
    }
}
