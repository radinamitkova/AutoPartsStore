package bg.startit.autoPartsStore.dao;

import bg.startit.autoPartsStore.mapper.UserMapper;
import bg.startit.autoPartsStore.model.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public UserDaoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void createUser(User user)
    {
        //@formatter:off
        String sql =
                "INSERT INTO users ("
               +"    id,            "
               +"    name,          "
               +"    username,      "
               +"    password,      "
               +"    role,          "
               +"    money          "
               +") VALUES (         "
               +"    :id,           "
               +"    :name,         "
               +"    :username,     "
               +"    :password,     "
               +"    :role,         "
               +"    :money)        ";
        //@formatter:on
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();

        parameterSource.addValue("id", user.getId())
                .addValue("name", user.getName())
               // .addValue("username", user.getUsername())
                //.addValue("password", user.getPassword())
                .addValue("role", user.getRole())
                .addValue("money", user.getMoney());

        jdbcTemplate.update(sql, parameterSource);
    }

    @Override
    public User getUserById(String id) {
        //@formatter:off
        String sql =
                 "SELECT id, name, money, role"
                +" FROM users                                      "
                +" WHERE id = :id                                  ";
        //@formatter:on

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("id", id);

        try {
            return jdbcTemplate.queryForObject(sql, parameterSource, new UserMapper());
        } catch (EmptyResultDataAccessException e) {
            return new User();
        }
    }

    @Override
    public User getUserByUsername(String username) {
        //@formatter:off
        String sql =
                "SELECT id, name, username, password, money, role"
               +"FROM users                                      "
               +"WHERE username = :username                      ";
        //@formatter:on

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("username", username);

        try {
            return jdbcTemplate.queryForObject(sql, parameterSource, new UserMapper());
        } catch (EmptyResultDataAccessException e) {
            return new User();
        }
    }

    @Override
    public void updateUser(User user) {
        //@formatter:off
        String sql =
                "UPDATE users      "
               +"SET money = :money"
               +"WHERE id = :id    ";
        //@formatter:on

        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("money", user.getMoney());
        parameterSource.addValue("id", user.getId());

        jdbcTemplate.update(sql, parameterSource);
    }

    @Override
    public void deleteUserById(String  id) {
        //@formatter:off
        String sql =
                "DELETE FROM users"
               +"WHERE id = :id   ";
        //@formatter:on

        MapSqlParameterSource paramSource = new MapSqlParameterSource()
                .addValue("id", id);

        jdbcTemplate.update(sql, paramSource);
    }
}
