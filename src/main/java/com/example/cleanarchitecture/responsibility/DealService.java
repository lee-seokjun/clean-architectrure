package com.example.cleanarchitecture.responsibility;

import com.example.cleanarchitecture.domain.BuyPeople2;
import com.example.cleanarchitecture.domain.SellPeople2;

public interface DealService {
  void deal(BuyPeople2 buyPeople, SellPeople2 sellPeople, String itemName, Long price);
}
