package bg.startit.autoPartsStore.service;

import bg.startit.autoPartsStore.model.Shop;

import java.math.BigDecimal;

public interface ShopService {

    void createShop(Integer shopId, String name, String ownerId, Integer Id, BigDecimal budget);

    void updateBudget(Shop shop, BigDecimal paymentAmount);


}
