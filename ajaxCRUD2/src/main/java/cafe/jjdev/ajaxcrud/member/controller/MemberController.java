package cafe.jjdev.ajaxcrud.member.controller;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import cafe.jjdev.ajaxcrud.member.vo.Member;
import cafe.jjdev.ajaxcrud.service.MemberService;

@RestController
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/getMembers")
	public Map<String, Object> getMembers(@RequestParam(value="currentPage", required = false, defaultValue = "1")int currentPage){
		System.out.println("/getMembers 요청");		
		
		Map<String, Object> map = memberService.getMembers(currentPage);
		System.out.println(currentPage);
		return map;
	}
	@PostMapping("/addMember")
	public void addMember(Member member) {
		System.out.println("/addMember 요청");
		System.out.println("MemberController addMember member"+member);
		memberService.addMember(member);
	}
	
	@PostMapping("/removeMember")
	public void removeMember(@RequestParam(value="ck[]")String[] ck) { // List<String> ck				
		System.out.println("/removeMember 요청");
		System.out.println("MemberController removeMember ck");
		memberService.removeMember(ck);
	}
	
	@PostMapping("/modifyMember")
	public void modifyMember(Member member) {
		System.out.println("/modifyMember 요청");
		System.out.println("MemberController modifyMember member"+member);
		memberService.modifyMember(member);
	}
}
