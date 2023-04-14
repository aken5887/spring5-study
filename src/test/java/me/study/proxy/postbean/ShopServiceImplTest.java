package me.study.proxy.postbean;

import java.lang.reflect.Proxy;
import me.config.Spring5Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Spring5Test
class ShopServiceImplTest {

  @Autowired
  ShopService shopService;

  @Test
  void advisorAutoProxyCreator(){
    shopService.saveShoppingList();
    Assertions.assertThat(Proxy.isProxyClass(shopService.getClass())).isTrue();
  }

  @Test
  void update_shopping_list(){
    shopService.updateShoppingList();
  }
}