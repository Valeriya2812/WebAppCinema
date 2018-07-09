package dao.impl;

import model.Hall;
import model.User;


import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static dao.impl.SQLs.INSERT_HALL;

import static dao.impl.SQLs.UPDATE_HALL;

public class HallDaoImpl extends CrudDAO<Hall> {


  /*  public HallDaoImpl() {
        super(Hall.class);
    }*/

    private static HallDaoImpl crudDAO;

    private HallDaoImpl(Class type) {
        super(type);
    }


    public static synchronized HallDaoImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new HallDaoImpl(Hall.class);
        }
        return crudDAO;
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Hall entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_HALL);
        setStatement(entity, preparedStatement);
        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Hall entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_HALL, Statement.RETURN_GENERATED_KEYS);
        setStatement(entity, preparedStatement);
        return preparedStatement;
    }

    private void setStatement(Hall entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, entity.getColor().name());
        preparedStatement.setInt(2, entity.getCountOfRows());
        preparedStatement.setInt(3, entity.getCountOfColumns());
    }

    @Override
    protected List<Hall> readAll(ResultSet resultSet) throws SQLException {
        List<Hall> result = new LinkedList<>();
        Hall hall = null;
        while (resultSet.next()) {
            hall = new Hall();
            hall.setId(resultSet.getInt("id"));
            hall.setColor(resultSet.getString("color"));
            hall.setCountOfRows(resultSet.getInt("countOfRows"));
            hall.setCountOfColumns(resultSet.getInt("countOfColumns"));

            result.add(hall);
        }
        return result;

    }
}
