package user.entity;

import java.util.Date; // 현재 날짜를 얻기 위해 import
import java.text.SimpleDateFormat; // Date를 통해 받은 현재 날짜의 형식을 원하는 대로 정하기 위하여 import
import java.util.UUID; // userNumber에 UUID값을 주기 위하여 import

import user.dto.request.user.SignUpRequestDto;

public class User {
	private String userNumber;
	private String name;
	private String gender;
	private String date;
	private String address;
	private String phoneNumber;
	private boolean marketingCheck;
	private boolean collectPersonalInfoCheck;

	public User() {
	}

	public User(String userNumber, String name, String gender, String date, String address, String phoneNumber,
			boolean marketingCheck, boolean collectPersonalInfoCheck) {
		this.userNumber = userNumber;
		this.name = name;
		this.gender = gender;
		this.date = date;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.marketingCheck = marketingCheck;
		this.collectPersonalInfoCheck = collectPersonalInfoCheck;
	}

	public User(SignUpRequestDto dto) {
		Date now = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy. MM. dd");
		this.userNumber = UUID.randomUUID().toString();
		this.name = dto.getName();
		this.gender = dto.getGender();
		this.date = simpleDateFormat.format(now);
		this.address = dto.getAddress();
		this.phoneNumber = dto.getPhoneNumber();
	}

	public String getUserNumber() {
		return userNumber;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getDate() {
		return date;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public boolean isMarketingCheck() {
		return marketingCheck;
	}

	public boolean isCollectPersonalInfoCheck() {
		return collectPersonalInfoCheck;
	}

	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setMarketingCheck(boolean marketingCheck) {
		this.marketingCheck = marketingCheck;
	}

	public void setCollectPersonalInfoCheck(boolean collectPersonalInfoCheck) {
		this.collectPersonalInfoCheck = collectPersonalInfoCheck;
	}

	@Override
	public String toString() {
		return "User [userNumber=" + userNumber + ", name=" + name + ", gender=" + gender + ", date=" + date
				+ ", address=" + address + ", phoneNumber=" + phoneNumber + ", marketingCheck=" + marketingCheck
				+ ", collectPersonalInfoCheck=" + collectPersonalInfoCheck + "]";
	}

}
