package aircraft;

import mediator.TowerMediator;

public abstract class Aircraft {
    protected String id;
    protected int fuelLevel; // уровень топлива

    public Aircraft(String id, int fuelLevel) {
        this.id = id;
        this.fuelLevel = fuelLevel;
    }

    public abstract void receive(String msg);

    public void send(String msg, TowerMediator m) {
        m.broadcast(msg, this);
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public String getId() {
        return id;
    }
}
