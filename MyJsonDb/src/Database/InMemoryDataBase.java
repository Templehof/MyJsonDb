package Database;

import Responses.DbResponse;
import Responses.DbResponseStatus;

import java.util.List;

public class InMemoryDataBase {
    private List<String> db;

    public InMemoryDataBase(List<String> db) {
        this.db = db;
    }

    public DbResponse getValue(int index) {
        try {
            CheckRange(index);
            var value = db.get(index);
            return new DbResponse(DbResponseStatus.OK, value);
        } catch (Exception ex) {
            return new DbResponse(DbResponseStatus.ERROR, "");
        }
    }

    public DbResponse setValue(int index, String value) {
        try {
            CheckRange(index);
            db.set(index, value);
            return new DbResponse(DbResponseStatus.OK, "");
        } catch (Exception ex) {
            return new DbResponse(DbResponseStatus.ERROR, "");
        }
    }

    public DbResponse deleteValue(int index) {
        try {
            CheckRange(index);
            db.remove(index);
            return new DbResponse(DbResponseStatus.OK, "");
        } catch (Exception ex) {
            return new DbResponse(DbResponseStatus.ERROR, "");
        }
    }

    private void CheckRange(int index) {
        if (index < 0 || index > db.size()) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }
}
