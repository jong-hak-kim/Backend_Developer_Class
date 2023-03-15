package trainReservation.entity;

import java.util.List;
import java.util.UUID;

//예약 번호
//열차 번호
//좌석 번호 리스트
//출발역
//출발 시간
//도착역
//도착 시간
//총 금액

public class ReservationInfo {

	private String reservationNumber;
	private String trainNumber;
	private List<String> seats;
	private String departureStation;
	private String departureTime;
	private String arrivalStation;
	private String arrivalTime;
	private int totalCost;

	public ReservationInfo() {

	}

	public ReservationInfo(String trainNumber, List<String> seats, String departureStation, String departureTime,
			String arrivalStation, String arrivalTime, int totalCost) {
		this.reservationNumber = UUID.randomUUID().toString(); // 랜덤 난수 생성
		this.trainNumber = trainNumber;
		this.seats = seats;
		this.departureStation = departureStation;
		this.departureTime = departureTime;
		this.arrivalStation = arrivalStation;
		this.arrivalTime = arrivalTime;
		this.totalCost = totalCost;
	}

	public String getReservationNumber() {
		return reservationNumber;
	}

	public String getTrainNumber() {
		return trainNumber;
	}

	public List<String> getSeats() {
		return seats;
	}

	public String getDepartureStation() {
		return departureStation;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getArrivalStation() {
		return arrivalStation;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public int getTotalCost() {
		return totalCost;
	}

	@Override
	public String toString() {
		return "ReservationInfo [reservationNumber=" + reservationNumber + ", trainNumber=" + trainNumber + ", seats="
				+ seats + ", departureStation=" + departureStation + ", departureTime=" + departureTime
				+ ", arrivalStation=" + arrivalStation + ", arrivalTime=" + arrivalTime + ", totalCost=" + totalCost
				+ "]";
	}

}
