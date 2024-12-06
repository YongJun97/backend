package data;

import entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserDB {
    private static final UserDB userDB = new UserDB();

    public static UserDB getInstance() {
        return userDB;
    }

    private final ArrayList<User> userList = new ArrayList<>();

    public void insertUser(User user) {
        userList.add(user);
    }

    public Optional<User> getUserByUserId(String userId) {
        User findUser = null;
        for (User user : userList) {
            if (user.getUserID().equals(userId)) {
                findUser = user;
                break;
            }
        }
        return Optional.ofNullable(findUser);
    }

    public List<User> getAllUsers() {
        return userList.stream().filter(x -> !x.isAdmin()).collect(Collectors.toList());
    }
}