package bg.startit.autoPartsStore.mapper;

import bg.startit.autoPartsStore.model.OrderArchive;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class OrderArchiveMapper implements RowMapper<OrderArchive> {

    @Override
    public OrderArchive mapRow(ResultSet rs, int rowNum) throws SQLException {

        OrderArchive orderArchive = new OrderArchive();
        orderArchive.setId(rs.getInt("order_id"));
        orderArchive.setAmount(rs.getInt("amount"));
        orderArchive.setPrice(rs.getBigDecimal("price"));
        orderArchive.setOrderDate(rs.getObject("order_date", LocalDateTime.class));
        return orderArchive;
    }
}
