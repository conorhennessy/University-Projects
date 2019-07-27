import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    //System.out.println("Exercise 1");
    //queryDatabase(statement);

    System.out.println("\nExercise 2");
    File file = new File("Lab 8/Lab 8 Submission/orders_2.txt");
    List<String> ordersList = fileInsert.insertFile(statement, file);
    System.out.println(ordersList);

    for (int i = 0; i < ordersList.size(); i++){   // call of the additional method created to insert the file into DB
        try{
            int insertOrder = statement.executeUpdate("INSERT INTO orders VALUES " + ordersList.get(i) + "");
            System.out.println(ordersList.get(i));
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Unable to add to orders_2 to DB");
        }
    }


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
        //Exercise 1
        try{
            //The following lines were used to add some orders to the table - commented out so that they are not added each time!
            //int insertOrder1 = statement.executeUpdate("INSERT INTO orders VALUES (8, 3, 'hat', 4.99)");
            //int insertOrder2 = statement.executeUpdate("INSERT INTO orders VALUES (9, 3, 'monitor', 354.99)");

            ResultSet rs = statement.executeQuery("SELECT DISTINCT name FROM customers JOIN orders WHERE price > 20 ");
            while (rs.next()){
                System.out.println(rs.getObject(1));
            }

        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Unable to query DB with first query; to add two orders to the orders table.");
        }
    }
}
