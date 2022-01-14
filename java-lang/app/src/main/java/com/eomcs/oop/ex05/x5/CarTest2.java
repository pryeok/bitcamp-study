package com.eomcs.oop.ex05.x5;

public class CarTest2 {

  public static void main(String[] args) {

    Sedan sedan = new Sedan();
    Trailer trailer = new Trailer(sedan);

    trailer.start();
    trailer.run();
    trailer.stop();

    System.out.println("-------------------");

    Truck truck = new Truck();
    truck.start();
    truck.run();
    truck.stop();

  }
}
