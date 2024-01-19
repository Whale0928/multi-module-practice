package app.multimodule.modulebaseball;


import java.util.LinkedList;
import java.util.List;


public class BaseBallResult {
	List<Decision> decisions = new LinkedList<>();

	public void addDecision(Decision decision) {
		decisions.add(decision);
	}

	public String getResult() {
		int strikeCount = 0;
		int ballCount = 0;
		for (Decision decision : decisions) {
			if (decision == Decision.STRIKE) {
				strikeCount++;
			} else if (decision == Decision.BALL) {
				ballCount++;
			}
		}
		return String.format("%d 스트라이크 %d 볼", strikeCount, ballCount);
	}
}
