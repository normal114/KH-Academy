package com.mvc.upgrade.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.upgrade.model.biz.MYBoardBiz;
import com.mvc.upgrade.model.dto.Criteria;
import com.mvc.upgrade.model.dto.MYBoardDto;

@Controller
public class MYBoardController {

	@Autowired
	private MYBoardBiz biz;

	@RequestMapping("/list.do")
	public String selectList(Model model) {

		model.addAttribute("list", biz.selectList());

		return "myboardlist";
	}

	@RequestMapping("/detail.do")
	public String selectOne(Model model, int myno) {

		model.addAttribute("dto", biz.selectOne(myno));

		return "myboarddetail";
	}

	@RequestMapping("/writeform.do")
	public String insertForm() {
		return "myboardinsert";
	}

	@RequestMapping("/writeres.do")
	public String insertRes(MYBoardDto dto) {

		if (biz.insert(dto) > 0) {
			return "redirect:list.do";
		}

		return "redirect:writeform.do";
	}

	@RequestMapping("/updateform.do")
	public String updateForm(Model model, int myno) {

		model.addAttribute("dto", biz.selectOne(myno));

		return "myboardupdate";
	}

	@RequestMapping("/updateres.do")
	public String updateRes(MYBoardDto dto) {

		if (biz.update(dto) > 0) {
			return "redirect:detail.do?myno=" + dto.getMyno();
		}

		return "redirect:updateform.do?myno=" + dto.getMyno();
	}

	@RequestMapping("/delete.do")
	public String delete(int myno) {
		if (biz.delete(myno) > 0) {
			return "redirect:list.do";
		}

		return "redirect:detail.do?myno=" + myno;
	}

	@RequestMapping("/muldel.do")
	public String multiDelete(String[] mynoes) {
		if (biz.multiDelete(mynoes) > 0) {
			return "redirect:list.do";
		}
		
		return "redirect:list.do";
	}
	@RequestMapping("/answerform")
	public String answerForm(Model model, int myno) {

		model.addAttribute("dto", biz.selectOne(myno));

		return "anwerform";
	}

	@RequestMapping("/answerproc.do")
	public String answerProc(MYBoardDto dto) {
		if (biz.answerProc(dto) > 0) {
			return "redirect:list.do";	
		}
		return "redirect:answerform.do";
	}

	/*
	@RequestMapping("selectListPage")
	public String selectListPage(Model model, Criteria cri) throws Exception {

		model.addAttribute("list", biz.selectListPage(cri));

		return "selectListPage";
	}
	*/
}
