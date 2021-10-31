package com.kh.bookmanager.member;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

//DTO(DATA TRANSFER OBJECT)
//데이터 전송 객체
//데이터베이스로부터 얻어 온 데이터를 service(비지니스로직)으로 보낼 때 사용한 객체
//비지니스 로직을 포함하고 있지 않은, 순수하게 데이터 전송만을 위한 객체
//getter/setter, equals, hashCode, toString 메서드만을 갖는다.

// *** 참고 
//	도메인 객체 : 데이터베이스 테이블에서 조회 해온 한 행(row)의 값을 저장하는 용도로 사용하는 객체
//	DOMAIN OBJECT, VALUE OBJECT(VO), DTO, ENTITY, BEAN

//DTO의 조건 (JAVA BEAN 규약)
//1. 모든 필드변수는 PRIVATE일 것
//2. 반드시 기본 생성자가 존재할 것. (매개변수가 있는 생성자가 있더라도, 기본 생성자가 있어야함)
//3. 모든 필드변수는 GETTER/SETTER 메서드를 가져야 한다.

//오라클 - 자바 타입 매핑
//CHAR, VARCHAR2 -> String
//DATE -> java.util.Date, java.sql.Date
//number -> int, double

@DynamicInsert // 갚이 null이 아닌 속성만 쿼리에 반영
@DynamicUpdate // 변경이 감지된 속성만 쿼리에 반영
@Data
@Entity
public class Member {	
	
	@Id
	private String userId;
	private String password;
	private String email;
	private String grade;
	private String tell;
	@Column(columnDefinition = "date default sysdate")
	private Date rentableDate;
	@Column(columnDefinition = "date default sysdate")
	private Date regDate;
	@Column(columnDefinition = "number default 0")
	private Boolean isLeave;
	
	
	
}
