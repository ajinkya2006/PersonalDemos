package java8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class StreamFromFile {
	static Integer wordCounter = 0;
	public static void main(String[] args) throws IOException {
		Path path = Path.of("data/firstNames.txt");
		Stream<String> lines = Files.lines(path);
		//lines.forEach(System.out::println);
		
		String searchString = "Pune";
		//TODO: Citibank question: Read from a file, and search the occrances of String "Pune"
		Path path1 = Path.of("data/search_pune.txt");
		Stream<String> lines1 = Files.lines(path1);
		lines1.forEach(line -> {
			int index = 0;
			while(index!= -1) {
				index = line.indexOf(searchString, index);
				if(index!=-1) {
					wordCounter++;
					index++;
				}
			}
		});
		System.out.println("No. of occurances of Pune is " + wordCounter);
		
	}
}
