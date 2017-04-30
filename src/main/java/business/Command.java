package business;

import model.exception.BusinessException;

public interface Command {

    Object execute() throws BusinessException;
}
