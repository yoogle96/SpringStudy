package com.springbook.biz.board;

import com.springbook.biz.board.impl.BoardDAO;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;

public class BoardServiceClient {

    public static void main(String[] args){
        BoardDAO boardDao = new BoardDAO();

        BoardVO vo = new BoardVO();
        vo.setTitle("myBatis 제목");
        vo.setWriter("홍길동");
        vo.setContent("myBatis 내용입니다....");
        boardDao.insertBoard(vo);

        vo.setSearchCondition("TITLE");
        vo.setSearchKeyword("");
        List<BoardVO> boardList = boardDao.getBoardList(vo);
        for (BoardVO board : boardList) {
            System.out.println("-----> " + board.toString());
        }

//
//        AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext2.xml");
//
//        BoardService boardService = (BoardService)container.getBean("boardService");
//
//        BoardVO vo = new BoardVO();
//        vo.setSeq(100);
//        vo.setTitle("임시 제목");
//        vo.setWriter("홍길동");
//        vo.setContent("임시 내용...........");
////        boardService.insertBoard(vo);
//
//        List<BoardVO> boardVOList = boardService.getBoardList(vo);
//        for(BoardVO board : boardVOList){
////            boardService.deleteBoard(board);
//            System.out.println("--->" + board.toString());
//        }
//
//        container.close();
    }
}
