package com.siseven.adm.suagendabarber;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Testes {

	public static void main(String[] args) {
		LocalDate ld = LocalDate.now();
		LocalDateTime ldt = LocalDateTime.now();
		LocalTime lt = LocalTime.now();
		System.out.println(ld);
		System.out.println(ldt);
		System.out.println(lt);
	}

}
