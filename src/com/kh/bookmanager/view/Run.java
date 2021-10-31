package com.kh.bookmanager.view;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.kh.bookmanager.common.code.jpa.JpaTemplate;

public class Run {
		public static void main(String[] args) {
			JpaTemplate.init();
			new Index().startMenu();
			
		}
}
