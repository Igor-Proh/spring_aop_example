package aop;

import org.springframework.stereotype.Component;


@Component
public class UniLibrary extends AbstractLibrary {

    public static void printDash() {
        System.out.println("-----------------------------------------");
    }

    public void getBook() {
        System.out.println(">>> Мы берем книгу из UniLibrary");
        printDash();
    }

    public String returnBook() {
        System.out.println(">>> Мы возвращаем книгу в UniLibrary");
        printDash();
        return "Война и мир";
    }

    public void getMagazine() {
        System.out.println(">>> Мы берем журнал из UniLibrary");
        printDash();
    }

    public void returnMagazine() {
        System.out.println(">>> Мы возвращаем журнал в UniLibrary");
        printDash();
    }

    public void addBook(String personName, Book book) {
        System.out.println(">>> Мы добавляем книгу в UniLibrary");
        printDash();
    }

    public void addMagazine() {
        System.out.println(">>> Мы добавляем журнал в UniLibrary");
        printDash();
    }
}
