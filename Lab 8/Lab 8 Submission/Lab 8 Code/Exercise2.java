import java.sql.*;

public class Exercise2 {
    import java.sql.*;

    public class Lab8{
        public static void main(String[] args) {
            Connection connection = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver loaded");
                connection = DriverManager.getConnection("jdbc:mysql://localhost/orderdb?useSSL=false", "root", null);
                // past experience has shown that using the one-argument version of getConnection doesn't work for some students
            }
            catch (ClassNotFoundException e) {
                System.out.println("driver not found");
                System.exit(1);
            }
            catch (SQLException e) { System.out.println("failed to connect to database");
                System.exit(1);
            }

            Statement statement = null;

            try{
                statement = connection.createStatement();
            }
            catch (SQLException e) {
                System.out.println("failed to access database");
                System.exit(1);
            }

            queryDatabase(statement);

            try {
                statement.close();
                connection.close();
                System.out.println("Connection closed");
            }
            catch (SQLException e) {
                System.out.println("problems closing connection");
                System.exit(1);
            }
        }

        static void queryDatabase(Statement statement) {
            //Exercise 2
            try{
                //to read orders_2.txt
                // insert into mySQL db
            }
            catch (SQLException e){
                e.printStackTrace();
                System.out.println("Unable to add DB with orders_2 file");
            }
        }
    }

}
