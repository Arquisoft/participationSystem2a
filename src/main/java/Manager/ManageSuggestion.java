package Manager;

import java.util.List;

import model.Suggestion;

public interface ManageSuggestion {
	
	public void addSuggestion(Suggestion sugerencia);
	public void updateSuggestion(Suggestion sugerencia);
	public Suggestion getSuggestion(Long id);
	public List<Suggestion> getSuggestions();
}
