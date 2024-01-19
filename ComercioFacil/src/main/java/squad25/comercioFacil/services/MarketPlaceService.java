package squad25.comercioFacil.services;

import java.util.List;
import squad25.comercioFacil.enums.State;
import squad25.comercioFacil.models.MarketPlace;

public interface MarketPlaceService extends GenericCrudService {
	//A implementação desses métodos serão chamados na implentação da inteface do administrador;
	
	List<MarketPlace> getAll();
	
	List<MarketPlace> getAllByState(State state);
}