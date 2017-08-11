import java.util.HashMap;

/**
 * Created by ljfeng on 2017/8/9.
 */
public class twoSum {
    public int[] sum(int[] numbers, int target) {
        int[] res = new int[2];
        if(numbers==null || numbers.length<2){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<numbers.length;i++)
        {
            if(map.containsKey(target-numbers[i]))
            {
                res[0]=map.get(target-numbers[i])+1;
                res[1]=i+1;
                return res;
            }
            map.put(numbers[i],i);
        }
        return null;
    }

    public int[] sum1(int[] numbers, int target) {
        int[] res = new int[2];
        if(numbers==null || numbers.length<2){
            return null;
        }
        for (int i = 0; i < numbers.length; i++){
            res[0] = i + 1;
            for (int j = i + 1; j < numbers.length; j++ ){
                if (target == numbers[i] + numbers[j]){
                    res[1] = j+1;
                    return res;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {1,3,5,6,8};
        int target = 7;
        twoSum twoSum = new twoSum();
        int[] res = twoSum.sum1(numbers,target);
        int[] result = twoSum.sum(numbers,target);
        //System.out.println(res.length);
        for (int i = 0; i < res.length; i++){
            System.out.print(res[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
