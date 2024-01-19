package squad25.comercioFacil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import squad25.comercioFacil.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}