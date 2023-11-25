package com.example.cleanarchitecture.domain;


import com.example.cleanarchitecture.responsibility.DealService;

public class DealServiceImpl implements DealService {
  public void deal(AbstractBuyPeopleImpl buyPeople, AbstractSellPeopleImpl sellPeople, String itemName, Long price){
    if(buyPeople.getNo().equals(sellPeople.getNo())) {
      throw new RuntimeException("어째 사는놈이랑 파는놈의 식별자가 같은거지?");
    }
    buyPeople.buy(itemName, price);
    sellPeople.sell(itemName, price);
  }
}

