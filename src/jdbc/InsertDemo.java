package jdbc;

import java.sql.*;

public class InsertDemo {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/movies?serverTimezone=UTC";
        String user = "root";
        String password = "abc123";

        Connection connection = null;
        Statement statement = null;
        try {
            // Create a connection
            connection = DriverManager.getConnection(url, user, password);

            // 2. Create a statement
            statement = connection.createStatement();

            // 3. Execute the SQL query
            Movie mib = new Movie(10, "Men In Black", 2000, "SciFi", "PG-13");
            String query = "insert into movie (id, title, release_year, genre, mpaa_rating)" +
                    " values (" + mib.getId() + ", '" + mib.getTitle() + "', " + mib.getReleaseYear() +
                    ", '" + mib.getGenre() + "', '" + mib.getMpaaRating() + "');";
            statement.execute(query);

            // 4. Process the result if necessary
            //ResultSet resultSet = statement.executeQuery(query);

            System.out.println("Movie added");

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Something might have went wrong with connection");
        } finally {
            statement.close();
            connection.close();
        }

    }
}
