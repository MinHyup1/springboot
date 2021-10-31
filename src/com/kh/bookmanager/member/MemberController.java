package com.kh.bookmanager.member;

import java.util.List;

//Controller
//사용자의 요청을 받아 해당 요청을 수행할 model(Service)의 메서드를 호출
//요청에 담겨온 데이터를 Application 내부에서 사용하기 적합하도록 변환
//	따라서 외부(클라이언트)의 변화로 요청의 양식이 변경되더라도 model의 코드가 변경될 일이 없다.
//model에서 처리한 결과를 사용자에게 어떤 형태와 양식으로 보여줄지 view를 선택
//적합하지 않은 요청에 대해 허가/불가 처리를 하는 외벽(권한관리)
public class MemberController {
	
	private MemberService memberService = new MemberService();
	
	public Member login(String userId, String password) {
		return memberService.memberAuthenticate(userId, password);
	}
	
	public Member searchById(String userId) {
		return memberService.findMemberById(userId);
	}
	
	public List<Member> searchAll(){
		return memberService.findAllMember();
	}

	public int join(Member member) {
		return memberService.persistMember(member);
	}

	public int modifyPassword(String userId, String password) {
		Member member = new Member();
		member.setUserId(userId);
		member.setPassword(password);
		return memberService.modifyMember(member);
	}

	public int removeMember(String userId) {
		return memberService.removeMember(userId);
	}
	
	
	
	
	
	
	
	
}
