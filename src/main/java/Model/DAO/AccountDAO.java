package Model.DAO;

import Model.BEAN.Account;
import Model.Mapping.AccountMapping;

import java.util.List;

public class AccountDAO extends BaseModel{
    public List<Account> getAll(){
        return query("select * from account", new AccountMapping());
    }
}
