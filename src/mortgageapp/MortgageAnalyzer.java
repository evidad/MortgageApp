/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mortgageapp;

import java.util.Scanner;
import java.lang.Math;

/**
 *
 * @author errol
 */
public class MortgageAnalyzer {
    private double loanAmount;
    private double annualInterestRate;
    private double loanDuration;

    public MortgageAnalyzer() {};

    public MortgageAnalyzer(double loanAmount, double annualInterestRate, double loanDuration) {
        this.loanAmount = loanAmount;
        this.annualInterestRate = annualInterestRate;
        this.loanDuration = loanDuration;
    }

    public String getLoanAmount() {
        return String.format("%.2f", this.loanAmount);
    }
    
    public double getUnformattedLoanAmount() {
        return this.loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public String getAnnualInterestRate() {
        return String.format("%.2f", this.annualInterestRate);
    }
    
    public double getUnformattedAnnualInterestRate() {
        return this.annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public String getLoanDuration() {
        return String.format("%.2f", this.loanDuration);
    }
    
    public double getUnformattedLoanDuration() {
        return this.loanDuration;
    }

    public void setLoanDuration(double loanDuration) {
        this.loanDuration = loanDuration;
    }

    public boolean verifyLoanAmount() {
        if (this.loanAmount > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void correctLoanAmount(Scanner scan) {
        System.out.println("Invalid loan amount, please enter again: ");
        while (!verifyLoanAmount()) {
            this.loanAmount = scan.nextDouble();
        }
        
    }

    public boolean verifyAnnualInterestRate() {
        if (this.annualInterestRate <= 0 || this.annualInterestRate > 100) {
            return false;
        } else {
            return true;
        }
    }

    public void correctAnnualInterestRate(Scanner scan) {
        System.out.println("Invalid annual interest rate, please enter again: ");
        while (!verifyAnnualInterestRate()) {
            this.annualInterestRate = scan.nextDouble();
        }
    }

    public boolean verifyLoanDuration () {
        if (this.loanDuration < 12 || this.loanDuration > 720) {
            return false;
        } else {
            return true;
        }
    }

    public void correctLoanDuration(Scanner scan) {
        while (!verifyLoanDuration()) {
            System.out.println("Invalid loan duration, please enter again: ");
            this.loanDuration = scan.nextDouble();
        }
    }

    public boolean verify() {
        return verifyLoanAmount() && verifyAnnualInterestRate() && verifyLoanDuration();
    }

     public double getMonthlyPaymentNumeric() {
        double p = this.loanAmount;
        double r = this.annualInterestRate / 100 / 12;
        double n = this.loanDuration;

        return (p * r * Math.pow((1 + r), n)) / (Math.pow((1 + r), n) - 1);
    }

    public String getMonthlyPayment() {
        return String.format("$%.2f", getMonthlyPaymentNumeric());
    }

    public double getTotalInterestNumeric() {
        double p = this.loanAmount;
        double n = this.loanDuration;
        double payment = getMonthlyPaymentNumeric();  // Using numeric value for payment

        return n * payment - p;
    }

    public String getTotalInterest() {
        return String.format("$%.2f", getTotalInterestNumeric());
    }

    public String calculateMortgageDetails() {
        return "Loan Amount: $" + getLoanAmount() + "\n" +
               "Annual Interest Rate: " + getAnnualInterestRate() + "%\n" +
               "Loan Duration (Months): " + getLoanDuration() + "\n" +
               "Monthly Payment: " + getMonthlyPayment() + "\n" +
               "Total Interest: " + getTotalInterest();
    }
}
