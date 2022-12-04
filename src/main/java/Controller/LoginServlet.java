package Controller;

import Model.BEAN.Account;
import Model.BO.AccountBO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@WebServlet(urlPatterns = {"/Nhan-vien"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("HELLO");
        AccountBO Bo = new AccountBO();
        List<Account> list = Bo.getAll();
        for(int i=0;i<list.size();i++){
            out.println(list.get(i).getPassword());
        }

    }
}
