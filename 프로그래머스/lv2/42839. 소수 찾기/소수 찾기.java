import java.util.*;

class Solution {

  Set<Integer> set = new HashSet<>();
  boolean[] visits;
  String[] arr;

  public int solution(String numbers) {

    arr = numbers.split("");
    visits = new boolean[numbers.length()];

    for (int i=1; i<=arr.length; i++) {
      findPrimeNumberCount(i, "");
    }

    System.out.println(set);

    return set.size();

  }

  public void findPrimeNumberCount(int size, String num) {

    if (num.length() == size) {

      int n = Integer.parseInt(num);

      if (isPrime(n)) {
        set.add(n);
      }

      return;

    }

    for (int i=0; i<arr.length; i++) {

      if (visits[i]) {
        continue;
      }

      visits[i] = true;
      findPrimeNumberCount(size, num + arr[i]);
      visits[i] = false;

    }

  }

  public boolean isPrime(int n) {

    if (n <= 1) {
      return false;
    }
    
    if (n == 2) {
      return true;
    }

    for (int i = 2; i <= Math.sqrt(n); i++) {
      
      if (n % i == 0) {
        return false;
      }

    }
    return true;
  }
}