package de.itemis.shelfdesigner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.*;

/**
 * - Remove column
 * - Remove line
 * - Move column
 * - Move line
 * - persist
 * - have multiple shelves designed
 */
@RunWith(MockitoJUnitRunner.class)
public class ShelfDesignTest {

    private ShelfDesigner designer;

    @Before
    public void givenShelfDesign() {
        designer = new ShelfDesigner(200, 100);
    }

    @Test (expected = IllegalArgumentException.class)
    public void maxBuildingWidthShallNotExceedWallWidth(){
        designer.setMaxBuildWidth(201);
    }

    @Test
    public void whenAddedWallWith200Centimeters() {
        designer.addWall(200);

        assertThat(designer.getWallWidth()).isEqualTo(200);
    }

    @Test
    public void whenAddedColumnWithWidth30Centimeters() {
        designer.addColumn(30, 100);

        assertThat(designer.getColumn()).isEqualTo(30);
    }

    @Test
    public void whenAddedTwoColumnsWithWidth50Centimeters() {
        designer.addColumn(50, 100);
        designer.addColumn(50, 100);

        assertThat(designer.getShelfWidth()).isEqualTo(100);
    }

    @Test
    public void whenAddedTwoLinesWithHigh50() {
        designer.addColumn(50, 100);
        designer.addLine(0, 50);
        designer.addLine(0, 50);

        assertThat(designer.getColumnHigh(0)).isEqualTo(100);
    }

    @Test
    public void addingLineHigherThanMaxHighIsNotAllowed() {
        designer.addColumn(50, 100);
        designer.addLine(0, 50);
        designer.addLine(0, 50);

        boolean result = designer.addLine(0, 50);

        assertThat(result).isFalse();
        assertThat(designer.getColumnHigh(0)).isEqualTo(100);
    }

    @Test
    public void addingColumnsLargerThanMaxBuildingWidthIsNotAllowed() {
        designer.addColumn(50, 100);
        designer.addColumn(50, 100);

        boolean result = designer.addColumn(50, 100);

        assertThat(result).isFalse();
        assertThat(designer.getShelfWidth()).isEqualTo(100);
    }
}
