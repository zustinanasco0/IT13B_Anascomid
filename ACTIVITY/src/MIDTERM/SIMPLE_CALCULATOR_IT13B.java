/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MIDTERM;



 
    import java.util.Scanner;

class Calculator {

    // Method for addition
    public double add(double x, double y) {
        return x + y;
    }

    // Method for subtraction
    public double subtract(double x, double y) {
        return x - y;
    }

    // Method for multiplication
    public double multiply(double x, double y) {
        return x * y;
    }

    // Method for division
    public double divide(double x, double y) {
        if (y != 0) {
            return x / y;
        } else {
            System.out.println("Error! Division by zero.");
            return Double.NaN; // Return NaN (Not a Number) to indicate error
        }
    }
}

public class  SIMPLE_CALCULATOR_IT13B{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculator calc = new Calculator();

        while (true) {
            System.out.println("\nSelect operation:");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Exit");

            System.out.print("Enter choice (1/2/3/4/5): ");
            int choice = scanner.nextInt();

            if (choice == 5) {
                System.out.println("Exiting the calculator. Goodbye!");
                break;
            }

            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            switch (choice) {
                case 1:
                    System.out.println(num1 + " + " + num2 + " = " + calc.add(num1, num2));
                    break;
                case 2:
                    System.out.println(num1 + " - " + num2 + " = " + calc.subtract(num1, num2));
                    break;
                case 3:
                    System.out.println(num1 + " * " + num2 + " = " + calc.multiply(num1, num2));
                    break;
                case 4:
                    double result = calc.divide(num1, num2);
                    if (!Double.isNaN(result)) {
                        System.out.println(num1 + " / " + num2 + " = " + result);
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
        scanner.close();
    }
}


