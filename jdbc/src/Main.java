import java.sql.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_lesson_jon","db_user_jon","12345");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from student");


        while (resultSet.next()){
            System.out.println(resultSet.getInt("id") + " " + resultSet.getString("name"));
        }

        connection.close();
    }
}