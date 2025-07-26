//Завдання №2 - скачай картинку
//Напиши клас HttpStatusImageDownloader.
//  Цей клас має мати один метод:
//      void downloadStatusImage(int code). Він приймає код статусу,
//      і якщо для цього коду статусу є картинка - скачує цю картинку,
//      і зберігає її в папці, де була запущена програма.
//      Якщо картинки немає - метод викидає Exception.
//Використай клас HttpStatusSchecker з попереднього завдання
// для отримання шляху до картинки та визначення наявності самої картинки.

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class HttpStatusImageDownloader {
    private static final int BUFFER_SIZE = 4096;
    private HttpStatusChecker statusChecker;

    public HttpStatusImageDownloader() {
        this.statusChecker = new HttpStatusChecker();
    }

    public void downloadStatusImage(int code) throws IOException{
        try {
            String imageUrl = statusChecker.getStatusImage(code);
            if (imageUrl == null || imageUrl.isEmpty()) {
                throw new IOException("No image found for status code: " + code);
            }

            URL url = new URL(imageUrl);

            byte[] buffer = new byte[BUFFER_SIZE];

            try(InputStream in = url.openStream();
                FileOutputStream fos = new FileOutputStream(code + ".jpg")) {
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
                System.out.println("Image " + code + ".jpg donwloaded successefully.");
            }
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }
    }
}

