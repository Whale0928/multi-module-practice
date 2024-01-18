package app.multimodule.modulebaseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@DisplayName("BaseBallTest")
public class BaseBallTest {

    @Test
    @DisplayName("nothing test")
    void nothing() {
        System.out.println("BaseBallTest");
    }


    @Test
    @DisplayName("stream test")
    void stream() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // Using parallel Stream API to process data
        List<Integer> squaredNumbers = numbers.parallelStream()
                .map(n -> {
                    System.out.println("Processing " + n + " on thread " + Thread.currentThread().getName());
                    return n * n;
                })
                .collect(Collectors.toList());

        System.out.println("Squared numbers: " + squaredNumbers);
    }
}
