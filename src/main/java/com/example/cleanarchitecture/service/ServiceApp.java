package com.example.cleanarchitecture.service;

import com.example.cleanarchitecture.domain.BuyPeople2;
import com.example.cleanarchitecture.domain.DealServiceImpl;
import com.example.cleanarchitecture.domain.People2;
import com.example.cleanarchitecture.domain.SellPeople;
import com.example.cleanarchitecture.domain.SellPeople2;
import com.example.cleanarchitecture.persist.PeopleRepository;
import com.example.cleanarchitecture.responsibility.DealService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceApp {
  private final PeopleRepository repository;
  private final DealService dealService = new DealServiceImpl();
  public void init () {

    SellPeople2 sellPeople2 = new SellPeople2(
        "950629-13",
        new ArrayList<>(List.of("iphone")),
        50000L
    );

    BuyPeople2 buyPeople2 = new BuyPeople2(
        "950629-14",
        new ArrayList<>(),
        50000L
    );
    repository.add(sellPeople2);
    repository.add(buyPeople2);
  }
  public void sellTo (String sellId, String buyId, String sellItem, Long price) {
    SellPeople2 seller =  repository.getSeller(sellId);
    BuyPeople2 buyer =  repository.getBuyer(buyId);

    dealService.deal(buyer, seller, sellItem, price);
  }

  public static void main(String[] args) {
    ServiceApp serviceApp = new ServiceApp(new PeopleRepository());
    serviceApp.init();
    serviceApp.sellTo("950629-13", "950629-14", "iphone" ,5000L);

  }
}
