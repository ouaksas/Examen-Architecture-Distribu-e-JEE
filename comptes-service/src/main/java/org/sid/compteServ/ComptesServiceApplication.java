package org.sid.compteServ;

import org.sid.compteServ.Model.Compte;
import org.sid.compteServ.Model.Operation;
import org.sid.compteServ.Repositorys.RepoCompte;
import org.sid.compteServ.Repositorys.RepoOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class ComptesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComptesServiceApplication.class, args);
    }

    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;
    @Bean
    CommandLineRunner commandLineRunner(RepoCompte repoCompte, RepoOperation repoOperation) {
        repositoryRestConfiguration.exposeIdsFor(Compte.class);
        return args -> {
            Compte compte = repoCompte.save(new Compte(null, "40", 20.00, new Date(), "COURANT", "ACTIVE", null, 1l,null));
            List<Operation> operations = new ArrayList<>();
            operations.add(repoOperation.save(new Operation(null, 40.00, "vers", compte)));
            compte.setOperations(operations);
            operations.forEach(o -> {
                repoOperation.save(o);
            });
        };
    }
}