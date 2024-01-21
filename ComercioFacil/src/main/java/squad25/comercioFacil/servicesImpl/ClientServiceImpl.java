package squad25.comercioFacil.servicesImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import squad25.comercioFacil.enums.SystemAlert;
import squad25.comercioFacil.models.Client;
import squad25.comercioFacil.repositories.ClientRepository;
import squad25.comercioFacil.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ClientRepository clientRepo;
	
	@Override
	public Object save(Object object) {	
		try {
			return this.clientRepo.save(mapper.map(object, Client.class));
			
		} catch (IllegalArgumentException e) {
			SystemAlert.printRuntimeEx(SystemAlert.USER_REGISTRATION_ERROR);
			return null;
		}
	}

	@Override
	public Object getById(Long id) {
		return null;
	}

	@Override
	public Object update(Long id, Object updatedObject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}
}