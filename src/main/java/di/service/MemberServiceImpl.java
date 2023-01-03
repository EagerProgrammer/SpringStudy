package di.service;

import di.dto.MemberDTO;
import di.entity.MemberEntity;
import di.persistence.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemberServiceImpl implements MemberService{
    //Service는 Repository를 주입받아서 사용
    private MemberRepository memberRepository;
    @Bean
    @Override
    public MemberDTO findById(String id) {
        //Repository에 필요한 매개변수 생성

        //Repository 메서드 호출
        MemberEntity memberEntity = memberRepository.findById(id);

        //Contoller에게 전달할 데이터를 생성
        MemberDTO memberDTO = MemberDTO.builder().id(memberEntity.getId()).password(memberEntity.getPassword()).nickname(memberEntity.getNickname()).build();
        return memberDTO;
    }
}
