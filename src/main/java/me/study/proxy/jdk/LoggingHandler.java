package me.study.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import me.study.proxy.MyUtil;

public class LoggingHandler implements InvocationHandler {
  private OrderService orderService;

  public LoggingHandler(OrderService orderService){
    this.orderService = orderService;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    System.out.println(proxy.getClass() + " - " + method.getName());
    Object result = method.invoke(orderService, args);
    System.out.println(MyUtil.getTodayWithFormat(""));
    return result;
  }
}
