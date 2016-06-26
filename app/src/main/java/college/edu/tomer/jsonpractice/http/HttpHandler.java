package college.edu.tomer.jsonpractice.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by master on 26/06/16.
 */
public class HttpHandler {
    /**
     *     <uses-permission android:name="android.permission.INTERNET"/>
     */
    public static  String getUrl(String address) throws IOException {
        BufferedReader reader = null;
        try {
            URL url = new URL(address);
            URLConnection con = url.openConnection();
            InputStream in = con.getInputStream();

            reader = new BufferedReader(new InputStreamReader(in));

            String line = reader.readLine();
            StringBuilder builder = new StringBuilder();
            while (line != null) {
                builder.append(line);
                line = reader.readLine();
            }
            return builder.toString();
        }
        finally {
            if (reader != null)
                reader.close();
        }

    }
}
