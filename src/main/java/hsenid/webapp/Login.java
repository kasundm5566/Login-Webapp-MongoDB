/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hsenid.webapp;

import com.mongodb.*;
import com.mongodb.client.MongoDatabase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hsenid.
 *
 * @author hsenid
 */
public class Login extends HttpServlet {

    User user;
    static String error="Error in username or password!";
    /*String host = "jdbc:mysql://localhost:3306/";
    String database = "userdata";
    String dbuser = "root";
    String dbpass = "test123";*/

    @Override
    /**
     * This method will gets parameters/values sent by the login.jsp and process them.
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        user = new User(req.getParameter("uname"), req.getParameter("pass"));
        boolean status = ValidateByDB(user);
        if (status) {
            resp.sendRedirect("success.jsp");
        } else {
            error="Error in username or password!";
            req.setAttribute("error_msg",error);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
            rd.forward(req, resp);
        }
    }

    /**
     * @param user
     * Passing a user to validate username and password
     * @return status
     * Returns whether user passed the validation or not
     */
    public static boolean ValidateByDB(User user) {

        boolean status = false;
        try {
            DB userdata = DBCon.getConnection();
            DBCollection user_cred = (DBCollection) userdata.getCollection("user_cred");
            BasicDBObject query = new BasicDBObject();
            query.put("Name", user.getUsername());
            query.append("Pass", user.getPassword());
            BasicDBObject fields = new BasicDBObject("Pass", 0).append("_id", 0);
            DBCursor cursor = user_cred.find(query, fields);
            status=cursor.hasNext();
        } catch (Exception e) {
            error="Something bad happened. Try again later.";
        }
        return status;
    }
}
