package Model.BO;

import Model.BEAN.Account;
import Model.DAO.AccountDAO;

import java.util.List;

public class AccountBO {

    private AccountDAO DAO  = new AccountDAO();
    public List<Account> getAll(){
        return  DAO.getAll();
    }
    public int CheckAccount(String username, String password){
        return  DAO.CheckAccount(username,password);
    }

}
