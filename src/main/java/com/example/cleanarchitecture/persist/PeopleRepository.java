package com.example.cleanarchitecture.persist;

import com.example.cleanarchitecture.domain.AbstractBuyPeopleImpl;
import com.example.cleanarchitecture.domain.People;
import com.example.cleanarchitecture.domain.AbstractSellPeopleImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PeopleRepository {
  private List<People> people2List = new ArrayList<>();

  public void add(People people2) {
    if(people2List.stream().anyMatch(l -> l.getNo().equals(people2.getNo()))) {
      throw new RuntimeException("이미 저장된거임");
    }
    people2List.add(people2);
  }
  public People getSeller(String no) {
    return people2List.stream()
        .filter(l -> l.getNo().equals(no))
        .findFirst().orElseThrow(() ->new RuntimeException("없음"));
  }
  public People getBuyer(String no) {
    return people2List.stream()
        .filter(l -> l.getNo().equals(no))
        .findFirst().orElseThrow(() ->new RuntimeException("없음"));
  }
}
