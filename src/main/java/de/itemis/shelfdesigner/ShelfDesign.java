package de.itemis.shelfdesigner;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple main application
 */
class ShelfDesign {

    private int wallWidth;
    private int buildingWidth;
    private List<Shelf> shelves;

    ShelfDesign(){
        shelves = new ArrayList<>();
    }

    public void addWall(int width) {
        this.wallWidth = width;
    }

    public int getWallWidth(){
        return wallWidth;
    }

    public void addBuildingWidth(int buildingArea) {
        this.buildingWidth = buildingArea;
    }

    public int getBuildingWidth(){
        return buildingWidth;
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
        return shelves.stream().mapToInt(shelf -> shelf.getWidth()).sum();
    }

    public int getColumnHigh(int column) {
        return shelves.get(column).getHigh();
    }
}
