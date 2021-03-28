package java8.stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import apps.City;
import apps.Person;

//Flatmap operations
public class FlatMap {

	public static void main(String[] args) {
	//1. Priceline question 
    //you need to get all values of nested Map i.e, List<Integer> and convert in a single List<Integer> ?	
		
	List<Integer> oneList = List.of(1,11,111,1111);
	List<Integer> twoList = List.of(2,22,222,2222);
	HashMap<Integer, List<Integer>> map1 = new HashMap<>();
	map1.put(1, oneList);
	HashMap<Integer, List<Integer>> map2 = new HashMap<>();
	map2.put(2, twoList);
	//FlatMap example
	Map<String, Map<Integer, List<Integer>>> map = new HashMap<>();
	map.put("OneList", map1);
	map.put("TwoList", map2);
	
	Collection<Map<Integer, List<Integer>>> values = map.values();
	List<List<Integer>> list1 = values.stream().flatMap(x -> x.values().stream()).collect(Collectors.toList());
	List<Integer> list2 = list1.stream().flatMap(List::stream).collect(Collectors.toList());
	System.out.println(list2);
	
	
	//Pluralsight example
	//Get all the persons living in a city
	List<City> cities = new ArrayList<>();
	cities.add(new City("Pune", List.of(new Person("Ajinkya", 31), new Person("Sonal", 30))));
	cities.add(new City("Mumbai", List.of(new Person("Amol", 41), new Person("Rekha", 36))));
	Function<City, Stream<Person>> flatMapper 
	   = city -> city.getPersonList().stream();
	
    List<String> persons = cities.stream()
    		.flatMap(flatMapper)
    		.map(p -> p.getName())
    		.collect(Collectors.toList());
    System.out.println(persons);
	
	}
}
