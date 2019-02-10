package de.itemis.shelfdesigner;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple main application
 */
class ShelfDesigner {

    private int wallWidth;
    private int maxBuildingWidth;
    private List<Shelf> shelves;

    ShelfDesigner(int wallWidth, int maxBuildingWidth){
        shelves = new ArrayList<>();
        this.wallWidth = wallWidth;
        setMaxBuildWidth(maxBuildingWidth);
    }

    public void addWall(int width) {
        this.wallWidth = width;
    }

    public int getWallWidth(){
        return wallWidth;
    }

    public void setMaxBuildWidth(int buildingArea) {
        if (buildingArea < wallWidth){
            this.maxBuildingWidth = buildingArea;
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    public int getMaxBuildingWidth(){
        return maxBuildingWidth;
    }

    public boolean addColumn(int width, int maxHigh) {
        if(getShelfWidth() + width > maxBuildingWidth){
            return false;
        }
        else{
            return shelves.add( new Shelf(width, maxHigh));
        }
    }

    public int getColumn() {
        return shelves.get(0).getWidth();
    }

    public boolean addLine(int shelf, int high){
        return shelves.get(shelf).addLine(high);
    }

    public int getShelfWidth() {
        return shelves.stream().mapToInt(shelf -> shelf.getWidth()).sum();
    }

    public int getColumnHigh(int column) {
        return shelves.get(column).getHigh();
    }
}
