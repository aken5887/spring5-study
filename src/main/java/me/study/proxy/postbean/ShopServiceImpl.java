package me.study.proxy.postbean;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShopServiceImpl implements ShopService{

  public void saveShoppingList(){
    System.out.println("save shopping list");
  }

  public void updateShoppingList(){
    System.out.println("update shopping list");
  }
}
