package DayOne;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//accept you,exe,ooo,xyz,zzz,write stream program to pick up words whose all characters are same
public class Que9 {
public static void main(String[] args) {
	List<String> list = Arrays.asList("you","exe","ooo","xyz","zzz");
	System.out.println(list.stream().filter( s-> (s.chars().distinct().count()==1)).collect(Collectors.toList()));
}
}
