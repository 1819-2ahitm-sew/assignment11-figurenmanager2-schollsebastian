public class Square extends Figure {
    private double[] coordinates = new double[2];
    private double length;

    public Square(double[] coordinates, int length) {
        this.setCoordinates(coordinates);
        this.setLength(length);
    }

    @Override
    public double area() {
        return getLength() * getLength();
    }

    @Override
    public double circumferemce() {
        return 4 * getLength();
    }

    @Override
    public String toString() {
        return "Rechteck mit Länge = " + getLength() + super.toString();
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
    //endregion
}
