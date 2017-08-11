import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.*;
import com.google.common.primitives.Ints;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ljfeng on 2017/7/25.
 */
public class Guava {
    public static void main(String[] args) {
//        Optional<Integer> optional = Optional.absent();
//        System.out.println(optional.or(1));
//        System.out.println(optional.isPresent());

        Optional<Integer> optional1 = Optional.of(12);
        System.out.println(optional1.isPresent());
        System.out.println(optional1.get());

        boolean f = true;
        Preconditions.checkArgument(f);
//        f = false;
//        Preconditions.checkArgument(f);
        System.out.println(Objects.equal(null,null));
//        System.out.println(java.util.Objects.equals(null,null));
        System.out.println(Objects.hashCode("rgfrgtgyh"));
//        System.out.println(java.util.Objects.hash("rgfrgtgyh"));

        test ans = new test();
        System.out.println(ans.get());
        System.out.println(Objects.toStringHelper("MyObject").add("x", 1).toString());

        //Map<String,String> map = Maps.newHashMap();
        ImmutableMap<String,String> map2 = ImmutableMap.of("key1", "value1", "key2", "value2");
        System.out.println(map2.get("key2"));

        ImmutableSet<String> set = ImmutableSet.<String>builder().add("red","orange","yellow","green").build();
        System.out.println(set.toString());

        System.out.println(ImmutableSortedSet.of("a", "b", "c", "a", "d", "b"));

        int a = 30;
        int b = 20;
        System.out.println(Ints.compare(a, b));

        List<Integer> list = ImmutableList.of(1, 2, 3, 4);
        int[] array2 = Ints.toArray(list);
        System.out.println(array2.length);

        Table<Integer,Integer, Integer> weightedGraph = HashBasedTable.create();
        weightedGraph.put(1, 2, 4);
        weightedGraph.put(1, 3, 20);
        weightedGraph.put(2, 3, 5);
        System.out.println(weightedGraph.row(1)); // returns a Map mapping v2 to 4, v3 to 20
        System.out.println(weightedGraph.column(3));// returns a Map mapping v1 to 20, v2 to 5

        BiMap<String, Integer> userId = HashBiMap.create();
        userId.put("id",1);
        String userForId = userId.inverse().get(1);
        System.out.println(userForId);

        List countUp = Ints.asList(1, 2, 3, 4, 5);
        List countDown = Lists.reverse(countUp); // {5, 4, 3, 2, 1}
        System.out.println(countDown);
        List<List> parts = Lists.partition(countUp, 2);
        System.out.println(parts);

        Set<String> wordsWithPrimeLength = ImmutableSet.of("one", "two", "three", "six", "seven", "eight");
        Set<String> primes = ImmutableSet.of("two", "three", "five", "seven");
        Sets.SetView<String> intersection = Sets.intersection(primes,wordsWithPrimeLength);
        System.out.println(intersection);
        // intersection包含"two", "three", "seven"
        System.out.println(intersection.immutableCopy());
        //可以使用交集，但不可变拷贝的读取效率更高

        Map<String, Integer> left = ImmutableMap.of("a", 1, "b", 2, "d", 4,"c", 3);
        Map<String, Integer> right = ImmutableMap.of("a", 1, "b", 2,"e", 5, "c", 3);
        MapDifference<String, Integer> diff = Maps.difference(left, right);
        System.out.println(diff.entriesInCommon()); // {b=2, c=3, a=1}
        System.out.println(diff.entriesOnlyOnLeft()); // {d=4}
        System.out.println(diff.entriesOnlyOnRight()); // {e=5}

        System.out.println(Strings.isNullOrEmpty(""));//true
        System.out.println(Strings.nullToEmpty("12"));

        String s1 = null;
        System.out.println(Strings.nullToEmpty(""));


    }
}

class test{
    public String get(){
        return Objects.toStringHelper(this.getClass().getName()).add("x", 1).toString();
// Returns "MyObject{x=1}"
        //return Objects.toStringHelper("MyObject").add("x", 1).toString();
    }
}



//// Returns "ClassName{x=1}"
//        return Objects.toStringHelper(this.getClass().getName()).add("x", 1).toString();
//// Returns "MyObject{x=1}"
//        return Objects.toStringHelper("MyObject").add("x", 1).toString();

