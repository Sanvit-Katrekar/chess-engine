import java.sql.*;
import java.io.File;
import java.util.Scanner;

public class SQLConnector {
    String url;
    String username;
    String passwd;
    Connection conn;
    Statement statement;
    public void init() {
        try {
            System.out.println(Resource.getResourcePath("details.txt"));
            File file = new File(Resource.getResourcePath("details.txt"));
            Scanner scanner = new Scanner(file);
            url = scanner.nextLine();
            username = scanner.nextLine();
            passwd = scanner.nextLine();
            scanner.close();
        }
        catch (Exception e) {
            System.out.println(url);
            System.out.println("Error reading database credentials!");
        }
    }
    public SQLConnector() {
        this.init();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(url, username, passwd);
            this.statement = conn.createStatement();
        }
        catch (Exception e) {
            System.out.println("Error in database connection!");
        }
    }
    public Statement getStatement() {
        return this.statement;
    }
    public ResultSet executeQuery(String query) {
        ResultSet rs = null;
        try {
            rs = this.statement.executeQuery(query);
        }
        catch (Exception e) {
            System.out.println("Error in connecting to database!");
        }
        return rs;
    }
    public void executeUpdate(String query) {
        try {
            this.statement.executeUpdate(query);
        }
        catch (Exception e) {
            System.out.println("Error in connecting to database!");
            System.out.println(e);
        }
    }
    public void commit() {
        try {
            this.conn.commit();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    public void close() throws SQLException {
        this.conn.close();
    }
}
