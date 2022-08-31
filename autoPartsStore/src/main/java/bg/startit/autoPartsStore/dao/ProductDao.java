package bg.startit.autoPartsStore.dao;

import bg.startit.autoPartsStore.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

public interface ProductDao {

    //Page<Product> getAll(Pageable pagable);

    Product getProductById(String productId);

    Product getProductByCarBrand(String carBrand);

    Product getProductByPrice(BigDecimal price);

    List<Product> getProductByOrderedPriceASC();

    List<Product> getProductByOrderedPriceDESC();

    int deleteProductById(String productId);
}
