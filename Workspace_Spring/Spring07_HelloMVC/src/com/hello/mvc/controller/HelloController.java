package com.hello.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hello.mvc.biz.HelloBiz;

@Controller
public class HelloController {

	// TODO : 05.Biz(@Service) 호출
	@Autowired
	private HelloBiz biz;
	
	// TODO : 04.HandlerMapping을 통해, hello.do로 넘어온 요청이 Controller의 해당 method를 찾아옴
	// @RequestMapping 메서드가 ModelAndView, Model, Map을 리턴하는 경우 이들에 담긴
	// 모델 데이터가 뷰에 전달된다.
	@RequestMapping("/hello.do")
	public String getHello(Model model) {
		
		// TODO : 09.return 받은 값을 model 객체에 담아서 전달(ModelAndView)
		model.addAttribute("message", biz.getHello());
		
		// TODO : 10.view
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/bye.do")
	// public ModelAndView getBye(@RequestParam("name") String nickname) {
	public ModelAndView getBye(String name) {	
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/WEB-INF/views/bye.jsp");
		mav.addObject("message", "bye, " + name);
		// mav.addObject("message", "bye, " + nickname);
		
		return mav;
	}

}

/*

 @RequestMapping
 - url을 class 또는 method와 mapping시켜주는 역할
 
 @RequestParam
 - key=value 형태로 넘어오는 파라미터를 mapping된 method의 파라미터로 지정
 
 @ModelAttribute
 - form tag를 통해 넘어온 model을 mapping된 method의 파라미터로 지정
 
 @SessionAttribute
 - session에서 model의 정보를 유지하고 싶을 경우 사용

 @RequestMapping은 DefaultAnnotationHandlerMapping에서 컨트롤러를 선택할 때 대표적으로 사용하는 애노테이션이다.
 url당 하나의 컨트롤러에 매핑되던 다른 핸들러 매핑과 달리 메서드 단위까지 세분화하여 적용할 수 있으며,
 url 뿐 아니라 파라미터, 헤더 등 더욱 넓은 범위를 적용할 수 있다.

 DefaultAnnotationHandlerMapping은 클래스와 메서드에 붙은 @RequestMapping 애노테이션 정보를 결합해 최종 매핑정보를 생성한다.
 기본적인 결합 방법은 클래스 레벨의 @RequestMapping을 기준으로 삼고, 메서드 레벨의 @RequestMapping으로 세분화하는 방식으로 사용된다.
 @RequestMapping에 사용할 수 있는 속성들은 아래와 같다.

*/ 
