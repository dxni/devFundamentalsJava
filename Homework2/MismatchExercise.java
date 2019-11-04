public class MismatchExercise {

    public static void main(String[] args) {
        int[] firstTestArrayOne = {1, 2, 3, 4, 5, 6};
        int[] firstTestArrayTwo = {1, 2, 3, 4, 5, 6};

        int resultFirstTest = mismatch(firstTestArrayOne, firstTestArrayTwo);
        System.out.println(resultFirstTest); //result should be -1


        int[] secondTestArrayOne = {1, 2, 3, 4, 5, 6};
        int[] secondTestArrayTwo = {1, 2, 3, 4, 2, 6};
        
        int resultSecondTest = mismatch(secondTestArrayOne, secondTestArrayTwo);
        System.out.println(resultSecondTest); //result should be 4


    }

    public static int mismatch(int[] left, int[] right) {
        //Fill your code here
        return -1;
    }
}