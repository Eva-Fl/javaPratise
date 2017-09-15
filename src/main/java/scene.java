/**
 * Created by ljfeng on 2017/9/11.
 */
public class scene {
    public static void main(String[] args) {

        int processStatus = 68355;
        System.out.println(((processStatus & 8) == 8) && ((processStatus & 16) == 16));
    }
}



