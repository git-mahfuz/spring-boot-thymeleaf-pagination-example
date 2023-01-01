package com.newroz.thymeleafpagination;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void generateDummyUsers() {
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setName("User " + i);
            user.setEmail("user" + i + "@example.com");
            user.setDistrict("District " + i);
            user.setDivision("Division " + i);
            user.setCountry("Country " + i);
            user.setStatus(i % 2 == 0);
            userRepository.save(user);
        }
    }

    public Page<User> getUsers(Pageable pageable, UserSearchFormParam userSearchFormParam) {
        return userRepository.findAll(UserSearchSpecs.getSearchTickets(userSearchFormParam), pageable);
    }

}

