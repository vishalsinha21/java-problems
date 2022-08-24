package org.vs.hackerrank;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;

public class PlusMinus {

    public static void main(String[] args) {
        plusMinus(List.of(-4, 3, -9, 0, 4, 1));
    }

    public static void plusMinus(List<Integer> arr) {
        int positive = 0;
        int negative = 0;
        int zero = 0;
        BigDecimal total = BigDecimal.valueOf(arr.size());

        for (Integer i: arr) {
            if (i == 0) {
                zero++;
            } else if (i > 0) {
                positive++;
            } else {
                negative++;
            }
        }

        BigDecimal positiveRatio = BigDecimal.valueOf(positive).divide(total, 6, RoundingMode.HALF_UP);
        System.out.println(positiveRatio);
        BigDecimal negativeRatio = BigDecimal.valueOf(negative).divide(total, 6, RoundingMode.HALF_UP);
        System.out.println(negativeRatio);
        BigDecimal zeroRatio = BigDecimal.valueOf(zero).divide(total, 6, RoundingMode.HALF_UP);
        System.out.println(zeroRatio);
    }

}
