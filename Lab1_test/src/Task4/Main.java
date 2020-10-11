package Task4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

import static Task4.PhoneType.SPECIAL;
import static Task4.PhoneType.DEFAULT;

public class Main {


    static Scanner sc = new Scanner(System.in);
    static LinkedList<Integer> doublyLinkedList = new LinkedList<>();
    static SingleList singleLinkedList = new SingleList();
    static Iterator<Integer> iterator = new Iterator<>(doublyLinkedList);

    public static void main(String[] args) {
        doublyLinkedList.addLast(1234567, DEFAULT);
        doublyLinkedList.addLast(7654332, DEFAULT);
        doublyLinkedList.addLast(4362623, DEFAULT);
        doublyLinkedList.addLast(1111111, DEFAULT);
        doublyLinkedList.addLast(5555555, DEFAULT);
        doublyLinkedList.addLast(123, SPECIAL);
        doublyLinkedList.addLast(101, SPECIAL);
        doublyLinkedList.addLast(102, SPECIAL);
        doublyLinkedList.addLast(103, SPECIAL);
        doublyLinkedList.addLast(104, SPECIAL);
        menu();
    }


    static void menu() {
        String controller;
        System.out.println("1. New subscriber\n2. Show subscribers list \n3. Delete subscriber \n4. Show new list without special services" +
                " \n5. Create new list without special services \n6. Exit ");
        while (true) {
            String regex = "\\d";
            controller = sc.nextLine().trim();
            if (!Pattern.matches(regex, controller) || Integer.parseInt(controller) > 6 || Integer.parseInt(controller) <= 0)
                continue;
            break;
        }
        switch (controller) {
            case "1":
                System.out.println("Choose number type: \n1. Special services \n2. Default");
                int num = sc.nextInt();
                PhoneType type = null;
                switch (num) {
                    case 1:
                        type = SPECIAL;
                        break;
                    case 2:
                        type = DEFAULT;
                        break;
                }
                System.out.print("\nEnter number:");
                int number = sc.nextInt();
                doublyLinkedList.addLast(number, type);
                break;
            case "2":
                iterator.reset();
                if (doublyLinkedList.isEmpty()) {
                    System.out.println("List is empty");
                    break;
                }
                System.out.println("\n\tSUB LIST:");
                while (iterator.getCurrent() != null) {
                    System.out.println(iterator.getCurrent().data + " " + iterator.getCurrent().type);
                    iterator.nextNode();
                }
                System.out.println("\n");
                break;

            case "3":
                iterator.reset();
                if (iterator.getCurrent() == null) {
                    System.out.println("List is empty");
                    break;
                }
                int cnt1=0;
                while (iterator.getCurrent() != null) {
                    System.out.println(cnt1+". "+iterator.getCurrent().data + " " + iterator.getCurrent().type);
                    iterator.nextNode();
                    cnt1++;
                }
                System.out.println("\n");
                System.out.print("Enter deleting index: ");
                number = sc.nextInt();

                while (true) {
                    if (number > doublyLinkedList.size() - 1) {
                        System.out.print("\nOut of bounds. Enter again:");
                        number = sc.nextInt();
                    } else break;
                }
                System.out.println();
                doublyLinkedList.deleteIndex(number);
                break;
            case "4":
                iterator.reset();
                if (iterator.getCurrent() == null || singleLinkedList.size() == 0) {
                    System.out.println("List is empty");
                    break;
                }
                System.out.println("New list without special services:");
                for (int i = 0; i < singleLinkedList.size(); i++) {
                    System.out.println(singleLinkedList.get(i));
                }
                break;
            case "5":
                singleLinkedList.clear();
                int cnt = 0;
                for (int i = doublyLinkedList.size() - 1; i >= 0; i--) {
                    if (doublyLinkedList.get(i).type.equals(DEFAULT)) {
                        cnt++;
                    }
                }
                int[] array = new int[cnt];
                for (int i = 0; i < cnt; i++) {
                    if (doublyLinkedList.get(i).type.equals(DEFAULT)) {
                        array[i] = doublyLinkedList.get(i).data;
                    }
                }
                Arrays.sort(array);
                for (int i = 0; i < cnt; i++) {
                    singleLinkedList.add(array[i], DEFAULT);
                }
                System.out.println("\n");
                break;

            case "6":
                System.exit(0);
                break;
        }
        menu();
    }


}