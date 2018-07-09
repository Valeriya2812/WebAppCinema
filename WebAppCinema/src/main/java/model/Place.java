package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Place extends Entity<Integer> {

    private Seance seance;
    private int row;
    private int column;
    private boolean free;
    private User user=null;


    public Place(){}

    public Place(Seance seance, int row, int column, boolean free){
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
