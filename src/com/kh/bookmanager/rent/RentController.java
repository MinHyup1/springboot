package com.kh.bookmanager.rent;

import java.util.List;

public class RentController {
	
	private RentService rentService = new RentService();
	
	public boolean registRent(String userId, List<String> bkIdxs) {
		return rentService.insertRentInfo(userId, bkIdxs);
	}

	public void returnBook(String rbIdx) {
		rentService.returnBook(rbIdx);
	}
	
	
	
	
	
	
	
	
	
	
	
}
