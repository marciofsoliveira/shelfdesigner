package de.itemis.shelfdesigner;

import java.util.ArrayList;
import java.util.List;

public class Shelf {

    private int width;

    private List<Integer> lines;

    Shelf(int width){
        lines = new ArrayList<>();
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public int getHigh() {
       return lines.stream().mapToInt(line -> line).sum();
    }

    public void addLine(int hight) {
        lines.add(hight);
    }
}
