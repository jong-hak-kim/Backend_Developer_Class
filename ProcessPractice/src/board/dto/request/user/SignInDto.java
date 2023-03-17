package board.dto.request.user;

public class SignInDto {

	private String email;
	private String password;

	public SignInDto() {
	}

	public SignInDto(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "SignInDto [email=" + email + ", password=" + password + "]";
	}

	public boolean vaildate() {
		boolean result = this.email.isBlank() || this.password.isBlank();
		return result;

	}

}
