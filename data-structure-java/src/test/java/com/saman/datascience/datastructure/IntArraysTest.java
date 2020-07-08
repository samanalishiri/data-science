package com.saman.datascience.datastructure;

import org.junit.Test;

import java.util.Map;

import static com.saman.datascience.datastructure.IntArrays.common;
import static com.saman.datascience.datastructure.IntArrays.contains;
import static com.saman.datascience.datastructure.IntArrays.copy;
import static com.saman.datascience.datastructure.IntArrays.count;
import static com.saman.datascience.datastructure.IntArrays.findNMaximums;
import static com.saman.datascience.datastructure.IntArrays.findNthMaximum;
import static com.saman.datascience.datastructure.IntArrays.getEvens;
import static com.saman.datascience.datastructure.IntArrays.getIndices;
import static com.saman.datascience.datastructure.IntArrays.getOdds;
import static com.saman.datascience.datastructure.IntArrays.getRepetitive;
import static com.saman.datascience.datastructure.IntArrays.groupingBy;
import static com.saman.datascience.datastructure.IntArrays.leftRotation;
import static com.saman.datascience.datastructure.IntArrays.leftShift;
import static com.saman.datascience.datastructure.IntArrays.reverse;
import static com.saman.datascience.datastructure.IntArrays.rightRotation;
import static com.saman.datascience.datastructure.IntArrays.rightShift;
import static com.saman.datascience.datastructure.IntArrays.subtract;
import static com.saman.datascience.datastructure.IntArrays.union;
import static com.saman.datascience.datastructure.IntArrays.xor;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IntArraysTest {

    @Test
    public void leftShift_WithArrayAsFirstParamAndStepAsSecondParam_ShiftTheElementsAboutStepNumber() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        leftShift(a, 2);
        assertArrayEquals(new int[]{3, 4, 5, 6, 7, 8, 9, 0, 0}, a);
    }

    @Test
    public void leftRotation_WithSortedArrayAsFirstParam_MoveTowFirstElementsToTheEndOfArray() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        leftRotation(a, 2);
        assertArrayEquals(new int[]{3, 4, 5, 6, 7, 8, 9, 1, 2}, a);
    }

    @Test
    public void rightRotation_WithSortedArrayAsFirstParam_MoveTowEndElementsToTheStartOfArray() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        rightRotation(a, 2);
        assertArrayEquals(new int[]{8, 9, 1, 2, 3, 4, 5, 6, 7}, a);
    }

    @Test
    public void rightShift_WithSortedArrayAsFirstParam_AddTwoZeroAtTheStartOfArray() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        rightShift(a, 2);
        assertArrayEquals(new int[]{0, 0, 1, 2, 3, 4, 5, 6, 7}, a);
    }

    @Test
    public void reverse_WithArrayWithOddLength_InverseArray() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        reverse(a);
        assertArrayEquals(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, a);
    }

    @Test
    public void reverse_WithArrayWithEvenLength_InverseArray() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        reverse(a);
        assertArrayEquals(new int[]{8, 7, 6, 5, 4, 3, 2, 1}, a);
    }

    @Test
    public void findNMaximums_WithUnsortedArrayAsFirstParam_ReturnMaximumSetOfArray() {
        int[] a = {5, 6, 6, 8, 4, 2, 3, 9, 4, 1, 2, 7};
        int[] maximums = findNMaximums(a, 3);
        assertArrayEquals(new int[]{7, 8, 9}, maximums);
    }

    @Test
    public void findNMaximums_WithSortedArrayAsFirstParam_ReturnMaximumSetOfArray() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] maximums = findNMaximums(a, 3);
        assertArrayEquals(new int[]{7, 8, 9}, maximums);
    }

    @Test
    public void findNthMaximum_WithSortedArrayAsFirstParam_ReturnNthMaximumOfArray() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int thirdMaximum = findNthMaximum(a, 3);
        assertEquals(7, thirdMaximum);
    }

    @Test
    public void getOdds_WithSortedArrayAsParam_ReturnOddsNumber() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] odds = getOdds(a);
        assertArrayEquals(new int[]{1, 3, 5, 7, 9}, odds);
    }

    @Test
    public void getEvens_WithSortedArrayAsParam_ReturnOddsNumber() {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] evens = getEvens(a);
        assertArrayEquals(new int[]{2, 4, 6, 8}, evens);
    }

    @Test
    public void groupingBy_WithUnsortedArrayAsParam_ReturnRepeatedElementsWithCountingAsMap() {
        int[] a = {5, 6, 6, 8, 4, 2, 3, 9, 4, 1, 2, 7};
        Map<Integer, Long> groups = groupingBy(a);
    }

    @Test
    public void count_WithUnsortedArrayAsFirstParamAndNumberAsSecondParam_ReturnCountOfNumber() {
        int[] a = {5, 6, 6, 8, 4, 2, 3, 9, 4, 1, 2, 7};
        long count = count(a, 6);
        assertEquals(2, count);
    }

    @Test
    public void contains_ThereIsNumberInTheArray_ReturnTrue() {
        int[] a = {5, 6, 6, 8, 4, 2, 3, 9, 4, 1, 2, 7};
        boolean contains = contains(a, 6);
        assertTrue(contains);
    }

    @Test
    public void contains_ThereIsNoNumberInTheArray_ReturnFalse() {
        int[] a = {5, 6, 6, 8, 4, 2, 3, 9, 4, 1, 2, 7};
        boolean contains = contains(a, 10);
        assertFalse(contains);
    }

    @Test
    public void getRepetitive_CheckWhichElementsAreRepeated_ReturnThemAsArray() {
        int[] a = {5, 6, 6, 8, 4, 2, 3, 9, 4, 1, 2, 7};
        int[] repetitive = getRepetitive(a);
        assertArrayEquals(new int[]{2, 4, 6}, repetitive);

    }

    @Test
    public void getIndices_WithUnsortedArrayAsFirstParamAndNumberAsSecondParam_ReturnIndicesArray() {
        int[] a = {5, 6, 6, 8, 4, 2, 3, 6, 9, 4, 1, 2, 7};
        int[] indices = getIndices(a, 6);
        assertArrayEquals(new int[]{1, 2, 7}, indices);

    }

    @Test
    public void union_WithTwoArrayAsParams_ReturnUnionOfTwoArrays() {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {6, 7, 8, 9, 10};
        int[] union = union(a, b);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, union);
    }

    @Test
    public void common_WithTwoArrayAsParams_ReturnCommonElements() {
        int[] a = {1, 2, 3, 6, 5};
        int[] b = {3, 4, 5, 6, 7};
        int[] commons = common(a, b);
        assertArrayEquals(new int[]{3, 6, 5}, commons);
    }

    @Test
    public void subtract_WithTwoArrayAsParams_ReturnCommonElements() {
        int[] a = {1, 8, 2, 6, 5};
        int[] b = {3, 4, 5, 6, 7};
        int[] subtract = subtract(a, b);
        assertArrayEquals(new int[]{1, 8, 2}, subtract);
    }

    @Test
    public void xor_WithArrayAsParams_ReturnXorArray() {
        int[] a = {2, 4, 1, 3, 5};
        xor(a);
        assertArrayEquals(new int[]{3, 5, 0, 2, 4}, a);
    }


    @Test
    public void copy_WithArrayAsParams_ReturnCopyArray() {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = copy(a);
        assertFalse(a == b);
    }
}