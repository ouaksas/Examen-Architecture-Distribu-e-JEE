package sid.org.ClientSer.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sid.org.ClientSer.Model.Client;

public interface RepositoryCl extends JpaRepository<Client,Long> {
}
