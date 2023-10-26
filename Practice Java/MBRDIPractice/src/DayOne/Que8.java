package DayOne;

import java.util.Arrays;
import java.util.List;

//series 11,14,13,45,20,-20 stream program to accept positive value and display sorted order.
public class Que8 {

	public static void main(String[] args) {
		int[] arr = {11,14,13,45,20,-20};
		List<Integer> list = Arrays.asList(11,14,13,45,20,-20);
		
		
		Arrays.stream(arr).filter(s -> s>0).sorted().forEach(System.out::println);
		
		System.out.println(list.stream().filter(s -> s>0).sorted().toList());
	}
}