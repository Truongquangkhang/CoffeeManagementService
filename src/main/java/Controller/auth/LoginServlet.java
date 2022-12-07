package Controller.auth;

import Model.BEAN.Account;
import Model.BO.AccountBO;
import Model.BO.CashierBO;
import com.mysql.fabric.Response;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.View;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@WebServlet(urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

    public AccountBO BO = new AccountBO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if(req.getParameter("action")!=null){

        }
        else{
            resp.sendRedirect("./View/Login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("action")!=null){
            if(req.getParameter("action").equals("login")){
                Login(req,resp);
            }
        }
    }

    public void Login(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        int id_account = BO.CheckAccount(username,password);
        if(id_account!=-1){
            System.out.println(id_account);
            req.getSession().setAttribute("cashier", CashierBO.Instance().get_Cashier_by_idAccount(id_account));

            RequestDispatcher rd = req.getRequestDispatcher("View/ListItem.jsp");
            rd.forward(req,resp);
        }
        else{
            resp.sendRedirect("./View/Login.jsp?mess=invalid");
        }
    }
}
