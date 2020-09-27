package Task1;

import javax.sound.sampled.Line;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static LinkedList linkedList = new LinkedList();

    public static void main(String[] args) {
        linkedList.add(5, 5);
        linkedList.add(4, 4);
        linkedList.add(2, 2);
        linkedList.add(3, 3);
        linkedList.add(1, 0);
        menu();
    }

    static void show(LinkedList linkedList) {
        System.out.print("\nP(x) = ");
        for (int i = 0; i < linkedList.size(); i++) {
            Coefficients current = linkedList.get(i);
            if (i == linkedList.size() - 1) {

                System.out.print(current.a + "x^" + current.n);
                break;
            }

            System.out.print(current.a + "x^" + current.n + " + ");
        }
    }

    public static void menu() {
        String controller;
        System.out.println("\n\nChoose an option:\n1. Add polynomial coefficient\n2. Show polynomial\n3. Delete\n4. Edit\n5. func Equality\n" +
                "6. func Meaning\n7. func Add\n8. Exit\n ");

        while (true) {
            String regex = "\\d";
            controller = sc.nextLine().trim();
            if (!Pattern.matches(regex, controller) || Integer.parseInt(controller) > 8 || Integer.parseInt(controller) <= 0)
                continue;
            break;
        }
        int index, a, n;
        switch (controller) {

            case "1":
                System.out.print("Adding\na = ");
                a = sc.nextInt();
                System.out.print("n = ");
                n = sc.nextInt();
                linkedList.add(a, n);
                break;
            case "2":
                show(linkedList);
                break;
            case "3":
                show(linkedList);
                System.out.print("\nIndex: ");
                index = sc.nextInt();
                linkedList.delete(index);
                break;
            case ("4"):
                show(linkedList);
                System.out.print("Index: ");
                index = sc.nextInt();
                System.out.print("\nnew a = ");
                a = sc.nextInt();
                System.out.print("\nnew n = ");
                n = sc.nextInt();
                linkedList.get(index).a = a;
                linkedList.get(index).n = n;
                break;
            case ("5"):
                // LinkedList p = new LinkedList();
                LinkedList q = new LinkedList();
                //    System.out.print("\nsize p = ");
                //int size_p = sc.nextInt();
                show(linkedList);
                System.out.print("\nsize q = ");
                int size_q = sc.nextInt();
                if (linkedList.size() != size_q) {
                    System.out.println(false);
                    break;
                }
                //   System.out.print("\nPolynomial p:\n");
                //    eqAdd(p, size_p);
                System.out.print("\nPolynomial q:\n");
                eqAdd(q, size_q);
                System.out.println("\n" + equality(linkedList, q));
                break;
            case "6":
                show(linkedList);
                System.out.print("\nx = ");
                int x = sc.nextInt();
                System.out.println(meaning(linkedList, x));
                break;
            case "7":
                LinkedList res = new LinkedList();
                LinkedList list_r = new LinkedList();
                LinkedList list_q = new LinkedList();
                System.out.print("\nList R size = ");
                int r_size = sc.nextInt();
                for (int i = 0; i < r_size; i++) {
                    System.out.print("R: a[" + i + "] = ");
                    a = sc.nextInt();
                    System.out.print("R: n[" + i + "] = ");
                    n = sc.nextInt();
                    list_r.add(a, n);
                }
                System.out.print("\nList Q size = ");
                int q_size = sc.nextInt();
                for (int i = 0; i < q_size; i++) {
                    System.out.print("Q: a[" + i + "] = ");
                    a = sc.nextInt();
                    System.out.print("Q: n[" + i + "] = ");
                    n = sc.nextInt();
                    list_q.add(a, n);
                }
                add_func(res, list_r, list_q);
                show(res);
                break;

            case "8":
                System.exit(0);
        }
        menu();
    }

    private static LinkedList add_func(LinkedList res, LinkedList list_r, LinkedList list_q) {
        int highestDegree = Math.max(list_r.highestDegree, list_q.highestDegree);
        for (int i = highestDegree; i >= 0; i--) {
            res.add(list_r.getA(i) + list_q.getA(i), i);
        }
        return res;
    }

    private static int meaning(LinkedList list, int x) {
        if (list.size() == 0) return 0;
        int answer = 0;
        for (int i = 0; i < list.size(); i++) {
            answer += list.get(i).a * Math.pow(x, list.get(i).n);
        }
        return answer;
    }

    private static void eqAdd(LinkedList name, int size) {
        int a;
        int n;
        for (int i = 0; i < size; i++) {
            System.out.print("a[" + i + "] = ");
            a = sc.nextInt();
            System.out.print("n[" + i + "] = ");
            n = sc.nextInt();
            name.add(a, n);
        }
    }

    public static boolean equality(LinkedList p, LinkedList q) {
        if (p.size() != q.size()) return false;
        else {
            for (int i = 0; i < p.size(); i++) {
                Coefficients current = p.get(i);
                boolean bool = false;
                for (int j = 0; j < q.size(); j++) {
                    if ((p.get(i).a == q.get(j).a) && (p.get(i).n == q.get(j).n)) bool = true;
                }
                if (!bool) return false;
            }
        }
        return true;
    }
}
