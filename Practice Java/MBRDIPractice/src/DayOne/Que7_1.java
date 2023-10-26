package DayOne;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//write a stream program to accept 3,7,8,1,12,13 and find out the average of value.

public class Que7_1 {
public static void main(String[] args) {
	int[] arr = {2,3,1};
	System.out.println(Arrays.stream(arr).average().orElse(Double.NaN));
	List<Integer> list = Arrays.asList(1,2,3);
	System.out.println(list.stream().collect(Collectors.averagingInt(Integer::intValue)));
	
}
}
