import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ljfeng on 2017/8/16.
 */
public class repeatTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        char[] lineStr = line.toCharArray();

        //寻找前缀后缀最长公共元素长度
        // 如aba，有长度为1的相同前缀后缀a
        // abab，有长度为2的相同前缀后缀ab
        int[] repeat = new int[line.length()];
        int k = -1;
        int j = 0;
        repeat[0] = -1;
        while(j < line.length() - 1){
            if (k == -1 || lineStr[j] == lineStr[k]){
                ++k;
                ++j;
                repeat[j] = k;
            }else{
                k = repeat[k];
            }
        }
        for (int i = 0; i < repeat.length; i++){
            System.out.print(repeat[i] + " ");
        }
    }
}
