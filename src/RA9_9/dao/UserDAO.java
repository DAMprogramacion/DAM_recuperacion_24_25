package RA9_9.dao;

import RA9_9.modelo.User;

import java.util.List;

public interface UserDAO {

    public List<User> getUsers();
    public User getUserByEmail(String email);
    public boolean insertUser(User user);
    public boolean deleteUser(String email);
    public void updateFisrtAndOrLastName(User user);
}
