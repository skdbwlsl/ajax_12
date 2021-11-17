package com.care.root;

import java.nio.channels.MembershipKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController //페이지가 아니라 데이터를 돌려주는 방법(responsebody가 자동 포함돼 생략되있다)
public class TestController {
	static int cnt = 0;//db만들었다는 가정하에 임시로 만든 코드
	static Map<String, InfoDTO> DBMap = new HashMap<String, InfoDTO>();//db만들었다는 가정하에 임시로 만든 코드
	
	@PostMapping(value="membership", produces = "application/json;charset=utf-8")
	public String membership(@RequestBody Map<String, Object> member){
		System.out.println(member.get("uId"));
		System.out.println(member.get("uName"));
		System.out.println(member.get("uAge"));
		System.out.println(member.get("uAddr"));
		System.out.println(member.get("uAddr"));
		System.out.println(member.get("uPhone"));
		return "{\"test\":true}";
	}
	
	@PutMapping(value="modify", produces = "application/json;charset=utf-8")
	public InfoDTO modify(@RequestBody InfoDTO dto) {
		// update member set age=? where name=?;
		DBMap.replace(dto.getName(), dto);
		return DBMap.get(dto.getName());
	}
	@GetMapping(value="user", produces = "application/json;charset=utf-8")
	public InfoDTO user(@RequestParam String id) {
		//select * from member where id=id;
		return DBMap.get(id);//DBMap은 나중에 db로 만들거라 가상의 코드다 신경쓰지 말자
	}
	
	@GetMapping(value="user/{name}", produces = "application/json;charset=utf-8")
	public InfoDTO user1(@PathVariable String name) {   //{name}을 꺼내올 때 쓰는게  @PathVariable
		//select * from member where id=id;
		return DBMap.get(name);
	}
	
	
	@GetMapping(value="users", produces = "application/json;charset=utf-8")
	public ArrayList<InfoDTO> users(){
		ArrayList<InfoDTO> list = new ArrayList<InfoDTO>();
		for(int i=cnt ; i<cnt+10 ; i++) {
			InfoDTO info = new InfoDTO();
			info.setName("홍길동"+i); info.setAge(10+i);
			list.add(info); DBMap.put("홍길동"+i, info);
		}
		cnt += 10;
		return list;
	}
	
	
	@GetMapping(value = "rest", produces = "application/json;charset=utf-8")
	public String get() {
		return "{\"execute\": \"get 데이터 요청할 떄 사용\"}";
	}
	
	@PostMapping(value = "rest", produces = "application/json;charset=utf-8")
	public String post() {
		return "{\"execute\": \"post 데이터 추가할 떄 사용\"}";//키와 값
	}
	
	@PutMapping(value = "rest", produces = "application/json;charset=utf-8")
	public String put() {
		return "{\"execute\": \"put 데이터 수정할 떄 사용\"}";//수정은 업데이트
	}
	
	@DeleteMapping(value = "rest", produces = "application/json;charset=utf-8")
	public String delete() {
		return "{\"execute\": \"delete 데이터 삭제할 떄 사용\"}";
	}

}
