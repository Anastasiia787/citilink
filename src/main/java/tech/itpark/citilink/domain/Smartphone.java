package tech.itpark.citilink.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Smartphone extends Product {
    private double display;
    private int memory;

    public Smartphone(long id, String name, int price, boolean removed, double display, int memory) {
        super(id, name, price, removed);
        this.display = display;
        this.memory = memory;
    }
}
