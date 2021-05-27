package com.bike.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bike.dao.BikeDao;
import com.bike.dto.BikeDto;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@WebServlet("/BikeController")
public class BikeController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getParameter("command");
		System.out.println("["+command+"]");
		
		if (command.equals("view")) {
			response.sendRedirect("view.html");
		} else if (command.equals("getdata")) {
			BikeDao dao = new BikeDao();
			
			if (dao.delete()) {
				System.out.println("db 초기화 성공");
			} else {
				System.out.println("db 초기화 실패");
			}
			
			String data = request.getParameter("mydata");
			System.out.println(data); // { "" : [ ] , "" : [ ] } 이런 형태로 출력된다.
			
			// JsonElement : JsonObject, JsonArray, JsonPrimitive, JsonNull 값들을 모두 포함! JsonObject인지 JsonArray인지 JsonPrimitive인지 JsonNull인지 모르기 때문에 JsonElement로 만들었다.
			JsonElement element = JsonParser.parseString(data);
			// JsonObject : key-value pair ({"String" : JsonElement} 형식)
			JsonObject jsonData = element.getAsJsonObject();
			
			// JsonObject jsonData = JsonParser.parseString(data).getAsJsonObject(); 
			
			JsonElement records = jsonData.get("records");
			JsonArray recordsArray = records.getAsJsonArray();
			
			List<BikeDto> list = new ArrayList<BikeDto>();
			JsonArray resultArray = new JsonArray(); // 3. 배열로 집어넣었다. {k:v}가 배열[ ]에 담겼다.
			
			for (int i = 0; i < recordsArray.size(); i++) { // Json 배열을 Java 형태로 바꾸는 것이다.
				/*
				 JsonElement tempElement = recordsArray.get(i);
				 JsontempObject tempObject = tempElement.getAsJsonObject();
				 JsonElement nameElement = tempObject.get("자전거대여소명");
				 String name = nameElement.getAsString(); // 0,1.... 배열의 value값이 문자열이기 때문에 getAsString을 사용한 것이다.  
				 */
				String name = recordsArray.get(i).getAsJsonObject().get("자전거대여소명").getAsString();
				String addr = null;
				if (recordsArray.get(i).getAsJsonObject().get("소재지도로명주소") != null) {
					addr = recordsArray.get(i).getAsJsonObject().get("소재지도로명주소").getAsString();	
				} else {
					addr = recordsArray.get(i).getAsJsonObject().get("소재지지번주소").getAsString();
				}
				
				double latitude = recordsArray.get(i).getAsJsonObject().get("위도").getAsDouble();
				double longitude = recordsArray.get(i).getAsJsonObject().get("경도").getAsDouble();
				
				int bike_count = recordsArray.get(i).getAsJsonObject().get("자전거보유대수").getAsInt();
				
				BikeDto dto = new BikeDto(name, addr, latitude, longitude, bike_count);
				list.add(dto);
				
				Gson gson = new Gson(); // json Object를 Gson Object로 변경
				String jsonString = gson.toJson(dto); // 1. gson이 dto(Java Object)를 json{k:v} 문자열로 바꾼 다음에  
				resultArray.add(JsonParser.parseString(jsonString)); // 2. json 형태의 문자열을 json 객체로 바꾼다음에 
			}
			
			if (dao.insert(list)) {
				System.out.println("db 저장 성공");
			} else {
				System.out.println("db 저장 실패");
			}
			
			JsonObject result = new JsonObject();
			result.add("result", resultArray); // 4. 하지만 위에서 만든 json배열은 value 형태이기 때문에 여기서 key="result", value"resultArray"와 같이 json형태가 아니라서 result
			
			response.getWriter().append(result+"");
		}
	}
}
