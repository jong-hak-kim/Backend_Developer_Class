package trainReservation;

import java.util.Scanner;

import trainReservation.controller.ReservationController;

public class MainApplication {

	private static ReservationController reservationController = new ReservationController();

	public static void main(String[] args) {

		while (true) {
			Scanner scanner = new Scanner(System.in);
			String endPoint = scanner.nextLine();

			if (endPoint.equals("POST /reservation")) {
				reservationController.reservation();
			}
			if (endPoint.equals("GET /reservation")) {
				reservationController.getReservation();
			}
		}
	}
}
