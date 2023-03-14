package trainReservation.entity;

import java.util.List;

// 기차 정보 Entity class
public class Train {
	private String trainNumber; // 열차 번호
	private String departureStation; // 출발역
	private String departureTime; // 출발 시간
	private String arrivalStation; // 도착역
	private String arrivalTime; // 도착 시간
	private int takeMinute; // 소요 시간
	private String type; // 기차 종류
	private List<StopStation> stopStations; // 정차역 - 클래스를 타입으로 사용할 때는 그 클래스와의 관계가 있다라고 말할 수 있음 (Train과 StopStation은 관계가
											// 있음)
	private List<Seat> seats; // 남아있는 좌석

	public Train() {
	}

	public Train(String trainNumber, String departureStation, String departureTime, String arrivalStation,
			String arrivalTime, int takeMinute, String type, List<StopStation> stopStations, List<Seat> seats) {
		this.trainNumber = trainNumber;
		this.departureStation = departureStation;
		this.departureTime = departureTime;
		this.arrivalStation = arrivalStation;
		this.arrivalTime = arrivalTime;
		this.takeMinute = takeMinute;
		this.type = type;
		this.stopStations = stopStations;
		this.seats = seats;
	}

	public String getTrainNumber() {
		return trainNumber;
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

	public int getTakeMinute() {
		return takeMinute;
	}

	public String getType() {
		return type;
	}

	public List<StopStation> getStopStations() {
		return stopStations;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	@Override
	public String toString() {
		return "\nTrain [trainNumber=" + trainNumber + ", departureStation=" + departureStation + ", departureTime="
				+ departureTime + ", arrivalStation=" + arrivalStation + ", arrivalTime=" + arrivalTime
				+ ", takeMinute=" + takeMinute + ", type=" + type + ", stopStations=" + stopStations + ", seats="
				+ seats + "]";
	}

}
