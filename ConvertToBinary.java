
import java.util.Scanner;

public class ConvertToBinary {

    public void convert(int number) {
        // it is used to handle the 0 case
        if (number == 0) {
            System.out.println("Binary representation of number is : 0");
            return;
        }

        StringBuilder binaryValue = new StringBuilder();
        int tempnumber = Math.abs(number);

        while (tempnumber > 0) {
            binaryValue.insert(0, tempnumber % 2);
            // Dividing  the number by 2 to get the next bit 
            tempnumber /= 2;
        }

        // If our original number was negative, append '-' to the binary representation
        if (number < 0) {
            binaryValue.insert(0, "-");
        }

        System.out.println("Binary representation of the number Entered is " + binaryValue.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get integer input from the user
        System.out.print("Enter an integer ");
        int inputNumber = sc.nextInt();

        // Create an instance of ConvertToBinary and convert the number
        ConvertToBinary converter = new ConvertToBinary();
        converter.convert(inputNumber);

        sc.close();
    }
}
