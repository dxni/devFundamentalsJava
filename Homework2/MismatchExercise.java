import org.graalvm.compiler.replacements.nodes.ReadRegisterNode;

public class MismatchExercise {

    public static void main(String[] args) {
        int[] firstTestArrayOne = { 1, 2, 3, 4, 5, 6 };
        int[] firstTestArrayTwo = { 1, 2, 3, 4, 5, 6 };

        int resultFirstTest = mismatch(firstTestArrayOne, firstTestArrayTwo);
        System.out.println(resultFirstTest); // result should be -1

        int[] secondTestArrayOne = { 1, 2, 3, 4, 5, 6, 5 };
        int[] secondTestArrayTwo = { 1, 2, 3, 4, 2, 6, 3};

        int resultSecondTest = mismatch(secondTestArrayOne, secondTestArrayTwo);
        System.out.println(resultSecondTest); // result should be 4

    }

    public static int mismatch(int[] left, int[] right) {

        // Fill your code here
        int pos = -1;
        for (int i = 0; i < left.length; i++) {
            if (left[i] == right[i]) {

            } else {
                pos = i;
                break;
            }
        }
        return pos;

    }
}