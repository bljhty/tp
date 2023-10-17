package seedu.duke.commands;

import seedu.duke.financialrecords.Expense;
import seedu.duke.financialrecords.Income;

import java.util.ArrayList;

public class ListCommand extends Commands {
    private ArrayList<Income> incomes;
    private ArrayList<Expense> expenses;

    private double totalIncome;
    private double totalExpenses;

    public ListCommand(ArrayList<Income> incomes, ArrayList<Expense> expenses) {
        this.incomes = incomes;
        this.expenses = expenses;
        totalIncome = 0;
        totalExpenses = 0;
    }
    @Override
    public void execute() {
        if (incomes.isEmpty() && expenses.isEmpty()) {
            System.out.println("You do not have any records.");
            return;
        }
        // Print incomes
        if (incomes.isEmpty()) {
            System.out.println("You have no recorded incomes.");
        } else {
            System.out.println("Here are your incomes:");
            for (int i = 0; i < incomes.size(); i++) {
                System.out.println((i + 1) + ". " + incomes.get(i).toString());
                totalIncome += incomes.get(i).getAmount();
            }
            System.out.printf("Total income is: $%.2f.", totalIncome);
        }
        System.out.println();
        // Print expenses
        if (expenses.isEmpty()) {
            System.out.println("You have no recorded expenses.");
        } else {
            System.out.println("Here are your expenses:");
            for (int i = 0; i < expenses.size(); i++) {
                System.out.println((i + 1) + ". " + expenses.get(i).toString());
                totalExpenses += expenses.get(i).getAmount();
            }
            System.out.printf("Total expenses is: $%.2f.", totalExpenses);
        }
        System.out.printf("Total balance is: $%.2f.", totalIncome - totalExpenses);
    }
}
