package board.dto.response;

public class ResponseDto<D> {

	private boolean status;
	private String message;
	private D data; // 어떤 메소드라도 유연하게 데이터를 받아오기 위하여 제너릭 사용

	public ResponseDto() {
	}

	public ResponseDto(boolean status, String message, D data) {
		this.status = status;
		this.message = message;
		this.data = data;
	}

	public boolean isStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public D getData() {
		return data;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setData(D data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResponseDto [status=" + status + ", message=" + message + ", data=" + data + "]";
	}

}
