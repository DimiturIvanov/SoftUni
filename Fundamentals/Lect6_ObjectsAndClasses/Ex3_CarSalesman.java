/*
Define two classes Car and Engine. A Car has a model, engine, weight and color. An Engine has model, power,
displacement and efficiency. A Car’s weight and color and its Engine’s displacements and efficiency are optional.
On the first line, you will read a number N which will specify how many lines of engines you will receive, on each of
the next N lines you will receive information about an Engine in the following format “<Model> <Power>
<Displacement> <Efficiency>”. After the lines with engines, on the next line you will receive a number M –
specifying the number of Cars that will follow, on each of the next M lines information about a Car will follow in the
following format “<Model> <Engine> <Weight> <Color>”, where the engine in the format will be the model of an
existing Engine. When creating the object for a Car, you should keep a reference to the real engine in it, instead of
just the engine’s model, note that the optional properties might be missing from the formats.
Your task is to print each car (in the order you received them) and its information in the format defined bellow, if
any of the optional fields has not been given print "n/a" in its place instead:
<CarModel>:
<EngineModel>:
Power: <EnginePower>
Displacement: <EngineDisplacement>
Efficiency: <EngineEfficiency>
Weight: <CarWeight>
Color: <CarColor>
 */
package Fundamentals.Lect6_ObjectsAndClasses;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex3_CarSalesman {

    static class Car {
        private String model;
        private String engine;
        private String weight;
        private String color;

        public Car(String model, String engine, String weight, String color) {
            this.model = model;
            this.engine = engine;
            this.weight = weight;
            this.color = color;
        }

        public String getModel() {
            return model;
        }

        public String getEngine() {
            return engine;
        }

        public String getWeight() {
            return weight;
        }

        public String getColor() {
            return color;
        }
    }

    static class Engine {
        private String model;
        private int power;
        private String displacement;
        private String efficiency;

        public Engine(String model, int power, String displacement, String efficiency) {
            this.model = model;
            this.power = power;
            this.displacement = displacement;
            this.efficiency = efficiency;
        }

        public String getModel() {
            return model;
        }

        public int getPower() {
            return power;
        }

        public String getDisplacement() {
            return displacement;
        }

        public String getEfficiency() {
            return efficiency;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberEngines = Integer.parseInt(scanner.nextLine());

        List<Engine> engines = new ArrayList<>();

        for (int i = 1; i <= numberEngines; i++) {
            String[] lineEngine = scanner.nextLine().split("\\s+");
            String model = lineEngine[0];
            int power = Integer.parseInt(lineEngine[1]);
            String displacement = "n/a";
            String efficiency = "n/a";

            switch (lineEngine.length) {
                case 3:
                    String word = lineEngine[2];
                    if (word.charAt(0) >= 65 && word.charAt(0) <= 90) {
                        efficiency = lineEngine[2];
                    } else {
                        displacement = lineEngine[2];
                    }
                    break;
                case 4:
                    displacement = lineEngine[2];
                    efficiency = lineEngine[3];
                    break;
                default:
                    break;
            }
            Engine engine = new Engine(model, power, displacement, efficiency);
            engines.add(engine);
        }

        int numberCars = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 1; i <= numberCars; i++) {
            String[] lineCar = scanner.nextLine().split("\\s+");
            String model = lineCar[0];
            String engine = lineCar[1];
            String weight = "n/a";
            String color = "n/a";

            switch (lineCar.length) {
                case 3:
                    String word = lineCar[2];
                    if (word.charAt(0) >= 65 && word.charAt(0) <= 90) {
                        color = lineCar[2];
                    } else {
                        weight = lineCar[2];
                    }
                    break;
                case 4:
                    weight = lineCar[2];
                    color = lineCar[3];
                    break;
                default:
                    break;
            }

            Car car = new Car(model, engine, weight, color);
            cars.add(car);
        }

        for (Car car : cars) {
            for (Engine engine : engines) {
                if (car.getEngine().equals(engine.getModel())) {
                    System.out.printf("%s:%n%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s%nWeight: %s%nColor: %s%n",
                            car.getModel(), car.getEngine(), engine.getPower(), engine.getDisplacement(), engine.getEfficiency(),
                            car.getWeight(), car.getColor());
                }
            }
        }

    }
}
