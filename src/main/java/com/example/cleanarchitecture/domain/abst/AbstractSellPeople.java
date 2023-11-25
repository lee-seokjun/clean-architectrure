package com.example.cleanarchitecture.domain.abst;

import com.example.cleanarchitecture.domain.People;
import java.util.List;

public abstract class AbstractSellPeople extends People {

  public AbstractSellPeople(String no, List<String> list, Long money) {
    super(no, list, money);
  }
  public AbstractSellPeople(People people2) {
    super(people2.getNo(), people2.getList(), people2.getMoney());
  }
  protected abstract void sell(String item, Long price);
}
