import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by ljfeng on 2017/8/23.
 */
public class listTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        //int num = list.size();
//        for (int i = 0; i < list.size(); i++){
//            if (list.get(i) == 5){
//                list.remove(i);
//                //i--;
//            }
//        }

//        // java.util.ConcurrentModificationException
//        Iterator<Integer> iterator = list.iterator();
//        while(iterator.hasNext()){
//            Integer item = iterator.next();
//            if (item == 4){
//                list.remove(item);
//            }
//        }

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer item = iterator.next();
            if (item == 4) {
                iterator.remove();
            }
        }

        //java.lang.IndexOutOfBoundsException
//        for (int i = 0; i < num; i++){
//            if (list.get(i) == 5){
//                list.remove(i);
//                //i--;
//            }
//        }

//        for (Integer item: list){
//            if (item == 5){
//                list.remove(item);
//            }
//        }
//        for (int i = 0; i < list.size(); i++){
//            System.out.println(list.get(i));
//        }
    }
}
