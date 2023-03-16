package trainReservation.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import trainReservation.dto.GetReservationDto;
import trainReservation.dto.GetTrainListDto;
import trainReservation.dto.PostReservationDto;
import trainReservation.entity.ReservationInfo;
import trainReservation.entity.Train;
import trainReservation.service.ReservationService;

// Controller class (계층)
// 사용자로부터 입력받는 기능 / 입력받은 데이터를 검증 기능 / 비즈니스 로직의 결과를 반환

public class ReservationController {

	private static DateTimeFormatter timeformatter = DateTimeFormatter.ofPattern("HH:mm");

	private ReservationService reservationService;

	private GetTrainListDto getTrainListDto;

	private GetReservationDto getReservationDto;

	private PostReservationDto postReservationDto;

	public ReservationController() {
		this.reservationService = new ReservationService();
	}

	public void reservation() {
		while (true) {

			getTrainListDto = new GetTrainListDto(); // 기본 생성자에 바로 넣어주어 선언하자마자 입력값 처리 가능

			LocalTime departureTime = null;

			if (getTrainListDto.isEmpty()) {
				System.out.println("모두 입력하세요.");
				continue;
			}

			try {
				departureTime = LocalTime.parse(getTrainListDto.getDepartureTime(), timeformatter);
			} catch (Exception exception) {
				System.out.println("잘못된 시간입니다.");
				continue;
			}

			if (getTrainListDto.getNumberOfPeople() <= 0) {
				System.out.println("잘못된 인원입니다.");
				continue;
			}

			if (getTrainListDto.isEqualStation()) {
				System.out.println("출발역과 도착역이 같습니다.");
				continue;
			}

			List<Train> possibleTrains = reservationService.getPossibleTrainList(getTrainListDto, departureTime); // 서비스
			System.out.println(possibleTrains.toString());

			postReservation();
			break;
		}
	}

	public void postReservation() {
		while (true) {
			postReservationDto = new PostReservationDto(getTrainListDto.getNumberOfPeople());
			ReservationInfo reservationInfo = reservationService.postReservation(postReservationDto, getTrainListDto);
			if (reservationInfo == null)
				continue;
			System.out.println(reservationInfo.toString());
			break;
		}

	}

	public void getReservation() {

		while (true) {
			getReservationDto = new GetReservationDto();
			String reservationNumber = getReservationDto.getReservationNumber();

			if (reservationNumber.isBlank()) {
				System.out.println("예약 번호를 입력하세요.");
				continue;
			}

			ReservationInfo reservationInfo = reservationService.getReservation(getReservationDto);

			// 조건에 따라서 다른 값을 반환하고자 한다면 삼항 연산자도 사용할 수 있다
			// 사용 안 하는 것이 좋음
			String message = reservationInfo == null ? "해당하는 예약 번호가 없습니다." : reservationInfo.toString();
			
			System.out.println(message);
			break;
		}

	}

}
