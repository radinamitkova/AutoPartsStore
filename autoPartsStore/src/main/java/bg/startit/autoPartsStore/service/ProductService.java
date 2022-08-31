package bg.startit.autoPartsStore.service;

import bg.startit.autoPartsStore.model.Product;
import bg.startit.autoPartsStore.model.Storage;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {

    Product getProductById(String productId);

    Product getProductByCarBrand(String  carBrand);

    Product getProductByPrice(BigDecimal price);

    List<Product> getProductByOrderedPriceASC();

    List<Product> getProductByOrderedPriceDESC();

    int deleteProductById(String productId);
}
