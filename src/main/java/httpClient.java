


import java.io.*;
import java.net.URLConnection;

/**
 * Created by ljfeng on 2017/7/17.
 */
public class httpClient {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\response.pdf");

        System.out.println(URLConnection.guessContentTypeFromName("D:\\文件存储设计方案.pdf"));


        InputStream is = new BufferedInputStream(new FileInputStream(file));
        System.out.println(URLConnection.guessContentTypeFromStream(is));

        long length = file.length();
        InputStream is1 = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream((int)length);
        byte[] bys = new byte[(int)length];
        int len = -1;
        while ((len = is1.read(bys)) != -1){
            bos.write(bys,0,len);
        }
        byte[] content = bos.toByteArray();
        System.out.println(content);

        InputStream inputStream = new ByteArrayInputStream(content);
        System.out.println(URLConnection.guessContentTypeFromStream(inputStream));
}

}
