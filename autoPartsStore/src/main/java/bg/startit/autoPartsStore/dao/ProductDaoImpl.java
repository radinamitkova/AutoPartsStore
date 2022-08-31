package bg.startit.autoPartsStore.dao;

import bg.startit.autoPartsStore.mapper.ProductMapper;
import bg.startit.autoPartsStore.model.Product;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.awt.print.PageFormat;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ProductDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Product getProductById(String productId) {
        //@formatter:off
        String sql =
                "SELECT product_id, car_brand, price, storage_id, shop_id"
               +"FROM products                                           "
               +"WHERE product_id = :productId                           ";
        //@formatter:on

        MapSqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("productId", productId);

        try {
            return jdbcTemplate.queryForObject(sql, paramSource, new ProductMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Product getProductByCarBrand(String carBrand) {
        //@formatter:off
        String sql =
                "SELECT product_id, car_brand, price"
               +"FROM products                                           "
               +"WHERE car_brand = :carBrand                             ";
        //@formatter:on

        MapSqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("carBrand", carBrand);
        try {
            return jdbcTemplate.queryForObject(sql, paramSource, new ProductMapper());

        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Product getProductByPrice(BigDecimal price) {
        //@formatter:off
        String sql =
                "SELECT product_id, car_brand, price, storage_id, shop_id"
               +"FROM products                                           "
               +"WHERE price = :price                                    ";
        //@formatter:on

        MapSqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("price", price);

        try {
            return jdbcTemplate.queryForObject(sql, paramSource, new ProductMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Product> getProductByOrderedPriceASC() {
        //@formatter:off
         String sql =
                "SELECT product_id, car_brand, price                     "
               +"FROM products                                           "
               +"ORDER BY price ASC                                      ";
        //@formatter:on

        return jdbcTemplate.query(sql, new ProductMapper());
    }

    @Override
    public List<Product> getProductByOrderedPriceDESC() {
        //@formatter:off
        String sql =
                "SELECT product_id, car_brand, price                     "
               +"FROM products                                           "
               +"ORDER BY price DESC                                     ";
        //@formatter:on

        return jdbcTemplate.query(sql, new ProductMapper());
    }

    @Override
    public int deleteProductById(String productId) {
        //@formatter:off
        String sql =
                "DELETE FROM products         "
               +"WHERE product_id = :productId";
        //@formatter:on

        MapSqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("productId", productId);

        try {
            return jdbcTemplate.update(sql, paramSource);
        } catch (EmptyResultDataAccessException e) {
            return 0;
        }
    }

    /*@Override
    public Page<Product> getAll(Pageable pagable) {
        //@formatter:off
        String sql =
                "SELECT product_id, car_brand, price"
               +"FROM products                      "
               +"OFFSET                             "
               +":offset                            "
               +"ROWS FETCH NEXT                    "
               +":limit                             "
               +"ROWS ONLY                          ";
        //@formatter:on

        MapSqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("limit", pagable.getPageSize())
                .addValue("offset", pagable.getPageNumber());

        List<Product> products = jdbcTemplate.query(sql, paramSource, new ProductMapper());

        return PageImpl<>(products, pagable, products.size());
    }
   */

}
