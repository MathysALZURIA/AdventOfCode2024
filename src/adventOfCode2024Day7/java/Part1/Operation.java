package adventOfCode2024Day7.java.Part1;

import java.util.function.BiFunction;

public enum Operation {

    ADDITION((Long a, Long b) -> a + b),
    MULTIPLICATION((Long a, Long b) -> a * b);

    private BiFunction<Long, Long, Long> operation;

    Operation(BiFunction<Long, Long, Long> operation) {
        this.operation = operation;
    }

    public BiFunction<Long, Long, Long> getOperation() {
        return operation;
    }
}
