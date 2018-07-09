package model;


import lombok.Getter;
import lombok.Setter;


import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Date;


@Setter
@Getter

public class User extends Entity<Integer>  {

    private String userName;
    private String userSurname;
    private String login;
    private String password;
    private Role role;
    private String email;
    private int age;



    public User(){}

    public void setRole(String roleStr){
      if(roleStr.compareTo("VISITOR")==0)
          role= Role.VISITOR;
      else
          role=Role.ADMIN;

     }

    public User(String userName, String userSurname, String email, String login,  String password, Role role, int age) {

        this.userName = userName;
        this.userSurname = userSurname;
        this.email = email;
        this.login = login;
        this.password = password;
        this.role=role;
        this.age=age;


    }}

