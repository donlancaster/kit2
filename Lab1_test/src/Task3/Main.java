package Task3;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static LinkedList linkedList = new LinkedList();
    public static Iterator iterator = new Iterator(linkedList);

    public static void main(String[] args) {
        linkedList.add("2222222", "Garkun Ivan");
        linkedList.add("1234576", "Shevchenko Daniil");
        menu();
    }

    static void add(LinkedList list, String number, String name) {
        iterator.reset();
        if (list.isEmpty()) {
            list.add(number, name);
            return;
        }
        if (name.compareTo(list.getFirst().sub.name) <= 0) {
            list.insertFirst(number, name);
            return;
        }
        if (name.compareTo(list.getLast().sub.name) >= 0) {
            list.insertLast(number, name);
            return;
        }
        while (iterator.getCurrent() != null) {
            if (name.compareTo(iterator.getCurrent().sub.name) < 0) {
                iterator.insertBefore(number, name);
                return;
            }
            iterator.nextNode();
        }
        iterator.reset();
    }

    static LinkedList searchByName(String name, LinkedList list) {
        iterator.reset();
        LinkedList phones = new LinkedList();
        while (iterator.getCurrent() != null) {
            String[] tmp = iterator.getCurrent().sub.name.split(" ");
            String currName = tmp[0];
            if (currName.equals(name)) {
                System.out.print("yes");
                phones.add(iterator.getCurrent().sub.number, iterator.getCurrent().sub.name);
            }
            iterator.nextNode();
        }
        iterator.reset();
        return phones;
    }

    static String searchByNumber(String number, LinkedList list) {
        iterator.reset();
        while (iterator.getCurrent() != null) {
            if (iterator.getCurrent().sub.number.equals(number)) {
                String name = iterator.getCurrent().sub.name;
                String[] tmp = name.split(" ", 2);
                name = tmp[0];
                return name;
            }
            iterator.nextNode();
        }
        iterator.reset();
        return null;
    }


    static void show(LinkedList list) {
        Iterator printer = new Iterator(list);
        printer.reset();
        int index = 0;
        System.out.println("-----------------------------------------------");
        while (printer.getCurrent() != null) {
            System.out.printf("|%-3d|%s%-30s|%9s|\n", index, " ", printer.getCurrent().sub.name, printer.getCurrent().sub.number);
            System.out.println("-----------------------------------------------");
            printer.nextNode();
            index++;
        }
    }

    public static void menu() {
        String controller;
        System.out.println("\nChoose an option:\n1. Add subscriber\n2. Delete\n" +
                "3. Show\n4. Search by number\n5. Search by name\n6. Exit\n");
        while (true) {
            String regex = "\\d";
            controller = sc.nextLine().trim();
            if (!Pattern.matches(regex, controller) || Integer.parseInt(controller) > 6 || Integer.parseInt(controller) <= 0)
                continue;
            break;
        }
        String name, number;
        int index;
        switch (controller) {
            case "1":
                System.out.print("Name: ");
                name = sc.nextLine();
                System.out.print("\nNumber: ");
                number = sc.nextLine();
                add(linkedList, number, name);
                break;
            case "2":
                show(linkedList);
                System.out.print("index: ");
                index = sc.nextInt();
                linkedList.delete(index);
                break;
            case "3":
                show(linkedList);
                break;
            case "4":
                System.out.print("Number: ");
                number = sc.nextLine();
                System.out.print("\n" + searchByNumber(number, linkedList) + "\n");
                break;
            case "5":
                System.out.print("Name: ");
                name = sc.nextLine();
                show(searchByName(name, linkedList));
                System.out.println();
                break;
            case "6":
                System.exit(0);
                break;
        }
        menu();
    }
}
