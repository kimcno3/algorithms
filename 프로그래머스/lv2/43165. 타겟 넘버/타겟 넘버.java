class Solution {

    private int answer;

    public int solution(int[] numbers, int target) {
        recursion(numbers, target, 0, 0);
        return answer;
    }

    private void recursion(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            if (sum == target) answer++;
            return;
        }
        recursion(numbers, target, index + 1, sum + numbers[index]);
        recursion(numbers, target, index + 1, sum - numbers[index]);
    }
}