package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbutil implements sqlinfo{
    public static Connection getConn() throws Exception{
        Class.forName(diver);
        Connection c;
        c = DriverManager.getConnection(url, uname, passwd);
        return c;
    }
    public static Connection CloseConnection(Connection c)throws Exception {
        c.close();
        return null;
    }
}