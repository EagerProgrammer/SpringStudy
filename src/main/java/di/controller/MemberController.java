package di.controller;

import di.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Controller는 다른 클래스에 주입되지 않기 때문에
//템플릿 메서드 패턴을 사용하지 않음(interface없이)
@Configuration
public class MemberController {
    //service 주입
    private MemberService memberService;
    @Bean
    public void findById(String id){
        System.out.println(memberService.findById(id));
    }
}
