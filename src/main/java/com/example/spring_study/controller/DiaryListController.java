package com.example.spring_study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
public class DiaryListController {
    private static final String user="jongmin";

//    private DiaryListRepository diaryListRepository;

//    @Autowired
//    public DiaryListController(DiaryListRepository diaryListRepository) {
//        this.diaryListRepository = diaryListRepository;
//    }

//    @RequestMapping(method= RequestMethod.GET)
//    public String usersDiarys(Model model) {
////        List<Diary> diaryList = diaryListRepository.findByUser(user);
////        if (diaryList != null) {
////            model.addAttribute("diarys", diaryList);
////        }
//        return "diaryList";
//    }
    @RequestMapping(method= RequestMethod.GET)
    public String test(Model model) {
        System.out.println("테스트 입니다.");
        return "diaryList";
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public String addToReadingList(Diary diary) {
//        diary.setUser(user);
//        diaryListRepository.save(diary);
//        return "redirect:/";
//    }
}
