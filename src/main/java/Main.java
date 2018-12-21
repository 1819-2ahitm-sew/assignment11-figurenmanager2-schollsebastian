import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Figure> figures = new ArrayList<Figure>();

    public static void main(String[] args) {
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
                                    if (figures.get(j).area() < figures.get(j + 1).area()) {
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
                                    if (figures.get(j).circumference() < figures.get(j + 1).circumference()) {
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
    }

    private static void createFigure() {
        String input = readFromKeyboard("1 - Polygon\n" +
                "2 - Rechteck\n" +
                "3 - Quadrat\n" +
                "4 - Ellipse\n" +
                "5 - Abbrechen\n\n" +
                "Eingabe: ", 5);
        double a;
        double b;
        double[] coordinates = new double[2];

        switch (input.charAt(0)) {
            case '1':
                List<Double[]> coordinatesPolygon = new ArrayList<Double[]>();
                String coordinateString;

                System.out.println("\nKoordinaten ('stop' beendet die Eingabe):");
                coordinateString = readFromKeyboard("   1. Punkt <x|y>: ", -1);

                for (int i = 2; !coordinateString.equalsIgnoreCase("stop"); i++) {
                    if (!coordinateString.equalsIgnoreCase("stop")) {
                        Double[] newCoordinates = new Double[2];

                        newCoordinates[0] = Double.valueOf(coordinateString.split("\\|")[0]);
                        newCoordinates[1] = Double.valueOf(coordinateString.split("\\|")[1]);

                        coordinatesPolygon.add(newCoordinates);
                    }
                    coordinateString = readFromKeyboard("   " + i + ". Punkt [x|y]: ", -1);
                }

                figures.add(new Polygon(coordinatesPolygon));
                break;
            case '2':
                System.out.println("\nRechteck:");
                a = Double.valueOf(readFromKeyboard("   Länge: ", -1));
                b = Double.valueOf(readFromKeyboard("   Breite: ", -1));
                coordinates[0] = Double.valueOf(readFromKeyboard("   x-Koordinate des linken oberen Punktes: ", -1));
                coordinates[1] = Double.valueOf(readFromKeyboard("   y-Koordinate des linken oberen Punktes: ", -1));
                figures.add(new Rectangle(coordinates, a, b));
                break;
            case '3':
                System.out.println("\nQuadrat:");
                a = Double.valueOf(readFromKeyboard("   Länge: ", -1));
                coordinates[0] = Double.valueOf(readFromKeyboard("   x-Koordinate des linken oberen Punktes: ", -1));
                coordinates[1] = Double.valueOf(readFromKeyboard("   y-Koordinate des linken oberen Punktes: ", -1));
                figures.add(new Square(coordinates, a));
                break;
            case '4':
                System.out.println("\nEllipse:");
                a = Double.valueOf(readFromKeyboard("   Hauptachse: ", -1));
                b = Double.valueOf(readFromKeyboard("   Nebenachse: ", -1));
                coordinates[0] = Double.valueOf(readFromKeyboard("   x-Koordinate des Mittelpunktes: ", -1));
                coordinates[1] = Double.valueOf(readFromKeyboard("   y-Koordinate des Mittelpunktes: ", -1));
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
