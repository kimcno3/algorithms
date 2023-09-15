import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int length = sc.nextInt();
        Integer num;
        Integer result;
        for (int i=0; i<length; i++) {
            num = sc.nextInt();
            if (num != 0) {
                heap.add(num);
            } else {
                if (heap.size() == 0) {
                    System.out.println(0);
                } else {
                    result = heap.poll();
                    System.out.println(result);
                }
            }

        }

    }
}