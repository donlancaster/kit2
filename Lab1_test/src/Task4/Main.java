package Task4;

import java.util.Scanner;
import java.util.regex.Pattern;

import static Task4.PhoneType.OFFICIAL;
import static Task4.PhoneType.SUBSCRIBER;

public class Main {



    static Scanner sc = new Scanner(System.in);
    static LinkedList<Integer> doublyLinkedList = new LinkedList<>();
    static SingleList singleLinkedList = new SingleList();
    static Iterator<Integer> iterator = new Iterator<>(doublyLinkedList);

    public static void main(String[] args) {
        menu();
    }


    static void menu() {
        String controller;
        System.out.println("1. Add\n2. Show \n3. Delete \n4. Show without spec.services" +
                " \n5. Create list without spec.services \n6. Exit ");
        while (true) {
            String regex = "\\d";
            controller = sc.nextLine().trim();
            if (!Pattern.matches(regex, controller) || Integer.parseInt(controller) > 6 || Integer.parseInt(controller) <= 0)
                continue;
            break;
        }
        switch (controller) {
            case "1":
                System.out.println("Тип номера \n1.Служебный \n2.Обычный");
                int num = sc.nextInt();
                PhoneType type = null;
                switch (num) {
                    case 1:
                        type = OFFICIAL;
                        break;
                    case 2:
                        type = SUBSCRIBER;
                        break;
                }
                System.out.println("Номер");
                int number = sc.nextInt();
                doublyLinkedList.addLast(number, type);
                break;
            case "2":
                iterator.reset();
                while (iterator.getCurrent() != null) {
                    System.out.println(iterator.getCurrent().item + " " + iterator.getCurrent().type);
                    iterator.nextNode();
                }
                System.out.println("\n");
                break;
            case "3":
                iterator.reset();
                while (iterator.getCurrent() != null) {
                    System.out.println(iterator.getCurrent().item + " " + iterator.getCurrent().type);
                    iterator.nextNode();
                }
                System.out.println("\n");
                System.out.println("Порядковый номер удаляемого ");
                number = sc.nextInt();
                doublyLinkedList.deleteIndex(number);
                break;
            case "4":
                for (int i = 0; i < singleLinkedList.size(); i++) {
                    System.out.println(singleLinkedList.get(i));
                }
                break;
            case "5":
                for (int i = doublyLinkedList.size() - 1; i >= 0; i--) {
                    if (doublyLinkedList.get(i).type.equals(SUBSCRIBER))
                        singleLinkedList.add(doublyLinkedList.get(i).item, doublyLinkedList.get(i).type);
                }
                System.out.println("\n");
                break;

            case "6":
                System.exit(0);
        }
    }
}