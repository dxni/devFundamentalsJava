public class homeWorkOne{
    public static void main (String []args){
        int n= 2;
        String word= "a";
         
        System.out.println("El resultado es: " +largestNumber(n));
        int year = 2012;
        System.out.println("el centenario es: "+centuryFromYear(year));

        if (checkPalindrome(word)== true){
            System.out.println("La Palabra "+word+" ...es Palindrome");
        }
        else{
            System.out.println("La Palabra "+word+" ...No es Palindrome");
        }




}

public static int largestNumber(int n){
        
    return (int) Math.pow(10, n)-1;
}

public static int centuryFromYear(int year){
    return ((year-1)/100)+1;

}

public static String invertirPalabra(String word){
    String aux="";
    for (int i=word.length()-1; i>=0 ; i--){
            aux=aux+ word.charAt(i);

    }
    
    return aux;

}

public static boolean checkPalindrome (String word){
    
    
    if (word.equals(invertirPalabra(word))){
        return true;
    }
    else
    {
        return false;
}
}    

}