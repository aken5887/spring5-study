package me.study.proxy.jdk;

import java.lang.reflect.Proxy;

public class JdkProxyMain {

  public static void main(String[] args) {
    OrderService orderService
        = (OrderService) Proxy.newProxyInstance(JdkProxyMain.class.getClassLoader(),
        new Class[]{OrderService.class},
        new LoggingHandler(new OrderServiceImpl()));
    orderService.pay();
    orderService.refund();
  }
}
