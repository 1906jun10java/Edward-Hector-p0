package com.revature.logic;

import java.lang.Math;
import com.revature.beans.Offer;

public class AnnuityCalc {

	public static double annuityCalc(Offer o) {
		double term = o.getNumberOfPayments();
		double interesRate = o.getInterestRate();
		double r = 1 + interesRate/100;
		double principal = o.getOfferAmmount();

		double annuity;
		if (r != 1) {
			annuity = ((principal * Math.pow(r, term)) * (1 - r)) / (1 - Math.pow(r, term));
		} else {
			annuity = principal / term;
		}
		return annuity;
	}

}
