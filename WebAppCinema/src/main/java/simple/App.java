package simple;
import mapper.BeanMapper;
import controllers.MovieServlet;
import dto.*;
import model.*;
import service.impl.*;


import java.util.*;
//import java.util.*;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Date;
import java.sql.Time;
public class App {
    private static final String URL = "jdbc:mysql://localhost:3306/forum?useSSL=false";
    private static final String USER = "forum_admin";
    private static final String PASSWORD = "123";
    private final static String SQL_CREATE_HUMAN_TABLE = "CREATE TABLE IF NOT EXISTS human(id int AUTO_INCREMENT primary key, name VARCHAR(30), age int)";
    private final static String SQL_INSERT_HUMAN = "INSERT INTO human(name , age) VALUES (?, ?)";
    private final static String SQL_READ_HUMAN = "SELECT * FROM human";

    public static void main(String[] args) {
        UserDTO userDTO = UserServiceImpl.getInstance().getByLogin("vpetrov");



        if(userDTO != null && userDTO.getPassword().equals("1234")){

            if(userDTO.getRole().name().compareTo("ADMIN")==0) {
               System.out.println("11111");

            }else{
                System.out.println("222");


            }

    }}
}
