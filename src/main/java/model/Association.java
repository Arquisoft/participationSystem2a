package model;

public class Association {

	public static class Asign {

		public static void link(User user, Citizen citizen) {
			user._setCitizen(citizen);
			citizen._setUser(user);
		}

		public static void unlink(User user, Citizen citizen) {
			citizen._setUser(null);
			user._setCitizen(null);
		}
	}
	
	public static class AsignSuggestion {
		
		public static void link(User user, Suggestion suggestion) {
			user._addSuggestion(suggestion);
			suggestion._setUser(user);
		}
		
		public static void unlink(User user, Suggestion suggestion) {
			user._deleteSuggestion(suggestion);
			suggestion._setUser(null);
		}
	}
	
	public static class AsignComentario {
		
		public static void link(Comment comment, Suggestion suggestion, User user){
			user._addComment(comment);
			suggestion.addComment(comment);
			comment._setSuggestion(suggestion);
			comment._setUser(user);
		}
		
		public static void unlink(Comment comment, Suggestion suggestion, User user){
			user._deleteComment(comment);
			user._deleteSuggestion(suggestion);
			comment._setSuggestion(null);
			comment._setUser(null);
		}
	}
}