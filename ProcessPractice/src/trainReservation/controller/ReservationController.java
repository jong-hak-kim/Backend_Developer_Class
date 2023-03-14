package trainReservation.controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import trainReservation.dto.GetTrainListDto;
import trainReservation.entity.Train;
import trainReservation.service.ReservationService;

// Controller class (계층)
// 사용자로부터 입력받는 기능 / 입력받은 데이터를 검증 기능 / 비즈니스 로직의 결과를 반환

public class ReservationController {

	private static DateTimeFormatter timeformatter = DateTimeFormatter.ofPattern("HH:mm");

	private ReservationService reservationService;

	public ReservationController() {
		this.reservationService = new ReservationService();
	}

	public void reservation() {
		while (true) {

			GetTrainListDto dto = new GetTrainListDto(); // 기본 생성자에 바로 넣어주어 선언하자마자 입력값 처리 가능

			LocalTime departureTime = null;

			if (dto.isEmpty()) {
				System.out.println("모두 입력하세요.");
				continue;
			}

			try {
				departureTime = LocalTime.parse(dto.getDepartureTime(), timeformatter);
			} catch (Exception exception) {
				System.out.println("잘못된 시간입니다.");
				continue;
			}

			if (dto.getNumberOfPeople() <= 0) {
				System.out.println("잘못된 인원입니다.");
				continue;
			}

			if (dto.isEqualStation()) {
				System.out.println("출발역과 도착역이 같습니다.");
				continue;
			}

			List<Train> possibleTrains = reservationService.getPossibleTrainList(dto, departureTime); //서비스 로직

			System.out.println(possibleTrains.toString());
		}

	}

}
