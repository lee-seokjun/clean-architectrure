package com.example.cleanarchitecture.domain;

import com.example.cleanarchitecture.domain.abst.AbstractSellPeople;
import java.util.List;

public class AbstractSellPeopleImpl extends AbstractSellPeople {

  public AbstractSellPeopleImpl(String no, List<String> list, Long money) {
    super(no, list, money);
  }

  public AbstractSellPeopleImpl(People people2) {
    super(people2);
  }

  @Override
  protected void sell(String item, Long price) {
    if(price == null) {
      throw new RuntimeException("돈을 안줬네 이놈???");
    }

    int itemIdx = getList().indexOf(item);

    if(itemIdx == -1) {
      throw new RuntimeException("아이템이 없습니다.");
    }

    long before = this.getMoney();

    //행동
    removeItem(itemIdx);
    plusMoney(price);
    // 행동 이후 검증

    if(before + price != this.getMoney()) {
      throw new RuntimeException("돈 계산이 틀렸다.");
    }

    System.out.println("판매하고 돈을 벌었다! 현재 남은 나의 자산은?");
    System.out.println(getList());
    System.out.println(getMoney());
  }
}
