package epamLab21.services;

import epamLab21.classes.CarTaxi;
import epamLab21.classes.ComfortTaxi;
import epamLab21.classes.EconomTaxi;
import epamLab21.classes.VipTaxi;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by TleuAkma on 05.02.2017.
 */
public class TaxiStation {

    final String NOTFOUND = "Not Found!";
    final String SPEEDRANGEFIT = "This car is suitable for a range of speed:  ";
    final int ECONOMPRICE = 500_000;
    final int COMFORTPRICE = 5_000_000;
    // final int VIPPRICE =
    private  String name;
    private ArrayList<CarTaxi> carsInStation = new ArrayList<>();


    public TaxiStation(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void addTaxiToStation(String model, double volumeOfEngine, int modelYear, int licencePlate, int maxSpeed, int price, int petrolConsumption){

        if (price <=ECONOMPRICE){
            CarTaxi taxi = new EconomTaxi(model,volumeOfEngine,modelYear,licencePlate,maxSpeed,price,petrolConsumption);
            carsInStation.add(taxi);
        }else if((price > ECONOMPRICE) && (price<=COMFORTPRICE)){
            CarTaxi taxi = new ComfortTaxi(model,volumeOfEngine,modelYear,licencePlate,maxSpeed,price,petrolConsumption);
            carsInStation.add(taxi);
        }else {
            CarTaxi taxi = new VipTaxi(model,volumeOfEngine,modelYear,licencePlate,maxSpeed,price,petrolConsumption);
            carsInStation.add(taxi);
        }
    }

    public int getValueOfTaxiStation(){

        int result =0;

        for (CarTaxi car: carsInStation){
            result+=car.getPrice();
        }
        return result;
    }

    public  void showCarsByPetrolConsumption(){

        Collections.sort(carsInStation);

        for(CarTaxi car:carsInStation){
            System.out.println(car);
        }


    }
    public CarTaxi getTaxiByLicencePlate(int licencePlate){

        for(CarTaxi taxi:carsInStation){
          if  (taxi.getLicencePlate()==licencePlate){
              return taxi;
          }
        }
        return null;
    }

    // ASK   как вместо void, object. под него toString ?
    public void findCarBySpeedRange(int minSpeed, int maxSpeed){

        for(CarTaxi car:carsInStation){

            if (car.getMaxSpeed()<=maxSpeed && car.getMaxSpeed()>= minSpeed) {
                System.out.println(SPEEDRANGEFIT+car);
                return;
            }
        }

        System.out.println(NOTFOUND);
    }




}
