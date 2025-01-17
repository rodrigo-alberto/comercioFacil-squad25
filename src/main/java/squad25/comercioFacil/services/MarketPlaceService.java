package squad25.comercioFacil.services;

import java.util.List;
import squad25.comercioFacil.enums.State;
import squad25.comercioFacil.models.Address;
import squad25.comercioFacil.models.MarketPlace;

public interface MarketPlaceService {
	//A implementação desses métodos será chamada no controlador administrativo;
	
//	MarketPlace save(MarketPlace marketPlace, List<Long> enterprisesIds);
	
	MarketPlace save(MarketPlace marketPlace);
	
	MarketPlace getById(Long id);
	
	List<MarketPlace> getAll();
	
	List<MarketPlace> getByState(State state);

	MarketPlace update(Long id, MarketPlace updatedMarket, Address updatedAddress);
	
	void deleteById(Long id);
}