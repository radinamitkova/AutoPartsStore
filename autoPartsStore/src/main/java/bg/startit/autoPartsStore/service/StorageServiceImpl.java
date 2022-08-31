package bg.startit.autoPartsStore.service;

import bg.startit.autoPartsStore.dao.ProductDao;
import bg.startit.autoPartsStore.dao.StorageDao;
import bg.startit.autoPartsStore.model.Product;
import bg.startit.autoPartsStore.model.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class StorageServiceImpl implements StorageService{

    private final StorageDao storageDao;
    private final ProductDao productDao;

    @Override
    public Storage getStorageById(Integer storageId) {
        return this.storageDao.getStorageById(storageId);
    }

    @Override
    public int getStockOfProduct(Product product) {

        Storage storage = this.storageDao.getStockOfProductByProductId(product.getId());
        storage.setProduct(product);

        return storage.getStock();
    }

    @Override
    public void updateStock(Storage storage, int amountOfOrderedProducts) {

        storage.setProduct(productDao.getProductById(storage.getProduct().getId()));
        storage.setStock(storage.getStock() - amountOfOrderedProducts);

        this.storageDao.updateStockOfProducts(storage);
    }

}
