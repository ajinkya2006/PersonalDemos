package java8.stream;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamFromRegEx {

	public static void main(String[] args) {
		String sentence = "Today is Saturday and I am studying and that is awesome";
		String[] words = sentence.split(" ");
		Stream<String> wordsStream = Arrays.stream(words);
		System.out.println(wordsStream.count());
		
		//A better approach - Above operation is costly, because we are storing intermediate 
		//results in an array and doing string operations
		
		Pattern pattern = Pattern.compile(" ");
		System.out.println(pattern.splitAsStream(sentence).count());
		
		
	}
	
	
}
