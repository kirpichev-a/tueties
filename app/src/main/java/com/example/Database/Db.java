package com.example.Database;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
public class Db {
    public static void main(String[] args) {
        try {
            Db Db = new Db();
            Connection conn = Db.getPostgreSQLConnection();
            /* You can use the connection object to do any insert, delete, query or update action to the mysql server.*/
            /* Do not forget to close the database connection after use, this can release the database connection.*/

            conn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
    }

    /* This method return java.sql.Connection object. */
    public Connection getPostgreSQLConnection()
    {
        /* Declare and initialize a sql Connection variable. */
        Connection ret = null;

        try {

            /* Register jdbc driver class. */
            Class.forName("org.postgresql.Driver");
            String mysqlConnUrl = "jdbc:postgresql://database-1.coo46xxerdbs.eu-west-1.rds.amazonaws.com:5432/webarei1";
            String mysqlUserName = "postgres";
            String mysqlPassword = "LwLhack11";
            ret = DriverManager.getConnection(mysqlConnUrl, mysqlUserName , mysqlPassword);

            DatabaseMetaData dbmd = ret.getMetaData();
            String dbName = dbmd.getDatabaseProductName();
            String dbVersion = dbmd.getDatabaseProductVersion();
            String dbUrl = dbmd.getURL();
            String userName = dbmd.getUserName();
            String driverName = dbmd.getDriverName();
            System.out.println("Database Name is " + dbName);
            System.out.println("Database Version is " + dbVersion);
            System.out.println("Database Connection Url is " + dbUrl);
            System.out.println("Database User Name is " + userName);
            System.out.println("Database Driver Name is " + driverName);
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally
        {
            return ret;
        }
    }

}

