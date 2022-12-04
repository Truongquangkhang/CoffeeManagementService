package Model.Mapping;

import java.sql.ResultSet;

public interface BaseMapping <T>{
    public T Mapping(ResultSet rs);
}
