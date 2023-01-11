package com.kakao.gusetbook.gusetbook;

import com.kakao.gusetbook.gusetbook.domain.GuestBook;
import com.kakao.gusetbook.gusetbook.dto.GuestBookDTO;
import com.kakao.gusetbook.gusetbook.dto.PageRequestDTO;
import com.kakao.gusetbook.gusetbook.dto.PageResponseDTO;
import com.kakao.gusetbook.gusetbook.service.GuestBookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ServiceTest {
    @Autowired
    private GuestBookService guestBookService;

    @Test
    public void testRegister(){
        GuestBookDTO dto = GuestBookDTO.builder()
                .title("샘플 제목")
                .content("샘플 내용")
                .writer("나야나")
                .build();
        System.out.println(guestBookService.register(dto));
    }

    @Test
    public void testList(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(1)
                .size(10)
                .build();
        PageResponseDTO<GuestBookDTO, GuestBook> result = guestBookService.getList(pageRequestDTO);
        for(GuestBookDTO dto : result.getDtoList()){
            System.out.println(dto);
        }
    }
    @Test
    public void testListInformaiton(){
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .page(19)
                .size(10)
                .build();
        PageResponseDTO<GuestBookDTO, GuestBook> result = guestBookService.getList(pageRequestDTO);
        //데이터 확인
        //데이터 목록
        System.out.println(result.getDtoList());
        //페이지 목록
        System.out.println(result.getPageList());
        //전체 페이지 개수
        System.out.println(result.getTotalPage());
        //이전 여부
        System.out.println(result.isPrev());
        //다음 여부
        System.out.println(result.isNext());
    }
}
