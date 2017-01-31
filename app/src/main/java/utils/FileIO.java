package utils;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Rana Ahsan Ali on 2/1/2017.
 */

public class FileIO {

    public static String readFile(Context context, int fileResource) {
        InputStream inputStream = context.getResources().openRawResource(fileResource);

        System.out.println(inputStream);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return byteArrayOutputStream.toString();

    }
}
