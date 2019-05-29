package cafe.jjdev.ajaxcrud.member.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import cafe.jjdev.ajaxcrud.member.vo.Member;

@Mapper
public interface MemberMapper {
	//두개 이상을 받으려고 map을 쓴다
	public List<Member> selectMemberList(Map<String,Integer> map);
	public int selectMemberCount();
	public int insertMember(Member member);
	public int deleteMember(Member member);
	public int updateMember(Member member);
}
