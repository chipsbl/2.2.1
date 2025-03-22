package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);


        userService.add(new User("Fedor", "Drozdov", "drozdovkin@mail.ru",
                new Car("Toyota Camry", 322)));
        userService.add(new User("Rayan", "Gosling", "sigma@mail.ru",
                new Car("Chevrolet Cruze", 251)));
        userService.add(new User("Ariana", "Grande", "popstar@mail.ru",
                new Car("Lada Granta", 151)));
        userService.add(new User("Bil", "Harington", "noname@mail.ru",
                new Car("Nissan Almeiro", 592)));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car model = " + user.getCar().getModel());
            System.out.println("Car series = " + user.getCar().getSeries());
            System.out.println("-----------------------------------");
        }
        userService.getUserByCar("Toyota Camry", 322);
        context.close();
    }
}
