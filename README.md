   ### Mars Rovers Coding Challenge
--------------------

Rovers have been sent to Mars to survey the terrain and you have been charged with creating
their navigation system.

> **The specifications of the challenge are listed below:**

> - Mars’s surface can be thought of as a zone that is itself a two-dimensional grid of square areas.
> - The zones have been very carefully surveyed ahead of time and are deemed safe for exploration within the landing terrain bounds, as represented by a single cartesian coordinate - for example: (5, 5).
> - The rover understands the cardinal points and can face either East (E), West (W), North (N) or South (S) at any given time.
> - The rover understands three commands:
    >>> M-Move one space forward in the direction it is facing
    >>> R-rotate 90 degrees to the right
    >>> L-rotate 90 degrees to the left
    
> - Due to the transmission delay in communicating with the rover on Mars, you are only able to send the rover a single list of commands.
> - These commands will be executed by the rover and its resulting location sent back to HQ. This is an example of the list of commands sent to the rover:
```
8 10
1 2 E
MMLMRMMRRMML
```
> - This is how the rover will interpret the above commands:
    >> The first line describes how big the current zone is. This zone’s boundary is at the Cartesian coordinate of 8,10 and the zone comprises 80 blocks.
    >>The second line describes the rover’s starting location and orientation.
    >>This rover would start at position 1 on the horizontal axis, position 2 on the vertical axis and would be facing East (E). The third line is the list of commands (movements and rotations) to be executed by the rover.
    >> As a result of following these commands, a rover starting at 1 2 E in this zone would land up at 3 3 S .
  
  #### Project Structure
--------------------

My project has four classes. 
> - `Coordinates` which defines the x-axis and y-axis, which is the starting location/coordinate of the Rover. `
> - Directions`, defines which direction the Rover is facing and the possible directions it can face whether it turns left or right for each of the four directions. 
> - `MarsRover` which is the main class, where we pass in the commands for the Rover to interpret. 
> - `Zone` which defines the area in which the Rover can manoeuvre. 

> **Code Snippets:**
>>> The below code which can be found in the `Coordinates` class, determines the Rover's next coordinates while ensuring that it doesn't get out of the specified zone. Should specified commands try to force it out of the zone it will reset back to zone's max width/height if the Rover is facing South/West or the origin point if the Rover is facing North/East.
```
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
```
>>> For Directions there are enums for which directions the specified direction can change or turn to as can be seen the code below. The first enum which is North has 3 string/directions, the first string is the current direction which the Rover is facing the second one is the direction the Rover can turn to to the left and third one is the direction which the Rover can turn to to the right. This can be found in the `Directions` class.
```
public enum Direction {
        NORTH("N", "W", "E"),
        EAST("E", "N", "S"),
        SOUTH("S", "E", "W"),
        WEST("W", "S", "N");
    }
```
>>> The `Zone` class simply defines the max height and width which is the area the Rover can move. 
```
    private final int maxHeight;
    private final int maxWidth;

    Zone(int maxHeight, int maxWidth) {
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;
    }
```
>>> In the `MarsRover` class we pass in the commands which are turned into a char array, from which we can determine which direction the Rover needs to turn to or move to depending on the direction it's currently facing.
```
public String process(String commands) {
        for (char command : commands.toCharArray())
            if (command == 'R') direction = direction.right();
            else if (command == 'L') direction = direction.left();
            else if (command == 'M') coordinate = coordinate.nextCoordinate(this);
        System.out.println(new StringBuilder().append(coordinate.getX()).append(" ").append(coordinate.getY()).append(" ").append(direction.value()).toString());
        return new StringBuilder().append(coordinate.getX()).append(" ").append(coordinate.getY()).append(" ").append(direction.value()).toString();
    }
```

  #### Instructions
--------------------
To move the Rover there are certain inputs you need to pass. 

> **Input Instructions:**
>>> We first create a new `Coordinates` object which takes the starting point where the Rover will start i.e. `Coordinates coordinate = new Coordinates(1, 2);`. We also create a new `Zone` object to specify the area in which the Rover can move i.e. `Zone zone = new Zone(8, 10);`. Then we create a new `MarsRover` object which takes in the `Zone` which it can move in, the `Coordinate` of where it should start and the `Direction` which it will be facing i.e. `MarsRover marsRover = new MarsRover(zone, coordinate, EAST);`. And lastly we create a string of commands (`String commands = "MMLMRMMRRMML";`) which the `MarsRover` will process and move according to i.e. `marsRover.process(commands);`. 

```
public static void main(String args[]) {
    Coordinates coordinate = new Coordinates(1, 2);
    Zone zone = new Zone(8, 10);
    MarsRover marsRover = new MarsRover(zone, coordinate, EAST);

    String commands = "MMLMRMMRRMML";
    marsRover.process(commands);
}
```

> **Output:**
>>> To get an output simply run the main method and it will produce the output below in the console.
```
3 3 S
```

  #### Testing
--------------------
>>>To run more tests please execute the Unit Tests provided in the project which can be found in the path below, the Unit Tests test multiple scenarios. 
```
 (YOUR_LOCAL_DRIVE)\(DIRECTORY)\..\..\marsrover\src\test\java\rover\mars\MarsRoverTest.java
```# marsrover
# marsrover
