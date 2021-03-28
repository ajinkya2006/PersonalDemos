package java8.stream;

public class StreamFromStrings {

	public static void main(String[] args) {
		String string = "we will see all the words that are there in this string";
		string.chars()
		   .mapToObj(codePoint -> Character.toString(codePoint))
		   .distinct()
		   .filter(letter -> !letter.equals(" "))
		   .sorted()
		   .forEach(letter -> System.out.print(letter));
	}
}
