package com.springbook.view.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DispatcherServlet")
public class DispatcherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HandlerMapping handlerMapping;
    private ViewResolver viewResolver;

    public void init() throws ServletException {
        handlerMapping = new HandlerMapping();
        viewResolver = new ViewResolver();
        viewResolver.setPrefix("./");
        viewResolver.setSuffix(".jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        process(request, response);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 1. 클라이언트의 요청 path 정보를 추출한다.
        String uri = request.getRequestURI();
        String path = uri.substring(uri.lastIndexOf("/"));

        // 2. HandlerMapping을 통해 path에 해당하는 Controller를 검색한다.
        Controller ctrl = handlerMapping.getController(path);

        // 3. 검색된 Controller를 실행한다.
        String viewName = ctrl.handleRequest(request, response);

        // 4. ViewResolver를 통해 viewName에 해당하는 화면을 검색한다.
        String view = null;
        if(!viewName.contains(".do")) {
            view = viewResolver.getView(viewName);
        } else {
            view = viewName;
        }

        // 5. 검색된 화면으로 이동한다.
        response.sendRedirect(view);

        if (path.equals("/login.do")) {
            System.out.println("로그인 처리");
        } else if(path.equals("/logout.do")) {
            System.out.println("로그아웃 처리");
        } else if(path.equals("/insertBoard.do")) {
            System.out.println("글 등록 처리");
        } else if(path.equals("/updateBoard.do")) {
            System.out.println("글 수정 처리");
        } else if(path.equals("/deleteBoard.do")) {
            System.out.println("글 삭제 처리");
        } else if(path.equals("/getBoard.do")) {
            System.out.println("글 상세 조회 처리");
        } else if(path.equals("/getBoardList.do")) {
            System.out.println("글 목록 검색 처리");
        }
    }
}
