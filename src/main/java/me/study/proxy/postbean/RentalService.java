package me.study.proxy.postbean;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RentalService {
  @Transactional
  public void saveBorrow(){
    System.out.println("save borrowed things");
  }
}
