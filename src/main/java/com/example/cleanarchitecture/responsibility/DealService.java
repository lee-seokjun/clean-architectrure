package com.example.cleanarchitecture.responsibility;

import com.example.cleanarchitecture.domain.AbstractBuyPeopleImpl;
import com.example.cleanarchitecture.domain.AbstractSellPeopleImpl;

public interface DealService {
  void deal(AbstractBuyPeopleImpl buyPeople, AbstractSellPeopleImpl sellPeople, String itemName, Long price);
}
