package aircraft;

public class CargoPlane extends Aircraft {

    public CargoPlane(String id, int fuelLevel) {
        super(id, fuelLevel);
    }

    @Override
    public void receive(String msg) {
        System.out.println("Cargo plane " + id + " received: " + msg);
    }
}
