import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        
        Arrays.stream(s.split(""))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList())
                .forEach(sb::append);
        
        return sb.toString();
    }
}