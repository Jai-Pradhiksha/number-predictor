/*
A company XYZ wants to develop an app which can predict the lucky number for a person.
The name of the app is LuckyNumberPredictor. This app consists of a method - upon calling the person gets to know his/her lucky number.
This method calls another class —> NumberPredictor - which have the formula for predicting the lucky number of that person.
This approach is done so that no-one else gets to know the secret formula for this prediction.
LuckyNumberPredictor accepts only one argument i.e: date of birth of the person.
The formula for predicting the lucky number is quite simple
-> a person’s lucky number is calculated by rounding off the date of birth to the nearest Fibonacci number.
Another thought that XYZ company is having - is to predict unlucky number as well -
 but for this — for now, they don’t have any formula ready.
 But they want to have this idea to be stored in - in their NumberPredictor class.
 The company is asking you to develop this system.
*/

import java.util.Scanner;
import java.lang.String;
abstract class NumberPredictor {
    abstract boolean isFibonacci(int number);
    abstract int predictLuckyNumber(int dateOfBirth);
    abstract String predictUnluckyNumber(int dateOfBirth);
}

class LuckyNumberPredictor extends NumberPredictor {
    @Override
    public boolean isFibonacci(int number) {
        int a = 0, b = 1;
        while (b < number) {
            int c = b;
            b = a + b;
            a = c;
        }
        return b == number;
    }

    @Override
    public int predictLuckyNumber(int dateOfBirth) {
        int closestFibonacci = 0;
        for (int i = 1; i <= dateOfBirth; i++) {
            if (isFibonacci(i)) {
                closestFibonacci = i;
            }
        }
        return closestFibonacci;
    }

    @Override
    String predictUnluckyNumber(int dateOfBirth) {
        String message = "Your Unlucky number for "+dateOfBirth+" is not available now.";
        return message;
    }
}
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your date of birth: ");
        int dateOfBirth = scanner.nextInt();

        LuckyNumberPredictor predictor = new LuckyNumberPredictor();

        int luckyNumber = predictor.predictLuckyNumber(dateOfBirth);
        System.out.println("Your lucky number is: " + luckyNumber);
        System.out.println(predictor.predictUnluckyNumber(dateOfBirth));

    }
}
