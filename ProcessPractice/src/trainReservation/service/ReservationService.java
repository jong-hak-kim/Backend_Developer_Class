package trainReservation.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import trainReservation.dto.GetReservationDto;
import trainReservation.dto.GetTrainListDto;
import trainReservation.dto.PostReservationDto;
import trainReservation.entity.Cost;
import trainReservation.entity.ReservationInfo;
import trainReservation.entity.Seat;
import trainReservation.entity.StopStation;
import trainReservation.entity.Train;

// Service class (계층)
// 실제 비즈니스 로직 담당
public class ReservationService {

	private static List<Train> trains = new ArrayList<>();
	private static List<Cost> costs = new ArrayList<>();
	private static List<ReservationInfo> reservations = new ArrayList<>();

	private static DateTimeFormatter timeformatter = DateTimeFormatter.ofPattern("HH:mm");

	public ReservationService() {
		initData();
	}

	public List<Train> getPossibleTrainList(GetTrainListDto dto, LocalTime departureTime) {

		List<Train> possibleTrains = new ArrayList<>();

		for (Train train : trains) {

			List<StopStation> stopStations = train.getStopStations();
			int sameStationIndex = -1;

			for (int stopStationIndex = 0; stopStationIndex < stopStations.size(); stopStationIndex++) {

				StopStation stopStation = stopStations.get(stopStationIndex);
				String stopStatonName = stopStation.getStationName();

				if (!dto.isEqualDepartureStation(stopStatonName))
					continue;
				if (stopStation.getDepartureTime().equals(""))
					continue;
				LocalTime stationDepartureTime = LocalTime.parse(stopStation.getDepartureTime(), timeformatter);

				// 입력한 시간 전에 출발하는 기차이면 검색할 필요 없으므로 break 해줌
				if (stationDepartureTime.isBefore(departureTime))
					break;

				sameStationIndex = stopStationIndex; // 동일한 정거장이 존재하면 sameStationIndex 변경
				break;
			}
			// sameStationIndex가 -1이면 기차가 해당 정거장을 거치지 않거나 이전 정거장이다.
			if (sameStationIndex == -1)
				continue;

			boolean isPossible = false;

			for (int stopStationIndex = 0; stopStationIndex < stopStations.size(); stopStationIndex++) {
				String stationName = stopStations.get(stopStationIndex).getStationName();

				// 입력한 정거장이 도착 정거장에 없다면 continue로 처음 작업으로 가게 한다
				if (!dto.isEqualArrivalStation(stationName))
					continue;

				// 도착역 인덱스 //출발역 인덱스
				if (stopStationIndex <= sameStationIndex) { // sameStationIndex가 출발역 정거장이 같거나 도착역이 출발역 전에 있는 것이므로
															// break
					break;
				}

				isPossible = true;
				break;
			}

			if (!isPossible) {
				continue;
			}

			List<Seat> seats = train.getSeats();

			int possibleSeatCount = 0;

			for (Seat seat : seats) { // 좌석 상태를 가져와서 예약 가능한 좌석 개수 카운트
				if (!seat.isSeatStatus())
					possibleSeatCount++;
			}

			if (possibleSeatCount < dto.getNumberOfPeople()) { // 가능한 좌석이 입력한 사람 수보다 작으면 continue
				continue;
			}

			possibleTrains.add(train);

		}

		return possibleTrains;

	}

	public ReservationInfo postReservation(PostReservationDto postReservationDto, GetTrainListDto getTrainListDto) { // 열차가
																														// 존재하는지
		Train train = null;

		for (Train trainItem : trains) {
			if (postReservationDto.isEqualTrainNumber(trainItem.getTrainNumber())) { // 입력한 열차번호가 지정돼있는 열차번호랑 같으면
																						// train에 trainItem의 주소값 저장
				train = trainItem;
				break;
			}
		}

		if (train == null) {
			System.out.println("존재하지 않는 열차입니다.");
			return null;
		}

		boolean designationState = true;
		List<Seat> seats = train.getSeats(); // 좌석 정보 가져오기
		List<String> inputSeatNumbers = postReservationDto.getSeats(); // 입력한 좌석 정보

		for (int index = 0; index < seats.size(); index++) { // 좌석 개수만큼 반복
			Seat seat = seats.get(index);
			for (String seatNumber : inputSeatNumbers) { // 입력한 좌석을 seatNumber에 복사하고 반복

				if (!seat.getSeatNumber().equals(seatNumber)) { // train에서 받아온 좌석 번호와 입력한 좌석 번호가 같은지 여부 확인
					continue;
				}

				if (seat.isSeatStatus()) { // 좌석 상태가 true 이면 좌석이 이미 있는 것이므로 좌석 지정 상태값 false로 변경
					designationState = false;
					break;
				}

				seat.setSeatStatus(true); // 좌석이 비어있다면 true로 변경해준다
				break;

			}
			if (!designationState) // 좌석 지정 상태값이 false이면 break한다
				break;
		}
		if (!designationState) {
			System.out.println("좌석 배정에 실패했습니다.");
			return null; // 반복문을 나와서 좌성 지정 상태값이 false이면 null 리턴
		}

		int totalCost = 0;

		for (Cost cost : costs) { // 해당 요소의 출발역과 도착역이 지정한 출발역이랑 도착역과 같은지?
			boolean isEqualDepartureStation = getTrainListDto.isEqualDepartureStation(cost.getDepartureStation());
			boolean isEqualArrivalStation = getTrainListDto.isEqualArrivalStation(cost.getArrivalStation());

			if (!isEqualDepartureStation || !isEqualArrivalStation) // 하나라도 거짓이 존재한다면 continue
				continue;
			totalCost = cost.getAmount() * getTrainListDto.getNumberOfPeople(); // 맞으면 totalCost에 가격을 넣은 후 break
			break;
		}

		String departureTime = "";
		String arrivalTime = "";

		for (StopStation stopStation : train.getStopStations()) {
			boolean isEqualDepartureStation = getTrainListDto.isEqualDepartureStation(stopStation.getStationName());
			boolean isEqualArrivalStation = getTrainListDto.isEqualArrivalStation(stopStation.getStationName());
			if (isEqualDepartureStation) {
				departureTime = stopStation.getDepartureTime();
			}
			if (isEqualArrivalStation) {
				arrivalTime = stopStation.getArrivalTime();
			}
		}

		ReservationInfo reservationInfo = new ReservationInfo(postReservationDto.getTrainNumber(),
				postReservationDto.getSeats(), getTrainListDto.getDepartureStation(), departureTime,
				getTrainListDto.getArrivalStation(), arrivalTime, totalCost); // 예약 정보 객체 생성

		reservations.add(reservationInfo);

		return reservationInfo;
	}

	public ReservationInfo getReservation(GetReservationDto dto) {
		ReservationInfo reservationInfo = null;
		String reservationNumber = dto.getReservationNumber();

		for (ReservationInfo item : reservations) {
			boolean isEqualReservationNumber = reservationNumber.equals(item.getReservationNumber());

			if (!isEqualReservationNumber)
				continue;

			reservationInfo = item;
			break;
		}
		return reservationInfo;
	}

	private static void initData() {
		costs.add(new Cost("부산역", "서울역", 30000));
		costs.add(new Cost("부산역", "대전역", 20000));
		costs.add(new Cost("부산역", "대구역", 10000));
		costs.add(new Cost("대구역", "서울역", 20000));
		costs.add(new Cost("대구역", "대전역", 10000));
		costs.add(new Cost("대전역", "서울역", 10000));

		costs.add(new Cost("서울역", "부산역", 30000));
		costs.add(new Cost("서울역", "대구역", 20000));
		costs.add(new Cost("서울역", "대전역", 10000));
		costs.add(new Cost("대전역", "부산역", 20000));
		costs.add(new Cost("대전역", "대구역", 10000));
		costs.add(new Cost("대구역", "부산역", 10000));

		Train train;
		List<Seat> seats = new ArrayList<>();
		List<StopStation> stopStations = new ArrayList<>();

		seats.add(new Seat(1, "A1", false));
		seats.add(new Seat(1, "B1", false));
		seats.add(new Seat(1, "A2", false));
		seats.add(new Seat(1, "B2", false));
		seats.add(new Seat(2, "A1", false));
		seats.add(new Seat(2, "B1", false));
		seats.add(new Seat(2, "A2", false));
		seats.add(new Seat(2, "B2", false));
		seats.add(new Seat(3, "A1", false));
		seats.add(new Seat(3, "B1", false));
		seats.add(new Seat(3, "A2", false));
		seats.add(new Seat(3, "B2", false));

		stopStations.add(new StopStation("서을역", "", "06:00"));
		stopStations.add(new StopStation("대전역", "06:45", "07:00"));
		stopStations.add(new StopStation("대구역", "07:45", "08:00"));
		stopStations.add(new StopStation("부산역", "09:00", ""));

		train = new Train("KTX001", "서울역", "06:00", "부산역", "09:00", 180, "KTX", stopStations, seats);
		trains.add(train);

		seats = new ArrayList<>();
		stopStations = new ArrayList<>();

		seats.add(new Seat(1, "A1", false));
		seats.add(new Seat(1, "B1", false));
		seats.add(new Seat(1, "A2", false));
		seats.add(new Seat(1, "B2", false));
		seats.add(new Seat(2, "A1", false));
		seats.add(new Seat(2, "B1", false));
		seats.add(new Seat(2, "A2", false));
		seats.add(new Seat(2, "B2", false));
		seats.add(new Seat(3, "A1", false));
		seats.add(new Seat(3, "B1", false));
		seats.add(new Seat(3, "A2", false));
		seats.add(new Seat(3, "B2", false));

		stopStations.add(new StopStation("부산역", "", "09:00"));
		stopStations.add(new StopStation("대구역", "09:45", "10:00"));
		stopStations.add(new StopStation("대전역", "10:45", "11:00"));
		stopStations.add(new StopStation("서울역", "12:00", ""));

		train = new Train("KTX002", "부산역", "09:00", "서울역", "12:00", 180, "KTX", stopStations, seats);
		trains.add(train);

	}

}
