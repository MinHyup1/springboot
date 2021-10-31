package com.kh.bookmanager.member;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.kh.bookmanager.common.code.jpa.JpaTemplate;

//Service 
//웹어플리케이션의 비지니스로직 작성
//사용자의 요청을 컨트롤러로 부터 위임받아 해당 요청을 처리하기 위한 핵심적인 작업을 진행
//요청을 처리하기 위해 데이터베이스에 저장된 데이터가 필요하면 Dao에게 요청
//비지니스 로직을 Service가 담당하기 때문에 Transaction 관리도 Service가 담당.
//commit,rollback을 Service 클래스에서 처리
public class MemberService {

	private MemberRepositroy memberRepository = new MemberRepositroy();
	
	public Member memberAuthenticate(String userId, String password) {
		
		EntityManager em = JpaTemplate.createEntityManager();
		//find() : 조회
		
		
		try {
			Member member = em.find(Member.class,userId);
			
			if(member == null) return null;
			if(member.getPassword().equals(password)) return member;
			return null;
			
		} finally {
			em.close();
		}
		
		
	}

	public Member findMemberById(String userId) {
		EntityManager em = JpaTemplate.createEntityManager();
		Member member = null;
		
		
		return null;
	}

	public List<Member> findAllMember() {
		EntityManager em = JpaTemplate.createEntityManager();
		List<Member> members = new ArrayList();
		try {
			members = memberRepository.findAllMember(em);
		} finally {
			em.close();
		}
		
		
		
		return members;
	}

	public int persistMember(Member member) {
		EntityManager em = JpaTemplate.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		int res = 0;
		
		tx.begin();
		try {
			em.persist(member);
			tx.commit();
			res = 1;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
		}
		
		
		return res;
	}

	public int modifyMember(Member member) {
		EntityManager em = JpaTemplate.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		int res = 0;
		
		try {
			Member memberEntity = em.find(Member.class, member.getUserId());
			memberEntity.setPassword(member.getPassword());
			tx.commit();
			res = 1;
		}catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}
		finally {
			em.close();
		}
		
		
		return res;
	}

	public int removeMember(String userId) {
		EntityManager em = JpaTemplate.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		int res = 0;
		
		try {
			Member member = em.find(Member.class, userId);
			em.remove(member);
			
			tx.commit();
			res = 1;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		}finally {
			em.close();
		}
		
		return res;
	}

	
	
	
	
	
	
	
	
	
	

}
