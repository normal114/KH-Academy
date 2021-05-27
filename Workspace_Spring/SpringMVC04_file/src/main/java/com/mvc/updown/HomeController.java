package com.mvc.updown;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.WebUtils;

import com.mvc.updown.validate.FileValidator;
import com.mvc.updown.validate.UploadFile;

@Controller
public class HomeController {
	
	@Autowired
	private FileValidator fileValidator;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/form")
	public String uploadForm() {
		return "upload";
	}
	
	@RequestMapping("/upload")
	public String fileUpload(HttpServletRequest request, Model model, UploadFile uploadFile, BindingResult result) {
		// bindingResult : 결과를 묶어 놓을 거야. 에러가 나면 다음으로 못갈 때까지 붙잡고 있을 것이다. 결과가 나올 때까지 다음으로 못 넘어간다.
	
		fileValidator.validate(uploadFile, result);
		if (result.hasErrors()) { // 에러를 가지고 있으면
			return "upload";
		}
	
		MultipartFile file = uploadFile.getMpfile();
		String name = file.getOriginalFilename();
		
		UploadFile fileObj = new UploadFile();
		fileObj.setName(name);
		fileObj.setDesc(uploadFile.getDesc());
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		
		try {
			inputStream = file.getInputStream(); // 파일을 불러온다.
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
			// Session에 담겨있는 객체들을 보다 짧은 코드로 넣다 뺏다 할 수 있고 
			// session객체나 cookie객체를 가져올 수 있다.
			System.out.println("업로드 실제 경로 : " + path);
			
			File storage = new File(path);
			if (!storage.exists()) { // 만약 경로(폴더)가 존재하지 않는다면
				storage.mkdir(); // 경로를 만든다.
			}
			
			File newFile = new File(path + "/" + name);
			System.out.println("인풋스트림 : " + newFile);
			if (!newFile.exists()) { // 파일이 존재하지 않는다면
				newFile.createNewFile(); // 파일을 생성한다.
			}
			
			outputStream = new FileOutputStream(newFile);
			System.out.println("아웃풋스트림 : " + newFile);
			
			int read = 0;
			byte[] b = new byte[(int)file.getSize()]; // 업로드한 파일의 크기를 구한다.
					
			while((read = inputStream.read(b)) != -1) { // 입력한다. 스트림 끝까지 도달(종료) = -1이다. 
				outputStream.write(b, 0, read); // 출력한다(보여준다, 저장한다.)
			}
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close(); // 반드시 close 해줘야 한다.
				outputStream.close(); // 반드시 clsoe 해줘야 한다.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		model.addAttribute("fileObj", fileObj);
		
		return "download";
	}
	
	@ResponseBody // return(java의 값)을 response 객체에다가 modelandview를 통하지 않고 바로 전달해주겠다. 
	@RequestMapping("/download")
	public byte[] fileDownload(HttpServletRequest request, HttpServletResponse response, String name) {
		
		byte[] down = null;
		
		try {
			String path = WebUtils.getRealPath(request.getSession().getServletContext(), "/resources/storage");
			
			File file = new File(path + "/" + name);
			System.out.println("파일 : " + file);
			
			down = FileCopyUtils.copyToByteArray(file); 
			
			String filename = new String(file.getName().getBytes(), "8859_1"); // 8859_1은 문자인코딩. 
			
			// Content-Disposition : attachment -> file download 설정 ( filename 설정 )
			response.setHeader("Content-Disposition", "attachment; filename=\""+filename+"\"");
			response.setContentLength(down.length);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return down;
		
	}
	
}
