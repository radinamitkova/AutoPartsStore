package bg.startit.autoPartsStore.service;

import bg.startit.autoPartsStore.dao.ShopDao;
import bg.startit.autoPartsStore.model.Shop;
import bg.startit.autoPartsStore.model.Storage;
import bg.startit.autoPartsStore.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Transactional
@Service
public class ShopServiceImpl implements ShopService{

    private final ShopDao shopDao;
    private final UserService userService;
    private final StorageService storageService;

    public ShopServiceImpl(ShopDao shopDao, UserService userService, StorageService storageService) {
        this.shopDao = shopDao;
        this.userService = userService;
        this.storageService = storageService;
    }

    @Override
    public void createShop(Integer shopId, String name, String ownerId, Integer storageId, BigDecimal budget) {
        User user = this.userService.getUserById(ownerId);
        user.setRole(User.RoleName.OWNER);
        Storage storage = this.storageService.getStorageById(storageId);

        Shop newShop = new Shop();
        newShop.setId(shopId);
        newShop.setOwner(user);
        newShop.setStorage(storage);
        newShop.setName(name);
        newShop.setBudget(budget);

        shopDao.createShop(newShop);
    }

    @Override
    public void updateBudget(Shop shop, BigDecimal paymentAmount) {
        shop.setOwner(userService.getUserById(shop.getOwner().getId()));
        shop.setStorage(storageService.getStorageById(shop.getStorage().getId()));
        shop.setBudget(shop.getBudget().add(paymentAmount));
        this.shopDao.updateShopBudget(shop);
    }


}
