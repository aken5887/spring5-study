package me.study.proxy.cglib;

public class DeliveryService {
  public void getOrder(){
    System.out.println("get ordered");
  }

  public void getPaid(){
    System.out.println("get paid");
  }

  public void goDeliver(){
    System.out.println("go deliver");
  }
}
