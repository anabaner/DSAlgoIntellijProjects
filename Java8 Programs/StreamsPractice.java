import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsPractice {
    public static void main(String args[]){

        //convert array to list
        int arr[] = {1,2,3};
        List<Integer> list1 = Arrays.stream(arr).boxed().toList();
        System.out.println(list1);

        //print even nos
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream().filter(n->n%2==0).collect(Collectors.toList()).forEach(System.out::println);

        System.out.println();

        //convert to uppercase
        List<String> llist = Arrays.asList("apple","banana");
        List<String> uppercaseList = llist.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(uppercaseList);

        //find max no
        List<Integer> numbers = Arrays.asList(10, 20, 5, 45, 2, 100, 23);
        Optional<Integer> oi = numbers.stream().max(Integer::compareTo);
        System.out.println(oi);
        oi.ifPresent(System.out::println);

        //distinct nos
        List<Integer> nums = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> uniqueNumbers = nums.stream().distinct().collect(Collectors.toList());
        System.out.println(uniqueNumbers);

        //find kth smallest element

        int[] array = {4, 2, 7, 1, 5, 3, 6};
        int k = 3; // Find the 3rd smallest element
        int elem = Arrays.stream(array).sorted().skip(k-1).findFirst().orElse(-1);
        System.out.println(elem);

        //map the occurence of each object
        List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana");
        Map<String,Long> map = items.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map);

        //use of flatmap
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8)
        );
        listOfLists.stream().flatMap(l->l.stream()).collect(Collectors.toList());
        System.out.println(listOfLists);

        //reverse a string
        String s = "abc";
        String collect = Stream.of(s).map(word -> new StringBuilder(s).reverse().toString()).collect(Collectors.joining());
        System.out.println (collect);
    }
}






/*
Map<String, Long> bag =
   Pattern.compile(" ")
          .splitAsStream("one o'clock two o'clock three o'clock rock")
          .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
Map<String, Long> sortedBag =
    bag.entrySet()
       .stream()
       .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
       .collect(Collectors.toMap(
           Map.Entry::getKey,
           Map.Entry::getValue,
           (v1, v2) -> { throw new IllegalStateException(); },
           LinkedHashMap::new
       ));
 */
