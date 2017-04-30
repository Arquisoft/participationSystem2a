package business.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import business.Command;
import model.exception.BusinessException;
import persistence.Jpa;

public class CommandExecutor {

    public Object execute(Command cmd) throws BusinessException {

	EntityManager mapper = Jpa.createEntityManager();
	EntityTransaction trx = mapper.getTransaction();
	trx.begin();

	try {
	    Object result = cmd.execute();

	    trx.commit();
	    return result;

	} catch (BusinessException be) {
	    if (trx.isActive())
		trx.rollback();
	    throw be;
	} catch (PersistenceException p) {
	    if (trx.isActive())
		trx.rollback();
	    throw p;
	} finally {
	    if (mapper.isOpen())
		mapper.close();
	}
    }
}
