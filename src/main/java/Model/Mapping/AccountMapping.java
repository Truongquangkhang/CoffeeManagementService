package Model.Mapping;

import Model.BEAN.Account;

import java.sql.ResultSet;

public class AccountMapping implements BaseMapping{


    @Override
    public Account Mapping(ResultSet rs) {
        try{
            Account temp = new Account();
            while(rs.next()){
                temp.setId(rs.getInt("id"));
                temp.setUsername(rs.getString("username"));
                temp.setPassword(rs.getString("password"));
                temp.setType_account(rs.getBoolean("type_account"));
                temp.setStatus(rs.getBoolean("status"));
            }
            return  temp;
        }
        catch (Exception e){
            return null;
        }

    }
}
