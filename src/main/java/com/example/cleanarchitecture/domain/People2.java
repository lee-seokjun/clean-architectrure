package com.example.cleanarchitecture.domain;

import java.util.List;
import lombok.Getter;

@Getter
public class People2  {
  private String no;
  private List<String> list ;
  private Long money;

  protected People2(String no, List<String> list, Long money) {
    this.no = no;
    this.list = list;
    this.money = money;
  }

  protected void removeItem(int idx) {
    list.remove(idx);
  }
  protected void plusMoney(Long price) {
  money += price;
}

  protected void minusMoney(Long price) {
    this.money -= price;
  }
  protected void addItem(String item) {
    list.add(item);
  }
  public static People2 sample() {
    return new People2(
        "950629-1",
        List.of("iphone"),
        50000L
    );
  }


}
