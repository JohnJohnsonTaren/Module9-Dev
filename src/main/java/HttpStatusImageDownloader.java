//Завдання №2 - скачай картинку
//Напиши клас HttpStatusImageDownloader.
//  Цей клас має мати один метод:
//      void downloadStatusImage(int code). Він приймає код статусу,
//      і якщо для цього коду статусу є картинка - скачує цю картинку,
//      і зберігає її в папці, де була запущена програма.
//      Якщо картинки немає - метод викидає Exception.
//Використай клас HttpStatusSchecker з попереднього завдання
// для отримання шляху до картинки та визначення наявності самої картинки.

import javax.imageio.IIOException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class HttpStatusImageDownloader {
    private HttpStatusChecker statusChecker;

    public HttpStatusImageDownloader() {
        this.statusChecker = new HttpStatusChecker();
    }

    public void downloadStatusImage(int code) throws IOException{
        try {
            String imageUrl = statusChecker.getStatusImage(code);
            URL url = new URL(imageUrl);

            try(InputStream in = url.openStream();
                FileOutputStream fos = new FileOutputStream(code + ".jpg")) {
                byte [] buffer = new byte[4096];
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
