package java8.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SkippingAndLimit {

	public static void main(String[] args) throws IOException {
		
		//Skipping and limit on IntStream
		IntStream.range(1, 30)
		.skip(10)
		.limit(10)
		.forEach(item -> System.out.print(item + " "));
		
		// Skipping and limit on Stream
		Path path = Path.of("data/firstNames.txt");
		Stream<String> lines = Files.lines(path);
		lines.skip(2)
		 .limit(3)
		 .forEach(x -> System.out.println(x));
		
	}
}
