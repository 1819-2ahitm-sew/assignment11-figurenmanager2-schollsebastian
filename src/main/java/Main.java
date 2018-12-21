import processing.core.PApplet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends PApplet {

    private static List<Figure> figures = new ArrayList<Figure>();
    private static boolean stop = false;

    public static void main(String[] args) {
        PApplet.main("Main", args);

        String input = readFromKeyboard("-----------------------------------------\n" +
                "1 - Figur erstellen\n" +
                "2 - Figuren nach Fläche sortiert ausgeben\n" +
                "3 - Figuren nach Umfang sortiert ausgeben\n" +
                "4 - Programm beenden\n\n" +
                "Eingabe: ", 4);
        System.out.println("-----------------------------------------");

        while (!input.equals("4")) {
            if (!input.equals("4")) {
                System.out.println();
                switch (input.charAt(0)) {
                    case '1':
                        createFigure();
                        break;
                    case '2':
                        if (figures.size() != 0) {
                            System.out.println("Figuren nach Fläche sortiert:");
                            for (int i = 1; i <= figures.size(); i++) {
                                for (int j = 0; j < figures.size() - i; j++) {
                                    if (figures.get(j).area() > figures.get(j + 1).area()) {
                                        Figure help = figures.get(j);
                                        figures.set(j, figures.get(j + 1));
                                        figures.set(j + 1, help);
                                    }
                                }
                            }
                            for (Figure figure : figures) {
                                System.out.println("   " + figure);
                            }
                        } else {
                            System.out.println("Noch keine Figuren erstellt!");
                        }
                        break;
                    case '3':
                        if (figures.size() != 0) {
                            System.out.println("Figuren nach Umfang sortiert:");
                            for (int i = 1; i <= figures.size(); i++) {
                                for (int j = 0; j < figures.size() - i; j++) {
                                    if (figures.get(j).circumference() > figures.get(j + 1).circumference()) {
                                        Figure help = figures.get(j);
                                        figures.set(j, figures.get(j + 1));
                                        figures.set(j + 1, help);
                                    }
                                }
                            }
                            for (Figure figure : figures) {
                                System.out.println("   " + figure);
                            }
                        } else {
                            System.out.println("Noch keine Figuren erstellt!");
                        }
                        break;
                }
                System.out.println();

                input = readFromKeyboard("-----------------------------------------\n" +
                        "1 - Figur erstellen\n" +
                        "2 - Figuren nach Fläche sortiert ausgeben\n" +
                        "3 - Figuren nach Umfang sortiert ausgeben\n" +
                        "4 - Programm beenden\n\n" +
                        "Eingabe: ", 4);
                System.out.println("-----------------------------------------");
            }
        }

        stop = true;
    }

    public void settings() {
        size(800, 800);
    }

    public void setup() {
        frameRate(60);
        noFill();
    }

    public void draw() {
        if (!stop) {
            for (Figure figure : figures) {
                if (figure instanceof Polygon) {
                    for (int i = 0; i < ((Polygon) figure).getCoordinates().size(); i++) {
                        if (i == ((Polygon) figure).getCoordinates().size() - 1) {
                            line(((Polygon) figure).getCoordinates().get(i)[0],
                                    ((Polygon) figure).getCoordinates().get(i)[1],
                                    ((Polygon) figure).getCoordinates().get(0)[0],
                                    ((Polygon) figure).getCoordinates().get(0)[1]);
                        } else {
                            line(((Polygon) figure).getCoordinates().get(i)[0],
                                    ((Polygon) figure).getCoordinates().get(i)[1],
                                    ((Polygon) figure).getCoordinates().get(i + 1)[0],
                                    ((Polygon) figure).getCoordinates().get(i + 1)[1]);
                        }
                    }
                } else if (figure instanceof Rectangle) {
                    rect(((Rectangle) figure).getCoordinates()[0],
                            ((Rectangle) figure).getCoordinates()[1],
                            ((Rectangle) figure).getLength(),
                            ((Rectangle) figure).getWidth());
                } else if (figure instanceof Square) {
                    rect(((Square) figure).getCoordinates()[0],
                            ((Square) figure).getCoordinates()[1],
                            ((Square) figure).getLength(),
                            ((Square) figure).getLength());
                } else if (figure instanceof Ellipse) {
                    ellipse(((Ellipse) figure).getCoordinates()[0],
                            ((Ellipse) figure).getCoordinates()[1],
                            ((Ellipse) figure).getMainAxis(),
                            ((Ellipse) figure).getMinorAxis());
                }
            }
        } else {
            exit();
        }
    }

    private static void createFigure() {
        String input = readFromKeyboard("1 - Polygon\n" +
                "2 - Rechteck\n" +
                "3 - Quadrat\n" +
                "4 - Ellipse\n" +
                "5 - Abbrechen\n\n" +
                "Eingabe: ", 5);
        float a;
        float b;
        float[] coordinates = new float[2];

        switch (input.charAt(0)) {
            case '1':
                List<Float[]> coordinatesPolygon = new ArrayList<Float[]>();
                String coordinateString;

                System.out.println("\nKoordinaten ('stop' beendet die Eingabe):");
                coordinateString = readFromKeyboard("   1. Punkt <x|y>: ", -1);

                for (int i = 2; !coordinateString.equalsIgnoreCase("stop"); i++) {
                    if (!coordinateString.equalsIgnoreCase("stop")) {
                        Float[] newCoordinates = new Float[2];

                        newCoordinates[0] = Float.valueOf(coordinateString.split("\\|")[0]);
                        newCoordinates[1] = Float.valueOf(coordinateString.split("\\|")[1]);

                        coordinatesPolygon.add(newCoordinates);
                    }
                    coordinateString = readFromKeyboard("   " + i + ". Punkt <x|y>: ", -1);
                }

                figures.add(new Polygon(coordinatesPolygon));
                break;
            case '2':
                System.out.println("\nRechteck:");
                a = Float.valueOf(readFromKeyboard("   Länge: ", -1));
                b = Float.valueOf(readFromKeyboard("   Breite: ", -1));
                coordinates[0] = Float.valueOf(readFromKeyboard("   x-Koordinate des linken oberen Punktes: ", -1));
                coordinates[1] = Float.valueOf(readFromKeyboard("   y-Koordinate des linken oberen Punktes: ", -1));
                figures.add(new Rectangle(coordinates, a, b));
                break;
            case '3':
                System.out.println("\nQuadrat:");
                a = Float.valueOf(readFromKeyboard("   Länge: ", -1));
                coordinates[0] = Float.valueOf(readFromKeyboard("   x-Koordinate des linken oberen Punktes: ", -1));
                coordinates[1] = Float.valueOf(readFromKeyboard("   y-Koordinate des linken oberen Punktes: ", -1));
                figures.add(new Square(coordinates, a));
                break;
            case '4':
                System.out.println("\nEllipse:");
                a = Float.valueOf(readFromKeyboard("   Hauptachse: ", -1));
                b = Float.valueOf(readFromKeyboard("   Nebenachse: ", -1));
                coordinates[0] = Float.valueOf(readFromKeyboard("   x-Koordinate des Mittelpunktes: ", -1));
                coordinates[1] = Float.valueOf(readFromKeyboard("   y-Koordinate des Mittelpunktes: ", -1));
                figures.add(new Ellipse(coordinates, a, b));
                break;
        }
    }

    private static String readFromKeyboard(String menuString, int maxValidNumber) {
        Scanner scanner = new Scanner(System.in);
        boolean inputIsValid = false;
        String input;

        if (maxValidNumber != -1) {
            do {
                boolean keepRunning = true;

                System.out.print(menuString);
                input = scanner.next();

                for (int i = 1; i <= maxValidNumber && keepRunning; i++) {
                    if (input.equals("" + i)) {
                        inputIsValid = true;
                        keepRunning = false;
                    }
                }

                if (!inputIsValid) {
                    System.out.println("\nEingabe ist ungültig!\n");
                }
            } while (!inputIsValid);
        } else {
            System.out.print(menuString);
            input = scanner.next();
        }

        return input;
    }
}
