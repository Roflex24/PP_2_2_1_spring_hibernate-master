package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.model.Car;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      Car car1 = new Car(user1, "model1", 1);
      userService.add(user1);
      userService.addCar(car1);
      user1.setUserCar(car1);

      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      Car car2 = new Car(user2, "model2", 2);
      userService.add(user2);
      userService.addCar(car2);
      user1.setUserCar(car2);

      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      Car car3 = new Car(user3, "model3", 3);
      userService.add(user3);
      userService.addCar(car3);
      user1.setUserCar(car3);

      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      Car car4 = new Car(user4, "model4", 4);
      userService.add(user4);
      userService.addCar(car4);
      user1.setUserCar(car4);


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println();
      }

      System.out.println(userService.getUserByCar("model3", 3).toString());

      context.close();
   }
}
