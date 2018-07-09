package dao.impl;


import dao.DaoFactory;
import model.User;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static dao.impl.SQLs.INSERT_USER;
import static dao.impl.SQLs.UPDATE_USER;



public class UserDaoImpl extends CrudDAO<User> {
    public UserDaoImpl() {
        super(User.class);
    }

    @Override
    protected PreparedStatement createUpdateStatement(Connection connection, User entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
        setStatement(entity, preparedStatement);
        return preparedStatement;
    }

    @Override
    protected PreparedStatement createInsertStatement(Connection connection, User entity) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER, Statement.RETURN_GENERATED_KEYS);
        setStatement(entity, preparedStatement);
        return preparedStatement;
    }

    private void setStatement(User entity, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, entity.getUserName());
        preparedStatement.setString(2, entity.getUserSurname());
        preparedStatement.setString(3, entity.getLogin());
        preparedStatement.setString(4, entity.getPassword());
        preparedStatement.setString(5, entity.getRole().name());
        preparedStatement.setString(6, entity.getEmail());
      //  preparedStatement.setDate(7, Date.valueOf(entity.getBirthday()));
        preparedStatement.setInt(7, entity.getAge());
        //preparedStatement.setDate(8, new Date(entity.getBirthday().YEAR, entity.getBirthday().MONTH, entity.getBirthday().DAY_OF_MONTH));
    }


    @Override
    protected List<User> readAll(ResultSet resultSet) throws SQLException {
        List<User> result = new LinkedList<>();
       User user = null;
        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt("id"));
            user.setUserName(resultSet.getString("userName"));
            user.setUserSurname(resultSet.getString("userSurname"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setRole(resultSet.getString("role"));
            user.setEmail(resultSet.getString("email"));
            user.setAge(resultSet.getInt("age"));
           // user.setRole(DaoFactory.getInstance().getRoleDao().getById(resultSet.getInt("role_id")));
            result.add(user);
        }
        return result;
    }
}
