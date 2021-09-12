package org.vs.hackerrank;

import java.util.Arrays;

public class MinimumTimeRequired {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
        int count = 0;
        int days = 0;

        int day = 1;
        while (true) {
            for (int j = 0; j < machines.length; j++) {
                if (day % machines[j] == 0) {
                    count++;
                }
            }

            if (count >= goal) {
                days = day;
                break;
            }
            day++;
        }

        return days;
    }

    static long minTime1(long[] machines, long goal) {
        long[] sortedMachines = Arrays.stream(machines).sorted().toArray();
        int length = machines.length;

        long lowerbound = (long) Math.ceil((goal * sortedMachines[0]) / length);
        long upperbound = (long) Math.ceil((goal * sortedMachines[length - 1]) / length);

        System.out.println("lowerbound:" + lowerbound);
        System.out.println("upperbound:" + upperbound);

        while (lowerbound < upperbound) {
            long mid = (lowerbound + upperbound) / 2;
            long sum = 0;

            for (int i = 0; i < sortedMachines.length; i++) {
                sum += (mid / sortedMachines[i]);
            }

            System.out.println("mid:" + mid + "|sum:" + sum);
            if (sum == goal) {
                while (true) {
                    sum = 0;
                    long tempMid = mid - 1;
                    for (int i = 0; i < sortedMachines.length; i++) {
                        sum += (tempMid / sortedMachines[i]);
                    }

                    if (sum < goal) {
                        break;
                    } else {
                        mid = tempMid;
                    }
                }
                return mid;
            }

            if (sum > goal) {
                lowerbound = mid;
            } else {
                lowerbound = mid;
            }
        }

        return 0;
    }

    static long minTime2(long[] machines, long goal) {
        Arrays.sort(machines);
        int length = machines.length;
        long max = machines[length - 1];
        long min = machines[0];

        long minDays = (long) Math.ceil((min * goal) / length);
        long maxDays = (long) Math.ceil((max * goal) / length);
        long result = -1;

        while (minDays < maxDays) {
            long mid = (minDays + maxDays) / 2;
            long unit = 0;
            for (long machine : machines) {
                unit += mid / machine;
            }
            if (unit < goal) {
                minDays = mid + 1;
            } else {
                result = mid;
                maxDays = mid;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long[] arr = {1, 3, 4};
        System.out.println(minTime2(arr, 10));
    }
}
