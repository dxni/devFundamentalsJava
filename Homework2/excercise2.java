import java.util.Arrays;

public class excercise2 {

    public static void main(String args[]) {

        /* Exersice 1 - Minimum, maximum, and average of an int array */
        int[] A = { 32, 4, 1, 2, 1, 6, 32, 23, 25, 32 };
        int mini = A[0];
        int maxi = A[0];
        int sum = 0;
        int average;
        // en un for se busca el mayor, el menor y la media

        for (int i = 0; i < A.length; i++) {
            maxi = Math.max(maxi, A[i]);
            mini = Math.min(mini, A[i]);
            sum = sum + A[i];
        }
        average = (sum / A.length);
        System.out.println("*Exersice 1 result:");
        System.out.println("The max value:" + maxi);
        System.out.println("The min value is:" + mini);
        System.out.println("The average is:" + average);

        /* Exersice 2 - Count repeating words in a string */

        String sentence = "miau te amo gato te amo  perro gato te amo mucho mucho gato";
        String[] words = sentence.split(" ");
        int cont = 1;
        System.out.println("*Exersice 2 result:");
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    cont = cont + 1;
                    words[j] = "0";
                }
            }
            if (words[i] != "0" && cont > 1)

                System.out.println(words[i] + " : " + cont);
            cont = 1;
        }

        /* Exersice 3 - Checking whether two strings are anagrams */

        String input1 = "LIST EN";
        String input2 = "si lent";
        System.out.println("*Exersice 3 result:");
        System.out.println(
                "Are the -" + input1 + "- and -" + input2 + "- strings anagrams? .... " + isAnagram(input1, input2));
    
    /* Exersice 4 -  */
                
    }

    static boolean isAnagram(String input1, String input2) {
        char[] input1Array = input1.toLowerCase().toCharArray();
        char[] input2Array = input2.toLowerCase().toCharArray();
        Arrays.sort(input1Array);
        Arrays.sort(input2Array);
        return Arrays.equals(input1Array, input2Array);
    }




}