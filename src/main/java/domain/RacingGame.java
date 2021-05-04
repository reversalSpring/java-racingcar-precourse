package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
	private List<RacingCar> racingCarList = new ArrayList<>();

	private int racingEndRound;

	public RacingGame(int GameCoin, String[] carNameList) {
		racingEndRound = GameCoin;
		for (String carName : carNameList) {
			racingCarList.add(new RacingCar(carName));
		}
	}

	public List<RacingCar> moveCars() {
		for (RacingCar car : racingCarList) {
			int power = 1;
			car.move(power);
		}

		return racingCarList;
	}

	public int getMaxPosition() {
		return racingCarList.stream()
			.mapToInt(RacingCar::getCurrentPosition)
			.max()
			.getAsInt();
	}

	public List<RacingCar> findWinner() {
		int maxPosition = getMaxPosition();

		return racingCarList.stream()
			.filter(car -> car.samePosition(maxPosition))
			.collect(Collectors.toList());
	}

	public boolean isNotEnd() {
		racingEndRound--;
		return racingEndRound >= 0;
	}
}