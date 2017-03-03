package epamLab21.classes;

/**
 * Created by TleuAkma on 05.02.2017.
 */
public class VipTaxi extends CarTaxi {
    private final int BASETARIFF = 1000;
    private final int DISTANCETARIFF = 100;
    private final int TIMETARIFF = 50;

    public VipTaxi(String model, double volumeOfEngine, int modelYear, int licencePlate, int maxSpeed, int price, int petrolConsumption) {
        super(model, volumeOfEngine, modelYear, licencePlate, maxSpeed, price, petrolConsumption);
    }

    public VipTaxi() {
    }

    public int getFare(int distance, int travelTime) {
        return BASETARIFF+DISTANCETARIFF*distance+TIMETARIFF*travelTime;
    }
}
