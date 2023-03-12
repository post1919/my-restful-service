package com.example.myrestfulservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount = 3;
    static {
        users.add(new User(1, "dongah.shin", new Date(), "pass1", "810101-1010293"));
        users.add(new User(2, "dongah.shin", new Date(), "pass2", "810102-1010293"));
        users.add(new User(3, "dongah.shin", new Date(), "pass3", "810103-1010293"));
    }

    public User save(User user){
        if( user.getId() == null ){
            user.setId(++usersCount);
        }

        users.add(user);

        return user;
    }

    public List<User> findAll(){
        return users;
    }

    public User findOne(int id){
        for (User user : users) {
            if(user.getId() == id){
                return user;
            }
        }

        return null;
    }
}
