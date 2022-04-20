package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main_3_Test_Around {
    public static void main(String[] args) {
        System.out.println("Method Main Start ...");
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(Config.class);

        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        String returnBook = uniLibrary.returnBook();
        System.out.println("В библиотеку вернули книгу " + returnBook);

        context.close();
        System.out.println("Method Main end ...");
    }
}
