package Model.DAO;

import Model.Mapping.BaseMapping;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseModel {
    Connection connection = Connect();
    public Connection Connect() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/jsp_servlet", "root", "");
        }catch (Exception e){
            return null;
        }
    }


    public <T>List<T> query(String query, BaseMapping<T> mapper, Object...param){
        try {
            List<T> list = new ArrayList<>();
            PreparedStatement ps = this.connection.prepareStatement(query);
            setParameter(ps,param);
            ResultSet rs=  ps.executeQuery();
            while(rs.next()){
                list.add(mapper.Mapping(rs));
            }
            return list;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public <T> T find(String query, BaseMapping<T> mapper, Object...param){
        try {
            List<T> list = new ArrayList<>();
            PreparedStatement ps = this.connection.prepareStatement(query);
            setParameter(ps,param);
            ResultSet rs=  ps.executeQuery();
            while(rs.next()){
                return mapper.Mapping(rs);
            }
            return null;
        }catch (Exception e){

            return null;
        }
    }

    private void setParameter(PreparedStatement statement, Object... parameters) {
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                int index = i + 1;
                if (parameter instanceof Long) {
                    statement.setLong(index, (Long) parameter);
                } else if (parameter instanceof String) {
                    statement.setString(index, (String) parameter);
                } else if (parameter instanceof Integer) {
                    statement.setInt(index, (Integer) parameter);
                }
                else if(parameter instanceof Boolean){
                    statement.setBoolean(index,(Boolean) parameter);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
