package sid.org.ClientSer.ResController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sid.org.ClientSer.Model.Client;
import sid.org.ClientSer.Repository.RepositoryCl;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    RepositoryCl repositoryCl;

    @PostMapping("client")
    public Client addClient(@RequestBody Client c){

        return repositoryCl.save(c);
    }
    @GetMapping("clients")
    public List<Client> getClients(){

        return repositoryCl.findAll();
    }

    @GetMapping("client/{id}")
    public Client getClient(@PathVariable("id") Long id){

        return repositoryCl.getOne(id);
    }


}
