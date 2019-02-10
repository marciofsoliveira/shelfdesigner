package de.itemis.shelfdesigner;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.*;

/**
 * - add lines
 *
 * 5- Remove column
 * 6- Remove line
 * 7- Move column
 * 8- Move line
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ShelfDesignTest {

    private ShelfDesign designer;

    @Before
    public void givenShelf() {
        designer = new ShelfDesign();
    }

    @Test
    public void whenAddedWallWith200Centimeters() {
        designer.addWall(200);

        assertThat(designer.getWallWidth()).isEqualTo(200);
    }

    @Test
    public void whenAddedBuildingWidthWith190Centimeters() {
        designer.addBuildingWidth(190);

        assertThat(designer.getBuildingWidth()).isEqualTo(190);
    }

    @Test
    public void whenAddedColumnWithWidth30Centimeters() {
        designer.addColumn(30);

        assertThat(designer.getColumn()).isEqualTo(30);
    }

    @Test
    public void whenAddedTwoColumnsWithWidth50Centimeters() {
        designer.addColumn(50);
        designer.addColumn(50);

        assertThat(designer.getShelfWidth()).isEqualTo(100);
    }

    @Test
    public void whenAddedTwoLinesWithHigh50() {
        designer.addColumn(50);
        designer.addLine(0, 50);
        designer.addLine(0, 50);

        assertThat(designer.getColumnHigh(0)).isEqualTo(100);
    }

}
