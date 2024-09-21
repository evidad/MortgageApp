/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package mortgageapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.util.Scanner;

/**
 *
 * @author errol
 */
public class FXMLDocumentController implements Initializable {

    MortgageAnalyzer mga;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mga = new MortgageAnalyzer();
    }

    @FXML
    private TextField annualInterestRateField;

    @FXML
    private Button enterLoanDetailsButton;

    @FXML
    private TextField loanDurationField;

    @FXML
    private TextField loanAmountField;

    @FXML
    private Label errorMessageLabel;

    @FXML
    private Label errorLoanLabel;

    @FXML
    private Label errorAnnualInterestRateLabel;

    @FXML
    private Label errorLoanDurationLabel;

    @FXML
    private Button handleCalculateButton;
    
    @FXML
    private Label totalInterestPaymentLabel;

    @FXML
    void handleEnterLoanDetails(ActionEvent event) {
        try {
            String r = annualInterestRateField.getText();
            String p = loanAmountField.getText();
            String n = loanDurationField.getText();

            mga.setAnnualInterestRate(Double.parseDouble(r));
            mga.setLoanAmount(Double.parseDouble(p));
            mga.setLoanDuration(Double.parseDouble(n));

            if (!mga.verifyLoanAmount()) {
                errorLoanLabel.setText("Loan amount is invalid. Please enter a value greater than 0.");
            } else {
                errorLoanLabel.setText("Loan amount is valid");
            }

            if (!mga.verifyAnnualInterestRate()) {
                errorAnnualInterestRateLabel.setText("Loan interst rate is invalid. Please enter a value between 0 and 100.");
            } else {
                errorAnnualInterestRateLabel.setText("Annual Interest Rate is valid");
            }

            if (!mga.verifyLoanDuration()) {
                errorLoanDurationLabel.setText("Loan duration is invalid. Please enter a value between 12 and 720.");
            } else {
                errorLoanDurationLabel.setText("Loan duration is valid");
            }

        } catch (NumberFormatException e) {
            errorMessageLabel.setText("Please enter valid numbers");
        }

    }

    @FXML
    void handleCalculatePayment(ActionEvent event) {
        String mortgageDetails = mga.calculateMortgageDetails();
        totalInterestPaymentLabel.setText(mortgageDetails);
    }

}
