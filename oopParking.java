import java.io.*;
import java.util.*;

class Vehicle {
  private int lotNumber;
  private String spotType;
  private int id;

  void setLotNumber(int lotNumber) {
    this.lotNumber = lotNumber;
  }
  int getLotNumber() {
    return lotNumber;
  }
   void setSpotType(String string) {
    this.spotType = string;
  }
  String getSpotType() {
    return spotType;
  }
   void setId(int id) {
    this.id = id;
  }
  int getId() {
    return id;
  }

}

class ParkingLot {

  protected ArrayList<Vehicle> vehicle = new ArrayList<Vehicle>();
  private int availableSpots;

  void setAvailableSpots(int availableSpots) {
    this.availableSpots = availableSpots;
  }
  int getAvailableSpots() {
    return availableSpots;
  }
}

class Solution {
  static void createVehicle(ParkingLot p, int id, int lotNumber, String spotType){
    p.setAvailableSpots(100);
    Vehicle e = new Vehicle();
    e.setId(id);
    e.setLotNumber(lotNumber);
    e.setSpotType(spotType);
	  p.vehicle.add(e);
    p.setAvailableSpots(p.getAvailableSpots()-1);
  }

  public static void main(String[] args) {
    
    ParkingLot p = new ParkingLot();
    p.setAvailableSpots(100);

   createVehicle(p,22,33,"van");
      
    try{
    Vehicle v = p.vehicle.stream()
            .filter(i->i.getId()==22).findAny().orElse(null);
      System.out.println(v.getId());  
    }catch(Exception e) {
      System.out.println("Vehicle not found!");
      e.printStackTrace();
    }     


  }
}
