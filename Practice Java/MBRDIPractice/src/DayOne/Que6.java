package DayOne;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Que6 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2,3,11,21,31,45,65,3,21,11);
		System.out.println(list.stream().sorted(Comparator.reverseOrder()).toList());
		//System.out.println(list.stream().sorted((a,b)-> a>b ? a:b).toList());
	}
}
