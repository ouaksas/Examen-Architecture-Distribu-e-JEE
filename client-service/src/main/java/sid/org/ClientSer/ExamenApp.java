
package sid.org.ClientSer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import sid.org.ClientSer.Model.Client;
import sid.org.ClientSer.Repository.RepositoryCl;

@SpringBootApplication
public class ExamenApp {

    public static void main(String[] args) {
        SpringApplication.run(ExamenApp.class, args);
    }
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;

    @Bean
    CommandLineRunner commandLineRunner(RepositoryCl Clien){
        repositoryRestConfiguration.exposeIdsFor(Client.class);
        return args -> {

            Client cl=new Client(null,"12","ommar","omar@gmail.com");
            Client cl2=new Client(null,"20","ouaksas","ouaksas@gmaial.com");
            Client cl3=new Client(null,"40","ait","ait@gmail.com");
            Client cl4=new Client(null,"50","yussef","yussef@gmail.com");
            Clien.save(cl);
            Clien.save(cl2);
            Clien.save(cl3);
            Clien.save(cl4);
        };
    }
}