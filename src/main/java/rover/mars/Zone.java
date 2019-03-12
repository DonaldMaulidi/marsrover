package rover.mars;

class Zone {
    private final int maxHeight;
    private final int maxWidth;

    Zone(int maxHeight, int maxWidth) {
        this.maxHeight = maxHeight;
        this.maxWidth = maxWidth;
    }

    int getMaxHeight() {
        return maxHeight;
    }

    int getMaxWidth() {
        return maxWidth;
    }
}
