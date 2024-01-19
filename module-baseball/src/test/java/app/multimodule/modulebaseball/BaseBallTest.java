package app.multimodule.modulebaseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("BaseBallTest")
public class BaseBallTest {
	List<Integer> strikeZones = new LinkedList<>() {
		{
			add(1);
			add(2);
			add(3);
		}
	};

	@Test
	@DisplayName("1~9 사이의 랜덤한 값을 만들수 있다.")
	void can_make_random() {
		Integer randomValue = new BaseBallGame().getRandom();
		assertTrue(randomValue >= 1 && randomValue <= 9);
	}

	@Test
	@DisplayName("1~9 사이의 중복되지 않은 랜덤한 값을 3번 만들수 있다.")
	void can_make_random_three_times() {
		BaseBallGame game = new BaseBallGame();
		List<Integer> randoms = game.getStrikeZones();

		System.out.println(randoms);
		assertEquals(3, randoms.size());
		assertNotEquals(randoms.get(0), randoms.get(1));
		assertNotEquals(randoms.get(0), randoms.get(2));
		assertNotEquals(randoms.get(1), randoms.get(2));
	}

	@Test
	@DisplayName("수를 입력받아 스트라이크를 판단할 수 있다.")
	void is_strike() {
		Integer strikeNumber = 1;
		Integer input = 1;
		boolean result = new BaseBallGame().isStrike(strikeNumber, input);
		assertTrue(result);
	}

	@Test
	@DisplayName("수를 입력받아 볼을 판단할 수 있다.")
	void is_ball() {
		Integer strikeNumber = 1;
		Integer input = 4;
		boolean result = new BaseBallGame().isStrike(strikeNumber, input);
		assertFalse(result);
	}

	@Test
	@DisplayName("스트라이크존과 입력값을 받아 사이즈를 검증할 수 있다.")
	void test_size_validation() {
		BaseBallGame game = new BaseBallGame();
		List<Integer> list = asList(1, 2, 3);
		List<Integer> list2 = asList(1, 2, 3, 4);
		List<Integer> inputs = asList(1, 2, 3);
		List<Integer> inputs2 = asList(1, 2, 3, 4);
		boolean result = game.sizeValidate(list, inputs);
		boolean result2 = game.sizeValidate(list, inputs2);
		boolean result3 = game.sizeValidate(list2, inputs);
		assertTrue(result);
		assertFalse(result2);
		assertFalse(result3);
	}

	@Test
	@DisplayName("스트라이크존과 입력값을 받아 결과를 제공 받을 수 있다.")
	void get_result() {
		BaseBallGame game = new BaseBallGame();
		List<Integer> list = asList(1, 2, 3);
		List<Integer> inputs = asList(1, 3, 6);
		BaseBallResult o = game.match(list, inputs);
		System.out.println(o.decisions);
	}

}
