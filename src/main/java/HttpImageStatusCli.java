//Завдання №3 - створи CLI
//Напиши клас HttpImageStatusCli. У цього класу має бути один метод:
//  void askStatus()
//      Коли викликається цей метод, то програма повинна:
//          запитати у юзера код статусу
//          (наприклад, Enter HTTP status code)
//          юзер вводить в консоль код статусу (наприклад, 200)
//        програма перевіряє, чи є картинка для цього статусу
//        на сайті https://http.cat, і якщо є - то скачує цю картинку.
//        Якщо ж картинки немає - виводить в консоль фразу
//        There is not image for HTTP status <CODE>
//          (замість <CODE> підставляється код статусу, що ввів користувач)
//  якщо користувач вводить некоректне число (наприклад, test) -
//      програма має вивести фразу Please enter valid number
//  Використай клас HttpStatusImageDownloader з попереднього завдання.

import java.io.IOException;
import java.util.Scanner;

public class HttpImageStatusCli {
    private HttpStatusImageDownloader imageDownloader;

    public HttpImageStatusCli () {
        this.imageDownloader = new HttpStatusImageDownloader();
    }

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter HTTP status code: ");

        while (true) {
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            try {
                int code = Integer.parseInt(input);
                imageDownloader.downloadStatusImage(code);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        scanner.close();
    }
}

