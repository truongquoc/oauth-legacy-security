package com.example.oauthlegacysecurity.data;

//import com.example.oauthlegacysecurity.repository.UserRepository;
import com.example.oauthlegacysecurity.constants.RoleEnum;
import com.example.oauthlegacysecurity.entity.Role;
import com.example.oauthlegacysecurity.entity.User;
import com.example.oauthlegacysecurity.repository.RoleRepository;
import com.example.oauthlegacysecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
public class DatabaseEnrichmentRunner implements CommandLineRunner {
    @Value("${data.users:admin,userman,user1,user2,user3,user4,user5}")
    private String[] users;
    @Value("${data.nouns:sky,winter,sun,moon,spring,weekend,fall,summer,mountain,wolf,bird}")
    private String[] nouns;
    @Value("${data.verbs:falling,rising,exploding,shining,coming,lightning,howling,chirping}")
    private String[] verbs;
    @Value("${data.feelings:bad,numb,fine,good}")
    private String[] feelings;
    @Value("${data.timeOfDay:morning,afternoon,evening,night}")
    private String[] timeOfDay;


    @Bean
    public CommandLineRunner initDatabase(RoleRepository repository) {
        return args -> {
            List<Role> roles = List.of(
                    new Role(1L, RoleEnum.USER),
                    new Role(2L, RoleEnum.USER_MANAGER),
                    new Role(3L, RoleEnum.ADMIN)
            );

            repository.saveAll(roles);
        };
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("DatabaseEnrichmentRunner.run");
    }
}
