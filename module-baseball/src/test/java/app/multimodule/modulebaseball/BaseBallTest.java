package app.multimodule.modulebaseball;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

@DisplayName("BaseBallTest")
public class BaseBallTest {

	@Test
	@DisplayName("nothing test")
	void nothing() {
		BaseBallGame baseBallGame = new BaseBallGame();
	}


	@Test
	@DisplayName("1~9 사이의 랜덤한 값을 만들수 있다.")
	void can_make_random() {
		Integer randomValue = new BaseBallGame().getRandom();
		Assertions.assertTrue(randomValue >= 1 && randomValue <= 9);
	}

	@Test
	@DisplayName("1~9 사이의 중복되지 않은 랜덤한 값을 3번 만들수 있다.")
	void can_make_random_three_times() {
		BaseBallGame game = new BaseBallGame();
		List<Integer> randoms = game.getStrikeZones();

		System.out.println(randoms);
		Assertions.assertEquals(3, randoms.size());
		Assertions.assertNotEquals(randoms.get(0), randoms.get(1));
		Assertions.assertNotEquals(randoms.get(0), randoms.get(2));
		Assertions.assertNotEquals(randoms.get(1), randoms.get(2));
	}

	@Test
	@DisplayName("수를 입력받아 스트라이크를 판단할 수 있다.")
	void is_strike() {
		List<Integer> strikeZones = new LinkedList<>() {
			{
				add(1);
				add(2);
				add(3);
			}
		};

		Integer input = 1;

		Assertions.assertTrue(strikeZones.contains(input));
	}
}
