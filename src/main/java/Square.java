public class Square extends Figure {
    private float[] coordinates = new float[2];
    private float length;

    public Square(float[] coordinates, float length) {
        this.setCoordinates(coordinates);
        this.setLength(length);
    }

    @Override
    public float area() {
        return getLength() * getLength();
    }

    @Override
    public float circumference() {
        return 4 * getLength();
    }

    @Override
    public String toString() {
        return "Quadrat mit Länge = " + getLength() + super.toString();
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
    //endregion
}
