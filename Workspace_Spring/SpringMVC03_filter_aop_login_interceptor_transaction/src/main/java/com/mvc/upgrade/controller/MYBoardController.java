package com.mvc.upgrade.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mvc.upgrade.model.biz.MYBoardBiz;
import com.mvc.upgrade.model.dto.Criteria;
import com.mvc.upgrade.model.dto.MYBoardDto;
import com.mvc.upgrade.model.dto.PageMaker;


@Controller
public class MYBoardController {
	
	private Logger logger = LoggerFactory.getLogger(MYBoardController.class);

	@Autowired
	private MYBoardBiz biz;

	@RequestMapping("/list.do")
	public String selectList(Model model, Criteria cri) {
		logger.info("[Controller] : list.do");

		model.addAttribute("list", biz.selectList(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(biz.listCount());
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "myboardlist";
	}

	@RequestMapping("/detail.do")
	public String selectOne(Model model, int myno) {
		logger.info("[Controller] : detail.do");

		model.addAttribute("dto", biz.selectOne(myno));

		return "myboarddetail";
	}

	@RequestMapping("/writeform.do")
	public String insertForm() {
		logger.info("[Controller] : writeform.do");
		
		return "myboardinsert";
	}

	@RequestMapping("/writeres.do")
	public String insertRes(MYBoardDto dto) {
		logger.info("[Controller] : list.do");
		
		if (biz.insert(dto) > 0) {
			return "redirect:list.do";
		}

		return "redirect:writeform.do";
	}

	@RequestMapping("/updateform.do")
	public String updateForm(Model model, int myno) {
		logger.info("[Controller] : updateform.do");

		model.addAttribute("dto", biz.selectOne(myno));

		return "myboardupdate";
	}

	@RequestMapping("/updateres.do")
	public String updateRes(MYBoardDto dto) {
		logger.info("[Controller] : updateres.do");

		if (biz.update(dto) > 0) {
			return "redirect:detail.do?myno=" + dto.getMyno();
		}

		return "redirect:updateform.do?myno=" + dto.getMyno();
	}

	@RequestMapping("/delete.do")
	public String delete(int myno) {
		logger.info("[Controller] : delete.do");
		
		if (biz.delete(myno) > 0) {
			return "redirect:list.do";
		}

		return "redirect:detail.do?myno=" + myno;
	}
	
	@RequestMapping("/answerform.do")
	public String answerFrom(Model model, int myno) {
		logger.info("[Controller] : answerform.do");

			model.addAttribute("dto", biz.selectOne(myno));

			return "myboarddetail";
		}
	
	@RequestMapping("/answerproc.do")
	public String answerProc(MYBoardDto dto) {
		logger.info("[Controller] : answerproc.do");
		
		if (biz.answerProc(dto) > 0) {
			return "redirect:list.do";
		}

		return "redirect:writeform.do";
	}
	
	@RequestMapping("/test.do")
	public String test() {
		logger.info("[Controller] : test.do");
		
		biz.test();
		
		return "redirect:list.do";
	}
}
