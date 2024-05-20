package com.sparta.memo_spring.repository;

import com.sparta.memo_spring.entity.Memo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoRepository extends JpaRepository<Memo,Long> {  // memoRepository 이름으로 bean 등록

}
