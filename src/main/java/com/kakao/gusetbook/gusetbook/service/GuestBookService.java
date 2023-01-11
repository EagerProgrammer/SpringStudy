package com.kakao.gusetbook.gusetbook.service;

import com.kakao.gusetbook.gusetbook.domain.GuestBook;
import com.kakao.gusetbook.gusetbook.dto.GuestBookDTO;
import com.kakao.gusetbook.gusetbook.dto.PageRequestDTO;
import com.kakao.gusetbook.gusetbook.dto.PageResponseDTO;
import org.springframework.stereotype.Service;
//Service에서 제일 많이하는 것중 하나가 DTO 와 Entity 사이의 변환이다 그래서 인터페이스에 default method로 추가해주는것이 좋습니다.
@Service
public interface GuestBookService {
    //데이터 삽입을 위한 메서드
    //매개변수는 대부분의 경우 DTO
    //리턴 타입은 삽입된 데이터를 그대로 리턴하기도하고 성공과 실패여부를 위해서 boolean 을 러턴하기도하고 영향받은 행의 개수를 으미하는 int를 리턴하기도하고
    //기본키의 값을 리턴하는 경우도 있습니다.
    public  Long register(GuestBookDTO dto);

    //목록 보기를 위한 메서드
    PageResponseDTO<GuestBookDTO, GuestBook> getList(PageRequestDTO requestDTO);


    //DTO를 Entity로 변환해주는 메서드
    default GuestBook dtoToEntity(GuestBookDTO dto){
        GuestBook entity = GuestBook.builder()
                .gno(dto.getGno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter()).
                build();
        return entity;
    }
    //Entity를 DTO로 변환해주는 메서드
    default GuestBookDTO entityToDTO(GuestBook entity){
        GuestBookDTO dto = GuestBookDTO.builder()
                .gno(entity.getGno())
                .title(entity.getTitle())
                .writer(entity.getWriter())
                .content(entity.getContent())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
            return dto;
    }
}
