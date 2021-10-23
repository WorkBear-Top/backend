package top.workbear.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import top.workbear.backend.domain.AppRole;
import top.workbear.backend.domain.AppUser;
import top.workbear.backend.service.AppUserService;

import java.util.ArrayList;

/**
 * @author workbear
 */
@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(AppUserService userService) {
        return args -> {
            userService.saveRole(new AppRole(null, "ROLE_USER"));
            userService.saveRole(new AppRole(null, "ROLE_MANAGER"));
            userService.saveRole(new AppRole(null, "ROLE_ADMIN"));
            userService.saveRole(new AppRole(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new AppUser(null, "张三", "zhangsan@gmail.com", "admin123", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "李四", "lisi@gmail.com", "admin123", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "王五", "wangwu@gmail.com", "admin123", new ArrayList<>()));
            userService.saveUser(new AppUser(null, "狗蛋", "goudan@gmail.com", "admin123", new ArrayList<>()));

            userService.addRoleToUser("zhangsan@gmail.com", "ROLE_USER");
            userService.addRoleToUser("lisi@gmail.com", "ROLE_MANAGER");
            userService.addRoleToUser("wangwu@gmail.com", "ROLE_ADMIN");
            userService.addRoleToUser("goudan@gmail.com", "ROLE_SUPER_ADMIN");
        };
    }
}
