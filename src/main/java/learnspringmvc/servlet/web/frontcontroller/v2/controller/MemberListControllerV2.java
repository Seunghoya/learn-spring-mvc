package learnspringmvc.servlet.web.frontcontroller.v2.controller;

import learnspringmvc.servlet.domain.member.Member;
import learnspringmvc.servlet.domain.member.MemberRepository;
import learnspringmvc.servlet.web.frontcontroller.MyView;
import learnspringmvc.servlet.web.frontcontroller.v2.ControllerV2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MemberListControllerV2 implements ControllerV2 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public MyView process(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        List<Member> members = memberRepository.findAll();
        req.setAttribute("members", members);

        return new MyView("/WEB-INF/views/members.jsp");
    }
}
