import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("input car names : ");
        String names = sc.next();
        System.out.print("input how many times to loop : ");
        int loopTimes = sc.nextInt();

        Racing racing = new Racing(names, loopTimes, new RandomNumBiggerThanCondition(4));
        racing.race();

        UI.drawWinner(racing.getWinner());

    }
}
