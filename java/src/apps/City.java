package apps;

import java.util.List;

public class City {

	private String name;
	private String state;
	private int population;
	private double area;
	
	private List<Person> personList;

	
	public City(String name, List<Person> personList) {
		this.name = name;
		this.personList = personList;
	}
	
	
	public City(String name, String state, int population, double area) {
		super();
		this.name = name;
		this.state = state;
		this.population = population;
		this.area = area;
	}


	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}

	
	public List<Person> getPersonList() {
		return personList;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
