package com.example.cleanarchitecture.persist;

import com.example.cleanarchitecture.domain.People;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PeopleRepository {
  private List<People> people2List = new ArrayList<>();

  public void save(People people2) {
    if(people2List.stream().anyMatch(l -> l.getNo().equals(people2.getNo()))) {
      people2List.removeIf(l -> l.getNo().equals(people2.getNo()));
    }
    people2List.add(people2);
  }
  public People getByNo(String no) {
    return people2List.stream()
        .filter(l -> l.getNo().equals(no))
        .findFirst().orElseThrow(() ->new RuntimeException("없음"));
  }
}
