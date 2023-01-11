package com.kakao.gusetbook.gusetbook;

import com.kakao.gusetbook.gusetbook.domain.GuestBook;
import com.kakao.gusetbook.gusetbook.domain.QGuestBook;
import com.kakao.gusetbook.gusetbook.persistence.GuestBookRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.stream.IntStream;

@SpringBootTest
public class RepositotyTest {
    @Autowired
    private GuestBookRepository guestBookRepository;

    @Test
    public void insertDummies(){
        IntStream.rangeClosed(1,300).forEach(i ->{
            GuestBook guestBook = GuestBook.builder()
                    .title("제목..."+i)
                    .content("내용..."+i)
                    .writer("user"+ i)
                    .build();
            System.out.println(guestBookRepository.save(guestBook));
        });
    }
    @Test
    public void updateDummies(){
        GuestBook guestBook = GuestBook.builder()
                .gno(1001L)
                .content("내용변경")
                .title("제목 변경")
                .writer("군계")
                .build();
        guestBookRepository.save(guestBook);
    }

    @Test
    //title에 1이라는 글자가 포함된 entity 조회
    public void testQuery1(){
        //10개씩 첫번째 페이지의 데이터를 조회
        //modDate의 내림차순 정렬
        Pageable pageable = PageRequest.of(0,10, Sort.by("regDate").descending());

        //querydsl 수행
        QGuestBook qGuestBook = QGuestBook.guestBook;
        //title에 1이 포함된 조건 생성
        String keyword = "1";
        BooleanBuilder builder = new BooleanBuilder();
        BooleanExpression expression = qGuestBook.title.contains(keyword);
        builder.and(expression);

        Page<GuestBook> result = guestBookRepository.findAll(builder, pageable);
        for(GuestBook guestBook : result.getContent()){
            System.out.println(guestBook);
        }
    }
    //Title or content에 1이 포함된 데이터를 조회
    @Test
    public void testQeury2(){
        Pageable pageable = PageRequest.of(0,10, Sort.by("regDate").descending());
        //querydsl 수행을 위해서 Q 클래스 가져오기
        QGuestBook qGuestBook = QGuestBook.guestBook;

        String keyword = "1";
        BooleanBuilder builder = new BooleanBuilder();

        //title에 포함된 조건
        BooleanExpression expression = qGuestBook.title.contains(keyword);
        //content에 포함된 조건
        BooleanExpression expression1 = qGuestBook.content.contains(keyword);
        //2개의 조건을 or로 결합
        BooleanExpression exAll = expression.or(expression1);
        builder.and(exAll);
        builder.and(qGuestBook.gno.lt(1100L));

        Page<GuestBook> result = guestBookRepository.findAll(builder, pageable);
        for(GuestBook guestBook : result.getContent()){
            System.out.println(guestBook);
        }

    }
}
