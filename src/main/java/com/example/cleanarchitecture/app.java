package com.example.cleanarchitecture;

import com.example.cleanarchitecture.domain.BuyPeople;
import com.example.cleanarchitecture.domain.AbstractBuyPeopleImpl;
import com.example.cleanarchitecture.domain.DealServiceImpl;
import com.example.cleanarchitecture.domain.SellPeople;
import com.example.cleanarchitecture.domain.AbstractSellPeopleImpl;
import com.example.cleanarchitecture.domain.responsibility.Buyer;
import com.example.cleanarchitecture.domain.allround.AllRounderPeople;
import com.example.cleanarchitecture.domain.responsibility.DealService;
import com.example.cleanarchitecture.domain.responsibility.Seller;
import java.util.ArrayList;
import java.util.List;

public class app {

  public static void main(String[] args) {
    Seller seller = new AllRounderPeople(
        "950629-11",
        new ArrayList<>(List.of("iphone")),
        50000L
    );

    Buyer buyer = new AllRounderPeople(
        "950629-2",
        new ArrayList<>(),
        50000L
    );
    AllRounderPeople allRounder = new AllRounderPeople(
        "950629-13",
        new ArrayList<>(),
        50000L
    );

    try {
      System.out.println("type 1 start");
      seller.sell("iphone", 4000L);
      buyer.buy("iphone", 4000L);
      System.out.println("type 1 end");
    }catch (Exception e) {
      e.printStackTrace();
      System.out.println("거래 실패");
    }

    Seller sellPeople = new SellPeople(
        "950629-11",
        new ArrayList<>(List.of("iphone")),
        50000L
    );
    Buyer buyPeople = new BuyPeople(
        "950629-12",
        new ArrayList<>(List.of("iphone")),
        50000L
    );


    try {
      System.out.println("type 2 start");
      sellPeople.sell("iphone", 4000L);
      buyPeople.buy("iphone", 4000L);
      System.out.println("type 2 end");
    }catch (Exception e) {
      e.printStackTrace();
      System.out.println("거래 실패");
    }

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
    DealService dealService = new DealServiceImpl();
    try {
      System.out.println("type 3 start");
      dealService.deal(buyPeople2, sellPeople2, "iphone", 4000L);
      System.out.println("type 3 end");
    }catch (Exception e) {
      e.printStackTrace();
      System.out.println("거래 실패");
    }
  }
}
