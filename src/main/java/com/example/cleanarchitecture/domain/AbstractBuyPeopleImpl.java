package com.example.cleanarchitecture.domain;

import com.example.cleanarchitecture.domain.abst.AbstractBuyPeople;
import java.util.List;

public class AbstractBuyPeopleImpl extends AbstractBuyPeople {

  public AbstractBuyPeopleImpl(String no, List<String> list, Long money) {
    super(no, list, money);
  }

  public AbstractBuyPeopleImpl(People people2) {
    super(people2);
  }

  @Override
  protected void buy(String item, Long price) {
    if(price > this.getMoney()) {
      throw new RuntimeException("돈 없네 못사겠다..");
    }

    if(item.isEmpty()) {
      throw new RuntimeException("아이템을 안줬는데???");
    }

    long before = this.getMoney();

    //행동
    addItem(item);
    minusMoney(price);

    // 행동 이후 검증

    if(before - price != this.getMoney()) {
      throw new RuntimeException("뭔가 이상하다 그럴리가 없다..");
    }

    System.out.println("물건을 구매하였다. 현재 남은 나의 자산은?");
    System.out.println(getList());
    System.out.println(getMoney());
  }
}
