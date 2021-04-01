package tech.itpark.citilink.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Laptop extends Product {
    private double screenDiagonal;
    private int randomAccessMemory;
    private String processor;

    public Laptop(long id, String name, int price, boolean removed, double screenDiagonal, int randomAccessMemory, String processor) {
        super(id, name, price, removed);
        this.screenDiagonal = screenDiagonal;
        this.randomAccessMemory = randomAccessMemory;
        this.processor = processor;
    }
}
