package java8.stream;

import java.interfaces.DogQuerier;
import java.pojo.Dog;

public class TestDogs {

	public static void main(String[] args) {
	Dog chotu = new Dog("chotu",14,20 );
	Dog laali = new Dog("laali", 8, 12);
	
	int numBalls = 1;
	DogQuerier dq = d -> {
		int numCats = 5;
		numCats++;
		//numBalls++;
		System.out.println("Number of cats: " + numCats);
	    System.out.println("Number of balls: " + numBalls);
		return d.getAge() > 10;
		};
	System.out.println("Is chotu older than 10: " + dq.test(chotu));
	System.out.println("Is laali older than 10: " + dq.test(laali));
	
	DogsPlay dp = new DogsPlay(d -> d.getAge() > 5);
	DogsPlay dp1 = new DogsPlay(dq);
	System.out.println("Dosgplay: Querying laali:" + dp.doQuery(laali));
	System.out.println("Dosgplay: Querying laali with sysouts:" + dp1.doQuery(laali));
	
	DogQuerier q = (d)-> d.getName().equals("chotu");
	
	
	DogQuerier query = s -> {
		System.out.println("Test");
		return s.getAge() > 10;
		};
	
	
	System.out.println("Dog chotu. Is he older than 10? " + query.test(chotu));
	System.out.println("Dog Laali. Is she older than 10? " + query.test(chotu));
	
}
}