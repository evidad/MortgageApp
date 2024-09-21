package mortgageapp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author errol
 */

public class MortgageAnalyzerTest {

     @Test
    public void testCalculateMortgageDetails() {
        MortgageAnalyzer analyzer = new MortgageAnalyzer(140000, 8.00, 360);
        
        double expectedMonthlyPayment = 1027.27;
        double expectedTotalInterest = 229817.20;

        double actualMonthlyPayment = analyzer.getMonthlyPaymentNumeric();
        double actualTotalInterest = analyzer.getTotalInterestNumeric();
        
        assertEquals(expectedMonthlyPayment, actualMonthlyPayment, 0.2);
        assertEquals(expectedTotalInterest, actualTotalInterest, 0.2);
    }
}

