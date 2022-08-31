package bg.startit.autoPartsStore.mapper;

import bg.startit.autoPartsStore.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        //user.setUsername(rs.getString("username"));
       // user.setPassword(rs.getString("password"));
        user.setRole(rs.getObject("role", User.RoleName.class));
        user.setMoney(rs.getBigDecimal("money"));
        return user;
    }
}
