package app.multimodule.modulebaseball;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Decision {
	STRIKE("스트라이크"), BALL("볼"), NOTHING("낫싱");

	private final String decision;
}
