package business;

import model.Category;

public interface AdminService {

    public void addCategoria(Category categoria);

    public void updateCategoria(Category categoria);

    public void deleteCategoria(Long id);

    public void deleteSugerencia(Long id);
}