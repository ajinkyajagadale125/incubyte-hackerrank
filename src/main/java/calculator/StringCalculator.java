package calculator;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class StringCalculator {

    int calledCount=0;
    public int add(String input)  {
        calledCount++;
        if (input.equals("")){
            return 0;
        }
        String customDelimiter="";
        if (input.startsWith("//")){
            String delimiterString = input.substring(2, input.indexOf("\n"));

            if (delimiterString.contains("[")) {
                Integer startIndex=null;
                Integer endIndex = null;
                boolean flag=false;
                for (int i = 0; i < delimiterString.length(); i++) {
                    if(delimiterString.charAt(i)=='[' && !flag){
                        startIndex=i;
                        flag=true;
                    }
                    if(delimiterString.charAt(i)==']' && flag){
                        endIndex=i;
                        flag=false;
                        
                    }
                }
                if (startIndex!=null && endIndex!=null)
                    customDelimiter+=delimiterString.substring(startIndex+1,endIndex);

            }
            int newLineIndex = input.indexOf('\n');
            input = input.substring(newLineIndex + 1);
            customDelimiter+= String.valueOf(input.charAt(newLineIndex-1));
        }

        if (input.length()==1){
            return Integer.parseInt(input);
        }
        if (input.length()>1){
            Stream<Integer> integerStream = Arrays.stream(input.split(",|\n" + customDelimiter)).map(Integer::parseInt);
            List<Integer> neg = integerStream.filter(x -> x < 0).collect(Collectors.toList());
            if (!neg.isEmpty())
                throw new RuntimeException("negatives not allowed - " + neg.stream().map(Objects::toString).collect(Collectors.joining(",")));
            Optional<Integer> z = integerStream.filter(x->x<1001).reduce(Integer::sum);
            return z.get();
        }


        return 0;
    }
    public int getCalledCount(){
        return this.calledCount;
    }

}