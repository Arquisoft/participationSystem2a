package business;

import business.impl.AdminServiceImpl;
import business.impl.CitizenServiceImpl;
import business.impl.CommentServiceImpl;
import business.impl.SuggestionServiceImpl;
import business.impl.SystemServiceImpl;

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
    
    /*
    public static CategoryService getCategoryServices(){
    	return new CategoryServiceImpl();
    }
    */

}
