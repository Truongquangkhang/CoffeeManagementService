package Model.DAO;

import Model.BEAN.Account;
import Model.Mapping.AccountMapping;

import java.util.List;

public class AccountDAO extends BaseModel{
    public List<Account> getAll(){
        return query("select * from account", new AccountMapping());
    }
    public int CheckAccount(String username, String password){
        Account temp = (Account) find("select * from account where username =? and password =?",new AccountMapping(),username,password);
        if(temp!=null) return temp.getId();
        return -1;
    }
}
