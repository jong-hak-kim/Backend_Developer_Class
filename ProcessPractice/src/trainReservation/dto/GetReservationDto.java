package trainReservation.dto;

import java.util.Scanner;

public class GetReservationDto {
	private String reservationNumber;

	public GetReservationDto() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("예약 번호 : ");
		this.reservationNumber = scanner.nextLine();
		
	}

	public GetReservationDto(String reservationNumber) { // 생성할 때만 사용 가능
		this.reservationNumber = reservationNumber;
	}

	public String getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(String reservationNumber) { //생성한 후에 사용
		this.reservationNumber = reservationNumber;
	}

	@Override
	public String toString() {
		return "GetReservationDto [reservationNumber=" + reservationNumber + "]";
	}

}
