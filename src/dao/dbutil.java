package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbutil implements sqlinfo{
    public Connection getConn() throws Exception{
        Connection c;
        Class.forName(diver);
        c = DriverManager.getConnection(url, uname, passwd);
        return c;
    }
    public static Connection CloseConnection(Connection c)throws Exception {
        c.close();
        return null;
    }
}