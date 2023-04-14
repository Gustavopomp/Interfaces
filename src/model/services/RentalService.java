package model.services;

import java.time.Duration;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

	private double priceperhour;
	private double priceperday;
	private TaxService taxService;

	public RentalService(double priceperhour, double priceperday, TaxService taxService) {

		this.priceperhour = priceperhour;
		this.priceperday = priceperday;
		this.taxService = taxService;
	}
	

	public void processInvoice(CarRental carRental) {
		double minutes = Duration.between(carRental.getStart(), carRental.getFinish()).toMinutes();
		double hours = minutes/60.0;
		
		double basicPayment;
		if(hours <= 12.0) {
			basicPayment = priceperhour * Math.ceil(hours);
		}
		else {
			basicPayment = priceperday * Math.ceil(hours / 24);
		}
		double tax = taxService.tax(basicPayment);
		carRental.setInvoice(new Invoice(basicPayment,tax));
	}

	public double getPriceperhour() {
		return priceperhour;
	}

	public void setPriceperhour(double priceperhour) {
		this.priceperhour = priceperhour;
	}

	public double getPriceperday() {
		return priceperday;
	}

	public void setPriceperday(double priceperday) {
		this.priceperday = priceperday;
	}

	public BrazilTazServices getTaxService() {
		return (BrazilTazServices) taxService;
	}

	public void setTaxService(BrazilTazServices taxService) {
		this.taxService = taxService;
	}
	
}
