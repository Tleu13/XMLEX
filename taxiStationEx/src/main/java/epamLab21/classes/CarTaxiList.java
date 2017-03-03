package epamLab21.classes;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akmatleu on 02.03.17.
 */
public class CarTaxiList {

    private List<CarTaxi> carTaxiList = new ArrayList<>();

    public List<CarTaxi> getCarTaxiList() {
        return carTaxiList;
    }

    public void addList(List<CarTaxi> carTaxiList){
        this.carTaxiList = carTaxiList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarTaxiList that = (CarTaxiList) o;

        return carTaxiList != null ? carTaxiList.equals(that.carTaxiList) : that.carTaxiList == null;
    }

    @Override
    public int hashCode() {
        return carTaxiList != null ? carTaxiList.hashCode() : 0;
    }
}
