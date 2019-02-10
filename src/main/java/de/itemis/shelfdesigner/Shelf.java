package de.itemis.shelfdesigner;

import java.util.ArrayList;
import java.util.List;

public class Shelf {

    private int width;
    private int maxHigh;
    private List<Integer> lines;


    Shelf(int width, int maxHigh){
        lines = new ArrayList<>();
        this.width = width;
        this.maxHigh = maxHigh;
    }

    public int getWidth() {
        return width;
    }

    public int getHigh() {
       return lines.stream().mapToInt(line -> line).sum();
    }

    public boolean addLine(int high) {
        if(getHigh()+high >maxHigh){
            return false;
        }
        else{
            return lines.add(high);
        }
    }
}
