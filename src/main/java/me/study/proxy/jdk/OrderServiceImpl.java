package me.study.proxy.jdk;

public class OrderServiceImpl implements OrderService{
  @Override
  public void pay() {
    System.out.println("get paid");
  }
  @Override
  public void refund() {
    System.out.println("get refund");
  }
}
