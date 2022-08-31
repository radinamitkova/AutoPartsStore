package bg.startit.autoPartsStore.service;

import bg.startit.autoPartsStore.model.Product;
import bg.startit.autoPartsStore.model.Storage;

public interface StorageService {

    Storage getStorageById(Integer storageId);

    int getStockOfProduct(Product product);

    void updateStock(Storage storage, int stock);
}
