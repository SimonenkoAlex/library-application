package databaselayer;

import businesslogiclayer.Librarian;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseHandler extends Configs{
    private Connection dbConnection;
    
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:postgresql://" + dbHost 
                + ":" + dbPort + "/" + dbName;
        Class.forName("org.postgresql.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }
    
    public Connection getMyConnection(){ return dbConnection; }
    
    public void destroy(){ 
        if(dbConnection !=null){ 
            try{ dbConnection.close();
            } catch(Exception e){} 
        }
    }
    
    public ResultSet authorizationUser(Librarian librarian) {
        ResultSet result = null;
        String select = "SELECT * FROM " + Const.LIBRARIAN_TABLE + " WHERE " +
                Const.LIBRARIANS_PHONE + "=? AND " + Const.LIBRARIANS_PASSWORD + "=?";
        try {
            try {
                PreparedStatement prSt = getDbConnection().prepareStatement(select);
                prSt.setString(1, librarian.getPhone());
                prSt.setString(2, librarian.getPassword());
                result = prSt.executeQuery();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
