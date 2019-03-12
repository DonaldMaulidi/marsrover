package rover.mars;

class Directions {
    public enum Direction {
        NORTH("N", "W", "E"),
        EAST("E", "N", "S"),
        SOUTH("S", "E", "W"),
        WEST("W", "S", "N");

        private final String currentDirection;
        private final String left;
        private final String right;

        Direction(String currentDirection, String left, String right) {
            this.currentDirection = currentDirection;
            this.left = left;
            this.right = right;
        }

        public Direction right() {
            return changeDirection(right);

        }

        public Direction left() {
            return changeDirection(left);
        }

        public String value() {
            return currentDirection;
        }

        private Direction changeDirection(String value) {
            for (Direction direction : values()) {
                if (direction.currentDirection == value) {
                    return direction;
                }
            }
            return null;
        }
    }
}
