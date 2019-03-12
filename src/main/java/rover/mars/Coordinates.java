package rover.mars;

import static rover.mars.Directions.Direction.*;

class Coordinates {
    private final int x;
    private final int y;

    Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    Coordinates nextCoordinate(MarsRover marsRover) {
        int x = getX();
        int y = getY();

        if (marsRover.direction == NORTH) {
            y = (y + 1) % marsRover.zone.getMaxHeight();
        } else if (marsRover.direction == EAST) {
            x = (x + 1) % marsRover.zone.getMaxWidth();
        } else if (marsRover.direction == SOUTH) {
            y = (((y > 0) ? y : marsRover.zone.getMaxHeight()) - 1) % marsRover.zone.getMaxHeight();
        } else {
            x = (((x > 0) ? x : marsRover.zone.getMaxWidth()) - 1) % marsRover.zone.getMaxWidth();
        }
        return new Coordinates(x, y);
    }
}
