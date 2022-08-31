package bg.startit.autoPartsStore.service;

import bg.startit.autoPartsStore.dao.ProductDao;
import bg.startit.autoPartsStore.dao.ShopDao;
import bg.startit.autoPartsStore.dao.StorageDao;
import bg.startit.autoPartsStore.exception.NoDataException;
import bg.startit.autoPartsStore.model.Product;
import bg.startit.autoPartsStore.model.Shop;
import bg.startit.autoPartsStore.model.Storage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductDao productDao;
    private final ShopDao shopDao;
    private final StorageDao storageDao;

    @Override
    public Product getProductById(String productId) {
        return this.productDao.getProductById(productId);
    }

    @Override
    public Product getProductByCarBrand(String carBrand) {
        Product product = productDao.getProductByCarBrand(carBrand);
        if(product == null){
            throw new NoDataException("There are no products of this brand - " + carBrand + "!");
        }

        Shop shop = shopDao.getShopById(product.getShop().getId());
        Storage storage = storageDao.getStorageById(product.getStorage().getId());
        product.setShop(shop);
        product.setStorage(storage);

        return product;
    }

    @Override
    public List<Product> getProductByOrderedPriceASC() {
        return this.productDao.getProductByOrderedPriceASC();
    }

    @Override
    public List<Product> getProductByOrderedPriceDESC() {
        return this.productDao.getProductByOrderedPriceDESC();
    }

    @Override
    public Product getProductByPrice(BigDecimal price) {
        Product product = productDao.getProductByPrice(price);

        Shop shop = shopDao.getShopById(product.getShop().getId());
        Storage storage = storageDao.getStorageById(product.getStorage().getId());
        product.setShop(shop);
        product.setStorage(storage);

        return product;
    }


    @Override
    public int deleteProductById(String productId) {
        return this.productDao.deleteProductById(productId);
    }
}
