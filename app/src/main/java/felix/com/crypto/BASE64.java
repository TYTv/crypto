package felix.com.crypto;

import android.util.Base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;

/**
 * Created by Felix on 2017/10/15.
 */

public class BASE64 {


    //1.）字符串进行Base64编码
    public static String encoder(String data) {
        return Base64.encodeToString(data.getBytes(), Base64.DEFAULT);
    }

    //2.）字符串进行Base64解码
    public static String decoder(String data) {
        return new String(Base64.decode(data, Base64.DEFAULT));
    }

    // 3.）对文件进行Base64编码
    public static void encoder(File fin, File fout) {

        try {
            FileInputStream inputFile = new FileInputStream(fin);
            byte[] buffer = new byte[(int) fin.length()];
            inputFile.read(buffer);
            inputFile.close();
//            encodedString = Base64.encodeToString(buffer, Base64.DEFAULT);
            FileWriter fw = null;
            try {
                fw = new FileWriter(fout);
                fw.write(Base64.encodeToString(buffer, Base64.DEFAULT));
            } finally {
                fw.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    // 4.）对文件进行Base64解码
    public static void decoder(File fin , File fout) {

        String data = FileRW.fileR(fin);

        try {
            byte[] decodeBytes = Base64.decode(data.getBytes(), Base64.DEFAULT);
            FileOutputStream fos = new FileOutputStream(fout);
            fos.write(decodeBytes);
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}