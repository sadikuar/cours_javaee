package com.example.demo.services;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Service;

@Service("userservice")
public class UserService {

	public int calculateAge(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int userBirthYear = calendar.get(Calendar.YEAR);
		calendar.setTime(new Date(System.currentTimeMillis()));
		int currentYear = calendar.get(Calendar.YEAR);
		return currentYear - userBirthYear;
	}

}
