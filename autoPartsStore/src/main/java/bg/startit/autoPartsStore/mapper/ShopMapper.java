package bg.startit.autoPartsStore.mapper;

import bg.startit.autoPartsStore.model.Shop;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShopMapper implements RowMapper<Shop> {

    @Override
    public Shop mapRow(ResultSet rs, int rowNum) throws SQLException {

        Shop shop = new Shop();
        shop.setId(rs.getInt("id"));
        shop.setName(rs.getString("name"));
        shop.setBudget(rs.getBigDecimal("budget"));
        return shop;
    }
}
