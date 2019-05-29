package cafe.jjdev.ajaxcrud.service;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import cafe.jjdev.ajaxcrud.member.mapper.MemberMapper;
import cafe.jjdev.ajaxcrud.member.vo.Member;

@Service
@Transactional
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	
	public int addMember(Member member) {
		
		return memberMapper.insertMember(member);
	}
	
	public int modifyMember(Member member) {
		return memberMapper.updateMember(member);
	}
	
	public void removeMember(@RequestParam(value="ck[]")String[] ck) {			
		System.out.println(ck);		
		for(String id : ck) {		
			Member member = new Member();
			member.setId(id);
		memberMapper.deleteMember(member);
		}
	}
	
	public Map<String, Object> getMembers(int currentPage){
		
		final int ROW_PER_PAGE = 10;
		int startRow = (currentPage-1)*ROW_PER_PAGE;
		Map<String,Integer> map = new HashMap<String,Integer>();
		
		map.put("startRow", startRow);
		map.put("rowPerPage", ROW_PER_PAGE);
		
		List<Member> list = memberMapper.selectMemberList(map);
		int selectCount = memberMapper.selectMemberCount();
		int lastPage = selectCount/ROW_PER_PAGE;
		if(selectCount%ROW_PER_PAGE != 0) {
			lastPage++;
		}	
		Map<String, Object> returnMap = new HashMap<String, Object>();
		returnMap.put("list", list);
		returnMap.put("selectCount", selectCount);
		returnMap.put("lastPage", lastPage);
		returnMap.put("currentPage", currentPage);
		
		return returnMap;
	}
}	
	
