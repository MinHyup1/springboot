package com.kh.bookmanager.view.member;

import java.util.List;
import java.util.Scanner;

import com.kh.bookmanager.common.code.MemberGrade;
import com.kh.bookmanager.member.Member;
import com.kh.bookmanager.member.MemberController;

public class MemberMenu {

	MemberController memberController = new MemberController();

	public void memberMenu() {
		Scanner sc = new Scanner(System.in);
		String userId = "";
		String password = "";

		while (true) {
			System.out.println("\n***  회원 관리 프로그램 ***");
			System.out.println("1. 회원 전체 조회");
			System.out.println("2. 새 회원 등록");
			System.out.println("3. 회원 암호 수정");
			System.out.println("4. 회원 탈퇴");
			System.out.println("5. 아이디로 회원 검색");
			System.out.println("6. 종료");
			System.out.print("번호 입력 : ");

			switch (sc.nextInt()) {
			case 1:
				List<Member> memberList = memberController.searchAll();
				for (Member m : memberList) {
					System.out.println(m);
				}
				break;
			case 2:
				if (memberController.join(receiveNewMember()) != 0) {
					System.out.println("회원가입에 성공했습니다.");
				} else {
					System.out.println("회원가입 도중 에러가 발생하였습니다.");
				}
				break;
			case 3: // 사용자로부터 아이디와 암호를 입력받아 해당 회원의 암호를 수정
				System.out.print("비밀번호를 변경할 아이디 : ");

				sc.nextLine();
				userId = sc.nextLine();
				System.out.print("변경할 비밀번호 : ");
				password = sc.next();

				if (memberController.modifyPassword(userId, password) != 0) {
					System.out.println("비밀번호가 변경되었습니다.");
				} else {
					System.out.println("비밀번호 변경에 실패하였습니다.");
				}
				break;
			case 4: // 사용자로부터 아이디를 입력받아 해당 회원을 삭제
				System.out.print("삭제할 아이디를 입력하세요 : ");
				userId = sc.next();
				if (memberController.removeMember(userId) != 0) {
					System.out.println("삭제처리가 완료되었습니다.");
				} else {
					System.out.println("삭제처리에 실패하였습니다.");
				}
				break;

			case 5:
				// 클라이언트로 부터 아이디를 입력받는다.
				// 입력받은 아이디를 MemberController에게 전달
				// MemberController에서 반환한 Member DTO를 출력
				// 만약 반환된 Member가 null이라면 "존재하지 않는 회원입니다." 출력
				System.out.print("조회 할 회원의 아이디를 입력하세요 :");
				userId = sc.next();
				Member searchMember = memberController.searchById(userId);

				if (searchMember != null) {

					System.out.println(searchMember);

				} else {
					System.out.println("존재하지 않는 회원입니다.");
				}

				break;
			case 6:
				return;
			default:
				System.out.println("잘못된 번호를 입력했습니다.");
			}
		}
	}

	// 사용자로부터 회원가입정보를 입력받아서 dto에 저장하고 반환
	public Member receiveNewMember() {
		Scanner sc = new Scanner(System.in);
		Member member = new Member();

		System.out.println("회원 정보를 입력하세요---------------------");

		System.out.print("아이디 : ");
		member.setUserId(sc.next());

		System.out.print("암호 : ");
		member.setPassword(sc.next());

		System.out.print("휴대폰 번호 : ");
		member.setTell(sc.next());

		System.out.print("이메일 주소 : ");
		member.setEmail(sc.next());

		return member;
	}

}
