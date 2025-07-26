//Завдання №1 - отримай посилання
//Напиши класс HttpStatusChecker. Цей клас має мати один метод:
//      String getStatusImage(int code). Він приймає код статусу,
//              і повертає посилання на картинку для цього коду.
//              Якщо для відповідного коду картинки немає
//              (сайт https://http.cat повернув 404) - метод викидає Exception.
//        Наприклад, виклик getStatusImage(200) має повернути рядок
//        https://http.cat/200.jpg. А виклик getStatusImage(10000)
//        має викинути виключення, тому що сайт https://http.cat поверне
//        код відповіді 404.
//Протестуй свою програму, викликаючи її з різними аргументами.

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static java.net.HttpURLConnection.HTTP_NOT_FOUND;
import static java.net.HttpURLConnection.HTTP_OK;

public class HttpStatusChecker {
    public String getStatusImage(int code) throws IOException {
        String imageUrl = "https://http.cat" + code + ".jpg";
        URL url = new URL(imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("HEAD");

        int responseCode = connection.getResponseCode();

        if (responseCode == HTTP_OK) {
            return imageUrl;
        } else if (responseCode == HTTP_NOT_FOUND) {
            throw new IOException("Image not found for status code " + code);
        }
        return imageUrl;
    }
}
