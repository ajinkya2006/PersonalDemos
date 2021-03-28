package java8.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import apps.Person;

public class CollectorsExample{

	public static void main(String[] args) {
		List<Person> personList = List.of(new Person("Ajinkya", 31, "Male"), new Person("Sonal", 30, "Female"), new Person("Amol", 41, "Male"),
				new Person("Rekha", 36, "Female"), new Person("Pradnya",34, "Female"));
		
		
		Map<String, List<Person>> genderMap = personList.stream()
		          .collect(
		        		  Collectors.groupingBy(p -> p.getGender()));
		genderMap.forEach((k,v) -> System.out.println("Key: " + k + " " + "Value" + v));
		
		//Downstream Collectors - Using Collectors.counting()
		Map<String, Long> countPerGender = personList.stream()
		          .collect(Collectors.groupingBy(Person::getGender, Collectors.counting()));
		System.out.println("No. of females:" + countPerGender.get("Female"));
		
		//Histogram
		
		Entry<String, Long> moreMembersinGender = countPerGender.entrySet().stream() //Stream Map.Entry<String, Long>
		//.max(Comparator.comparing(entry -> entry.getValue()))
				.max(Entry.comparingByValue())
		.orElseThrow();
		
		System.out.println("Gender majority:" + moreMembersinGender);
		
		//Sum of the ages of all females
		int ageSum = genderMap.get("Female")
		         .stream()
		         .collect(Collectors.summingInt(Person::getAge));
		System.out.println("Sum of female ages:" + ageSum);
		
	}
				          
}
