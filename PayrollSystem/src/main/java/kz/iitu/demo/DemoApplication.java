package kz.iitu.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("kz.iitu.demo");
        context.refresh();

        PayrollSystem payrollSystem = context.getBean(PayrollSystem.class);
        payrollSystem.showMenu();
    }

}
