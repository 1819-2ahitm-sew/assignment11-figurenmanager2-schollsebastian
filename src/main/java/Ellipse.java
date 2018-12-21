public class Ellipse extends Figure {
    private double[] coordinates = new double[2];
    private double mainAxis;
    private double minorAxis;

    public Ellipse(double[] coordinates, double mainAxis, double minorAxis) {
        this.setCoordinates(coordinates);
        this.setMainAxis(mainAxis);
        this.setMinorAxis(minorAxis);
    }

    @Override
    public double area() {
        return getMainAxis() * getMinorAxis() * Math.PI;
    }

    @Override
    public double circumference() {
        double lambda = (getMainAxis() - getMinorAxis()) / (getMainAxis() + getMinorAxis());
        return (getMainAxis() + getMinorAxis()) * Math.PI * (1 + ((3 * lambda * lambda)) / (10 + Math.sqrt(4 - 3 * lambda * lambda)));
    }

    @Override
    public String toString() {
        return "Ellipse mit Hauptachse = " + getMainAxis() + " und Nebenachse = " + getMinorAxis() + super.toString();
    }

    //region Getter and Setter
    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public double getMainAxis() {
        return mainAxis;
    }

    public void setMainAxis(double mainAxis) {
        this.mainAxis = mainAxis;
    }

    public double getMinorAxis() {
        return minorAxis;
    }

    public void setMinorAxis(double minorAxis) {
        this.minorAxis = minorAxis;
    }
    //endregion
}
