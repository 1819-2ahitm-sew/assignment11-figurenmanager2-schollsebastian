public class Rectangle extends Figure {
    private double[] coordinates = new double[2];
    private double length;
    private double width;

    public Rectangle(double[] coordinates, double length, double width) {
        this.setCoordinates(coordinates);
        this.setLength(length);
        this.setWidth(width);
    }

    @Override
    public double area() {
        return getLength() * getWidth();
    }

    @Override
    public double circumference() {
        return 2 * (getLength() + getWidth());
    }

    @Override
    public String toString() {
        return "Rechteck mit Länge = " + getLength() + " und Breite = " + getWidth() + super.toString();
    }

    //region Getter and Setter
    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
    //endregion
}
