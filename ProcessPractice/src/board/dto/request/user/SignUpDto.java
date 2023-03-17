package board.dto.request.user;

public class SignUpDto {

	private String email;
	private String password;
	private String passwordCheck;
	private String nickname;
	private String phoneNumber;
	private String address;
	private String addressDetail;

	public SignUpDto() {
	}

	public SignUpDto(String email, String password, String passwordCheck, String nickname, String phoneNumber,
			String address, String addressDetail) {
		this.email = email;
		this.password = password;
		this.passwordCheck = passwordCheck;
		this.nickname = nickname;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.addressDetail = addressDetail;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getPasswordCheck() {
		return passwordCheck;
	}

	public String getNickname() {
		return nickname;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPasswordCheck(String passwordCheck) {
		this.passwordCheck = passwordCheck;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	@Override
	public String toString() {
		return "SignUpDto [email=" + email + ", password=" + password + ", passwordCheck=" + passwordCheck
				+ ", nickname=" + nickname + ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", addressDetail=" + addressDetail + "]";
	}

	public boolean validate() {
		boolean result = this.email.isBlank() || this.password.isBlank() || this.passwordCheck.isBlank()
				|| this.nickname.isBlank() || this.phoneNumber.isBlank() || this.address.isBlank()
				|| this.addressDetail.isBlank();
		return result;
	}

}
