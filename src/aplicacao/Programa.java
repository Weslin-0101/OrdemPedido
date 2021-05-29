package aplicacao;

import entidades.Cliente;
import entidades.Ordem;
import entidades.OrdemPedido;
import entidades.Produto;
import entidadesenum.OrdemStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Entre com as informações do cliente:");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Data de aniversário (DD/MM/YYYY): ");
        Date dataAniversario = sdf.parse(sc.next()); // transformar a data escrita pelo usuário em um tipo Date

        Cliente cliente = new Cliente(nome, email, dataAniversario);
        System.out.println("Entre com as informações do pedido:");
        System.out.print("Status: ");
        OrdemStatus status = OrdemStatus.valueOf(sc.next()); // converte a string no formato do OrdemStatus

        Ordem ordem = new Ordem(new Date(), status, cliente);

        System.out.print("Quantos items o pedido vai ter? ");
        int n = sc.nextInt();
        for (int i=1; i<=n; i++){
            System.out.println();
            System.out.println("Entre com as informações do " + i + " pedido:");
            System.out.print("Nome do produto: ");
            sc.nextLine();
            String nomeProduto = sc.nextLine();
            System.out.print("Preço do produto: ");
            double precoProduto = sc.nextDouble();

            Produto produto = new Produto(nomeProduto, precoProduto);

            System.out.print("Quantidade: ");
            int quantidade = sc.nextInt();

            OrdemPedido pedido = new OrdemPedido(quantidade, precoProduto, produto);
            ordem.adicionarItem(pedido);
        }

        System.out.println();
        System.out.println(ordem);

        sc.close();
    }
}
