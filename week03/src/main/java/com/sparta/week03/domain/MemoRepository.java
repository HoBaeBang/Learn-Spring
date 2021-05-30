package com.sparta.week03.domain;

import org.springframework.data.jpa.repository.JpaRepository;


import java.time.LocalDateTime;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime start, LocalDateTime end);
             //전부찾아라 ModifiedAt을 기준으로 ()사이에서 순서대로 정렬해서 modifiedAt을 토대로 내림차순으로
             //findAllByOrderByModifiedAtDesc
             //전부찾아라 순서대로 정렬해서 modifiedAt을 토대로 내림차순으로
}
