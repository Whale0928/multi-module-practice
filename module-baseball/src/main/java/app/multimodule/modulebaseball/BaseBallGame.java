package app.multimodule.modulebaseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BaseBallGame {

	public Integer getRandom() {
		return new Random().nextInt(9) + 1;
	}

	public List<Integer> getStrikeZones() {
		List<Integer> strikeZones = new ArrayList<>();
		while (strikeZones.size() < 3) {
			Integer random = getRandom();
			if (!strikeZones.contains(random)) {
				strikeZones.add(random);
			}
		}
		return strikeZones;
	}
}
