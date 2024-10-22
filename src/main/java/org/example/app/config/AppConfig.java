package org.example.app.config;

import org.example.app.controller.EmployeeController;
import org.example.app.repository.employee.EmployeeRepository;
import org.example.app.repository.employee.EmployeeRepositoryImpl;
import org.example.app.service.employee.EmployeeService;
import org.example.app.service.employee.EmployeeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
// Spring сканує файли, які знаходяться в пакеті org.example.app
@ComponentScan("org.example.app")
public class AppConfig {


    // Оголошення біну для EmployeeRepository
      @Bean("employeeRepository")
    public EmployeeRepository employeeRepository() {
        return new EmployeeRepositoryImpl();
    }


 // Оголошення біну для EmployeeService
   @Bean("employeeService")
    public EmployeeService employeeService() {
        return new EmployeeServiceImpl(employeeRepository()); // Передача біну EmployeeRepository
    }

   /*   // Оголошення біну для EmployeeController
   @Bean("EmployeeController")
    public EmployeeController employeeController() {
        return new EmployeeController(employeeService()); // Передача біну EmployeeService
    }*/

}
