package src.business;

import src.business.impl.AdminServiceImpl;
import src.business.impl.CategoryServiceImpl;
import src.business.impl.CitizenServiceImpl;
import src.business.impl.CommentServiceImpl;
import src.business.impl.SuggestionServiceImpl;
import src.business.impl.SystemServiceImpl;

public class Services {

    public static CitizenService getCitizenServices() {
	return new CitizenServiceImpl();
    }

    public static AdminService getAdminServices() {
	return new AdminServiceImpl();
    }

    public static SystemService getSystemServices() {
	return new SystemServiceImpl();
    }
    
    public static SuggestionService getSuggestionServices(){
    	return new SuggestionServiceImpl();
    }
    
    public static CommentService getCommentServices(){
    	return new CommentServiceImpl();
    }
    
    
    public static CategoryService getCategoryServices(){
    	return new CategoryServiceImpl();
    }
    

}
