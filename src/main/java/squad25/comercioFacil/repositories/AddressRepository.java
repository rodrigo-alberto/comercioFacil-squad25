package squad25.comercioFacil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import squad25.comercioFacil.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	
	@Query
	(nativeQuery = true, value = "SELECT a.* FROM `address` AS a "
			+ "JOIN `marketplace` AS m "
			+ "ON m.fk_id_address = a.id_address "
			+ "WHERE m.id_market = :idMarket")
	Address findByIdMarket(@Param("idMarket") Long idMarket);
	
}