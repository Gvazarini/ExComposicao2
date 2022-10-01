package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException
	{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Isnsira os dados do cliente: ");
		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.println("data de nascimento (DD/MM/YYYY)");
		Date birthdate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthdate);
		
		System.out.println("Entre com o pedido do cliente: ");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("Quantos items o client pediu? ");
		int qtd = sc.nextInt();
		for(int i = 0; i< qtd; i++)
		{
			System.out.println("Dados do #" + (i+1) + " item:");
			System.out.print("Nome do Produto: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Preço: R$");
			double valueProd = sc.nextDouble();
			System.out.print("Quantidade: ");
			int n = sc.nextInt();
			
			Product product = new Product(productName, valueProd);
			OrderItem it = new OrderItem(n, valueProd, product);
			
			order.addItem(it);
			
		}
		System.out.println();
		System.out.println(order.toString());
		sc.close();

	}

}
