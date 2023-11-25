package com.example.cleanarchitecture.service;

import com.example.cleanarchitecture.domain.BuyPeople;
import com.example.cleanarchitecture.domain.SellPeople;
import com.example.cleanarchitecture.persist.PeopleRepository;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceApp {
  private final PeopleRepository repository;
  public void init () {

    SellPeople sellPeople2 = new SellPeople(
        "950629-13",
        new ArrayList<>(List.of("iphone")),
        50000L
    );

    BuyPeople buyPeople2 = new BuyPeople(
        "950629-14",
        new ArrayList<>(),
        50000L
    );
    repository.save(sellPeople2);
    repository.save(buyPeople2);
  }
  public void deal (String sellId, String buyId, String sellItem, Long price) {
    SellPeople seller =  new SellPeople(repository.getByNo(sellId));
    BuyPeople buyer =  new BuyPeople(repository.getByNo(buyId));

    seller.sell(sellItem, price);
    buyer.buy(sellItem, price);
    repository.save(seller);
    repository.save(buyer);

    System.out.println("판매자 : " + repository.getByNo(sellId));
    System.out.println("구매자 : " +repository.getByNo(buyId));
  }

  public static void main(String[] args) {
    ServiceApp serviceApp = new ServiceApp(new PeopleRepository());
    serviceApp.init();
    serviceApp.deal("950629-13", "950629-14", "iphone" ,5000L);

  }
}
