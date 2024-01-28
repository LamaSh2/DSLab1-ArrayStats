import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] arr1;
        int[] arr2;
        int size1 = 0, size2 = 0;
        Scanner input = new Scanner(System.in);

        while (size1 <= 0) {
            try {
                System.out.print("What is the size of the first array: ");
                size1 = input.nextInt();
                if (size1 <= 0) {
                    System.err.println("\nInvalid input. Please enter a positive integer value for the array size.\n");
                }
            } catch (InputMismatchException e) {
                System.err.println("\nInvalid input. Please enter an integer value for the array size.\n");
                input.nextLine();
            }
        }

        while (size2 <= 0) {
            try {
                System.out.print("What is the size of the second array: ");
                size2 = input.nextInt();
                if (size2 <= 0) {
                    System.err.println("\nInvalid input. Please enter a positive integer value for the array size.\n");
                }
            } catch (InputMismatchException e) {
                System.err.println("\nInvalid input. Please enter an integer value for the array size.\n");
                input.nextLine();
            }
        }

        arr1 = new int[size1];
        arr2 = new int[size2];

        System.out.println("Entering the first array values: ");
        arrayValues(arr1, size1, input);

        System.out.println("Entering the second array values: ");
        arrayValues(arr2, size2, input);

        input.nextLine();
        mainMenu();
        String choiceStr = input.nextLine();

        while (choiceStr.matches("\\d+")) {
            int choice = Integer.parseInt(choiceStr);

            switch (choice) {
                case 1:
                    System.out.println("The maximum of the first array is: " + maximum(arr1, size1));
                    System.out.println("The maximum of the second array is: " + maximum(arr2, size2));
                    break;
                case 2:
                    System.out.println("The minimum of the first array is: " + minimum(arr1, size1));
                    System.out.println("The minimum of the second array is: " + minimum(arr2, size2));
                    break;
                case 3:
                    System.out.println("The average of the first array is: " + average(arr1, size1));
                    System.out.println("The average of the second array is: " + average(arr2, size2));
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid choice.");
                    break;
            }

            mainMenu();
            choiceStr = input.nextLine();
        }

        input.close();
    }

    public static int maximum(int[] arr, int size) {
        int temp = arr[0];
        for (int i = 1; i < size; i++)
            if (arr[i] > temp)
                temp = arr[i];
        return temp;
    }

    public static int minimum(int[] arr, int size) {
        int temp = arr[0];
        for (int i = 1; i < size; i++)
            if (arr[i] < temp)
                temp = arr[i];
        return temp;
    }

    public static double average(int[] arr, int size) {
        int sum = 0;
        for (int i = 0; i < size; i++)
            sum += arr[i];
        return (double) sum / size;
    }

    public static void mainMenu() {
        System.out.println("Menu: \n1-Find the maximum\n2-Find the minimum\n3-Find the average\n(Press anything else to exit)\nYour choice: ");
    }

    public static int[] arrayValues(int[] arr, int size, Scanner input) {
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + i + " : ");
            try {
                arr[i] = input.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("\nInvalid input. Please enter an integer value.\n");
                input.nextLine();
                i--;
            }
        }
        return arr;
    }
}