package java.interfaces;

import java.pojo.Dog;

@FunctionalInterface
public interface DogQuerier {

	public boolean test(Dog d);
	
}
