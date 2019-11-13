import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegularExpresionExtractorphoneValidator {  
    public static void main(String[] args) throws IOException {
        Pattern phoneRegex=Pattern.compile("(\\(?\\d{2,4}\\)?[-.\\s]?\\d{2,4}[-.\\s]?\\d{7})|(\\(?\\d{2,4}\\)?[-.\\s]?\\d{2,4}+[-.\\s]?\\d{3}?[-.\\s]?\\d{4})|(\\(?\\d{2,4}\\)?[-.\\s]?\\d{1}[-.\\s]?\\d{3}?[-.\\s]?\\d{4})");
        
        String text = Files.readString(Path.of("phoneNumbers.txt"));
        ArrayList<String> phoneNumber = new ArrayList<>(); 
        Matcher matcher = phoneRegex.matcher(text);

        while(matcher.find()){
            phoneNumber.add(matcher.group());
        }

        System.out.println(phoneNumber);

        
    }
}