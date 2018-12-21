public abstract class Figure {
    public abstract float area();
    public abstract float circumference();

    @Override
    public String toString() {
        return ": Fläche = " + area() + ", Umfang = " + circumference();
    }
}
