package question;

import java.util.Scanner;

// import question.q1;
// import question.q2;
// import question.q3;
// import question.q4;
// import question.q5;

class Main {

    /**
     * @param msg
     * @param lower
     * @param upper
     * @return int
     */
    // secure input function that gets the int selection for menu with a
    // bullet-proof
    // error handling
    public static int get_selection(String msg, int lower, int upper) {
        boolean flag = false;
        int selection = 0;

        Scanner scanner = new Scanner(System.in);
        while (!flag) {
            if (!msg.isEmpty())
                System.out.printf("%s", msg);
            selection = scanner.nextInt();
            // System.out.println(scanner.next()); // remove unnecessary characters
            if (selection < lower || selection > upper) {
                System.out.printf("Invalid!%n");
                continue;
            }
            flag = true;
        }
        scanner.close();
        return selection;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("main");
    }
}
