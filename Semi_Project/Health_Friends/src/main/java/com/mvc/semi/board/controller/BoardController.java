package com.mvc.semi.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.semi.board.biz.BoardBiz;

@Controller
public class BoardController {

	@Autowired
	private BoardBiz biz;
	
	@RequestMapping("/list.do")
		public String selectList(Model model) {
		
		model.addAttribute("list", biz.accompany_selectList());
		model.addAttribute("list", biz.notice_selectList());
		model.addAttribute("list", biz.photo_selectList());
		
		return "myboardlist";		
	}
	
	@RequestMapping("/select.do")
		public String selectOne(Model model, int postId) {
		
		model.addAttribute("dto", biz.accompany_selectOne(postId));
		model.addAttribute("dto", biz.notice_selectOne(postId));
		model.addAttribute("dto", biz.photo_selectOne(postId));
		
		return "myboarddetail";
		
	}
		
}
