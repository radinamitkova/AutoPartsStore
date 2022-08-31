package bg.startit.autoPartsStore.dao;

import bg.startit.autoPartsStore.model.Storage;

public interface StorageDao {

    Storage getStorageById(Integer id);

    Storage getStockOfProductByProductId(String productId);

    void updateProducts(Storage storage);

    void updateStockOfProducts(Storage storage);
}
