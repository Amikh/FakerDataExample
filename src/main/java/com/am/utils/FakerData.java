package com.am.utils;

import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;

public class FakerData {

	/**
	 * 
	 * Use only english language
	 * 
	 */

	private Faker faker = new Faker(new Locale("en"));

	/**
	 * 
	 * Get fake first name
	 * return
	 * 
	 */

	String isFirstName() {
		return faker.name().firstName();

	}

	/**
	 * 
	 * Get fake last name
	 * return
	 * 
	 */
	String isSecondName() {
		return faker.name().lastName();

	}

	/**
	 * 
	 * Get fake city
	 * return
	 * 
	 */

	String isCity() {
		return faker.address().city();
	}
	/**
	 * 
	 * Get fake country
	 * return
	 * 
	 */

	String isCountry() {
		return faker.address().country();
	}

	/**
	 * 
	 * Generate random number for ID
	 * use Class Math and Random from Java Util
	 * return
	 * 
	 */

	int generateUserId() {
		int m = (int) Math.pow(10, 9 - 1);
		return m + new Random().nextInt(9 * m);

	}

}