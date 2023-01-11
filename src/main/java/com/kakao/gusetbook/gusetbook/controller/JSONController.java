package com.kakao.gusetbook.gusetbook.controller;

import com.kakao.gusetbook.gusetbook.domain.GuestBook;
import com.kakao.gusetbook.gusetbook.dto.GuestBookDTO;
import com.kakao.gusetbook.gusetbook.dto.PageRequestDTO;
import com.kakao.gusetbook.gusetbook.dto.PageResponseDTO;
import com.kakao.gusetbook.gusetbook.service.GuestBookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequiredArgsConstructor
public class JSONController {
    private final GuestBookService guestBookService;

    @GetMapping("/guestbook/list.json")
    public PageResponseDTO<GuestBookDTO, GuestBook> list(PageRequestDTO pageRequestDTO){
        return guestBookService.getList(pageRequestDTO);
    }
}
