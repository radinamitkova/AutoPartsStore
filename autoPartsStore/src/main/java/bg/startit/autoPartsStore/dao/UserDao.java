package bg.startit.autoPartsStore.dao;

import bg.startit.autoPartsStore.model.User;

public interface UserDao {

    void createUser(User user);

    User getUserById(String id);

    User getUserByUsername(String username);

    void updateUser(User user);

    void deleteUserById(String id);
}
