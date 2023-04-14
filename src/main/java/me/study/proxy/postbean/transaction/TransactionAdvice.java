package me.study.proxy.postbean.transaction;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public class TransactionAdvice implements MethodInterceptor {

  PlatformTransactionManager platformTransactionManager;

  public void setPlatformTransactionManager(
      PlatformTransactionManager platformTransactionManager) {
    this.platformTransactionManager = platformTransactionManager;
  }

  @Override
  public Object invoke(MethodInvocation invocation) throws Throwable {
    TransactionStatus txStatus = platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    try{
      System.out.println("before platformTransactionManager commit");
      Object result = invocation.proceed();
      platformTransactionManager.commit(txStatus);
      System.out.println("after platformTransactionManager commit");
      return result;
    }catch(RuntimeException e){
      platformTransactionManager.rollback(txStatus);
      throw e;
    }
  }
}
