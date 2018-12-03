import java.sql.*;

public class Lab7
{ public static void main(String[] args)
{
    Connection connection = null;

    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        connection = DriverManager.getConnection("jdbc:mysql://localhost/orderdb", "root", null);
        // past experience has shown that using the one-argument version of getConnection doesn't work for some students
    }
    catch (ClassNotFoundException e)
    {
        System.out.println("driver not found");
        System.exit(1);
    }
    catch (SQLException e)
    { System.out.println("failed to connect to database");
        System.exit(1);
    }

    Statement statement = null;

    try{
        statement = connection.createStatement();
    }
    catch (SQLException e)
    {
        System.out.println("failed to access database");
        System.exit(1);
    }

    queryDatabase(statement);

    try
    {
        statement.close();
        connection.close();
        System.out.println("Connection closed");
    }
    catch (SQLException e)
    {
        System.out.println("problems closing connection");
        System.exit(1);
    }
}

    static void queryDatabase(Statement statement)
    {
        //Exercise 2
        try{
            ResultSet rs = statement.executeQuery("SELECT custID, name, email FROM customers");
            System.out.println(rs.toString());
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("Unable to query DB with first query; to show customer IDs and emails from the Customer table.");
        }

        //Exercise 3 - slide 59 from lectures utilised
        try {
            ResultSet rs2 = statement.executeQuery("SELECT orderid, suctid, goods, price FROM orders WHERE 10.00<price<40.00");
            System.out.println(rs2.toString());
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Unable to query DB with second query; to show all of the orders and their attributes for orders priced in the range of £10 to £40.");
        }
    }
}