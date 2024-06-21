package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.entities.User;
import spring.resources.UserResource;
import spring.service.ServiceKotlin;


@RestController
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    private ServiceKotlin serviceKotlin;
    private UserResource userResource;

    @Autowired
    public void KotlinController(ServiceKotlin serviceKotlin, UserResource userResource){
        this.serviceKotlin = serviceKotlin;
        this.userResource = userResource;
    }

    @GetMapping("/oi")
    public String testServer() {
        System.out.println("Request");
        return serviceKotlin.nameString();
    }
    @GetMapping("/teste")
    public ResponseEntity<User> testServer2() {
        return userResource.findAll();
    }
}
