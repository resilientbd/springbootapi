package com.faisal.canteenapp.canteenapp.user;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {

    private static List<User> userList = new ArrayList<>();
    private static int userCount = userList.size();

    /*static {
        userList.add(new User(1, "Sk. Faisal", "CSE"));
        userList.add(new User(2, "Shakiba E Nur", "EEE"));
        userList.add(new User(3, "Padmur", "TXT"));
    }*/

    public int addUser(User user) {
        if (user.getId() == 0) {
            user.setId(++userCount);
        }
        if (user.getDate() == null) {
            user.setDate(new Date());
        }
        userList.add(user);
        return user.getId();
    }

    public List<User> getAllUser() {
        return userList;
    }

    public User findUserById(int id) {
        for (User user : userList) {
            if (user.getId() == id)
                return user;
        }
        return null;
    }

    public User deleteUserById(int id)
    {
        Iterator<User> userIterator = userList.iterator();
        if(userIterator.hasNext())
        {
            User user = userIterator.next();
            if(user.getId()==id)
            {
                userIterator.remove();
                return user;
            }
        }
        return null;
    }


}
