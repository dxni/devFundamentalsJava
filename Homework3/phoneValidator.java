import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class phoneValidator {  
    public static void main(String[] args) {
        /*the new fix */
        Pattern passwPattern= Pattern.compile("^\\d{2,4}\\s\\d{2,4}\\s\\d{7}$|^\\d{2,4}-\\d{2,4}-\\d{3}-\\d{4}$|^\\d{2,4}.\\d{2,4}.\\d{3}.\\d{4}$|^\\(?\\d{4}\\)\\s\\d{2,4}\\s\\d{7}$|^\\(?\\d{4}\\)\\d{9}?|^\\d{13}$");
        while(true){
            
            String numberP = System.console().readLine("Enter the phone: ");
            Matcher matcher = passwPattern.matcher(numberP);
            if (matcher.matches()== true){
                System.out.println("It`s valid the number... "+numberP);    
            }
            else{
                System.out.println("It is NOT valid the number... "+numberP);  
            }
            
        }
    }
} 