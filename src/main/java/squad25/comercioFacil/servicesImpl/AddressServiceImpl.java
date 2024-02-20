package squad25.comercioFacil.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import squad25.comercioFacil.models.Address;
import squad25.comercioFacil.repositories.AddressRepository;
import squad25.comercioFacil.services.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepo;

	@Override
	public Address getByIdMarket(Long idMarket) {
		return this.addressRepo.findByIdMarket(idMarket);
	}
}