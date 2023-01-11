package com.kakao.gusetbook.gusetbook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;


@Data
@Builder
@AllArgsConstructor
public class PageRequestDTO {

    private int page;
    private int size;

    public PageRequestDTO(){
        this.page =1;
        this.size=10;
    }
    //Repository에게 전달할  Pageable 객체 만들어주는 메서드
    public Pageable getPageable(Sort sort){
        return PageRequest.of(page -1,size, sort);
    }
}
