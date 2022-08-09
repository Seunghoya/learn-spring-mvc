package learnspringmvc.servlet.web.frontcontroller.v4.controller;

import learnspringmvc.servlet.domain.member.Member;
import learnspringmvc.servlet.domain.member.MemberRepository;
import learnspringmvc.servlet.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

import static java.lang.Integer.parseInt;

public class MemberSaveControllerV4 implements ControllerV4 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        String username = paramMap.get("username");
        int age = parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.put("member", member);
        return "save-result";
    }
}
