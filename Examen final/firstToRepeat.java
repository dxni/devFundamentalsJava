import java.util.HashSet;

public class firstToRepeat {

    public static void main(String[] args) {
        int[] numbers = {1,2,32,565,4};

        HashSet<Integer> valuesRevised = new HashSet<>();
        boolean flag = false;
        for (int value : numbers) {
            boolean success = valuesRevised.add(value);
            if (!success) {
                System.out.println("The first repeating number is: " + value);
                flag=false;
                break;
            }
            flag=true;
        }

        if (flag==true){
            System.out.println("No number is repeated: -1");
        }
    }
}