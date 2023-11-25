package com.example.cleanarchitecture.persist;

import com.example.cleanarchitecture.domain.BuyPeople2;
import com.example.cleanarchitecture.domain.People2;
import com.example.cleanarchitecture.domain.SellPeople2;
import com.example.cleanarchitecture.responsibility.Buyer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PeopleRepository {
  private List<People2> people2List = new ArrayList<>();

  public void add(People2 people2) {
    if(people2List.stream().anyMatch(l -> l.getNo().equals(people2.getNo()))) {
      throw new RuntimeException("이미 저장된거임");
    }
    people2List.add(people2);
  }
  public SellPeople2 getSeller(String no) {
    return people2List.stream()
        .filter(l -> l.getNo().equals(no))
        .map(SellPeople2::new)
        .findFirst().orElseThrow(() ->new RuntimeException("없음"));
  }
  public BuyPeople2 getBuyer(String no) {
    return people2List.stream()
        .filter(l -> l.getNo().equals(no))
        .map(BuyPeople2::new)
        .findFirst().orElseThrow(() ->new RuntimeException("없음"));
  }
}
