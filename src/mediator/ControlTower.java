package mediator;

import aircraft.Aircraft;

import java.util.*;

public class ControlTower implements TowerMediator {
    private Queue<Aircraft> landingQueue = new LinkedList<>();
    private Queue<Aircraft> takeoffQueue = new LinkedList<>();

    @Override
    public void broadcast(String msg, Aircraft sender) {
        System.out.println("Control Tower: " + msg + " from " + sender.getId());
        if (msg.equals("MAYDAY")) {
            handleEmergency(sender);
        } else if (msg.equals("requestLanding")) {
            requestLanding(sender);
        } else if (msg.equals("requestTakeoff")) {
            requestTakeoff(sender);
        }
    }

    private void requestLanding(Aircraft a) {
        landingQueue.offer(a);
        System.out.println(a.getId() + " is in the landing queue.");
    }

    private void requestTakeoff(Aircraft a) {
        takeoffQueue.offer(a);
        System.out.println(a.getId() + " is in the takeoff queue.");
    }

    private void handleEmergency(Aircraft a) {
        // Очистка полосы для экстренного самолета
        landingQueue.clear();
        System.out.println(a.getId() + " is priority for landing due to MAYDAY. Clearing runway!");
        landingQueue.offer(a);
    }

    @Override
    public boolean requestRunway(Aircraft a) {
        if (!landingQueue.isEmpty()) {
            Aircraft landing = landingQueue.poll();
            System.out.println("Landing aircraft: " + landing.getId());
            return true;
        } else if (!takeoffQueue.isEmpty()) {
            Aircraft takeoff = takeoffQueue.poll();
            System.out.println("Takeoff aircraft: " + takeoff.getId());
            return true;
        }
        return false;
    }
}
