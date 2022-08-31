package bg.startit.autoPartsStore.dao;

import bg.startit.autoPartsStore.mapper.StorageMapper;
import bg.startit.autoPartsStore.model.Storage;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class StorageDaoImpl implements StorageDao{

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public StorageDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Storage getStorageById(Integer id) {

        //@formatter:off
        String sql =
                "SELECT id, product_id, capacity, stock"
               +"FROM storage                          "
               +"WHERE id = :id                        ";
        //@formatter:on

        MapSqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("id", id);

        try {
            return jdbcTemplate.queryForObject(sql, paramSource, new StorageMapper());
        } catch (EmptyResultDataAccessException e) {
            return  null;
        }
    }

    @Override
    public Storage getStockOfProductByProductId(String productId) {
        //@formatter:off
        String sql =
                "SELECT stock                  "
               +"FROM storage                  "
               +"WHERE product_id = :product_id";
        //@formatter:on

        MapSqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("product_id", productId);

        try {
            return jdbcTemplate.queryForObject(sql, paramSource, new StorageMapper());
        } catch (EmptyResultDataAccessException e) {
            return  null;
        }
    }

    @Override
    public void updateProducts(Storage storage) {
        //@formatter:off
        String sql =
                "UPDATE storage              "
               +"SET product_id = :product_id"
               +"WHERE id = :id              ";
        //@formatter:on

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("product_id", storage.getProduct());
        parameterSource.addValue("id", storage.getId());

        jdbcTemplate.update(sql, parameterSource);
    }

    @Override
    public void updateStockOfProducts(Storage storage) {
        //@formatter:off
        String sql =
                "UPDATE storage    "
               +"SET stock = :stock"
               +"WHERE id = :id    ";
        //@formatter:on

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("stock", storage.getStock());
        parameterSource.addValue("id", storage.getId());

        jdbcTemplate.update(sql, parameterSource);
    }
}
