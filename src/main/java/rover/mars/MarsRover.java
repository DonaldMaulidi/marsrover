package rover.mars;

import rover.mars.Directions.Direction;

import static rover.mars.Directions.Direction.EAST;

public class MarsRover {
    Direction direction;
    Coordinates coordinate;
    Zone zone;

    public MarsRover(Zone zone, Coordinates coordinate, Direction direction) {
        this.zone = zone;
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public String process(String commands) {
        for (char command : commands.toCharArray())
            if (command == 'R') direction = direction.right();
            else if (command == 'L') direction = direction.left();
            else if (command == 'M') coordinate = coordinate.nextCoordinate(this);
        System.out.println(new StringBuilder().append(coordinate.getX()).append(" ").append(coordinate.getY()).append(" ").append(direction.value()).toString());
        return new StringBuilder().append(coordinate.getX()).append(" ").append(coordinate.getY()).append(" ").append(direction.value()).toString();
    }

    public static void main(String args[]) {
        Coordinates coordinate = new Coordinates(1, 2);
        Zone zone = new Zone(8, 10);
        MarsRover
                marsRover = new MarsRover(zone, coordinate, EAST);

        String commands = "MMLMRMMRRMML";
        marsRover.process(commands);

    }

}
