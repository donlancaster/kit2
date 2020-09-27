package Task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedListRing listRing = new LinkedListRing();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int N = sc.nextInt();
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        for (int i = 1; i <= N; i++) {
            listRing.add(i);
        }

        int[] kids = new int[N];
        for (int i = 0; i < N; i++) {
            kids[i] = i + 1;
        }

        int kidsLeft = N;
        int cnt = 1;

        Iterator iterator = new Iterator(listRing);
        iterator.reset();

        while (kidsLeft != 1) {
            if (cnt % k == 0) {
                for (int tmp : kids) {
                    if (tmp != 0) System.out.print(tmp + " ");
                }
                System.out.println("\n");
                int deleting = iterator.getCurrent().num;
                iterator.remove();
                kidsLeft--;
                for (int i = 0; i < kids.length; i++) {
                    if (kids[i] == deleting) kids[i] = 0;
                }
            }
            cnt++;
            iterator.next();
        }
        for (int tmp : kids) {
            if (tmp != 0) System.out.print(tmp + " ");
        }
        System.out.println("\n");
    }
}
