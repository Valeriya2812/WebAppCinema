package dao.impl;

import dto.HallDTO;
import dto.MovieDTO;
import mapper.BeanMapper;
import model.Hall;
import model.Movie;
import model.Seance;
import model.User;
import service.impl.HallServiceImpl;
import service.impl.MovieServiceImpl;

import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import static dao.impl.SQLs.GET_MAX_ID_SEANCE;
import static dao.impl.SQLs.INSERT_SEANCE;
import static dao.impl.SQLs.UPDATE_SEANCE;

public class SeanceDaoImpl extends CrudDAO<Seance> {
   // private static BeanMapper beanMapper;
    private static SeanceDaoImpl crudDAO;

   /* public SeanceDaoImpl() {
        super(Seance.class);
    }*/
    private SeanceDaoImpl(Class type) {
        super(type);
    }


    public static synchronized  SeanceDaoImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new  SeanceDaoImpl(Seance.class);
        }
        return crudDAO;}

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Seance entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SEANCE);
        setStatement(entity, preparedStatement);
        return preparedStatement;
    }


    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Seance entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SEANCE, Statement.RETURN_GENERATED_KEYS);
        setStatement(entity, preparedStatement);
        return preparedStatement;
    }



    private void setStatement(Seance entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, entity.getMovie().getId());
        preparedStatement.setInt(2, entity.getHall().getId());
        preparedStatement.setDate(3, entity.getSeanceDate());
        preparedStatement.setTime(4, entity.getSeanceTime());
        preparedStatement.setInt(5, entity.getPrice());

    }



    @Override
    protected List<Seance> readAll(ResultSet resultSet) throws SQLException {


            List<Seance> result = new LinkedList<>();
            Seance seance = null;
            while (resultSet.next()) {
                seance = new Seance();
                seance.setId(resultSet.getInt("id"));
                MovieDTO movieDTO= MovieServiceImpl.getInstance().getById(resultSet.getInt("movie"));
                seance.setMovie(new Movie(movieDTO.getTitle(), movieDTO.getDescription(), movieDTO.getDuration(), movieDTO.getDirector(), movieDTO.getStarring(), movieDTO.getMinAge()));
                seance.getMovie().setId(movieDTO.getId());
                HallDTO hallDTO= HallServiceImpl.getInstance().getById(resultSet.getInt("hall"));
                seance.setHall(new Hall(hallDTO.getColor(), hallDTO.getCountOfRows(), hallDTO.getCountOfColumns()));
                seance.getHall().setId(hallDTO.getId());

                seance.setSeanceDate(resultSet.getDate("date"));
                seance.setSeanceTime(resultSet.getTime("time"));
                seance.setPrice(resultSet.getInt("price"));

                result.add(seance);
            }
            return result;

    }



}
