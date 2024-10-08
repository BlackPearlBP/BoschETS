package Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public Connection connection=null;
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String databaseName = "delivery";
    private final String local = "jdbc:mysql://localhost:3306/" + databaseName;
    private final String login = "root";
    private final String password = "root";
    
    public boolean getConnection(){
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(local,login,password);
            System.out.println("Connected database");
            return true;
            }catch(ClassNotFoundException erro){
                System.out.println("Driver not found "+erro.toString());
                return false;
            }catch(SQLException erro){
                System.out.println("Connection error "+erro.toString());
                return false;
        }
    }
}
