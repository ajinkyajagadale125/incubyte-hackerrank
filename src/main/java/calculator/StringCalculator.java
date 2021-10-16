package calculator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StringCalculator {

    int calledCount=0;
    public int add(String input)  {
        calledCount++;
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
            Stream<Integer> integerStream = Arrays.stream(input.split(",|\n" + customDelimiter)).map(Integer::parseInt);
            List<Integer> neg = integerStream.filter(x -> x > -1).collect(Collectors.toList());
            if (!neg.isEmpty())
                throw new RuntimeException("negatives not allowed - " + neg.stream().map(Objects::toString).collect(Collectors.joining(",")));
            Optional<Integer> z = integerStream.reduce(Integer::sum);
            return z.get();
        }


        return 0;
    }
    public int getCalledCount(){
        return this.calledCount;
    }

}