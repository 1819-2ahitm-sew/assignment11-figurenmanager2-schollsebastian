public abstract class Figure {
    public abstract double area();
    public abstract double circumference();

    @Override
    public String toString() {
        return ": Fläche = " + area() + ", Umfang = " + circumference();
    }
}
