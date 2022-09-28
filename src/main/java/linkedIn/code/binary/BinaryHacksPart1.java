package linkedIn.code.binary;

/**
 * Created by PDeb on 11/1/2017.
 */
public class BinaryHacksPart1 {
    public void isIntegerEvenOrOdd(int number)
    {
        if((number & 1) ==0)
            System.out.println(number +" is Even");
        else
            System.out.println(number +" is Odd");
    }

    public void twoIntegersHaveOppositeSign(int num1, int num2){
        if((num1^num2) < 0)
            System.out.println(num1+" and "+num2+ " have opposite sign");
        else
            System.out.println(num1+" and "+num2+ " do not have opposite sign");
    }

    void add1OrSubtractToInteger(int num)
    {
        System.out.println(num+" after adding 1 is "+ -~num);
        System.out.println(num+" after subtracting 1 is "+ ~-num);
    }

    void swapNumbers(int x, int y)
    {
        System.out.println("Before "+ x +" and "+y);
        x = x^y;
        y = y^x;
        x = x^y;
        System.out.println("After "+ x +" and "+y);
    }

    public static void main(String[] args) {
        BinaryHacksPart1 binaryHacksPart1 = new BinaryHacksPart1();
        binaryHacksPart1.isIntegerEvenOrOdd(3);

        binaryHacksPart1.twoIntegersHaveOppositeSign(4, -8);
        binaryHacksPart1.twoIntegersHaveOppositeSign(4, 6);

        binaryHacksPart1.add1OrSubtractToInteger(0);

        binaryHacksPart1.swapNumbers(10, 15);
    }
}
