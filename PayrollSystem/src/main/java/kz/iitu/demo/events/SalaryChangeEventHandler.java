package kz.iitu.demo.events;

import kz.iitu.demo.events.SalaryChangeEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SalaryChangeEventHandler implements ApplicationListener<SalaryChangeEvent> {

    @Override
    public void onApplicationEvent(SalaryChangeEvent salaryChangeEvent) {
        System.out.println("-------------------------------");
        System.out.println("SalaryChangeEventHandler.onApplicationEvent");
        System.out.println("Updated employee info:" +
                "\nEmployee: " + salaryChangeEvent.getEmployee().getEmpName()+
                "\nUpdated field: "+salaryChangeEvent.getUpdatedField()+
                "\nUpdated value: "+salaryChangeEvent.getUpdatedValue());
        System.out.println("-------------------------------");
    }
}