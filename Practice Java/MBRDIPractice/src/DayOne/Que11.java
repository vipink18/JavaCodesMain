package DayOne;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//write a stream program accept series 20,40,30,10,22,28. pickup only numbers starts with 2. out put -20,22,28
public class Que11 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(20,40,30,10,22,28);
		List<Integer> list1 = Arrays.asList(-20,40,30,10,22,-28);
		
		System.out.println(list.stream().map(s -> s+"").filter(s -> s.startsWith("2")).collect(Collectors.toList()));
		
		System.out.println( list1.stream().map(s -> s+"").filter(s -> s.startsWith("2")|| s.startsWith("-2")).collect(Collectors.toList()));
	}
}
