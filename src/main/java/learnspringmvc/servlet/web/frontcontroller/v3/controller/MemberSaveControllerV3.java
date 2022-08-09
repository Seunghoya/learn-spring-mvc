package learnspringmvc.servlet.web.frontcontroller.v3.controller;

import learnspringmvc.servlet.domain.member.Member;
import learnspringmvc.servlet.domain.member.MemberRepository;
import learnspringmvc.servlet.web.frontcontroller.ModelView;
import learnspringmvc.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

import static java.lang.Integer.parseInt;

public class MemberSaveControllerV3 implements ControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", member);
        return mv;
    }
}
