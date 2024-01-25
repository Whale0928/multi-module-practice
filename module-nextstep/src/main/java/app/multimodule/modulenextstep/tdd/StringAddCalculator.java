package app.multimodule.modulenextstep.tdd;

import java.util.Arrays;
import java.util.Objects;

public class StringAddCalculator {

	public static final String DEFAULT_DELIMITER = ",|:";

	public static int splitAndSum(String input) {
		if (Objects.isNull(input) || input.isBlank())
			return 0;

		String delimiter = getDelimiter(input);
		int customIndexAt = getCustomIndexAt(input);
		String[] numbers = getIntArrays(input, delimiter, customIndexAt);
		if (numbers.length < 1)
			return 0;

		return Arrays.stream(numbers)
			.mapToInt(s -> {
				int value = Integer.parseInt(s);
				if (value < 0)
					throw new RuntimeException("음수는 입력할 수 없습니다.");
				return value;
			})
			.sum();
	}

	public static String[] getIntArrays(String input, String delimiter, int customIndexAt) {
		if (customIndexAt != -1) {
			input = input.substring(customIndexAt + 1);
		}
		return input.split(delimiter);
	}

	public static int getCustomIndexAt(String input) {
		return input.indexOf("\n");
	}

	public static String getDelimiter(String input) {
		if (input.startsWith("//")) {
			return customDelimiter(input);
		}
		return DEFAULT_DELIMITER;
	}

	public static String customDelimiter(String input) {
		int startAt = 2;
		int endAt = input.indexOf("\n");
		if (endAt == -1)
			throw new RuntimeException("구분자가 잘못되었습니다.");
		String substring = input.substring(startAt, endAt);
		return substring + "|" + DEFAULT_DELIMITER;
	}

}
