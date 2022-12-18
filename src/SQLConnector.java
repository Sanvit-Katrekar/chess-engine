import java.sql.*;

public class SQLConnector {
    String url = "jdbc:mysql://sql6.freesqldatabase.com/sql6585315";
    String username = "sql6585315";
    String passwd = "ThU8rad8Wt";
    Connection conn;
    Statement statement;
    public SQLConnector() {
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
