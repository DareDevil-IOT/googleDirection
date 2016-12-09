package com.tw.dir.directionApi;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

public class retrieveDirection {
    private static Logger LOGGER = Logger.getLogger("InfoLogging");

    public void downloadUrl(String strUrl) throws IOException {
        String data = "";
        InputStream iStream = null;
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(strUrl);

            // Creating an http connection to communicate with url
            urlConnection = (HttpURLConnection) url.openConnection();

            // Connecting to url
            urlConnection.connect();

            // Reading data from url
            LOGGER.info("Reading data from url....");
            iStream = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(iStream));
            StringBuffer sb = new StringBuffer();

            String line = "";
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString();
            br.close();
            PrintWriter printWriter = new PrintWriter("data/direction.json");
            printWriter.print(data);

        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
        } finally {
            iStream.close();
            urlConnection.disconnect();
        }
    }
}
