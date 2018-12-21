public class Ellipse extends Figure {
    private float[] coordinates = new float[2];
    private float mainAxis;
    private float minorAxis;

    public Ellipse(float[] coordinates, float mainAxis, float minorAxis) {
        this.setCoordinates(coordinates);
        this.setMainAxis(mainAxis);
        this.setMinorAxis(minorAxis);
    }

    @Override
    public float area() {
        return getMainAxis() * getMinorAxis() * (float) Math.PI;
    }

    @Override
    public float circumference() {
        float lambda = (getMainAxis() - getMinorAxis()) / (getMainAxis() + getMinorAxis());
        return (getMainAxis() + getMinorAxis()) * (float) Math.PI * (1 + ((3 * lambda * lambda)) / (10 + (float) Math.sqrt(4 - 3 * lambda * lambda)));
    }

    @Override
    public String toString() {
        return "Ellipse mit Hauptachse = " + getMainAxis() + " und Nebenachse = " + getMinorAxis() + super.toString();
    }

    //region Getter and Setter
    public float[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(float[] coordinates) {
        this.coordinates = coordinates;
    }

    public float getMainAxis() {
        return mainAxis;
    }

    public void setMainAxis(float mainAxis) {
        this.mainAxis = mainAxis;
    }

    public float getMinorAxis() {
        return minorAxis;
    }

    public void setMinorAxis(float minorAxis) {
        this.minorAxis = minorAxis;
    }
    //endregion
}
