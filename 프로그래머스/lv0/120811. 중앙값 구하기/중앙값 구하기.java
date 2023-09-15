import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        return array[array.length / 2];
    }
}