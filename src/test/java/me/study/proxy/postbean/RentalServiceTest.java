package me.study.proxy.postbean;

import static org.junit.jupiter.api.Assertions.*;

import me.config.Spring5Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

@DisplayName("@Transactional Test")
@Spring5Test
class RentalServiceTest {
  @Autowired
  RentalService rentalService;

  @Test
  void rentalService(){
    System.out.println(rentalService);
    rentalService.saveBorrow();
  }

}