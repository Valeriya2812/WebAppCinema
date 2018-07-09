package simple;

import lombok.Data;

@Data
public class Human {
    private int id;
    private String name;
    private int age;
    public Human(){

    }
    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
