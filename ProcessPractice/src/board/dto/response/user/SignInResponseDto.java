package board.dto.response.user;

import java.util.UUID;

import board.entity.User;

public class SignInResponseDto {
	private String email;
	private String nickname;
	private String phoneNumber;
	private String address;
	private String addressDetail;
	private String profileImageUrl;
	private String token;

	public SignInResponseDto() {
	}

	public SignInResponseDto(String email, String nickname, String phoneNumber, String address, String addressDetail,
			String profileImageUrl, String token) {
		this.email = email;
		this.nickname = nickname;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.addressDetail = addressDetail;
		this.profileImageUrl = profileImageUrl;
		this.token = token;
	}

	public SignInResponseDto(User user) {
		this.email = user.getEmail();
		this.nickname = user.getNickname();
		this.phoneNumber = user.getPhoneNumber();
		this.address = user.getAddress();
		this.addressDetail = user.getAddressDetail();
		this.profileImageUrl = user.getProfileImageUrl();
		this.token = UUID.randomUUID().toString();
	}
	
	public String getEmail() {
		return email;
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

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public String getToken() {
		return token;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "SignInResponseDto [email=" + email + ", nickname=" + nickname + ", phoneNumber=" + phoneNumber
				+ ", address=" + address + ", addressDetail=" + addressDetail + ", profileImageUrl=" + profileImageUrl
				+ ", token=" + token + "]";
	}

}
