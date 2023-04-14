package me.study.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

public class CglibMain {
  public static void main(String[] args) {
    DeliveryService deliveryService
        = (DeliveryService) Enhancer.create(DeliveryService.class,
            new LoggingMethodInterceptor(new DeliveryService()));
    deliveryService.getOrder();
    deliveryService.getPaid();
    deliveryService.goDeliver();
  }
}
