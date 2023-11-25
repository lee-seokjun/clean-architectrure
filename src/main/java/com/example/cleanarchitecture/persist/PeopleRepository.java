package com.example.cleanarchitecture.persist;

import com.example.cleanarchitecture.domain.People;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class PeopleRepository {
  private List<People> peopleList = new ArrayList<>();

  public void save(People people2) {
    if(peopleList.stream().anyMatch(l -> l.getNo().equals(people2.getNo()))) {
      peopleList.removeIf(l -> l.getNo().equals(people2.getNo()));
    }
    peopleList.add(people2);
  }
  public People getByNo(String no) {
    return peopleList.stream()
        .filter(l -> l.getNo().equals(no))
        .findFirst().orElseThrow(() ->new RuntimeException("없음"));
  }
}
