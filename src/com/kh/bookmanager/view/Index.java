package com.kh.bookmanager.view;

import java.util.Scanner;

import com.kh.bookmanager.member.Member;
import com.kh.bookmanager.member.MemberController;
import com.kh.bookmanager.view.book.BookMenu;
import com.kh.bookmanager.view.member.MemberMenu;
import com.kh.bookmanager.view.rent.RentMenu;

//MVC2 모델에서 VIEW는 사용자에게 데이터를 보여주는 형태와 양식을 의미
public class Index {
	
	MemberController memberController = new MemberController();
	MemberMenu memberMenu = new MemberMenu();
	BookMenu bookMenu = new BookMenu();
	RentMenu rentMenu = new RentMenu();
	
	public void startMenu() {
		Scanner sc = new Scanner(System.in);		
		System.out.println("로그인 하세요.");
		
		System.out.print("아이디 : ");
		String userId = sc.next();
		
		System.out.print("암호 : ");
		String password = sc.next();
		
		Member member = memberController.login(userId, password);
		
		if(member == null) {
			System.out.println("아이디나 암호를 확인하세요.");
			return;
		}
		
		System.out.println("\n " + member.getUserId() + "님 로그인 되었습니다. \n");
		
		while(true) {
			System.out.println("관리할 메뉴를 선택하세요.");
			System.out.println("1. 회원관리");
			System.out.println("2. 도서관리");
			System.out.println("3. 대출관리");
			System.out.println("4. 종료");
			System.out.print("입력 : ");
			
			switch(sc.nextInt()) {
			case 1 : memberMenu.memberMenu(); break;
			case 2 : bookMenu.bookMenu(); break;
			case 3 : rentMenu.rentMenu(); break;
			case 4 : System.out.println("프로그램을 종료합니다."); return;
			default :  System.out.println("잘못된 숫자를 입력하셨습니다.");
			}
		}
	}
}
