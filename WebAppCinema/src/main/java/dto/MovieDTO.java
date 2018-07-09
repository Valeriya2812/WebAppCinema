package dto;


import lombok.Getter;
import lombok.Setter;
import model.Entity;
@Setter
@Getter

public class MovieDTO extends Entity<Integer> {

    private String title;
    private String description;
    private String director;
    private String starring;
    private int duration;
    private int minAge;

    public MovieDTO(){}

    public MovieDTO(String title, String description, int duration, String director, String starring, int minAge) {
        this.title = title;
        this.description=description;
        this.duration=duration;
        this.minAge=minAge;
        this.director=director;
        this.starring=starring;
    }


    @Override
    public String toString() {
        return "MovieDTO{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                "} ";
    }
}