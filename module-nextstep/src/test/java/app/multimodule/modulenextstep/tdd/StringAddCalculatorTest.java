package app.multimodule.modulenextstep.tdd;

import org.junit.jupiter.api.Test;

import static app.multimodule.modulenextstep.tdd.StringAddCalculator.DEFAULT_DELIMITER;
import static app.multimodule.modulenextstep.tdd.StringAddCalculator.getCustomIndexAt;
import static app.multimodule.modulenextstep.tdd.StringAddCalculator.getDelimiter;
import static app.multimodule.modulenextstep.tdd.StringAddCalculator.getIntArrays;
import static app.multimodule.modulenextstep.tdd.StringAddCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

	@Test
	public void splitAndSum_null_또는_빈문자() {
		int result = splitAndSum(null);
		assertThat(result).isEqualTo(0);

		result = splitAndSum("");
		assertThat(result).isEqualTo(0);
	}

	@Test
	public void splitAndSum_숫자하나() throws Exception {
		int result = splitAndSum("1");
		assertThat(result).isEqualTo(1);
	}

	@Test
	public void splitAndSum_쉼표구분자() throws Exception {
		int result = splitAndSum("1,2");
		assertThat(result).isEqualTo(3);
	}


	@Test
	public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
		int result = splitAndSum("1,2:3");
		assertThat(result).isEqualTo(6);
	}


	@Test
	public void getCustomIndexAt_쉼표_또는_콜론_구분자() throws Exception {
		int result1 = getCustomIndexAt("1,2:3");
		int result2 = getCustomIndexAt("//;\n1;2;3");

		assertThat(result1).isEqualTo(-1);
		assertThat(result2).isEqualTo(3);
	}

	@Test
	public void getDelimiter_구분자() throws Exception {
		String delimiter1 = getDelimiter("//;\n1;2;3");
		String delimiter2 = getDelimiter("//;;;;\n1;2;3");

		assertThat(delimiter1).isEqualTo(";" + "|" + DEFAULT_DELIMITER);
		assertThat(delimiter2).isEqualTo(";;;;" + "|" + DEFAULT_DELIMITER);
	}

	@Test
	public void getIntArrays_test() throws Exception {
		String input = "//;\n1;2;3";
		String delimiter = ";|" + DEFAULT_DELIMITER;
		int customIndexAt = getCustomIndexAt(input);

		String[] intArrays = getIntArrays(input, delimiter, customIndexAt);

		assertThat(intArrays.length).isEqualTo(3);
		assertThat(intArrays[0]).isEqualTo("1");
		assertThat(intArrays[1]).isEqualTo("2");
		assertThat(intArrays[2]).isEqualTo("3");
	}

	@Test
	public void splitAndSum_custom_구분자() throws Exception {
		int result = splitAndSum("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	public void splitAndSum_negative() throws Exception {
		assertThatThrownBy(() -> splitAndSum("-1,2,3"))
			.isInstanceOf(RuntimeException.class);
	}
}
