package aop.aspects;

import aop.Book;
import aop.UniLibrary;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(10)
public class LoggingAspect {

    @Before("aop.aspects.MyPointcuts.allAddMethods()")
    public void beforeAddLoggingAdvice(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();

        System.out.println("methodSignature = " + methodSignature);
        System.out.println("methodSignature.getMethod() = " + methodSignature.getMethod());
        System.out.println("methodSignature.getReturnType() = " + methodSignature.getReturnType());
        System.out.println("methodSignature.getName() = " + methodSignature.getName());

        if (methodSignature.getName().equals("addBook")) {
            Object[] arguments = joinPoint.getArgs();
            for (Object obj : arguments) {
                if (obj instanceof Book) {
                    Book myBook = (Book) obj;
                    System.out.println("Информация о книге: название - " + myBook.getName() +
                            ", автор - " + myBook.getAuthor() +
                            ", год издания - " + myBook.getYearOfPublication());
                }
                else if(obj instanceof String){
                    System.out.println("Книгу в библиотеку добавляет - " + obj);
                }
            }
        }

        System.out.println("beforeGetLoggingAdvice: логирование попытки получить книгу/журнал");
        UniLibrary.printDash();
    }

    /* Пример 1
    // Pointcut написан таким образом что будет вызыватся для всех методов getBook где бы он не находился
    @Before("execution(public void getBook())") // @Before( pointcut )
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: попытка получить книгу");
    }
    */

    /* Пример 2
    // В данном примере Pointcut обращается к конкретному методу (getBook) из конкретного класса (UniLibrary)
    @Before("execution(public void aop.UniLibrary.getBook())") // @Before( pointcut )
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: попытка получить книгу");
    }
    */

    /* Пример 3
    // В данном примере Pointcut обращается ко всем методам без параметров с любым уровнем доступа, любым возвращ. значением и любым именем
    @Before("execution(* *())")
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: попытка получить книгу");
    }
    */

    /*
    // Пример 4
    // В данном примере Pointcut обращается ко всем методам которые начинаются на get
    @Before("execution(public void get* ())") // @Before( pointcut )
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: попытка получить книгу");
    }
     */

    /*
    // Пример 5
    // В данном примере Pointcut обращается ко всем методам returnBook c любыи возвращающим значением
    @Before("execution(* returnBooK())")
    public void beforeReturnBookAdvice(){
        System.out.println("beforeReturnBookAdvice: попытка вернуть книгу");
    }
     */

    /*
    // Пример 6
    // В данном примере Pointcut обращается к любому методу с 1 параметром
    @Before("execution(public void * (*))") // @Before( pointcut )
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: попытка получить книгу");
    }
    */

    /*
    // Пример 7
    // В данном примере Pointcut обращается к любому методу с любым кол параметром
    @Before("execution(public void * (..))") // @Before( pointcut )
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: попытка получить книгу");
    }
    */

    /*
    // Пример 8
    // В данном примере Pointcut обращается к методу getBook с 1 параметром Book
    @Before("execution(public void getBook (aop.Book))") // @Before( pointcut )
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: попытка получить книгу");
    }
     */

    /*
    // Пример 9
    // В данном примере Pointcut обращается к любому методу с любым
    // количеством любого типа параметров и любым уровнем доступа где бы они не находились
    @Before("execution(* *(..))") // @Before( pointcut )
    public void beforeGetBookAdvice(){
        System.out.println("beforeGetBookAdvice: попытка получить книгу");
    }
     */
}
