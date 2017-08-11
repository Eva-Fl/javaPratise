import java.util.*;

/**
 * Created by ljfeng on 2017/8/1.
 */
public class map {
    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(2,3);
        map.put(3,8);
        map.put(4,3);
        map.put(5,8);
        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
        List<Integer> list = new ArrayList<>();

        while (entries.hasNext()) {
            Map.Entry<Integer, Integer> entry = entries.next();
            //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            list.add(entry.getKey());
        }
        System.out.println(list);
        if (list.contains(5)) {
            System.out.println(true);
        }
    }
}
