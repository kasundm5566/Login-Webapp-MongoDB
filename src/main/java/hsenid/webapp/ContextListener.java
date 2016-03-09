/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hsenid.webapp;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.SQLException;

/**
 * Created by hsenid.
 *
 * @author hsenid
 */
public class ContextListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        //Get parameters and create a connection using the DBCon class.
        ServletContext context = sce.getServletContext();
        String mdb_host = context.getInitParameter("mdb_host");
        String port = context.getInitParameter("port");
        DBCon.CreateConnection(mdb_host, port);
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }
}
