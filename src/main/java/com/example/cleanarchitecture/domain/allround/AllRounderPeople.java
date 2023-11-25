package com.example.cleanarchitecture.domain.allround;

import com.example.cleanarchitecture.responsibility.Buyer;
import com.example.cleanarchitecture.responsibility.Seller;
import java.util.List;

public class AllRounderPeople implements Seller, Buyer {
  private String no;
  private List<String> list ;
  private Long money;

  public AllRounderPeople(String no, List<String> list, Long money) {
    this.no = no;
    this.list = list;
    this.money = money;
  }

  @Override
  public void sell(String itemName, Long price) {
    if(price == null) {
      throw new RuntimeException("돈을 안줬네 이놈???");
    }

    int itemIdx = list.indexOf(itemName);

    if(itemIdx == -1) {
      throw new RuntimeException("아이템이 없습니다.");
    }

    long before = this.money;

    //행동
    removeItem(itemIdx);
    plusMoney(price);
    // 행동 이후 검증

    if(before + price != this.money) {
      throw new RuntimeException("뭔가 이상하다 그럴리가 없다..");
    }

    System.out.println("판매하고 돈을 벌었다! 현재 남은 나의 자산은?");
    System.out.println(list);
    System.out.println(money);
  }

    private void removeItem(int idx) {
      list.remove(idx);
    }
    private void plusMoney(Long price) {
    money += price;
  }

  @Override
  public void buy(String item, Long price) {
    if(price > this.money) {
      throw new RuntimeException("돈 없네 못사겠다..");
    }

    if(item.isEmpty()) {
      throw new RuntimeException("아이템을 안줬는데???");
    }

    long before = this.money;

    //행동
    addItem(item);
    minusMoney(price);

    // 행동 이후 검증

    if(before - price != this.money) {
      throw new RuntimeException("뭔가 이상하다 그럴리가 없다..");
    }

    System.out.println("물건을 구매하였다. 현재 남은 나의 자산은?");
    System.out.println(list);
    System.out.println(money);
  }
  private void minusMoney(Long price) {
    this.money -= price;
  }
  private void addItem(String item) {
    list.add(item);
  }
  public static AllRounderPeople sample() {
    return new AllRounderPeople(
        "950629-1",
        List.of("iphone"),
        50000L
    );
  }


}
