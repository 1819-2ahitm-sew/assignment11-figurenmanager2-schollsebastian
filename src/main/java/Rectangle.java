public class Rectangle extends Figure {
    private float[] coordinates = new float[2];
    private float length;
    private float width;

    public Rectangle(float[] coordinates, float length, float width) {
        this.setCoordinates(coordinates);
        this.setLength(length);
        this.setWidth(width);
    }

    @Override
    public float area() {
        return getLength() * getWidth();
    }

    @Override
    public float circumference() {
        return 2 * (getLength() + getWidth());
    }

    @Override
    public String toString() {
        return "Rechteck mit Länge = " + getLength() + " und Breite = " + getWidth() + super.toString();
    }

    //region Getter and Setter
    public float[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(float[] coordinates) {
        this.coordinates = coordinates;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }
    //endregion
}
