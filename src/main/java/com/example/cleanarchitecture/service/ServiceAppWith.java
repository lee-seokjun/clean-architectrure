package com.example.cleanarchitecture.service;

import com.example.cleanarchitecture.domain.AbstractBuyPeopleImpl;
import com.example.cleanarchitecture.domain.DealServiceImpl;
import com.example.cleanarchitecture.domain.AbstractSellPeopleImpl;
import com.example.cleanarchitecture.persist.PeopleRepository;
import com.example.cleanarchitecture.responsibility.DealService;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceAppWith {
  private final PeopleRepository repository;
  private final DealService dealService = new DealServiceImpl();
  public void init () {

    AbstractSellPeopleImpl sellPeople2 = new AbstractSellPeopleImpl(
        "950629-13",
        new ArrayList<>(List.of("iphone")),
        50000L
    );

    AbstractBuyPeopleImpl buyPeople2 = new AbstractBuyPeopleImpl(
        "950629-14",
        new ArrayList<>(),
        50000L
    );
    repository.add(sellPeople2);
    repository.add(buyPeople2);
  }
  public void deal (String sellId, String buyId, String sellItem, Long price) {
    AbstractSellPeopleImpl seller =  new AbstractSellPeopleImpl(repository.getSeller(sellId));
    AbstractBuyPeopleImpl buyer =  new AbstractBuyPeopleImpl(repository.getBuyer(buyId));

    dealService.deal(buyer, seller, sellItem, price);
  }

  public static void main(String[] args) {
    ServiceAppWith serviceApp = new ServiceAppWith(new PeopleRepository());
    serviceApp.init();
    serviceApp.deal("950629-13", "950629-14", "iphone" ,5000L);

  }
}
