package bg.startit.autoPartsStore.service;

import bg.startit.autoPartsStore.dao.UserDao;
import bg.startit.autoPartsStore.exception.BadRequestException;
import bg.startit.autoPartsStore.exception.ElementAlreadyExistsException;
import bg.startit.autoPartsStore.model.Product;
import bg.startit.autoPartsStore.model.User;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final OrderArchiveService orderArchiveService;
    private final ShopService shopService;
    private final StorageService storageService;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao,  OrderArchiveService orderArchiveService, @Lazy ShopService shopService,
                           StorageService storageService) {
        this.userDao = userDao;
        this.orderArchiveService = orderArchiveService;
        this.shopService = shopService;
        this.storageService = storageService;
    }

    @Override
    public void orderProduct(User user, Product product, Integer amount) throws Exception {
        BigDecimal finalPrice = product.getPrice().multiply(BigDecimal.valueOf(amount));

        if (user.getMoney().compareTo(finalPrice) >= 0 && storageService.getStockOfProduct(product) >= amount) {
            orderArchiveService.createOrderArchive(user.getId(), product.getId(), amount);
            shopService.updateBudget(product.getShop(), finalPrice);
            storageService.updateStock(product.getStorage(), amount);
        } else {
            throw new BadRequestException("You don't have enough money to make an order!");
        }
    }

    @Override
    public void createUser(String name, String username, String password) throws Exception {
        User dbUser = userDao.getUserByUsername(username);
        User newUser = new User();

        if (dbUser == null) {
        newUser.setName(name);
       // newUser.setUsername(username);
       // newUser.setPassword(passwordEncoder.encode(password));
        newUser.setMoney(generateRandomBigDecimalForMoney(BigDecimal.ONE, BigDecimal.valueOf(Integer.MAX_VALUE)));
        newUser.setRole(User.RoleName.CLIENT);
        }
        throw new ElementAlreadyExistsException("Failed - the user already exists.");
    }

    @Override
    public BigDecimal generateRandomBigDecimalForMoney(BigDecimal min, BigDecimal max) {
        BigDecimal randomMoney = min.add(BigDecimal.valueOf(Math.random()).multiply(max.subtract(min)));
        return randomMoney.setScale(2,BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public User getUserById(String id) {
        return this.userDao.getUserById(id);
    }

    @Override
    public void deleteUserById(String id) {
        this.userDao.deleteUserById(id);
    }


}
