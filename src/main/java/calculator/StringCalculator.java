package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class StringCalculator {

    public int add(String input) {
        if (input.equals("")){
            return 0;
        }
        String customDelimiter;
        if (input.startsWith("//")){
            int newLineIndex = input.indexOf('\n');
            input = input.substring(newLineIndex + 1);
            customDelimiter= String.valueOf(input.charAt(newLineIndex-1));
        }
        else {
            customDelimiter="";
        }
        if (input.length()==1){
            return Integer.parseInt(input);
        }
        if (input.length()>1){
            Optional<Integer> z = Arrays.stream(input.split(",|\n"+customDelimiter)).map(Integer::parseInt).reduce(Integer::sum);
            return z.get();
        }


        return 0;
    }

}