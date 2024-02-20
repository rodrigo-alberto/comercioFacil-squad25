package squad25.comercioFacil.servicesImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import squad25.comercioFacil.enums.State;
import squad25.comercioFacil.enums.SystemAlert;
import squad25.comercioFacil.models.Address;
import squad25.comercioFacil.models.MarketPlace;
import squad25.comercioFacil.repositories.MarketPlaceRepository;
import squad25.comercioFacil.services.MarketPlaceService;

@Service
public class MarketPlaceServiceImpl implements MarketPlaceService {

	@Autowired
	private MarketPlaceRepository marketRepo;
	
	@Override
	public MarketPlace save(MarketPlace market) {		
		return this.marketRepo.save(market);
	}

	@Override
	public MarketPlace getById(Long id) {
		return this.marketRepo.findById(id).orElseThrow(() -> SystemAlert.printRuntimeEx(SystemAlert.NOT_FOUND_ERROR));
	}
	
	@Override
	public List<MarketPlace> getAll() {
		return this.marketRepo.findAll();
	}
	
	@Override
	public List<MarketPlace> getByState(State state) {
		List<MarketPlace> listMarketsByState = this.marketRepo.findByState(state);
		
		if(!listMarketsByState.isEmpty()) {
			return listMarketsByState;
		}else {
			List<MarketPlace> listDefaultOption = new ArrayList<>();
			MarketPlace defaultMarketPlace = new MarketPlace();
			
			defaultMarketPlace.setNameMarket("Não há feiras para este estado");
			listDefaultOption.add(defaultMarketPlace);
			
			return listDefaultOption;			
		}
	}

	@Override
	public MarketPlace update(Long id, MarketPlace updatedMarket, Address updatedAddress) {
		MarketPlace existingMarket = this.marketRepo.findById(id).orElseThrow(() -> SystemAlert.printRuntimeEx(SystemAlert.NOT_FOUND_ERROR));
		
		existingMarket.setNameMarket(updatedMarket.getNameMarket());
		existingMarket.setMapUrl(updatedMarket.getMapUrl());
		existingMarket.setDescription(updatedMarket.getDescription());
		existingMarket.getAddress().setCity(updatedAddress.getCity());
		existingMarket.getAddress().setNeighborhood(updatedAddress.getNeighborhood());
		existingMarket.getAddress().setState(updatedAddress.getState());
		existingMarket.getAddress().setStreet(updatedAddress.getStreet());
		existingMarket.getAddress().setMarketPlace(existingMarket);
		
		return this.marketRepo.save(existingMarket);
	}

	@Override
	public void deleteById(Long id) {
		this.marketRepo.findById(id).orElseThrow(() -> SystemAlert.printRuntimeEx(SystemAlert.NOT_FOUND_ERROR));
		this.marketRepo.deleteById(id);	
	}
}