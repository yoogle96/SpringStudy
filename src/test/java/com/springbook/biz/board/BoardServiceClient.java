package com.springbook.biz.board;

//import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.board.impl.BoardDAOMybatis;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class BoardServiceClient {

    public static void main(String[] args){
        // EntityManager 생성
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");
        EntityManager em = emf.createEntityManager();

        // Transaction 생성
        EntityTransaction tx = em.getTransaction();
        try {
            // Transaction 시작
            tx.begin();

            Board board = new Board();
            board.setTitle("JAP 제목");
            board.setWriter("관리자");
            board.setContent("JPA 글 등록 잘 되네요");

            // 글 등록
            em.persist(board);

            // 글 목록 조회
            String jpql = "select b from Board b order by b.seq desc";
            List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();

            for(Board brd : boardList) {
                System.out.println("---> " + brd.toString());
            }
            // Transaction commit
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            // Transaction rollback
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
