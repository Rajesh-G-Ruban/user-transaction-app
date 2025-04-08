package txn;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import txn.model.AppUser;
import txn.model.UserRoleEnum;
import txn.service.AppUserService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@RequiredArgsConstructor
public class TransactionApp implements CommandLineRunner {

    @Autowired
    AppUserService appUserService;

    public static void main(String[] args) {
        SpringApplication.run(TransactionApp.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


    @Override
    public void run(String... params) throws Exception {
        AppUser admin = new AppUser();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setUserRole( UserRoleEnum.ROLE_ADMIN);
        appUserService.signupUser(admin);
    }

}
