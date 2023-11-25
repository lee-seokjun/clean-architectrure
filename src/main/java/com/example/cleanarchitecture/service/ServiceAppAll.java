package com.example.cleanarchitecture.service;

import com.example.cleanarchitecture.domain.allround.AllRounderPeople;
import com.example.cleanarchitecture.domain.responsibility.Buyer;
import com.example.cleanarchitecture.domain.responsibility.Seller;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ServiceAppAll {
  private List<AllRounderPeople> peoples = new ArrayList<>();
  public void init () {

    AllRounderPeople seller = new AllRounderPeople(
        "950629-11",
        new ArrayList<>(List.of("iphone")),
        50000L
    );

    AllRounderPeople buyer = new AllRounderPeople(
        "950629-12",
        new ArrayList<>(),
        50000L
    );

    save(seller);
    save(buyer);
  }
  public AllRounderPeople getById(String id) {
    return peoples.stream().filter(v-> v.getNo().equals(id)).findFirst().orElseThrow(()-> new RuntimeException("없어"));
  }
  public void save(AllRounderPeople people2) {
    if(peoples.stream().anyMatch(l -> l.getNo().equals(people2.getNo()))) {
      peoples.removeIf(l -> l.getNo().equals(people2.getNo()));
    }
    peoples.add(people2);
  }
  public void deal (String sellId, String buyId, String sellItem, Long price) {
    try {
      AllRounderPeople seller = getById(sellId);
      AllRounderPeople buyer = getById(buyId);
      System.out.println("type 1 start");
      sell(seller, sellItem, price);
      buy(buyer, sellItem, price);

      save(seller);
      save(buyer);

      System.out.println("type 1 end");
      System.out.println("판매자 : " + getById(sellId));
      System.out.println("구매자 : " + getById(buyId));
    }catch (Exception e) {
      e.printStackTrace();
      System.out.println("거래 실패");
    }
  }
  public void sell(Seller seller, String sellItem, Long price) {
    seller.sell(sellItem, price);
  }
  public void buy(Buyer buyer, String sellItem, Long price) {
    buyer.buy(sellItem, price);
  }
  public static void main(String[] args) {
    ServiceAppAll serviceApp = new ServiceAppAll();
    serviceApp.init();
    serviceApp.deal("950629-11", "950629-12", "iphone" ,5000L);

  }
}
