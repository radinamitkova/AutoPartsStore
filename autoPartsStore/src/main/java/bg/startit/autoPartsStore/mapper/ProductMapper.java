package bg.startit.autoPartsStore.mapper;

import bg.startit.autoPartsStore.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

        Product product = new Product();
        product.setId(rs.getString("product_id"));
        product.setPrice(rs.getBigDecimal("price"));
        product.setCarBrand(rs.getString("car_brand"));
        return product;
    }
}
