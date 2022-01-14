package com.eomcs.oop.ex05.x6;

public class CarTest3 {

  public static void main(String[] args) {

    Sedan sedan = new Sedan();
    SnowChain chained = new SnowChain(sedan);
    testCar(chained);

    System.out.println("---------------");

    Truck truck = new Truck();
    BlackBox boxed = new BlackBox(truck);
    testCar(boxed);

    System.out.println("---------------");

    Suv suv = new Suv();
    SnowChain ChainedSuv = new SnowChain(suv);
    BlackBox blackboxedSuv = new BlackBox(ChainedSuv);
    testCar(blackboxedSuv);

  }

  static void testCar(Car car) {

    car.start();
    car.run();
    car.stop();
  }

}
