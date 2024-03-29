package com.example.springbatchexample.batch;

import com.example.springbatchexample.model.User;
import com.example.springbatchexample.repository.UserRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<User> {

    private final UserRepository userRepository;

    @Autowired
    public DBWriter(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void write(List<? extends User> users) throws Exception {
        System.out.println("Data saved for Users: " + users);
        userRepository.saveAll(users);
    }
}
