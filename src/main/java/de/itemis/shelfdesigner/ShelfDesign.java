package de.itemis.shelfdesigner;

import java.util.ArrayList;
import java.util.List;

/**
 * Simple main application
 */
class ShelfDesign {

    private int width;
    private int buildingArea;
    private int lineHigh;
    private List<Integer> columns;

    ShelfDesign(){
        columns = new ArrayList<>();
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
        this.columns.add(width);
    }

    public int getColumn() {

        return columns.get(0);
    }

    public void addLine(int high){
        this.lineHigh = high;
    }

    public int getLine() {
        return lineHigh;
    }

    public int getShelfWidth() {
        int shelfWidth = columns.stream().mapToInt(value -> value).sum();
        return shelfWidth;
    }

    public int getColumnHight(int column) {
        return 0;
    }
}
