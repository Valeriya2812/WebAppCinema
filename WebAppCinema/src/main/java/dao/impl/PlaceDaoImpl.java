package dao.impl;

import dto.SeanceDTO;
import model.Place;
import model.Seance;
import service.impl.SeanceServiceImpl;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static dao.impl.SQLs.INSERT_PLACE;
import static dao.impl.SQLs.UPDATE_PLACE;

public class PlaceDaoImpl extends CrudDAO<Place> {
    private static PlaceDaoImpl crudDAO;

    private PlaceDaoImpl(Class type) {
        super(type);
    }


    public static synchronized  PlaceDaoImpl getInstance() {
        if (crudDAO == null) {
            crudDAO = new  PlaceDaoImpl(Place.class);
        }
        return crudDAO;}



    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, Place entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PLACE);
        updateStatement(entity, preparedStatement);
        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, Place entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PLACE, Statement.RETURN_GENERATED_KEYS);
        setStatement(entity, preparedStatement);
        return preparedStatement;
    }

    private void updateStatement(Place entity, PreparedStatement preparedStatement) throws SQLException {

        preparedStatement.setInt(1, entity.getSeance().getId());
        preparedStatement.setInt(2, entity.getRow());
        preparedStatement.setInt(3, entity.getColumn());
        preparedStatement.setBoolean(4, entity.getFree());
        preparedStatement.setInt(5, entity.getUser().getId());

        preparedStatement.setInt(6, entity.getId());


    }


    private void setStatement(Place entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setInt(1, entity.getSeance().getId());
        preparedStatement.setInt(2, entity.getRow());
        preparedStatement.setInt(3, entity.getColumn());
        preparedStatement.setBoolean(4, entity.getFree());

    }



    @Override
    protected List<Place> readAll(ResultSet resultSet) throws SQLException {
        List<Place> result = new LinkedList<>();
        Place place = null;
        while (resultSet.next()) {
            place = new Place();
            place.setId(resultSet.getInt("id"));
            SeanceDTO seanceDTO= SeanceServiceImpl.getInstance().getById(resultSet.getInt("seance"));
            place.setSeance(new Seance(seanceDTO.getMovie(),seanceDTO.getHall(), seanceDTO.getSeanceDate(),
                    seanceDTO.getSeanceTime(),  seanceDTO.getPrice()));
            place.getSeance().setId(seanceDTO.getId());


            place.setRow(resultSet.getInt("row"));
            place.setColumn(resultSet.getInt("col"));
            place.setFree(resultSet.getBoolean("free"));

            result.add(place);
        }
        return result;
    }
}
