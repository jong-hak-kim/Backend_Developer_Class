package trainReservation.entity;

// 정차역 Entity class
public class StopStation {
	private String stationName; // 역명
	private String departureTime; // 도착 시간
	private String arrivalTime; // 출발 시간

	public StopStation() {
	}

	public StopStation(String stationName, String departureTime, String arrivalTime) {
		this.stationName = stationName;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	public String getStationName() {
		return stationName; //setget 인스턴스에는 매개변수가 없어 this.을 안 써도 되기는 하나 웬만하면은 써주는 것이 좋다
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	@Override
	public String toString() {
		return "StopStation [stationName=" + stationName + ", departureTime=" + departureTime + ", arrivalTime="
				+ arrivalTime + "]";
	}

}
