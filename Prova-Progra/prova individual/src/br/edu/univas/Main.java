package br.edu.univas;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Venda {
    private Cliente cliente;
    private String nomeProduto;
    private double valorUnitario;
    private int quantidade;

    public Venda(Cliente cliente, String nomeProduto, double valorUnitario, int quantidade) {
        this.cliente = cliente;
        this.nomeProduto = nomeProduto;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    public double getValorTotal() {
        return valorUnitario * quantidade;
    }

    public Cliente getCliente() {
        return cliente;
    }
}

class Cliente {
    private String nome;
    private String tipo;

    public Cliente(String nome, String tipo) {
        this.nome = nome;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public String getTipo() {
        return tipo;
    }
}

class VendaService {
    private List<Venda> vendas;

    public VendaService() {
        vendas = new ArrayList<>();
    }

    public void adicionarVenda(Venda venda) {
        vendas.add(venda);
    }

    public double calcularValorTotalVendido() {
        double valorTotal = 0;
        for (Venda venda : vendas) {
            valorTotal += venda.getValorTotal();
        }
        return valorTotal;
    }

    public double calcularValorMedioPorVenda() {
        double valorTotal = calcularValorTotalVendido();
        return valorTotal / vendas.size();
    }
}

class VendaView {
    public static void exibirRelatorio(double valorTotalVendido, double valorMedioPorVenda) {
        System.out.println("Relatório de Vendas");
        System.out.println("-------------------");
        System.out.printf("Valor total vendido: R$ %.2f\n", valorTotalVendido);
        System.out.printf("Valor médio por venda: R$ %.2f\n", valorMedioPorVenda);
    }
}

public class Main {
    public static void main(String[] args) {
        VendaService vendaService = new VendaService();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Registrar nova venda");
            System.out.println("2 - Gerar relatório");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após a leitura do número

            if (opcao == 1) {
                System.out.print("Nome do cliente: ");
                String nomeCliente = scanner.nextLine();
                System.out.print("Tipo de cliente (PF/PJ): ");
                String tipoCliente = scanner.nextLine();
                System.out.print("Nome do produto vendido: ");
                String nomeProduto = scanner.nextLine();
                System.out.print("Valor unitário: ");
                double valorUnitario = scanner.nextDouble();
                System.out.print("Quantidade vendida: ");
                int quantidade = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha após a leitura do número

                Cliente cliente = new Cliente(nomeCliente, tipoCliente);
                Venda venda = new Venda(cliente, nomeProduto, valorUnitario, quantidade);
                vendaService.adicionarVenda(venda);
            } else if (opcao == 2) {
                double valorTotalVendido = vendaService.calcularValorTotalVendido();
                double valorMedioPorV;
                System.out.println("Encerrando o programa...");
            }
        }
    }
}