package DayOne;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// write a stream prgm to accept " abc, def,fgh,klm,akze ".Find out the word which start with "a" alphabet? output - abc,akze
public class Que10 {
public static void main(String[] args) {
	List<String> list = Arrays.asList("abc", "deaf","flag","klmMAll","akze");
	System.out.println(list.stream().filter(s -> s.startsWith("a")).toList());
	System.out.println(list.stream().filter(s-> s.contains("a")).toList());
	System.out.println(list.stream().map(s-> s.toLowerCase()).filter(s-> s.contains("a")).collect(Collectors.toList()));
}
}
