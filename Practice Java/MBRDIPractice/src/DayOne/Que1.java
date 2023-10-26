package DayOne;

import java.util.Arrays;
import java.util.List;

//Given a list of integers, find out all the even numbers exist in the
//list using Stream functions? list=[2,34,678,3]
public class Que1 {
	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2,34,678,3);
		System.out.println(list.parallelStream().filter(s -> s%2==0).toList());
	}

}
