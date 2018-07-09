package model;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Movie extends Entity<Integer> {

    private String title;
    private String description;
    private String director;
    private String starring;
    private int duration;
    private int minAge;

    public Movie(){}

    public Movie(String title, String description, int duration, String director, String starring, int minAge) {
        this.title = title;
        this.description=description;
        this.duration=duration;
        this.minAge=minAge;
        this.director=director;
        this.starring=starring;
    }
}
