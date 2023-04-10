package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.CarRental;
import model.entities.Vehicle;
import model.services.BrazilTazServices;
import model.services.RentalService;

public class Program {

	public static void main(String[] args) {

	//	Locale.setDefault(Locale.US);
		Scanner ler = new Scanner(System.in);
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");

		System.out.println("Entre com os dados do aluguel");
		System.out.println("Modelo do carro");
		String carModel = ler.nextLine();
		System.out.println("retirada (dd/MM/yyyy hh:mm): ");
		LocalDateTime start = LocalDateTime.parse(ler.nextLine(), fmt);
		System.out.println("retorno (dd/MM/yyyy hh:mm): ");
		LocalDateTime finish = LocalDateTime.parse(ler.nextLine(), fmt);
		CarRental cr = new CarRental(start, finish, new Vehicle(carModel));

		System.out.println("entre com o preço por hora");
		double pricePerHour = ler.nextDouble();
		System.out.println("entre com o preço por hora");
		double pricePerDay = ler.nextDouble();

		RentalService rs = new RentalService(pricePerHour, pricePerDay, new BrazilTazServices());

		rs.processInvoice(cr);
		System.out.println("Fatura:");
		System.out.println("pagamento basico: " + cr.getInvoice().getBasicPayment());
		System.out.println("Imposto: " + cr.getInvoice().getTax());
		System.out.println("Pagamento total: " + cr.getInvoice().getTotalPayment());
		ler.close();
	}

}
