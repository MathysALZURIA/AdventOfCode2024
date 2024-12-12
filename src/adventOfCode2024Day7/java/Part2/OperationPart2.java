package adventOfCode2024Day7.java.Part2;

import java.util.function.BiFunction;

public enum OperationPart2 {

    ADDITION((Long a, Long b) -> a + b),
    MULTIPLICATION((Long a, Long b) -> a * b),
    CONCATENATION((Long a, Long b) -> Long.parseLong(a.toString() + b.toString()));

    private BiFunction<Long, Long, Long> operation;

    OperationPart2(BiFunction<Long, Long, Long> operation) {
        this.operation = operation;
    }

    public BiFunction<Long, Long, Long> getOperation() {
        return operation;
    }
}
