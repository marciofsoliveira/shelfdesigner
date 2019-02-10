package de.itemis.shelfdesigner;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple main application
 */
class ShelfDesign {

    private int width;
    private int buildingArea;
    private List<Shelf> shelves;

    ShelfDesign(){
        shelves = new ArrayList<>();
    }

    public void addWall(int width) {
        this.width = width;
    }

    public int getWallWidth(){
        return width;
    }

    public void addBuildingWidth(int buildingArea) {
        this.buildingArea = buildingArea;
    }

    public int getBuildingWidth(){
        return buildingArea;
    }

    public void addColumn(int width) {
        shelves.add( new Shelf(width));
    }

    public int getColumn() {
        return shelves.get(0).getWidth();
    }

    public void addLine(int shelf, int high){
        shelves.get(shelf).addLine(high);
    }

    public int getShelfWidth() {
        int shelfWidth = shelves.stream().mapToInt(shelf -> shelf.getWidth()).sum();
        return shelfWidth;
    }

    public int getColumnHigh(int column) {
        return shelves.get(column).getHigh();
    }
}
