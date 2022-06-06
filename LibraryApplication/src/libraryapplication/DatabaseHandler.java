package libraryapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class DatabaseHandler extends Configs{
    private Connection dbConnection;
    
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:postgresql://" + dbHost 
                + ":" + dbPort + "/" + dbName;
        Class.forName("org.postgresql.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }
    
    public void destroy(){ 
        if(dbConnection !=null){ 
            try{ dbConnection.close();
            } catch(Exception e){} 
        }
    }
    
    public void authorizationUser() {
        
    }
}
