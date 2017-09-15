/**
 * Created by ljfeng on 2017/8/16.
 */
public class intToByte {
    public static void main(String[] args) {
        int a = 285;
        byte[] ans = convertIntToByte(a);
        for (int i = 0; i < ans.length; i++){
            System.out.println(ans[i]);
        }
    }
    public static byte[] convertIntToByte(int val){
        byte[] rtn = new byte[4];
//        rtn[0] = (byte)((val >> 24) & 0xff);
//        rtn[1] = (byte)((val >> 16) & 0xff);
//        rtn[2] = (byte)((val >> 8) & 0xff);
//        rtn[3] = (byte)(val & 1);
        rtn[0] = (byte)(val >> 24);
        rtn[1] = (byte)(val >> 16);
        rtn[2] = (byte)(val >> 8);
        rtn[3] = (byte)(val);
        return rtn;
    }
}
