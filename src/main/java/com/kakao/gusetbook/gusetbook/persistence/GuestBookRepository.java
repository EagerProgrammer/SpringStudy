package com.kakao.gusetbook.gusetbook.persistence;

import com.kakao.gusetbook.gusetbook.domain.GuestBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface GuestBookRepository extends JpaRepository<GuestBook,Long>, QuerydslPredicateExecutor<GuestBook> {

}
