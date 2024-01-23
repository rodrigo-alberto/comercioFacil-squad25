package squad25.comercioFacil.servicesImpl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import squad25.comercioFacil.enums.State;
import squad25.comercioFacil.enums.SystemAlert;
import squad25.comercioFacil.models.Employer;
import squad25.comercioFacil.models.MarketPlace;
import squad25.comercioFacil.repositories.MarketPlaceRepository;
import squad25.comercioFacil.services.MarketPlaceService;

@Service
public class MarketPlaceServiceImpl implements MarketPlaceService {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private MarketPlaceRepository marketRepo;
	
	@Override
	public Object save(Object object) {
		return this.marketRepo.save(mapper.map(object, MarketPlace.class));
	}

	@Override
	public Object getById(Long id) {
		return this.marketRepo.findById(id).orElseThrow(() -> SystemAlert.printRuntimeEx(SystemAlert.NOT_FOUND_ERROR));
	}

	@Override
	public Object update(Long id, Object updatedObject) {
		MarketPlace existingMarket = this.marketRepo.findById(id).orElseThrow(() -> SystemAlert.printRuntimeEx(SystemAlert.NOT_FOUND_ERROR));
		MarketPlace updatedMarket = mapper.map(updatedObject, MarketPlace.class);
		
		existingMarket.setNameMarket(updatedMarket.getNameMarket());
		existingMarket.setMapUrl(updatedMarket.getMapUrl());
		existingMarket.setAddress(updatedMarket.getAddress());
		existingMarket.setEnterprises(updatedMarket.getEnterprises());
		
		return null;
	}

	@Override
	public void deleteById(Long id) {
		this.marketRepo.findById(id).orElseThrow(() -> SystemAlert.printRuntimeEx(SystemAlert.NOT_FOUND_ERROR));
		this.marketRepo.deleteById(id);	
	}

	@Override
	public List<MarketPlace> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MarketPlace> getAllByState(State state) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
