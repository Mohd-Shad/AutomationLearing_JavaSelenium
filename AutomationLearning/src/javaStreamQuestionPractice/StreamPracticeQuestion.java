package javaStreamQuestionPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StreamPracticeQuestion {

	@Test(enabled = false)
	public void multiplyEachElementOfArray() {
		int[] arr = { 1, 2, 3, 4, 5 };
		List<Integer> result = Arrays.stream(arr).map(s -> s * 3).boxed().collect(Collectors.toList());
		System.out.println(result);
	}

	@Test(enabled = false)
	public void multiplyEachElementOfArray1() {
		List<Integer> que = Arrays.asList(1, 2, 3, 4, 5);
		List<Integer> ans = que.stream().map(num -> num * 4).collect(Collectors.toList());
		ans.forEach(a -> System.out.println(a));
	}

	@Test(enabled = false)
	public void strToint() {
		List<String> str = Arrays.asList("1", "2", "3", "4", "5");
		List<Integer> integer = str.stream().map(Integer::parseInt).collect(Collectors.toList());
		integer.forEach(a -> System.out.println(a));
	}

	@Test(enabled = false)
	public void streamMap() {

		ArrayList<String> names = new ArrayList<String>();
		names.add("man");
		names.add("Don1");
		names.add("women");

		// print names which have last letter as "a" with Uppercase
		Stream.of("Abhijeet", "Don", "Alekhya", "Adam", "Rama").filter(s -> s.endsWith("a")).map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		// print names which have first letter as "a" with uppercase and sorted
		List<String> names1 = Arrays.asList("Azbhijeet", "Don2", "Alekhya", "Adam", "Rama");
		names1.stream().filter(s -> s.startsWith("A")).sorted().map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));

		// Merging 2 different lists
		Stream<String> newStream = Stream.concat(names.stream(), names1.stream());
		// newStream.sorted().forEach(s->System.out.println(s));
		boolean flag = newStream.anyMatch(s -> s.equalsIgnoreCase("Adam"));
		System.out.println(flag);
		Assert.assertTrue(flag);

		// print unique number from the given below array
		List<Integer> values = Arrays.asList(3, 2, 2, 7, 5, 1, 9, 7);
		values.stream().distinct().forEach(a -> System.out.println(a));
		List<Integer> li = values.stream().distinct().sorted().collect(Collectors.toList());
		// li.forEach(a->System.out.println(a));
		System.out.println(li.get(2));
	}

	@Test
	public void prcticeque() {
		List<Double> num = new ArrayList<Double>();
		num.add(3.8);
		num.add(6.5);
		num.add(5.5);

		System.out.println(num);

		// Print Average of numbers
		double ans = num.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
		System.out.println(ans);

		List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

		double ans1 = numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
		System.out.println(ans1);

		// Print Sum of given numbers
		int sum = numbers.stream().mapToInt(Integer::intValue).sum();
		System.out.println(sum);

		// Given a list of integers, return a new list containing the square of each
		// number.
		List<Integer> num1 = Arrays.asList(2, 3, 4, 5, 6, 7);
		List<Integer> square = num1.stream().map(a -> a * a).collect(Collectors.toList());
		System.out.println(square);
		// square.forEach(a->System.out.println(a));

		// limiting the result
		square.stream().limit(1).forEach(a -> System.out.println(a));

		// From a list of names, find all names that have more than 4 characters.
		List<String> names = Arrays.asList("Ram", "Usmani", "Ali", "Mohammad");
		List<String> result = names.stream().filter(a -> a.length() > 4).collect(Collectors.toList());
		result.forEach(a -> System.out.println(a));

		// Given a list with duplicate numbers, return a list of unique numbers in
		// sorted order.
		List<Integer> list1 = Arrays.asList(2, 3, 4, 2, 3, 7, 8, 4, 5, 6, 0, 7, 4, 2, 5);
		list1.stream().distinct().sorted().forEach(s -> System.out.println(s));

		// Sort a list of strings in alphabetical order using streams.
		List<String> words = Arrays.asList("banana", "apple", "grape", "cherry");
		List<String> sortedOrder = words.stream().sorted().collect(Collectors.toList());
		sortedOrder.forEach(a -> System.out.println(a));
		// System.out.println(sortedOrder);

		// From a list of words, find the word with the maximum length.
		List<String> words1 = Arrays.asList("stream", "java", "programming", "api");
		String longest = words1.stream().max(Comparator.comparingInt(String::length)).get();
		System.out.println(longest);

		// Calculate the sum of all even/Odd numbers from a list.
		List<Integer> numbers1 = Arrays.asList(5, 10, 15, 20, 25);
		int evenNum = numbers1.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
		int oddNum = numbers1.stream().filter(n -> n % 2 != 0).mapToInt(Integer::intValue).sum();
		System.out.println("Sum of Even Num is = " + evenNum);
		System.out.println("Sum of Odd Num is = " + oddNum);

		// Given a list of strings, join them into a single string separated by commas.
		// Example: ["Java", "Stream", "API"] → "Java, Stream, API"

		List<String> list = Arrays.asList("Java", "Stream", "API");
		String joined = list.stream().collect(Collectors.joining(", "));
		System.out.println("Joined: " + joined);
		
		
		//Count Frequency of Characters From a string, count the frequency of each character.
		//Example: "banana" → {b=1, a=3, n=2}
		
		String input = "banana";
        Map<Character, Long> freq = input.chars()
                                         .mapToObj(c -> (char)c)
                                         .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println("Frequency: " + freq);
        
        
        //Find Second Highest Number
        List<Integer> numbers2 = Arrays.asList(10, 20, 50, 40, 30);
        int secondHighest = numbers2.stream()
                                   .sorted(Comparator.reverseOrder())
                                   .skip(1)
                                   .findFirst()
                                   .get();

        System.out.println("Second Highest: " + secondHighest);
        
        //Partition Numbers into Even and Odd
        //Given a list of integers, create a map that groups numbers into even and odd categories.
        //Example: {true=[2,4,6], false=[1,3,5]}
        
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Boolean, List<Integer>> partitioned = nums.stream()
                                                      .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Partitioned: " + partitioned);
		

	}

}

/*
 * The map() operation in Java Streams is used when a transformation needs to be
 * applied to each element of a stream, resulting in a new stream containing the
 * transformed elements.
 */
