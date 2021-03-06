package src.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import src.business.SuggestionService;
import src.model.Suggestion;
import src.repository.SuggestionRepository;

@Service
public class SuggestionServiceImpl implements SuggestionService {
	
	@Autowired
	private SuggestionRepository suggestionRepository;

	@Override
	public Suggestion addSuggestion(Suggestion sugerencia) {
		return suggestionRepository.save(sugerencia);
	}

	@Override
	public void updateSuggestion(Suggestion sugerencia) {
		suggestionRepository.save(sugerencia);
	}

	@Override
	public List<Suggestion> getSuggestions() {
		return suggestionRepository.findAll();
	}

	@Override
	public Suggestion getSuggestion(Long id) {
		return suggestionRepository.findOne(id);
	}

	@Override
	public void deleteSuggestion(Long id) {
		suggestionRepository.delete(id);
	}

}
