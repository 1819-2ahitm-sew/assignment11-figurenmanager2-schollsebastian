import java.util.List;

public class Polygon extends Figure {
    private List<Double[]> coordinates;

    public Polygon(List<Double[]> coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public double area() {
        double area = 0;

        for (int i = 0; i < coordinates.size(); i++) {
            if (i == coordinates.size() - 1){
                area += (coordinates.get(i)[0] * coordinates.get(0)[1]) - (coordinates.get(i)[1] * coordinates.get(0)[0]);
            }
            else {
                area += (coordinates.get(i)[0] * coordinates.get(i + 1)[1]) - (coordinates.get(i)[1] * coordinates.get(i + 1)[0]);
            }
        }

        return Math.abs(area) / 2;
    }

    @Override
    public double circumference() {
        double circumference = 0d;

        for (int i = 0; i < coordinates.size(); i++) {
            if(i == coordinates.size() - 1){
                circumference += Math.sqrt(Math.pow(coordinates.get(0)[0] - coordinates.get(i)[0], 2) + Math.pow(coordinates.get(0)[1] - coordinates.get(i)[1], 2));
            }
            else{
                circumference += Math.sqrt(Math.pow(coordinates.get(i + 1)[0] - coordinates.get(i)[0], 2) + Math.pow(coordinates.get(i + 1)[1] - coordinates.get(i)[1], 2));
            }

        }

        return circumference;
    }

    @Override
    public String toString() {
        String outputText = "Polygon mit ";

        for (int i = 0; i < coordinates.size(); i++) {
            if (i != 0 && i != coordinates.size() - 1) {
                outputText += ", ";
            } else if (i == coordinates.size() - 1) {
                outputText += " und ";
            }
            outputText += "(" + coordinates.get(i)[0] + "|" + coordinates.get(i)[1] + ")";
        }

        return outputText + super.toString();
    }

    //region Getter and Setter
    public List<Double[]> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<Double[]> coordinates) {
        this.coordinates = coordinates;
    }
    //endregion
}
