package com.kh.bookmanager.member;

import java.util.List;

import javax.persistence.EntityManager;

//DAO(DATA ACCESS OBJECT) 
//DBMS에 접근해 데이터의 조회, 수정, 삽입, 삭제 요청을 보내는 클래스
//DAO의 메서드는 하나의 메서드에서 하나의 쿼리만 처리하도록 작성
public class MemberRepositroy {
	
	public List<Member> findAllMember(EntityManager em) {
		return em.createQuery("from member").getResultList();
		
	}
	
}
