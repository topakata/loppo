package models;

import java.io.Serializable;
import java.util.Objects;

import javax.xml.bind.annotation.*;


@XmlRootElement(name="user")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cat  implements Serializable {
	 
	private static final long serialVersionUID = 1L;
	private int id;
	private String personName;
	private String catName;
	private String breed;
	private String description;
	
	
	
	public Cat() {
	}
	
	public Cat(String personName, String catName, String breed, String description) {
		super();
		this.personName = personName;
		this.catName = catName;
		this.breed = breed;
		this.description = description;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(breed, catName, description, personName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		return Objects.equals(breed, other.breed) && Objects.equals(catName, other.catName)
				&& Objects.equals(description, other.description) && Objects.equals(personName, other.personName);
	}

	

	
}
