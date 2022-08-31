package bg.startit.autoPartsStore.dao;

import bg.startit.autoPartsStore.model.Shop;

public interface ShopDao {

    void createShop(Shop shop);

    Shop getShopById(Integer shopId);

    void updateShopBudget(Shop shop);

}
