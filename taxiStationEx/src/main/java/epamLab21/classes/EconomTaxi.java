package epamLab21.classes;

/**
 * Created by TleuAkma on 05.02.2017.
 */
public class EconomTaxi extends CarTaxi {
    private final int BASETARIFF = 350;
    private final int DISTANCETARIFF = 50;
    private final int TIMETARIFF = 20;

    public EconomTaxi(String model, double volumeOfEngine, int modelYear, int licencePlate, int maxSpeed, int price, int petrolConsumption) {
        super(model, volumeOfEngine, modelYear, licencePlate, maxSpeed, price, petrolConsumption);
    }



    public EconomTaxi() {
    }

    public int getFare(int distance, int travelTime) {
        return BASETARIFF+DISTANCETARIFF*distance+TIMETARIFF*travelTime;
    }
}


