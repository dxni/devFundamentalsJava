import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashSet;
import java.util.Set;

public class RegularExpresionExtractorphoneValidator {
    public static void main(String[] args) throws IOException {
        /* the new fix */
        Pattern numberRegex = Pattern.compile("^(\\(?\\d{2,4}\\)?)[-.\\s]?(\\d{1,4})[-.\\s]?(\\d{3}[-.\\s]?\\d{4})$",
                Pattern.MULTILINE);

        String text = Files.readString(Path.of("phoneNumbers.txt"));
        ArrayList<String> operatorCode = new ArrayList<>();
        ArrayList<String> cityCode = new ArrayList<>();
        ArrayList<String> phoneNumber = new ArrayList<>();
        Matcher matcher = numberRegex.matcher(text);

        while (matcher.find()) {
            operatorCode.add(matcher.group(1));
            cityCode.add(matcher.group(2));
            phoneNumber.add(matcher.group(3));

        }

        Set<String> clearoperator = new HashSet<String>(operatorCode);
        operatorCode.clear();
        operatorCode.addAll(clearoperator);

        Set<String> clearCitycode = new HashSet<String>(cityCode);
        cityCode.clear();
        cityCode.addAll(clearCitycode);

        Set<String> clearPhone = new HashSet<String>(phoneNumber);
        phoneNumber.clear();
        phoneNumber.addAll(clearPhone);

        System.out.println("Operator codes are: "+operatorCode);
        System.out.println("City codes are: "+cityCode);
        System.out.println("Phones number are: "+phoneNumber);

    }

}