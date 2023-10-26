package DayOne;

import java.util.Arrays;
import java.util.List;

//Accept a number series 22,322,607,70. Write a stream progam that accepts only two digits numbers.
public class Que12 {
public static void main(String[] args) {
	List<Integer> list = Arrays.asList(22,322,607,70);
	System.out.println(list.stream().map(s-> s+"").filter(s-> s.length()==2).toList());
}
}
