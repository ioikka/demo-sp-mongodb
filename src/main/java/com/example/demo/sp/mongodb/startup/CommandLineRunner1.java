package com.example.demo.sp.mongodb.startup;

import com.example.demo.sp.mongodb.model.document.User;
import com.example.demo.sp.mongodb.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@ConditionalOnProperty(prefix = "app.props.startup", name = "enabled", havingValue = "true")
@Slf4j
@RequiredArgsConstructor
@Component
public class CommandLineRunner1 implements CommandLineRunner {
    private final UsersRepository usersRepository;

    @Override
    public void run(String... args) throws Exception {
        usersRepository.insert(User.builder().name("tester").birthDate(LocalDate.now()).build());
        List<User> all = usersRepository.findAll();
        for (User user : all) {
            log.info("{}", user);
        }
    }
}
