package kz.iitu.demo.events;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SalaryChangeEventHandler implements ApplicationListener<SalaryChangeEvent> {

    @Override
    public void onApplicationEvent(SalaryChangeEvent salaryChangeEvent) {
        System.out.println("-------------------------------");
        System.out.println("SalaryChangeEventHandler.onApplicationEvent");
        System.out.println("Updated employee info:");
        System.out.println("FixedSalary changed to " +salaryChangeEvent.getEmployee().getFixedSalary());
        System.out.println("-------------------------------");
    }
}
