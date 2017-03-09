package utils;

import framework.Log;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {
    public static JSONObject sendGet(String send) {
        try {
            URL url = new URL(send);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("GET");
            con.setRequestProperty("Content-length", "0");
            con.connect();

            InputStream in = con.getInputStream();

            int ch;
            String text = "";

            while ((ch = in.read()) != -1) {
                text += (char) ch;
            }

            Log.info("Send GET request: " + send);
            return new JSONObject(text);
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }
}
