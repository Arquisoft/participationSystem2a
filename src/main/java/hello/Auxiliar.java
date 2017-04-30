package hello;


import java.util.List;

import org.springframework.ui.Model;

import business.SuggestionService;
import model.Suggestion;

public class Auxiliar {
	
	private Suggestion selected;
	

	public Suggestion getSelected() {
		return selected;
	}

	public void setSelected(Suggestion selected) {
		this.selected = selected;
	}
	
	public void cargarSugerencias(Model model, SuggestionService suggestionService) {
		List<Suggestion> sugerencias = suggestionService.getSuggestions();
		model.addAttribute("sugerencias", sugerencias);
	}

}
