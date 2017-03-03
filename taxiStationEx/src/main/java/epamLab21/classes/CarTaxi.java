package epamLab21.classes;

/**
 * Created by TleuAkma on 05.02.2017.
 */
public abstract class CarTaxi implements Comparable<CarTaxi> {
    private String model;
    private double volumeOfEngine;
    private int modelYear;
    private int licencePlate;
    private int maxSpeed;
    private int price;
    private int petrolConsumption;

    public CarTaxi(String model, double volumeOfEngine, int modelYear, int licencePlate, int maxSpeed, int price, int petrolConsumption) {
        this.model = model;
        this.volumeOfEngine = volumeOfEngine;
        this.modelYear = modelYear;
        this.licencePlate = licencePlate;
        this.maxSpeed = maxSpeed;
        this.price = price;
        this.petrolConsumption = petrolConsumption;
    }

    public CarTaxi() {

    }

    public String getModel() {
        return model;
    }

    public double getVolumeOfEngine() {
        return volumeOfEngine;
    }

    public int getModelYear() {
        return modelYear;
    }

    public int getLicencePlate() {
        return licencePlate;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public int getPrice() {
        return price;
    }

    public int getPetrolConsumption() {
        return petrolConsumption;
    }




    public void setModel(String model) {
        this.model = model;
    }

    public void setVolumeOfEngine(double volumeOfEngine) {
        this.volumeOfEngine = volumeOfEngine;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public void setLicencePlate(int licencePlate) {
        this.licencePlate = licencePlate;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setPetrolConsumption(int petrolConsumption) {
        this.petrolConsumption = petrolConsumption;
    }

    abstract public int getFare(int distance, int travelTime);

    public int compareTo(CarTaxi carTaxi) {

        int comparePetrolConsumption = (carTaxi.getPetrolConsumption());

        return this.petrolConsumption-comparePetrolConsumption;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarTaxi)) return false;

        CarTaxi carTaxi = (CarTaxi) o;

        if (Double.compare(carTaxi.volumeOfEngine, volumeOfEngine) != 0) return false;
        if (modelYear != carTaxi.modelYear) return false;
        if (licencePlate != carTaxi.licencePlate) return false;
        if (maxSpeed != carTaxi.maxSpeed) return false;
        if (price != carTaxi.price) return false;
        if (petrolConsumption != carTaxi.petrolConsumption) return false;
        return model != null ? model.equals(carTaxi.model) : carTaxi.model == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = model != null ? model.hashCode() : 0;
        temp = Double.doubleToLongBits(volumeOfEngine);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + modelYear;
        result = 31 * result + licencePlate;
        result = 31 * result + maxSpeed;
        result = 31 * result + price;
        result = 31 * result + petrolConsumption;
        return result;
    }

    @Override
    public String toString() {
        return "CarTaxi{" +
                "model='" + model + '\'' +
                ", volumeOfEngine=" + volumeOfEngine +
                ", petrolConsumption=" + petrolConsumption +
                '}';
    }
}
