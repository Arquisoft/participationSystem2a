package model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "TCATEGORY")
public class Category {

    Long id;
    String name;

    @OneToMany(mappedBy="TCATEGORY", cascade = CascadeType.ALL)
    private Set<Suggestion> suggestions;
    
    Category(){}

    public Category(String name) {
	super();
	this.name = name;
    }

    public String getName() {
	return name;
    }

    public Long getId() {
	return id;
    }

    public Set<Suggestion> getSuggestions() {
	return new HashSet<Suggestion>(suggestions);
    }
    
    protected Set<Suggestion> _getSuggestions() {
		return suggestions;
	}

    public void addsuggestion(Suggestion suggestion) {
	this.suggestions.add(suggestion);
    }

    @Override
    public int hashCode() {
	return name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Category other = (Category) obj;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Categoria [id=" + id + ", name=" + name + ", Suggestions=" + suggestions + "]";
    }

}
