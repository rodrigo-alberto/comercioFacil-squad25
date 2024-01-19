package squad25.comercioFacil.services;

import java.util.List;

import squad25.comercioFacil.models.Enterprise;

public interface EnterpriseService extends GenericCrudService {
	List<Enterprise> getAllByIdUser(Long idUser);
	
	List<Enterprise> getAllByIdMarket(Long IdMarket);
}