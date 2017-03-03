package epamLab21.classes;

/**
 * Created by TleuAkma on 05.02.2017.
 */
public class ComfortTaxi extends CarTaxi {

    private final int BASETARIFF = 400;
    private final int DISTANCETARIFF = 75;
    private final int TIMETARIFF = 25;


    public ComfortTaxi(String model, double volumeOfEngine, int modelYear, int licencePlate, int maxSpeed, int price, int petrolConsumption) {
        super(model, volumeOfEngine, modelYear, licencePlate, maxSpeed, price, petrolConsumption);
    }



    public ComfortTaxi() {
    }

    public int getFare(int distance, int travelTime) {

        return BASETARIFF+DISTANCETARIFF*distance+TIMETARIFF*travelTime;
    }
}
