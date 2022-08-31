package bg.startit.autoPartsStore.mapper;

import bg.startit.autoPartsStore.model.Storage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class StorageMapper implements RowMapper<Storage> {

    @Override
    public Storage mapRow(ResultSet rs, int rowNum) throws SQLException {

        Storage storage = new Storage();
        storage.setId(rs.getInt("id"));
        storage.setCapacity(rs.getInt("capacity"));
        storage.setStock(rs.getInt("stock"));
        return storage;
    }
}
