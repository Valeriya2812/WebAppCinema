package dto;

import lombok.Getter;
import lombok.Setter;
import model.Entity;
import model.Hall;
import model.Movie;

import java.sql.Date;
import java.sql.Time;
@Getter
@Setter
public class SeanceDTO extends Entity<Integer> {

        private Movie movie;
        private Hall hall;
        private Date seanceDate;
        private Time seanceTime;
        private int price;


    public SeanceDTO(){}

    public  SeanceDTO(Movie movie, Hall hall, Date seanceDate, Time seanceTime,  int price){
            this.movie=movie;
            this.seanceDate=seanceDate;
            this.seanceTime=seanceTime;
            this.hall=hall;
            this.price=price;


        }
    }


