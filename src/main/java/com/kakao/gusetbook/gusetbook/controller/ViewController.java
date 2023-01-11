package com.kakao.gusetbook.gusetbook.controller;

import com.kakao.gusetbook.gusetbook.dto.GuestBookDTO;
import com.kakao.gusetbook.gusetbook.dto.PageRequestDTO;
import com.kakao.gusetbook.gusetbook.service.GuestBookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Log4j2
@Controller
@RequiredArgsConstructor
public class ViewController {
    private final GuestBookService guestBookService;
    @GetMapping({"/"})
    public String list(){
        log.info("메인화면...");
        return "redirect:/guestbook/list";
    }
    @GetMapping("/guestbook/list")
    public void list(PageRequestDTO pageRequestDTO, Model model){
        model.addAttribute("result", guestBookService.getList(pageRequestDTO));
    }

    @GetMapping("/guestbook/register")public void register(){
        log.info("데이터 삽입 요청");
    }



    @PostMapping("/guestbook/register")public String register(
        GuestBookDTO dto, RedirectAttributes rattr
        //RedirectAttributes는 세선에 저장하는데 한번 사용하고 자동 소멸
    ){
       log.info(dto);//파라미터 확인
       Long gno = guestBookService.register(dto);
       //데이터 전송
        rattr.addFlashAttribute("msg", gno+"등록");
        //데이터베이스에 변경작업을 수행하고 나면 반드시 redircet
        return "redirect:/guestbook/list";
    }
}
