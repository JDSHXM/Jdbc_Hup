import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ResultSetExample1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_lesson_jon",
                "db_user_jon", "12345");

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from movie");

        while (resultSet.next()){
            Integer id = resultSet.getInt(1);
            String title = resultSet.getString("title");
            Long duration = resultSet.getLong("duration");
            LocalDateTime localDateTime = resultSet.getTimestamp("created_date").toLocalDateTime();
            LocalDate localDate = resultSet.getDate("publish_date").toLocalDate();
            Double rating = resultSet.getDouble("rating");

            System.out.println(id + " " + title + " " + duration + " " + localDateTime + " " + localDate + " " + rating);
        }

        connection.close();

    }
}
