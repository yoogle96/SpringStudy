package com.springbook.view.user;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("로그아웃 처리");

        // 1. 브라우저와 연결된 세션 객체를 강제 종료한다.
        HttpSession session = request.getSession();
        session.invalidate();

        // 2. 세션 종료후, 메인 화면으로 이동한다.
        ModelAndView mav = new ModelAndView();
        mav.setViewName("redirect:login.jsp");
        return mav;
    }
}