package dao.impl;


public class SQLs {
    public static final String SELECT_ALL = "Select * from %s";
    public static final String FIND_BY_ID = "Select * from %s where id = ?";
    public static final String FIND_BY = "Select * from %s where %s = ?";
    public static final String DELETE_BY_ID = "DELETE FROM %s WHERE id = ?";
    public static  final String INSERT_MOVIE = "Insert into movie (title, description, duration, starring, director, minAge) values (?,?,?,?,?,?)";
    public static  final String UPDATE_MOVIE = "UPDATE movie SET title = ?, description = ?, duration = ?, starring = ?, director = ?, minAge = ?, WHERE id = ?";

    public static  final String UPDATE_USER = "UPDATE user SET userName = ?, userSurname= ?, login = ?, last_name = ?, password = ?, role = ?, email = ?, age = ?, WHERE id = ?";
    public static  final String INSERT_USER = "Insert into user (userName, userSurname, login, password, role," +
            "email, age) VALUES (?, ?, ?, ?, ?, ?, ?)";

    public static  final String UPDATE_SEANCE = "UPDATE seance SET movie = ?, hall = ?, date = ?, time = ?, WHERE id = ?";
    public static  final String INSERT_SEANCE = "Insert into seance (movie, hall, date, time, price) VALUES (?, ?, ?, ?, ?)";
    public static  final String GET_MAX_ID_SEANCE ="SELECT max(id) FROM seance";



    public static  final String UPDATE_HALL = "UPDATE hall SET color = ?, countOfRows = ?, countOfColumns = ?, WHERE id = ?";
    public static  final String INSERT_HALL = "Insert into hall (color, countOfRows, countOfColumns) VALUES (?, ?, ?)";

    public static  final String UPDATE_PLACE = "UPDATE place SET seance = ?, row = ?, col = ?, free = ?, user=? WHERE id = ?";
    public static  final String INSERT_PLACE = "Insert into place (seance, row, col, free) VALUES (?,?,?,?)";


}
