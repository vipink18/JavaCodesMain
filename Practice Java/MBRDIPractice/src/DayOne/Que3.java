package DayOne;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
//How to find duplicate elements in a given integers list in java using Stream functions?
public class Que3 {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2,3,11,21,31,45,65,3,21,11);
		Set<Integer> set = new HashSet<>();
		List<Integer>list2=	list.stream().filter(s -> !set.add(s)).collect(Collectors.toList());
		System.out.println(list2);
		System.out.println(list.stream().collect(Collectors.counting()));
		//Map<Integer,Integer> map = new HashMap<>();
		System.out.println(list.stream().collect(Collectors.groupingBy(s->s, LinkedHashMap::new,Collectors.counting())));
	}
}
