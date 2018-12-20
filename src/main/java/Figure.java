public abstract class Figure {
    public abstract double area();
    public abstract double circumferemce();

    @Override
    public String toString() {
        return ": Fläche = " + area() + ", Umfang = " + circumferemce();
    };
}
