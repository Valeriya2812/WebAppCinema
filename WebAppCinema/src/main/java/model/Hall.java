package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Hall extends Entity<Integer> {

    private Color color;
    private int countOfRows;
    private int countOfColumns;


    public Hall(){}

    public Hall(Color color, int countOfRows, int countOfColumns) {
        this.color = color;
        this.countOfRows=countOfRows;
        this.countOfColumns=countOfColumns;

    }
   public void setColor(Color color){
        this.color=color;
    }

    public  void setColor(String colorStr){
        if(colorStr.compareTo("YELLOW")==0)
            this.color= Color.YELLOW;
       else if(colorStr.compareTo("RED")==0)
            this.color= Color.RED;
       else this.color=Color.INDIGO;
    }

}
