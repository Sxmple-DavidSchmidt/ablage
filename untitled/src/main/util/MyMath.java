package main.util;

public class MyMath {
    public static int fibonacci(int iterations) {
        int current = 1;
        int last = 0;

        while(iterations > 0) {
            current += last;
            last = current - last;
            iterations--;
        }

        return last;
    }

    public static int add(int num1, int num2) {
        return num1 + num2;
    }

    public static char getGrade(int points) {
        if (points < 0)
            throw new IllegalArgumentException(
                    "Points can't be smaller than 0"
            );
        if (points < 60) return 'F';
        if (points < 70) return 'D';
        if (points < 80) return 'C';
        if (points < 90) return 'B';
        return 'A';
    }

    public static int findNumberInArray(int number, int[] numbers) {
        if (numbers.length == 0) return -1;

        for (int i = 0; i < numbers.length; i++)
            if (numbers[i] == number) return i;

        return -1;
    }
}