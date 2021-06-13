package org.vs.ctci;

import org.vs.ctci.domain.Party;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AwesomeFunctions {

    //Returns frequency of each character in String or char array
    //Example "hello" would return {e=1, h=1, l=2, o=1}
    public static Map<Character, Long> getCharFrequencyMap(char[] chars) {
        if (chars == null || chars.length == 0) {
            return new HashMap<>();
        }
        Stream<Character> characterStream = IntStream.range(0, chars.length).mapToObj(i -> chars[i]);
        Map<Character, Long> characterLongMap = characterStream
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return characterLongMap;
    }

    //Group all parties for a order
    public static Map<BigInteger, List<Party>> getPartyMap(List<Party> parties) {
        return parties.stream().collect(Collectors.groupingBy(Party::getOrderId));
    }

}
