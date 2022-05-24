package repository;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBException;
import javax.xml.bind.annotation.*;

import org.xml.sax.SAXException;

import models.Cat;
import xml.XMLWorker;

@XmlRootElement(name="cats")
@XmlAccessorType(XmlAccessType.FIELD)
public class Repository {
	private static Repository instance = null;
	
	@XmlElement(name="cat")
	private static Set<Cat> collection = new HashSet<Cat>();
	static int index=1;
	private static String pathToXml = "C:\\Users\\FERKO\\eclipse-workspace\\cat-test\\src\\main\\xml\\storage.xml";
	private static String pathToSchema = "C:\\Users\\FERKO\\eclipse-workspace\\cat-test\\src\\main\\xml\\schema1.xsd";
	
	public static Repository getInstance() {
		if(instance == null) {
			XMLWorker worker = new XMLWorker();

			try {
				instance = worker.readFromXml(pathToXml,pathToSchema);
				index=collection.size()+1;
			} catch (FileNotFoundException | UnsupportedEncodingException | JAXBException | SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		return instance;
	}
	
	public void addCat(Cat cat) {
		cat.setId(index++);
		collection.add(cat);
		update();
	}
	
	public boolean ifExist(Cat cat) {
		return collection.contains(cat);
	}
	
	public Cat getCatByCatName(String catName) {
		for(Cat c:collection) {
			if(c.getCatName().equals(catName)) {
				return c;
			}
		}
		return null;
	}
	
	public Cat getCatById(int id) {
		for(Cat c:collection) {
			if(c.getId()==id) {
				return c;
			}
		}
		return null;
	}
	
	public void update() {
		XMLWorker worker = new XMLWorker();
		try {
			worker.writeToXMLFile(pathToXml, this);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public static Set<Cat> getCollection() {
		return collection;
	}
}
