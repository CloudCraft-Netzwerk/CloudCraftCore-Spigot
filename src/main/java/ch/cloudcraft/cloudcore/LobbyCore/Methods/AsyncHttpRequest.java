package ch.cloudcraft.cloudcore.LobbyCore.Methods;

import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class AsyncHttpRequest implements Runnable {
    private JSONObject applicant;
    private String URL;

    public AsyncHttpRequest(String URL, JSONObject object) {
        this.applicant = object;
        this.URL = URL;
    }

    public static String getResponse(String URL, JSONObject obj) {
        String fresponse = null;
        try {

            HttpURLConnection httpClient =
                    (HttpURLConnection) new URL(URL).openConnection();

            // optional default is GET
            httpClient.setRequestMethod("POST");
            httpClient.setRequestProperty("Content-Type", "application/json; utf-8");
            httpClient.setRequestProperty("User-Agent", "Http go skrr");

            httpClient.setDoOutput(true);
            try (OutputStream os = httpClient.getOutputStream()) {
                byte[] input = obj.toJSONString().getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }

            //add request header

            int responseCode = httpClient.getResponseCode();

            System.out.println("Making Request to " + URL);
            System.out.println("Response Code : " + responseCode);

            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(httpClient.getInputStream()))) {

                StringBuilder response = new StringBuilder();
                String line;

                while ((line = in.readLine()) != null) {
                    response.append(line);
                }

                fresponse = response.toString();


            }


        } catch (IOException ex) {
            ex.printStackTrace();
        }


        return fresponse;
    }

    @Override
    public void run() {
        System.out.println(getResponse(URL, applicant));
        System.out.println("Sending finished! Interrupting thread");
        Thread.currentThread().interrupt();
    }
}
