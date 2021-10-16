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
        if (input.length()==1){
            return Integer.parseInt(input);
        }
        if (input.length()>1){
            Optional<Integer> z = Arrays.stream(input.split(",")).map(Integer::parseInt).reduce(Integer::sum);
            return z.get();
        }


        return 0;
    }

}