package user.dto.request.user;

public class SignUpRequestDto {
	private String name;
	private String gender;
	private String address;
	private String phoneNumber;
	private String marketingCheck;
	private String collectPersonalInfoCheck;

	public SignUpRequestDto() {
	}

	public SignUpRequestDto(String name, String gender, String address, String phoneNumber, String marketingCheck,
			String collectPersonalInfoCheck) {
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.marketingCheck = marketingCheck;
		this.collectPersonalInfoCheck = collectPersonalInfoCheck;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getMarketingCheck() {
		return marketingCheck;
	}

	public String getCollectPersonalInfoCheck() {
		return collectPersonalInfoCheck;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setMarketingCheck(String marketingCheck) {
		this.marketingCheck = marketingCheck;
	}

	public void setCollectPersonalInfoCheck(String collectPersonalInfoCheck) {
		this.collectPersonalInfoCheck = collectPersonalInfoCheck;
	}

	@Override
	public String toString() {
		return "SignUpRequestDto [name=" + name + ", gender=" + gender + ", address=" + address + ", phoneNumber="
				+ phoneNumber + ", marketingCheck=" + marketingCheck + ", collectPersonalInfoCheck="
				+ collectPersonalInfoCheck + "]";
	}

	public boolean validate() {
		boolean result = this.name.isBlank() || this.gender.isBlank() || this.address.isBlank()
				|| this.marketingCheck.isBlank() || this.collectPersonalInfoCheck.isBlank();
		return result;
	}

}
