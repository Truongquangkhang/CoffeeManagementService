package Model.BEAN;

public class Account {
    private int id;
    private String username;
    private  String password;
    private boolean type_account;
    private  boolean status;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isType_account() {
        return type_account;
    }

    public void setType_account(boolean type_account) {
        this.type_account = type_account;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
