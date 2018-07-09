package dto;


import lombok.Getter;
import lombok.Setter;
import model.Entity;
import model.Role;

import java.time.LocalDate;

@Setter
@Getter


public class UserDTO extends Entity<Integer> {
    private String userName;
    private String userSurname;
    private String login;
    private String password;
    private Role role;
    private String email;
    int age;


    public UserDTO(){}

    public void setRole(String roleStr){
        if(roleStr.compareTo("VISITOR")==0)
            role= Role.VISITOR;
        else
            role=Role.ADMIN;

    }


    public void setRole(Role role){
      this.role=role;

    }

    public UserDTO(String userName, String userSurname, String email, String login,  String password, Role role, int age) {

        this.userName = userName;
        this.userSurname = userSurname;
        this.email = email;
        this.login = login;
        this.password = password;
        this.role=role;
        this.age=age;


    }
    @Override
    public String toString() {
        return "UserDTO{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' + "} " + super.toString();
    }
}


