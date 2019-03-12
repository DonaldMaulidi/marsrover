package rover.mars;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static rover.mars.Directions.Direction.EAST;
import static rover.mars.Directions.Direction.NORTH;

@RunWith(JUnitParamsRunner.class)
@SuppressWarnings("Duplicates")
public class MarsRoverTest {

    @Test
    public void test() {
        Directions.Direction direction = EAST;
        Coordinates coordinate = new Coordinates(1, 2);
        Zone zone = new Zone(8, 10);

        MarsRover marsRover = new MarsRover(zone, coordinate, direction);

        assertEquals("3 3 S", marsRover.process("MMLMRMMRRMML"));
    }

    @Test
    @Parameters({
            "R, 0 0 E",
            "RR, 0 0 S",
            "RRR, 0 0 W",
            "RRRR, 0 0 N"
    })
    public void canRotateRight(String commands, String position) {
        Directions.Direction direction = NORTH;
        Coordinates coordinate = new Coordinates(0, 0);
        Zone zone = new Zone(10, 10);

        MarsRover marsRover = new MarsRover(zone, coordinate, direction);

        assertThat(marsRover.process(commands), is(position));
    }

    @Test
    @Parameters({
            "L, 0 0 W",
            "LL, 0 0 S",
            "LLL, 0 0 E",
            "LLLL, 0 0 N"
    })
    public void canRotateLeft(String commands, String position) {
        Directions.Direction direction = NORTH;
        Coordinates coordinate = new Coordinates(0, 0);
        Zone zone = new Zone(10, 10);

        MarsRover marsRover = new MarsRover(zone, coordinate, direction);

        assertThat(marsRover.process(commands), is(position));
    }

    @Test
    @Parameters({
            "M, 0 1 N",
            "MMM, 0 3 N"
    })
    public void canMoveUp(String commands, String position) {
        Directions.Direction direction = NORTH;
        Coordinates coordinate = new Coordinates(0, 0);
        Zone zone = new Zone(10, 10);

        MarsRover marsRover = new MarsRover(zone, coordinate, direction);

        assertThat(marsRover.process(commands), is(position));
    }

    @Test
    @Parameters({
            "M, 0 1 N",
            "MMM, 0 3 N",
            "MMMMMMMMMMMMM, 0 3 N"
    })
    public void canMoveUpWithoutGettingOfTheZone(String commands, String position) {
        Directions.Direction direction = NORTH;
        Coordinates coordinate = new Coordinates(0, 0);
        Zone zone = new Zone(10, 10);

        MarsRover marsRover = new MarsRover(zone, coordinate, direction);

        assertThat(marsRover.process(commands), is(position));
    }

    @Test
    @Parameters({
            "RMMM, 3 0 E",
            "RMMMMMMM, 7 0 E"
    })
    public void canMoveRight(String commands, String position) {
        Directions.Direction direction = NORTH;
        Coordinates coordinate = new Coordinates(0, 0);
        Zone zone = new Zone(10, 10);

        MarsRover marsRover = new MarsRover(zone, coordinate, direction);

        assertThat(marsRover.process(commands), is(position));
    }

    @Test
    @Parameters({
            "RMMMMMMMMMMMMM, 3 0 E"
    })
    public void canMoveRightWithoutGettingOfTheZone(String commands, String position) {
        Directions.Direction direction = NORTH;
        Coordinates coordinate = new Coordinates(0, 0);
        Zone zone = new Zone(10, 10);

        MarsRover marsRover = new MarsRover(zone, coordinate, direction);

        assertThat(marsRover.process(commands), is(position));
    }

    @Test
    @Parameters({
            "LMMM, 7 0 W",
            "LMMMMMM, 4 0 W"
    })
    public void canMoveLeft(String commands, String position) {
        Directions.Direction direction = NORTH;
        Coordinates coordinate = new Coordinates(0, 0);
        Zone zone = new Zone(10, 10);

        MarsRover marsRover = new MarsRover(zone, coordinate, direction);

        assertThat(marsRover.process(commands), is(position));
    }

    @Test
    @Parameters({
            "LMMMMMMMMMMMMMMMM, 4 0 W"
    })
    public void canMoveLeftWithoutGettingOfTheZone(String commands, String position) {
        Directions.Direction direction = NORTH;
        Coordinates coordinate = new Coordinates(0, 0);
        Zone zone = new Zone(10, 10);

        MarsRover marsRover = new MarsRover(zone, coordinate, direction);

        assertThat(marsRover.process(commands), is(position));
    }

    @Test
    @Parameters({
            "LLMMM, 0 7 S"
    })
    public void canMoveSouth(String commands, String position) {
        Directions.Direction direction = NORTH;
        Coordinates coordinate = new Coordinates(0, 0);
        Zone zone = new Zone(10, 10);

        MarsRover marsRover = new MarsRover(zone, coordinate, direction);

        assertThat(marsRover.process(commands), is(position));
    }
}
