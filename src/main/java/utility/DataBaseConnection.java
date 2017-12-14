package utility;


import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class DataBaseConnection {
	
	private static DataBaseConnection dataBaseConnexion;
	
    private static final String URL = "jdbc:mysql://www.vincentpersyn.fr:9000/tintas";
    private static final String USER = "tintas-sql";
    private static final String PASSWORD = "tintas-sql";
    
    private static java.sql.Connection con;
    
    private DataBaseConnection() {
    }
    
    public static java.sql.Connection connect() {
    	if (dataBaseConnexion == null) {
    		dataBaseConnexion = new DataBaseConnection();
    	}
    	
        try {
            Class.forName("com.mysql.jdbc.Driver");

             con = DriverManager.getConnection(URL, USER, PASSWORD);          

          } catch (Exception e) {
            e.printStackTrace();
          }  
        return con;
    }
}
