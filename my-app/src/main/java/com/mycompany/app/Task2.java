package com.mycompany.app;

import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Task2 {
    public static void main(String[] args) {
        try {
            // Создаём URL
            URL url = new URL("https://api.ipify.org/?format=json");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Чтение ответа
            Reader reader = new InputStreamReader(connection.getInputStream());
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(reader);

            // Получение IP
            String ip = (String) json.get("ip");
            System.out.println("Ваш IP-адрес: " + ip);

        } catch (Exception e) {
            System.out.println("Ошибка:");
            System.out.println(e.toString());
        }
    }
}
