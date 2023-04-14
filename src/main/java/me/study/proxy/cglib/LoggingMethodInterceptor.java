package me.study.proxy.cglib;

import java.lang.reflect.Method;
import me.study.proxy.MyUtil;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class LoggingMethodInterceptor implements MethodInterceptor {
  private DeliveryService deliveryService;
  public LoggingMethodInterceptor(DeliveryService deliveryService){
    this.deliveryService = deliveryService;
  }
  @Override
  public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
      throws Throwable {
    System.out.println(proxy.getClass() +" - "+method);
    Object result = proxy.invoke(deliveryService, args);
    System.out.println(MyUtil.getTodayWithFormat(""));
    return result;
  }
}
