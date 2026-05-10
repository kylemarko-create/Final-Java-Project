// To further strengthen your work, you might consider refining input validation (such as handling invalid numeric input more specifically) and using case-insensitive comparisons when matching vehicle data. You could also enhance the design by separating responsibilities further (e.g., moving inventory management outside of the Car class) to better align with object-oriented best practices.

import java.util.Scanner;
import java.util.ArrayList;

public class App {

    //default class of what makes a car
    static class Car {
        //define values
        private String make;
        private String model;
        private String color;
        private int mileage;
        private int year;

        public Car(String make, String model, String color, int year, int mileage) {
            this.make = make;
            this.model = model;
            this.color = color;
            this.year = year;
            this.mileage = mileage;
        }
        // add a car from console input
        public static Car addCar(Scanner scanner) {
            System.out.print("Make:");
            String make = scanner.nextLine();
            System.out.print("Model:");
            String model = scanner.nextLine();
            System.out.print("Color:");
            String color = scanner.nextLine();
            System.out.print("Year:");
            int year;
            try {
                year = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid year. Must be a number.");
                return null;
            }
            System.out.print("Mileage:");
            int mileage;
            try {
                mileage = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid mileage. Must be a number.");
                return null;
            }
            return new Car(make, model, color, year, mileage);
        }

        // remove function
        public static String removeCar(ArrayList<Car> inventory, String make, String model, String color, int year) {
            try {
                for (int i = 0; i < inventory.size(); i++) {
                    Car c = inventory.get(i);
                    if (c.make.equalsIgnoreCase(make) && c.model.equalsIgnoreCase(model)
                            && c.color.equalsIgnoreCase(color) && c.year == year) {
                        inventory.remove(i);
                        return "Car removed successfully.";
                    }
                }
                return "No matching car found.";
            } catch (Exception e) {
                return "Error removing car: " + e.getMessage();
            }
        }

        // list a cars info function
        public String[] listCar() {
            try {
                return new String[]{
                    "Make:" + make,
                    "Model:" + model,
                    "Color:" + color,
                    "Year:" + year,
                    "Mileage:" + mileage
                };
            } catch (Exception e) {
                return new String[]{"Error listing car:" + e.getMessage()};
            }
        }

        // list all cars
        public static String listAll(ArrayList<Car> inventory) {
            try {
                if (inventory.isEmpty()) {
                    return "Inventory is empty.";
                }
                for (int i = 0; i < inventory.size(); i++) {
                    System.out.println("Car #" + (i + 1));
                    for (String info : inventory.get(i).listCar()) {
                        System.out.println("  " + info);
                    }
                    System.out.println();
                }
                return inventory.size() + " car(s) in inventory.";
            } catch (Exception e) {
                return "Error listing inventory:" + e.getMessage();
            }
        }
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            ArrayList<Car> inventory = new ArrayList<>();
            boolean running = true;

            System.out.println("Car Dealership Inventory");
            System.out.println();

            while (running) {
                System.out.println("1. Add a car");
                System.out.println("2. Remove a car");
                System.out.println("3. List all");
                System.out.println("4. Quit");
                System.out.print("Choose an option:");
                String choice = scanner.nextLine();
                System.out.println();

                switch (choice) {
                    case "1":
                        Car car = Car.addCar(scanner);
                        if (car != null) {
                            inventory.add(car);
                            System.out.println("Car added!");
                        }
                        break;
                    case "2":
                        System.out.print("Make: ");
                        String make = scanner.nextLine();
                        System.out.print("Model:");
                        String model = scanner.nextLine();
                        System.out.print("Color:");
                        String color = scanner.nextLine();
                        System.out.print("Year:");
                        int year;
                        try {
                            year = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid year. Must be a number.");
                            break;
                        }
                        System.out.println(Car.removeCar(inventory, make, model, color, year));
                        break;
                    case "3":
                        System.out.println(Car.listAll(inventory));
                        break;
                    case "4":
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
                System.out.println();
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
}
