package Observers;

import Model.Observer;
//import org.apache.commons.codec.binary.Base64;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Brandon on 2015-09-14.
 */
public class Pushbullet implements Observer {

    private static final String api_key = "";

    @Override
    public void update(String charName, boolean status) {
        SSLSocketFactory sslSocketFactory = null; // getSSL();

        HttpsURLConnection connection = null;
        try {
            connection = (HttpsURLConnection) new URL(
                    "https://www.pushbullet.com/api/devices").openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        connection.setSSLSocketFactory(sslSocketFactory);

        try {
            connection.setRequestMethod("GET");
        } catch (ProtocolException e) {
            e.printStackTrace();
        }

        connection.setUseCaches(false);
        connection.setDoInput(true);
        connection.setDoOutput(true);

        String authStr = api_key + ":";
        String authEncoded = null; //Base64.encodeBytes(authStr.getBytes());
        connection.setRequestProperty("Authorization", "Basic " + authEncoded);

        InputStream is = null;
        try {
            is = connection.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader rd = new BufferedReader(new InputStreamReader(is));
        String line;
        StringBuffer response = new StringBuffer();
        try {
            while ((line = rd.readLine()) != null) {
                response.append(line);
                response.append('\r');


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            rd.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(response.toString());
    }
}
