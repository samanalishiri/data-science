package com.saman.datascience.datastructure;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.floorDiv;
import static java.lang.Math.floorMod;
import static java.lang.String.format;
import static java.lang.System.arraycopy;
import static java.util.Objects.requireNonNull;

/**
 * @author Saman Alishirishahrbabak
 */
public class IntArrays {

    /**
     * Check the {@code n}, if it be less than one then throw the
     * {@link RuntimeException}. In other words the {@code n} must be member of
     * natural number set.
     *
     * @param n     the integer that, it must be check for condition
     * @param param the name of parameter that, must be check for condition
     * @throws RuntimeException
     */
    public static void requireNaturalNumber(int n, String param) {
        if (n < 1)
            throw new RuntimeException(format("%s cannot be less than 1", param));
    }

    /**
     * Every element as many as {@code step} number will be shifted to left side. Amount of
     * the elements from end side of the array will change to zero and the elements from
     * beginning side must be remove from array.
     *
     * @param a    the reference of array that, its elements will be shifted to left side
     * @param step the number of steps that every element must be shifted
     * @throws RuntimeException if {@code a} be empty or null or {@code step} not be member of natural number set
     */
    public static void leftShift(int[] a, int step) {
        requireNonEmpty(a);
        requireNaturalNumber(step, "shift step");

        int lastIndex = a.length - 1;

        for (int i = 0; i <= lastIndex; i++)
            if (i + step > lastIndex)
                a[i] = 0;
            else
                a[i] = a[i + step];
    }

    /**
     * Every element after {@code start} index as many as {@code step} number will be shifted
     * to left side. Amount of the elements from end side of the array will change to zero
     * and the elements from beginning side must be remove from array.
     *
     * @param a     the reference of array that, its elements will be shifted to left side
     * @param start the position that, shift action must be start from that
     * @param step  the number of steps that every element must be shifted
     * @throws RuntimeException if {@code a} be empty or null or {@code start} be negative integer
     *                          or {@code step} not be member of natural number set
     */
    public static void leftShift(int[] a, int start, int step) {
        requireNonEmpty(a);
        requirePositiveInteger(start, "start index");
        requireNaturalNumber(step, "shift step");

        int lastIndex = a.length - 1;

        for (int i = start; i <= lastIndex; i++)
            if (i + step > lastIndex)
                a[i] = 0;
            else
                a[i] = a[i + step];
    }

    /**
     * Every element as many as {@code step} number will be shifted to right side. Amount of
     * the elements from beginning side of the array will change to zero and the elements from
     * end side must be remove from array.
     *
     * @param a    the reference of array that, its elements will be shifted to right side
     * @param step the number of steps that every element must be shifted
     * @throws RuntimeException if {@code a} be empty or null or {@code step} not be member of natural number set
     */
    public static void rightShift(int[] a, int step) {
        requireNonEmpty(a);
        requireNaturalNumber(step, "shift step");

        int lastIndex = a.length - 1;

        for (int i = lastIndex; i >= 0; i--)
            if (i - step < 0)
                a[i] = 0;
            else
                a[i] = a[i - step];
    }

    /**
     * Every element after {@code start} index as many as {@code step} number will be shifted
     * to right side. Amount of the elements from beginning side of the array will change to zero
     * and the elements from end side must be remove from array.
     *
     * @param a     the reference of array that, its elements will be shifted to right side
     * @param start the position that, shift action must be start from that
     * @param step  the number of steps that every element must be shifted
     * @throws RuntimeException if {@code a} be empty or null or {@code start} be negative integer
     *                          or {@code step} not be member of natural number set
     */
    public static void rightShift(int[] a, int start, int step) {
        requireNonEmpty(a);
        requirePositiveInteger(start, "start index");
        requireNaturalNumber(step, "shift step");

        int lastIndex = a.length - 1;

        for (int i = lastIndex - start; i >= 0; i--)
            if (i - step < 0)
                a[i] = 0;
            else
                a[i] = a[i - step];
    }

    /**
     * Every element as many as {@code step} number will be shifted to left side. The elements from beginning side
     * must be remove from array then add them to end of array.
     *
     * @param a    the reference of array that, its elements will be shifted to left side
     * @param step the number of steps that every element must be shifted
     * @throws RuntimeException if {@code a} be empty or null or {@code step} not be member of natural number set
     */
    public static void leftRotation(int[] a, int step) {
        requireNonEmpty(a);
        requireNaturalNumber(step, "shift step");

        int[] temp = subarray(a, 0, step);
        leftShift(a, step);
        arraycopy(temp, 0, a, a.length - step, step);

    }

    /**
     * Every element as many as {@code step} number will be shifted to right side. The elements from end side
     * must be remove from array then add them to beginning of array.
     *
     * @param a    the reference of array that, its elements will be shifted to left side
     * @param step the number of steps that every element must be shifted
     * @throws RuntimeException if {@code a} be empty or null or {@code step} not be member of natural number set
     */
    public static void rightRotation(int[] a, int step) {
        requireNonEmpty(a);
        requireNaturalNumber(step, "shift step");

        int[] temp = subarray(a, (a.length - step), step);
        rightShift(a, step);
        arraycopy(temp, 0, a, 0, step);
    }

    /**
     * The array divided to part with the same length then the position of every element has to change with the
     * symmetry element.
     *
     * @param a the reference of array that, it will be reverse
     * @throws RuntimeException if {@code a} be empty or null
     */
    public static void reverse(int[] a) {
        requireNonEmpty(a);

        int lastIndex = a.length - 1;
        int iterationNumber = floorDiv(a.length, 2);

        for (int i = 0; i < iterationNumber; i++)
            swap(a, i, lastIndex - i);
    }

    /**
     * This method gives statics function like sum, average, min, etc for an array.
     *
     * @param a the reference of array
     * @throws RuntimeException if {@code a} be empty or null
     */
    public static IntSummaryStatistics statistics(int[] a) {
        requireNonEmpty(a);
        return IntStream.of(a).summaryStatistics();
    }

    /**
     * Finding the {@code n} bigger integer in an array then Return them as a new array.
     *
     * @param a the reference of array.
     * @param n the number of maximums integers
     * @return {@code n} bigger integers as a new array
     * @throws RuntimeException if {@code a} be empty or null or {@code n} not be member of natural number set
     */
    public static int[] findNMaximums(int[] a, int n) {
        requireNonEmpty(a);
        requireNaturalNumber(n, "");

        int[] maximums = subarray(a, 0, n);

        for (int i = 0; i < a.length; i++) {
            int k = 0;
            for (int j = 0; j < maximums.length; j++) {
                if (a[i] > maximums[j]) {
                    if (k != j) maximums[k] = maximums[j];
                    maximums[j] = a[i];
                    k = j;
                }
            }
        }

        return maximums;
    }

    /**
     * Finding the {@code n}th bigger integer in an array.
     *
     * @param a the reference of array.
     * @param n the number of maximums integers
     * @return {@code n}th bigger integer
     */
    public static int findNthMaximum(int[] a, int n) {
        return findNMaximums(a, n)[0];
    }

    /**
     * Return All odd integers.
     *
     * @param a the array reference
     * @return odd integers as a new array
     * @throws RuntimeException if {@code a} be empty or null
     */
    public static int[] getOdds(int[] a) {
        requireNonEmpty(a);
        return IntStream.of(a).filter(n -> floorMod(n, 2) == 1).toArray();
    }

    /**
     * Return All even integers.
     *
     * @param a the array reference
     * @return even integers as a new array
     * @throws RuntimeException if {@code a} be empty or null
     */
    public static int[] getEvens(int[] a) {
        requireNonEmpty(a);
        return IntStream.of(a).filter(n -> floorMod(n, 2) == 0).toArray();
    }

    /**
     * Filter all elements that located in even index.
     *
     * @param a the array reference
     * @return the elements that located in even index
     * @throws RuntimeException if {@code a} be empty or null
     */
    public static int[] getEvenIndices(int[] a) {
        requireNonEmpty(a);
        return IntStream.range(0, a.length).filter(i -> i % 2 == 0).map(i -> a[i]).toArray();
    }

    /**
     * Filter all elements that located in odd index.
     *
     * @param a the array reference
     * @return the elements that located in odd index
     * @throws RuntimeException if {@code a} be empty or null
     */
    public static int[] getOddIndices(int[] a) {
        requireNonEmpty(a);
        return IntStream.range(0, a.length).filter(i -> i % 2 == 1).map(i -> a[i]).toArray();
    }

    /**
     * Search in array and return index of {@code n}.
     *
     * @param a the array reference
     * @param n the integer that, supposed to be found position of it
     * @return index of {@code n} as a integer
     * @throws RuntimeException if {@code a} be empty or null
     */
    public static int getIndex(int[] a, int n) {
        requireNonEmpty(a);
        for (int i = 0; i < a.length; i++)
            if (a[i] == n) return i;

        return -1;
    }

    /**
     * It search in array and if {@code n} is repeated more than one then, it returns indices of {@code n}, otherwise
     * returns an array with maximum length of one
     *
     * @param a the array reference
     * @param n the integer that, supposed to be found position(s) of it
     * @return new array included indices of {@code n}
     * @throws RuntimeException if {@code a} be empty or null
     */
    public static int[] getIndices(int[] a, int n) {
        requireNonEmpty(a);

        int[] indices = new int[0];

        for (int i = 0; i < a.length; i++)
            if (a[i] == n) indices = addToEnd(indices, i);

        return indices;
    }

    /**
     * It added the new element to the end of array and if the array was filled, it will increase
     * the size of array as many one element.
     *
     * @param a the array reference
     * @param n new integer that wants to add to the array
     * @return new array include new element(s)
     * @throws RuntimeException if {@code a} be null
     */
    public static int[] addToEnd(int[] a, int n) {
        requireNonNull(a);

        int[] array = increaseLengthFromEndSide(a, 1);
        array[array.length - 1] = n;
        return array;
    }

    /**
     * It added the new element to the begin of array and if the array was filled, it will increase
     * the size of array as many one element.
     *
     * @param a the array reference
     * @param n new integer that wants to add to the array
     * @return new array include new element(s)
     * @throws RuntimeException if {@code a} be null
     */
    public static int[] addToBegin(int[] a, int n) {
        requireNonNull(a);

        int[] array = increaseLengthFromBeginningSide(a, 1);
        array[0] = n;

        return array;
    }

    /**
     * Join two arrays to each other and return new array include all elements.
     *
     * @param a the reference of first array
     * @param b the reference of second array that wants to add to the {@code a}
     * @return new array include all elements
     * @throws RuntimeException if {@code a} or {@code b} be null
     */
    public static int[] union(int[] a, int[] b) {
        requireNonNull(a);
        requireNonNull(b);

        int[] array = new int[a.length + b.length];
        arraycopy(a, 0, array, 0, a.length);
        arraycopy(b, 0, array, a.length, b.length);
        return array;
    }

    /**
     * Return new array include the element(S) that are common in {@code a} and {@code b}.
     *
     * @param a the reference of first array
     * @param b the reference of second array
     * @return Return new array include the element(S) that are common in {@code a} and {@code b}
     * @throws RuntimeException if {@code a} or {@code b} be null
     */
    public static int[] common(int[] a, int[] b) {
        requireNonNull(a);
        requireNonNull(b);

        return IntStream.of(a).filter(item -> contains(b, item)).toArray();
    }

    /**
     * Return new array include the element(S) that are member of {@code a} and not member of {@code b}.
     *
     * @param a the reference of first array
     * @param b the reference of second array that wants to subtract from {@code a}
     * @return Return new array include the element(S) that are member of {@code a} and not member of {@code b}
     * @throws RuntimeException if {@code a} or {@code b} be null
     */
    public static int[] subtract(int[] a, int[] b) {
        requireNonNull(a);
        requireNonNull(b);

        return IntStream.of(a).filter(item -> noneContains(b, item)).toArray();
    }

    /**
     * Return element(s) that are repeated in {@code a}
     *
     * @param a the array reference
     * @return element(s) that are repeated in {@code a}
     * @throws RuntimeException if {@code a} be empty or null
     */
    public static int[] getRepetitive(int[] a) {
        requireNonEmpty(a);

        return groupingBy(a).entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .mapToInt(entry -> entry.getKey())
                .toArray();
    }

    public static Map<Integer, Long> groupingBy(int[] a) {
        return IntStream.of(a).boxed().collect(Collectors.groupingBy(n -> n, Collectors.counting()));
    }

    public static int calculateXor(int[] a) {
        int xor = 0;

        for (int i = 0; i < a.length; i++) {
            xor ^= a[i];
        }

        return xor;
    }

    public static void xor(int[] a) {
        int xor = calculateXor(a);

        for (int i = 0; i < a.length; i++) {
            a[i] = xor ^ a[i];
        }
    }

    public static List<int[]> getAllSubset(int[] a) {
        int length = a.length;

        ArrayList<int[]> subsets = new ArrayList<>();

        for (int i = 0; i < (1 << length); i++) {
            int m = 1;
            List<Integer> numbers = new LinkedList<>();
            for (int j = 0; j < length; j++) {
                if ((i & m) > 0) {
                    numbers.add(a[j]);
                }
                m = m << 1;
            }

            subsets.add(numbers.stream().mapToInt(Integer::intValue).toArray());
        }

        return subsets;
    }

    public static int[] remove(int[] a, int n) {
        return Arrays.stream(a).filter(item -> item != n).toArray();
    }

    public static int[] removeByIndex(int[] a, int index) {
        int[] array = new int[a.length - 1];
        arraycopy(a, 0, array, 0, index);
        arraycopy(a, index + 1, array, index, a.length - index - 1);
        return array;
    }

    public static int[] removeByIndexShifting(int[] a, int index) {

        leftShift(a, index, 1);

        int length = a.length - 1;

        int[] array = new int[length];
        arraycopy(a, 0, array, 0, length);

        return array;
    }

    public static int[] set(int[] a, int index, int n) {

        int length = a.length + 1;
        int[] array = new int[length];
        array[index] = n;

        arraycopy(a, 0, array, 0, index);
        arraycopy(a, index, array, index + 1, a.length - index);

        return array;
    }

    /**
     * Check the Array reference, if it be {@code null } or empty then throw the
     * {@link RuntimeException}.
     *
     * @param a the reference of array that, it must be check for emptiness
     * @throws RuntimeException
     */
    public static void requireNonEmpty(int[] a) {
        if (a == null || a.length == 0)
            throw new RuntimeException("array cannot be null or empty");
    }

    /**
     * Check the {@code n}, if it be a negative integer then throw the
     * {@link RuntimeException}.
     *
     * @param n     the integer that, it must be check for sign
     * @param param the name of parameter that, must be check for sign
     * @throws RuntimeException
     */
    public static void requirePositiveInteger(int n, String param) {
        if (n < 0)
            throw new RuntimeException(format("%s cannot be less than 0", param));
    }

    public static boolean contains(int[] a, int n) {
        return IntStream.of(a).anyMatch(i -> i == n);
    }

    public static boolean noneContains(int[] a, int n) {
        return IntStream.of(a).noneMatch(i -> i == n);
    }

    public static void initialize(int[] a, int start, int length, int n) {
        for (int i = start; i < start + length; i++) {
            a[i] = n;
        }
    }

    public static long count(int[] a, int n) {
        return IntStream.of(a).filter(element -> element == n).count();
    }

    public static int[] subarray(int[] a, int start, int length) {
        int[] temp = new int[length];
        arraycopy(a, start, temp, 0, length);
        return temp;
    }

    public static int[] copy(int[] a) {
        return IntStream.of(a).toArray();
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int[] increaseLengthFromEndSide(int[] a, int length) {

        if (a.length == 0) return new int[length];

        int[] array = new int[a.length + length];
        arraycopy(a, 0, array, 0, a.length);
        return array;
    }

    public static int[] increaseLengthFromBeginningSide(int[] a, int length) {

        if (a.length == 0) return new int[length];

        int[] array = new int[a.length + length];
        arraycopy(a, 0, array, length, a.length);
        return array;
    }

    public static String toString(int... a) {
        return Arrays.stream(a).mapToObj(String::valueOf).collect(Collectors.joining(","));
    }

    public static void print(PrintStream printer, int... a) {
        printer.println(toString(a));
    }

}
