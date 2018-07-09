package dto;

import lombok.Getter;
import lombok.Setter;
import model.Color;
import model.Entity;
import model.Role;


@Getter
@Setter
public class HallDTO extends Entity<Integer> {
    private Color color;
    private int countOfRows;
    private int countOfColumns;


    public HallDTO(){}

    public HallDTO(Color color, int countOfRows, int countOfColumns) {
        this.color = color;
        this.countOfRows=countOfRows;
        this.countOfColumns=countOfColumns;

    }


    public void setColor(Color color){
        this.color=color;
    }


   public void setColor(String colorStr){
        if(colorStr.compareTo("YELLOW")==0)
            this.color= Color.YELLOW;
        else if(colorStr.compareTo("RED")==0)
            this.color= Color.RED;
        else this.color=Color.INDIGO;
    }
}
