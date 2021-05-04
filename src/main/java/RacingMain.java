import domain.RacingGame;
import view.RacingInput;
import view.RacingOutput;

public class RacingMain {
	RacingInput racingInput = new RacingInput();

	String[] carNames = racingInput.inputCarNames();
	int gameCoin = racingInput.inputGameCoin();

	RacingGame racingGame = new RacingGame(gameCoin, carNames);

        while(racingGame.isNotEnd()) {
		RacingOutput.printRacing(racingGame.moveCars());
	}

        RacingOutput.printWinner(racingGame.findWinner());
}
