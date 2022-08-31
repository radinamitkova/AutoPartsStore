package bg.startit.autoPartsStore.dao;

import bg.startit.autoPartsStore.mapper.ShopMapper;
import bg.startit.autoPartsStore.model.Shop;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShopDaoImpl implements ShopDao{

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ShopDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createShop(Shop shop)
    {
        //@formatter:off
        String sql =
                "INSERT INTO shop ("
               +"    owner_id,     "
               +"    storage_id,   "
               +"    name,         "
               +"    budget        "
               +") VALUES (        "
               +"    :owner_id,    "
               +"    :storage_id,  "
               +"    :name,        "
               +"    :budget)      ";
        //@formatter:on
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("owner_id", shop.getOwner())
                .addValue("storage_id", shop.getStorage())
                .addValue("name", shop.getName())
                .addValue("budget", shop.getBudget());

        jdbcTemplate.update(sql, parameterSource);
    }

    @Override
    public Shop getShopById(Integer shopId) {
        //@formatter:off
        String sql =
                "SELECT id, owner_id, storage_id, name, budget"
               +"FROM shop                                    "
               +"WHERE id = :id                               ";
        //@formatter:on

        MapSqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("id", shopId);

        try {
            return jdbcTemplate.queryForObject(sql, paramSource, new ShopMapper());
        } catch (EmptyResultDataAccessException e) {
            return  null;
        }
    }

    @Override
    public void updateShopBudget(Shop shop) {
        //@formatter:off
        String sql =
                "UPDATE shop         "
               +"SET budget = :budget"
               +"WHERE id = :id      ";
        //@formatter:on

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("budget", shop.getBudget());
        parameterSource.addValue("id", shop.getId());

        jdbcTemplate.update(sql, parameterSource);
    }
}
