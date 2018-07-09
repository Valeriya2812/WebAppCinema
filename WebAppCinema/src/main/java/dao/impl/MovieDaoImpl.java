package dao.impl;




import model.Movie;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;


public final class MovieDaoImpl extends CrudDAO<Movie> {
   // private final String INSERT = "Insert into movie (title, duration, description) values (?,?,?)";
  ///  private final String UPDATE = "UPDATE movie SET title = ?, duration = ?, description = ?,WHERE id = ?";
    private static MovieDaoImpl crudDAO;

    private MovieDaoImpl(Class type) {
        super(type);
    }


    public static synchronized MovieDaoImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new MovieDaoImpl(Movie.class);
        }
        return crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Movie entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(SQLs.UPDATE_MOVIE);
        preparedStatement.setString(1, entity.getTitle());
        preparedStatement.setString(2, entity.getDescription());
        preparedStatement.setInt(3, entity.getDuration());
        preparedStatement.setString(4, entity.getDirector());
        preparedStatement.setString(5, entity.getStarring());
        preparedStatement.setInt(6, entity.getMinAge());
       // preparedStatement.setInt(4, entity.getId());


        return preparedStatement;
    }

    @Override
    public PreparedStatement createInsertStatement(Connection connection, Movie entity) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement(SQLs.INSERT_MOVIE, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1, entity.getTitle());
                preparedStatement.setString(2, entity.getDescription());
                preparedStatement.setInt(3, entity.getDuration());
                preparedStatement.setString(4, entity.getDirector());
                preparedStatement.setString(5, entity.getStarring());
                preparedStatement.setInt(6, entity.getMinAge());

        return preparedStatement;
    }

    @Override
    public List<Movie> readAll(ResultSet resultSet) throws SQLException {
        List<Movie> result = new LinkedList<>();
        Movie movie = null;
        while (resultSet.next()) {
            movie = new Movie();
            movie.setId(resultSet.getInt("id"));
            movie.setTitle(resultSet.getString("title"));
            movie.setDescription(resultSet.getString("description"));
            movie.setDuration(resultSet.getInt("duration"));
            movie.setDirector(resultSet.getString("director"));
            movie.setStarring(resultSet.getString("starring"));
            movie.setMinAge(resultSet.getInt("minAge"));
            result.add(movie);
        }
        return result;
    }

}