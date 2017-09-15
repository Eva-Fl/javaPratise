import java.util.Scanner;


/**
 * Created by ljfeng on 2017/9/1.
 */
public class KMPTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //匹配字符串
        String S = sc.next();
        //匹配字符子串
        String P = sc.next();
        int location = ViolentMatch(S, P);
        System.out.println(location);
        location = KMPMatch(S, P);
        System.out.println(location);
    }
    //暴力破解法
    private static int ViolentMatch(String s, String p) {
        int i = 0;
        int j = 0;
        char[] str = s.toCharArray();
        char[] ptr = p.toCharArray();
        while((i < str.length) && (j < ptr.length)){
            if (str[i] == ptr[j]){
                i++;
                j++;
            }else{
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == ptr.length){
            return i-j;
        }
        return -1;
    }

    //KMP
    private static int KMPMatch(String s, String p) {
        int i = 0;
        int j = 0;
        char[] str = s.toCharArray();
        char[] ptr = p.toCharArray();
        int[] next = getNext(ptr);
        while((i < str.length) && (j < ptr.length)){
            //如果j=-1，或者当前字符匹配成功,都令i++，j++，继续匹配下一个字符；
            if (j == -1 || str[i] == ptr[j]){
                i++;
                j++;
            }else{
                //如果j!=-1，且当前字符匹配失败（即S[i] != P[j]），
                // 则令 i 不变，j = next[j]
                // 意味着失配时，模式串P相对于文本串S向右移动了j - next [j] 位
                // 当匹配失败时，模式串向右移动的位数为：失配字符所在位置 - 失配字符对应的next值
                // 即移动的实际位数为：j - next[j]，且此值大于等于1。
                j = next[j];
            }
        }
        if (j == ptr.length){
            return i-j;
        }
        return -1;
    }

    /**
     *  next 数组的求解
     *  next 数组各值的含义：代表当前字符之前的字符串中，有多大长度的相同前缀后缀
     *
     */
    private static int[] getNext(char[] ptr) {
        int len = ptr.length;
        int[] next = new int[len];
        next[0] = -1;
        int k = -1;
        int j = 0;
        while(j < len - 1){
            //ptr[k]表示前缀，ptr[j]表示后缀
            if (k == -1 || ptr[j] == ptr[k]){
                ++k;
                ++j;
                if (ptr[j] != ptr[k]){
                    // 优化---当p[j] != s[i] 时，下次匹配必然是p[ next [j]] 跟s[i]匹配
                    // 如果p[j] = p[ next[j] ]，必然导致后一步匹配失败
                    // p[j]已经跟s[i]失配，然后用跟p[j]等同的值p[next[j]]去跟s[i]匹配，必然失配
                    // 所以不能允许p[j] = p[ next[j ]]。
                    // 如果出现了p[j] = p[ next[j] ]，则需要再次递归，即令next[j] = next[ next[j] ]
                    next[j] = k;
                }
                else{
                    //因为不能出现p[j] = p[ next[j ]]，所以当出现时需要继续递归，k = next[k] = next[next[k]]
                    next[j] = next[k];
                }
                //next[j] = k;
            }else{
                k = next[k];
            }
        }
        return next;
    }
}
