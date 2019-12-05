import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegularExpresionExtractorIPValidator {
    public static void main(String[] args) throws IOException {
        /* the new fix */
        Pattern numberRegex = Pattern.compile("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$",
                Pattern.MULTILINE);

        String text = Files.readString(Path.of("IpAdress.txt"));
        ArrayList<String> validIpAddress = new ArrayList<>();
        
        Matcher matcher = numberRegex.matcher(text);
        
        while(matcher.find()) {
            validIpAddress.add(matcher.group());
        }
        
        System.out.println("The valid IPV4 address are: "+validIpAddress);

        }
        
    }

