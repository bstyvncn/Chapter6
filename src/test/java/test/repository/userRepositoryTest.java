package test.repository;

import org.binar.chapter4.model.users;
import org.binar.chapter4.repositories.userRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class userRepositoryTest {
    @Autowired
    userRepository userRepository;


}
