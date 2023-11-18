package com.ons.users.service;

import java.util.List;

import com.ons.users.entities.Role;
import com.ons.users.entities.User;

public interface UserService {
User saveUser(User user);
User findUserByUsername (String username);

List<User> findAllUsers();


    User addRoleToUser(long id, Role r);



    User findUserById(Long id);

    List<Role> findAllRoles();

    Role findRoleById(Long id);

    void deleteUser(long id);

    User removeRoleFromUser(long id, Role r);

    List<Role> findUserRolesById(Long id);
    User activateUser(String username, String code);
}
