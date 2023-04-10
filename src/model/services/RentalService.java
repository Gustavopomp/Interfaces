package model.services;

import model.entities.CarRental;
import model.entities.Invoice;

public class RentalService {

	private double priceperhour;
	private double priceperday;
	private BrazilTazServices taxService;

	public RentalService(double priceperhour, double priceperday, BrazilTazServices taxService) {

		this.priceperhour = priceperhour;
		this.priceperday = priceperday;
		this.taxService = taxService;
	}

	public void processInvoice(CarRental carRental) {
		carRental.setInvoice(new Invoice(50.0,10.0));
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
		return taxService;
	}

	public void setTaxService(BrazilTazServices taxService) {
		this.taxService = taxService;
	}
	
}
