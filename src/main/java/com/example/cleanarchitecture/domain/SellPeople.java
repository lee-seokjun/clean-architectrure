package com.example.cleanarchitecture.domain;

import com.example.cleanarchitecture.domain.responsibility.Seller;
import java.util.List;

public class SellPeople extends People implements Seller {

  public SellPeople(String no, List<String> list, Long money) {
    super(no, list, money);
  }
  public SellPeople(People people2) {
    super(people2.getNo(), people2.getList(), people2.getMoney());
  }
  @Override
  public void sell(String itemName, Long price) {
    if(price == null) {
      throw new RuntimeException("돈을 안줬네 이놈???");
    }

    int itemIdx = getList().indexOf(itemName);

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
