import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("### Тестування Завдання №1 - HttpStatusChecker ###");
        HttpStatusChecker checker = new HttpStatusChecker();
        try {
            String imageUrl200 = checker.getStatusImage(200);
            System.out.println("URL для статусу 200: " + imageUrl200);

            String imageUrl404 = checker.getStatusImage(404);
            System.out.println("URL для статусу 404: " + imageUrl404);
        } catch (IOException ex) {
            System.out.println("Помилка " + ex.getMessage());
        }

        try {
            String imageUrl10000 = checker.getStatusImage(10000);
            System.out.println("URL для статусу 10000: " + imageUrl10000);
        } catch (IOException ex) {
            System.out.println("Помилка " + ex.getMessage());
        }

        System.out.println("\n### Тестування Завдання №2 - HttpStatusImageDownloader ###");
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        try {
            downloader.downloadStatusImage(418);
        } catch (IOException ex) {
            System.out.println("Помилка завантаження: " + ex.getMessage());
        }
        try {
            downloader.downloadStatusImage(420);
        } catch (IOException ex) {
            System.out.println("Помилка завантаження: " + ex.getMessage());
        }

        System.out.println("\n### Тестування Завдання №3 - HttpImageStatusCli ###");
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();
    }
}
