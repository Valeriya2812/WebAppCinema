package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Time;
import java.sql.Date;


@Setter
@Getter

public class Seance extends Entity<Integer> {

    private Movie movie;
    private Hall hall;
    private Date seanceDate;
    private Time seanceTime;

    private int price;


   public Seance(){}

    public Seance(Movie movie, Hall hall, Date seanceDate, Time seanceTime,  int price){
        this.movie=movie;
        this.seanceDate=seanceDate;
        this.seanceTime=seanceTime;

        this.hall=hall;
        this.price=price;


    }
}
