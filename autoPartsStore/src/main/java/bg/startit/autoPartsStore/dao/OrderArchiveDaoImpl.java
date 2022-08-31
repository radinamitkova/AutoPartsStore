package bg.startit.autoPartsStore.dao;

import bg.startit.autoPartsStore.mapper.OrderArchiveMapper;
import bg.startit.autoPartsStore.model.OrderArchive;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Repository
public class OrderArchiveDaoImpl implements OrderArchiveDao{

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public OrderArchiveDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int createOrderArchive(OrderArchive order)
    {
        //@formatter:off
        String sql =
                "INSERT INTO orders ("
               +"    order_id,       "
               +"    client_id,      "
               +"    product_id,     "
               +"    amount,         "
               +"    price,          "
               +"    order_date      "
               +") VALUES (          "
               +"    :order_id,      "
               +"    :client_id,     "
               +"    :product_id,    "
               +"    :amount,        "
               +"    :price,         "
               +"    :order_date)    ";

        //@formatter:on
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("order_id", order.getId())
                .addValue("client_id", order.getClient())
                .addValue("product_id", order.getProduct())
                .addValue("amount", order.getAmount())
                .addValue("price", order.getPrice())
                .addValue("order_date", Timestamp.valueOf(LocalDateTime.now()));

        try {
            return jdbcTemplate.update(sql, parameterSource);
        }
        catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public OrderArchive getOrderByDate(LocalDateTime date) {
        //@formatter:off
        String sql =
                "SELECT order_id, client_id, product_id, amount, price, order_date"
               +"FROM orders                                                      "
               +"WHERE order_date = :date                                         ";
        //@formatter:on

        MapSqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("date", Timestamp.valueOf(LocalDateTime.now()));

        try {
            return jdbcTemplate.queryForObject(sql, paramSource, new OrderArchiveMapper());
        } catch (EmptyResultDataAccessException e) {
            return  null;
        }
    }

    @Override
    public OrderArchive getTimesProductSold(String productId) {
        //@formatter:off
        String sql =
                "SELECT SUM (amount)          "
               +"FROM orders                  "
               +"WHERE product_id = :productId";
        //@formatter:on

        MapSqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("productId", productId);

        try {
            return jdbcTemplate.queryForObject(sql, paramSource, new OrderArchiveMapper());
        } catch (EmptyResultDataAccessException e) {
            return  null;
        }
    }

    /*@Override
    public OrderArchive getMostSellingParts() {
        //@formatter:off
        String sql =
                "SELECT order_id, client_id, product_id, amount, price, order_date"
                        +"FROM orders                                                      "
                        +"WHERE order_date = :order_date                                   ";
        //@formatter:on
        return null;
    }

    @Override
    public String getSecondMostFragileCarBrand() {

        //@formatter:off
        String sql =
                "SELECT MAX(SELECT SUM (amount) "
               +"FROM orders                    "
               +"WHERE product_id = :productId) "
               +"FROM product                                 "
               +"WHERE product_id NOT IN (SELECT MAX (product_id) FROM product);                               ";
        //@formatter:on

        return jdbcTemplate.query(sql, new OrderArchiveMapper()).toString();
    }
    */
}
