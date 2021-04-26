package iitu.javaee.javaee_endterm.service;

import iitu.javaee.javaee_endterm.db.dao.UserDao;
import iitu.javaee.javaee_endterm.model.User;

public class UserService {
    private UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public boolean checkUserByUsernameAndPassword(String username, String password) {
        return userDao.getUserByUsernameAndPassword(username, password) != null;
    }

    public boolean checkUsername(String username) {
        return userDao.getUserByUsername(username) != null;
    }

    public void createUser(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userDao.createUser(user);
    }

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
}
