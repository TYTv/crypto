package felix.com.crypto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String path = getFilesDir().getAbsolutePath() + File.separator + "Hello";

        String aaa = MD5.md5("MD5密碼");
        FileRW.fileW(new File(path + ".txt"), aaa);

        BASE64.encoder(new File(path + ".txt"), new File(path + ".b64"));
        BASE64.decoder(new File(path + ".b64"), new File(path + ".b64.txt"));

        String key = DES.generateKey();
        String desdat = DES.encode(key, aaa);
        String dat = DES.decode(key, desdat );

    }
}
