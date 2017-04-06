package business.impl;

import java.util.List;

import business.SystemService;
import model.Categoria;
import model.Sugerencia;
import model.exception.BusinessException;

public class SystemServiceImpl implements SystemService {

	private CommandExecutor cmd = new CommandExecutor();

	@Override
	public List<Categoria> findAllCategories() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sugerencia> findAllSugerencias() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sugerencia> findSugerenciasByCategory(Long idCategory) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
