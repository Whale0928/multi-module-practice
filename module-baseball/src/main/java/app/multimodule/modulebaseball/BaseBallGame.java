package app.multimodule.modulebaseball;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Stack;

public class BaseBallGame {

	final int MAX_SIZE = 3;

	public Integer getRandom() {
		return new Random().nextInt(9) + 1;
	}

	public List<Integer> getStrikeZones() {
		List<Integer> strikeZones = new Stack<>();
		while (strikeZones.size() < 3) {
			Integer random = getRandom();
			if (!strikeZones.contains(random)) {
				strikeZones.add(random);
			}
		}
		return strikeZones;
	}

	public boolean isStrike(Integer strikeNumber, Integer input) {
		return Objects.equals(strikeNumber, input);
	}

	public boolean sizeValidate(List<Integer> strikeZones, List<Integer> inputs) {
		return strikeZones.size() == MAX_SIZE && inputs.size() == MAX_SIZE;
	}

	public BaseBallResult match(List<Integer> list, List<Integer> inputs) {

		BaseBallResult baseBallResult = new BaseBallResult();

		if (!sizeValidate(list, inputs))
			throw new IllegalArgumentException("입력값이 잘못되었습니다.");

		for (int i = 0; i < MAX_SIZE; i++) {
			Integer zoneValue = inputs.get(i);
			Integer initValue = list.get(i);

			if (isStrike(zoneValue, initValue)) {
				baseBallResult.addDecision(Decision.STRIKE);
			} else if (list.contains(zoneValue)) {
				baseBallResult.addDecision(Decision.BALL);
			} else {
				baseBallResult.addDecision(Decision.NOTHING);
			}
		}

		return baseBallResult;
	}
}
