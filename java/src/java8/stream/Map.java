package java8.stream;

import java.util.ArrayList;
import java.util.List;

import apps.City;
import apps.Person;

public class Map {

	public static void main(String[] args) {
		List<City> cities = new ArrayList<>();

		List<Person> personList = List.of(new Person("Ajinkya", 31), new Person("Sonal", 30), new Person("Amol", 41),
				new Person("Rekha", 36));
		cities.add(new City("Pune", List.of(new Person("Ajinkya", 31), new Person("Sonal", 30))));
		cities.add(new City("Mumbai", List.of(new Person("Amol", 41), new Person("Rekha", 36))));

		// Get city names
		cities.stream().map(city -> city.getName()).forEach(System.out::println);
		// To call the aggregate functions(min,max,average,sum),
		// IntStream,LongStream,DoubleStream
		// needs to be used

		// Find the eldest
		System.out.println("Eldest person:" + personList.stream().mapToInt(Person::getAge).max().orElse(0));

		// Find the youngest
		System.out.println("Youngest person:" + personList.stream().mapToInt(Person::getAge).min().orElse(0));

		// Find the average
		System.out.println("Average age:" + personList.stream().mapToInt(Person::getAge).average().orElse(0));

		// Sum
		int sum = personList.stream().mapToInt(Person::getAge).sum();
		System.out.println("Sum of ages is:" + sum);

		// Summary statistics
		System.out.println("Summary stats" + personList.stream().mapToInt(Person::getAge).summaryStatistics());

		System.out.println(personList.stream().map(Person::getAge).reduce((i1, i2) -> i1 + i2));
	}

}
