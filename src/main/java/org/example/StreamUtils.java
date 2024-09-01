package org.example;

import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUtils {

    /**
     * Filters a stream to include only elements that fall within a specific range
     * and then applies a function to each of the filtered elements.
     *
     * <p>The returned list contains the results of applying the function to each
     * element within the specified range. The stream is processed sequentially.
     *
     * @apiNote
     * For example, to filter a list of integers to include only those between 10 and 20,
     * and then square each of those integers:
     *
     * <pre>{@code
     *     List<Integer> result = StreamUtils.filterAndTransform(
     *             Stream.of(5, 15, 25, 35, 10, 20),
     *             10,
     *             20,
     *             x -> x * x);
     *     // result would be [225, 100, 400]
     * }</pre>
     *
     * @param <T> the type of elements in the stream
     * @param stream the input stream to be filtered and transformed
     * @param lowerBound the inclusive lower bound of the range
     * @param upperBound the inclusive upper bound of the range
     * @param transformer the function to apply to the filtered elements
     * @return a list containing the transformed elements within the specified range
     * @throws NullPointerException if any argument is null
     */
    public static <T extends Comparable<T>, R> List<R> filterAndTransform(
            Stream<T> stream,
            T lowerBound,
            T upperBound,
            Function<? super T, ? extends R> transformer) {

        Objects.requireNonNull(stream);
        Objects.requireNonNull(lowerBound);
        Objects.requireNonNull(upperBound);
        Objects.requireNonNull(transformer);

        return stream
                .filter(e -> e.compareTo(lowerBound) >= 0 && e.compareTo(upperBound) <= 0)
                .map(transformer)
                .collect(Collectors.toList());
    }
}
