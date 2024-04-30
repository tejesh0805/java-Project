import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Expense> expenses = new ArrayList<>();

    while (true) {
      System.out.println("\nExpense Tracker");
      System.out.println("1. Add Expense");
      System.out.println("2. View Expenses");
      System.out.println("3. Exit");
      System.out.print("Enter your choice: ");

      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          addExpense(expenses, scanner);
          break;
        case 2:
          viewExpenses(expenses);
          break;
        case 3:
          System.out.println("Goodbye!");
          System.exit(0);
        default:
          System.out.println("Invalid choice.");
      }
    }
  }

  private static void addExpense(ArrayList<Expense> expenses, Scanner scanner) {
    System.out.print("Enter date (YYYY-MM-DD): ");
    String date = scanner.next();
    System.out.print("Enter description: ");
    String description = scanner.nextLine();
    scanner.nextLine(); // Consume extra newline character
    System.out.print("Enter amount: ");
    double amount = scanner.nextDouble();

    expenses.add(new Expense(date, description, amount));
    System.out.println("Expense added successfully.");
  }

  private static void viewExpenses(ArrayList<Expense> expenses) {
    if (expenses.isEmpty()) {
      System.out.println("No expenses found.");
      return;
    }

    System.out.println("\nExpenses:");
    for (Expense expense : expenses) {
      System.out.println(expense);
    }
  }
}

class Expense {
  String date;
  String description;
  double amount;

  public Expense(String date, String description, double amount) {
    this.date = date;
    this.description = description;
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "Date: " + date + ", Description: " + description + ", Amount: $" + amount;
  }
}
