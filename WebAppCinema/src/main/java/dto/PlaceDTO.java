package dto;

import lombok.Getter;
import lombok.Setter;
import model.Entity;
import model.Seance;
import model.User;

@Setter
@Getter


public class PlaceDTO extends Entity<Integer> {
    private Seance seance;
    private int row;
    private int column;
    private boolean free;
    private User user=null;



    public PlaceDTO(){}

    public PlaceDTO(Seance seance, int row, int column, boolean free){
        if(row<seance.getHall().getCountOfRows()&&row>=0)
        { if(column<seance.getHall().getCountOfColumns()&&column>=0)
        {this.seance=seance;
            this.row = row;
            this.column=column;
            this.free=free;
        }}


    }

    public void setUser(User user){
        if(free==false)
            this.user=user;

    }
    public boolean getFree(){
        return free;
    }
}

