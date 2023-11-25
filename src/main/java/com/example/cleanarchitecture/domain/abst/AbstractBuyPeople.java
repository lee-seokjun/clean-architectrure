package com.example.cleanarchitecture.domain.abst;

import com.example.cleanarchitecture.domain.People;
import java.util.List;

public abstract class AbstractBuyPeople extends People {

  public AbstractBuyPeople(String no, List<String> list, Long money) {
    super(no, list, money);
  }
  public AbstractBuyPeople(People people2) {
    super(people2.getNo(), people2.getList(), people2.getMoney());
  }

  protected abstract void buy(String item, Long price);
}
