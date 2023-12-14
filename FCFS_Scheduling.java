import java.util.Scanner;

public class FCFS_Scheduling {

    static void calculateTurnaroundTime(int[] arrivalTime, int[] burstTime, int[] turnaroundTime, int[] waitingTime) {
        int n = arrivalTime.length;
        int currentTime = 0;

        for (int i = 0; i < n; i++) {
            turnaroundTime[i] = currentTime - arrivalTime[i] + burstTime[i];
            waitingTime[i] = turnaroundTime[i] - burstTime[i];
            currentTime += burstTime[i];
        }
    }

    static void printSummary(int[] turnaroundTime, int[] waitingTime) {
        int n = turnaroundTime.length;

        System.out.println("Process\tTurnaround Time\tWaiting Time");
        System.out.println("--------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t\t" + turnaroundTime[i] + "\t\t\t" + waitingTime[i]);
        }

        double averageTurnaroundTime = calculateAverage(turnaroundTime);
        double averageWaitingTime = calculateAverage(waitingTime);

        System.out.println("\nAverage Turnaround Time: " + averageTurnaroundTime);
        System.out.println("Average Waiting Time: " + averageWaitingTime);
    }

    static double calculateAverage(int[] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return (double) sum / array.length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of processes: ");
        int n = scanner.nextInt();

        int[] arrivalTime = new int[n];
        int[] burstTime = new int[n];
        int[] turnaroundTime = new int[n];
        int[] waitingTime = new int[n];

        // Input arrival time dan  burst time setiap proses
        for (int i = 0; i < n; i++) {
            System.out.print("Enter arrival time for Process " + (i + 1) + ": ");
            arrivalTime[i] = scanner.nextInt();

            System.out.print("Enter burst time for Process " + (i + 1) + ": ");
            burstTime[i] = scanner.nextInt();

           // System.out.print("Enter burst time for Process " + (i + 1) + ": ");
            //burstTime[i] = scanner.nextInt();
        }

        // kalkulasiturnaround time and waiting time
        calculateTurnaroundTime(arrivalTime, burstTime, turnaroundTime, waitingTime);

        // hasil penjadwalan
        System.out.println("\nFCFS Scheduling Summary:");
        printSummary(turnaroundTime, waitingTime);

        scanner.close();
    }
}
