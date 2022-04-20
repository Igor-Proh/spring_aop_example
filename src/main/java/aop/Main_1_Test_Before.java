package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main_1_Test_Before {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary",SchoolLibrary.class);
        Book book = context.getBean("book", Book.class);

        uniLibrary.getBook();
        uniLibrary.addBook("Ihor",book);
        uniLibrary.addMagazine();

        context.close();
    }
}
