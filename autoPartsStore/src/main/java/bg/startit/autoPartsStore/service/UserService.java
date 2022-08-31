package bg.startit.autoPartsStore.service;

import bg.startit.autoPartsStore.model.Product;
import bg.startit.autoPartsStore.model.User;

import java.math.BigDecimal;

public interface UserService {

    void createUser(String name, String username, String password) throws Exception;

    User getUserById(String id);

    void deleteUserById(String id);

    void orderProduct(User user, Product product, Integer amount) throws Exception;

    BigDecimal generateRandomBigDecimalForMoney(BigDecimal min, BigDecimal max);
}
