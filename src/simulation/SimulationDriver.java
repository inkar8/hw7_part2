package simulation;

import aircraft.Aircraft;
import aircraft.PassengerPlane;
import aircraft.CargoPlane;
import aircraft.Helicopter;
import mediator.ControlTower;

import java.util.*;
import java.util.concurrent.*;

public class SimulationDriver {

    private static final Random random = new Random();
    private static ControlTower tower = new ControlTower();

    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Симуляция случайных самолетов
        Runnable task = () -> {
            int fuelLevel = random.nextInt(100) + 1; // случайный уровень топлива
            Aircraft aircraft;
            if (random.nextBoolean()) {
                aircraft = new PassengerPlane("Plane" + random.nextInt(100), fuelLevel);
            } else if (random.nextBoolean()) {
                aircraft = new CargoPlane("Cargo" + random.nextInt(100), fuelLevel);
            } else {
                aircraft = new Helicopter("Helicopter" + random.nextInt(100), fuelLevel);
            }

            // Случайный запрос на посадку или взлет
            if (random.nextBoolean()) {
                aircraft.send("requestLanding", tower);
            } else {
                aircraft.send("requestTakeoff", tower);
            }

            // Случайная экстренная ситуация
            if (fuelLevel < 20) {
                aircraft.send("MAYDAY", tower);
            }
        };

        scheduler.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS);
    }
}
