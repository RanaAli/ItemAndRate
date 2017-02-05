package utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Rana Ahsan Ali on 2/1/2017.
 */

public class FileIO {

    public String readFile(String fileName) {

        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);

            System.out.println(inputStream);

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

            int i;

            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }
            inputStream.close();

            return byteArrayOutputStream.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
