package DayOne;

import java.util.Arrays;
import java.util.List;

//In a series 22,42,56,39, write a stream program that will pick up those words ends 2
public class Que13 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(22,42,56,39);
		System.out.println(list.parallelStream().map(s -> s+"").filter(s -> s.endsWith("2")).toList());
	}
}
