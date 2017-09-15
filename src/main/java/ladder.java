/**
 * Created by ljfeng on 2017/8/4.
 */
public class ladder {

    //递归解决
    private static int calculateCount(int ladder, int maxJump) {
        int jump = 0;
        if (ladder == 0) {
            return 1;
        }
        if (ladder >= maxJump) {
            // 剩下的楼梯大于最大可跳跃数
            for (int i = 1; i <= maxJump; i++) {
                jump += calculateCount(ladder - i, maxJump);
            }
        } else {
            // 剩下的楼梯不足最大可跳跃数
            jump = calculateCount(ladder, ladder);
        }
        return jump;
    }

    //非递归方法
    //当楼梯数为1、2、3、4、5时，对应的爬法有：1、2、3、5、8、13、21种。
    //随着楼梯数n的增加，爬法总数呈现斐波那契数列规律增加，即f（n） = f（n-1） + f（n-2）
    private static int count(int ladder) {
        if (ladder == 1 || ladder == 2) {
            return ladder;
        }
        int n1 = 1;
        int n2 = 2;
        for (int i = 3; i <= ladder; i++) {
            int tmp = n2;
            n2 = n1 + n2;
            n1 = tmp;
        }
        return n2;
    }

    public static void main(String[] args) {
        int ladder = 4;
        int maxJump = 2;
        int i = calculateCount(ladder, maxJump);
        System.out.println(i);
        for (int j = 1; j < 9; j++){
            System.out.println(count(j));
        }
    }
}
