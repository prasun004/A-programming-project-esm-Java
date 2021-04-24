import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    static Connection conn = null;
    static String url = "jdbc:sqlite:/home/prasun/db/db.db";
    int sno;
    String name;
    int seat;
    Database(){



    }

    Database(String name, int seat){
        this.name = name;
        this.seat = seat;

    }

//below to find the data entered by user


    public static void connect() {

        try {
            // db parameters
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    static void createNewTable(){
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	class integer NOT NULL,\n"
                + "	seat integer NOT NULL,\n"
                + "	sno integer NOT NULL\n"
                + ");";
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        connect();
        createNewTable();

    }

    public static void addToTables(String name, String classname, int seat, int sno){
        connect();
        String sql = "INSERT INTO users('name', 'class', 'seat','sno') VALUES (?, ?, ?, ?);";


        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
             statement.setString(1, name);
             statement.setString(2, classname);
             statement.setString(3, String.format("%d", seat));
             statement.setString(4, String.format("%d", sno));
             statement.addBatch();
             statement.executeBatch();
             System.out.println("Saved to Database");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        }
    public static List<String> getFromDatabase(int sno) throws SQLException {
        List<String> list = new ArrayList<String>();

        String sql = "SELECT * "
                + "FROM users WHERE sno = ?";
         ResultSet rs = null;
        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt  = conn.prepareStatement(sql)){

            // set the value
            pstmt.setInt(1,sno);
            //
            rs  = pstmt.executeQuery();
            while (rs.next()){
                list.add(rs.getString("name"));
                list.add(rs.getString("class"));
                list.add(String.format("%d", rs.getInt("seat")));
                list.add(String.format("%d", rs.getInt("sno")));

            }

            // loop through the result set

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
