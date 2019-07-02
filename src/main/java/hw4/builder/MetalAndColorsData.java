package hw4.builder;


import java.util.List;

public class MetalAndColorsData {

    private Integer odd = 1;
    private Integer even = 2;
    private List<String> elements;
    private String color;
    private String metal;
    private List<String> vegetables;

    public Integer getOdd() {
        return odd;
    }

    public void setOdd(Integer odd) {
        this.odd = odd;
    }

    public Integer getEven() {
        return even;
    }

    public void setEven(Integer even) {
        this.even = even;
    }

    public List<String> getElements() {
        return elements;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMetal() {
        return metal;
    }

    public void setMetal(String metal) {
        this.metal = metal;
    }

    public List<String> getVegetables() {
        return vegetables;
    }

    public void setVegetables(List<String> vegetables) {
        this.vegetables = vegetables;
    }
}
