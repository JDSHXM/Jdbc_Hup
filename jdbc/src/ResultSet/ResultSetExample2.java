package ResultSet;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class ResultSetExample2 {
    public static void main(String[] args) {
       List<Movie> movies = getMovie();
        movies.forEach(System.out::println);
    }

    public static List<Movie> getMovie(){
        List<Movie> movieList = new LinkedList<>();
        Connection connection = null;
        try {
            connection = DataBaseUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from movie");

            while (resultSet.next()){
                Movie movie = new Movie();
                movie.setId(resultSet.getInt(1));
                movie.setTitle(resultSet.getString("title"));
                movie.setDuration(resultSet.getLong("duration"));
                movie.setLocalDateTime(resultSet.getTimestamp("created_date").toLocalDateTime());
                movie.setLocalDate(resultSet.getDate("publish_date").toLocalDate());
                movie.setRating(resultSet.getDouble("rating"));
                movieList.add(movie);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return movieList;
    }

}
