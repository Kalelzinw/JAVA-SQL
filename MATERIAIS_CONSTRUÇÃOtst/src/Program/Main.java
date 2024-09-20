package Program;

import java.util.Scanner;
import Entities.Cliente;
import Entities.Endereco;
import Entities.Ficha;
import Entities.Produto;
import dao.ClienteDAO;
import dao.ProdutoDAO;
import dao.CompraDAO;
import dao.FichaDAO;
import Entities.Compra;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ClienteDAO clienteDAO = new ClienteDAO();        
        ProdutoDAO produtoDAO = new ProdutoDAO();
        CompraDAO compraDAO = new CompraDAO();
        FichaDAO fichaDAO = new FichaDAO();
        float precoProduto;
        int  idCliente,numeroEndereco, codigoProduto, idCompra,idClienteCompra,num_ficha,quantidadeCompra,codigoProdutoCompra;
        String ufEndereco,cidadeEndereco,bairroEndereco,logradouroEndereco,cpfCliente,rgCliente,nomeCliente,descricaoProduto;
        int opcao;
        Ficha ficha = null;
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Cadastrar Cliente e Endereço");
            System.out.println("2 - Cadastrar Produto");
            System.out.println("3 - Realizar Compra");
            System.out.println("4-  Preencher ficha");
            System.out.println("0 - Sair");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    
                    System.out.println("Digite o ID do Cliente:");
                    idCliente = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o nome do Cliente:");
                    nomeCliente = sc.nextLine();
                    System.out.println("Digite o RG do Cliente:");
                     rgCliente = sc.nextLine();
                    System.out.println("Digite o CPF do Cliente:");
                    cpfCliente = sc.nextLine();
                    System.out.println("Digite o número do Endereço:");
                    numeroEndereco = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o logradouro do Endereço:");
                    logradouroEndereco = sc.nextLine();
                    System.out.println("Digite o bairro do Endereço:");
                    bairroEndereco = sc.nextLine();
                    System.out.println("Digite a cidade do Endereço:");
                    cidadeEndereco = sc.nextLine();
                    System.out.println("Digite o estado (UF) do Endereço:");
                    ufEndereco = sc.nextLine();
                    Endereco endereco = new Endereco(idCliente, numeroEndereco, logradouroEndereco, bairroEndereco, cidadeEndereco, ufEndereco);                    
                    Cliente cliente = new Cliente(idCliente, nomeCliente, rgCliente, cpfCliente, endereco);
                    clienteDAO.insertClient(cliente, endereco);
                    break;
                case 2:
                    // Cadastro do produto
                    System.out.println("Digite o código do Produto:");
                    codigoProduto = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite a descrição do Produto:");
                    descricaoProduto = sc.nextLine();
                    System.out.println("Digite o preço do Produto:");
                    precoProduto = sc.nextFloat();
                    sc.nextLine();
                    Produto produto = new Produto(codigoProduto, descricaoProduto, precoProduto);
                    produtoDAO.inserirProduto(produto);
                    break;
                case 3:
                    System.out.println("Digite ID compra:");
                    idCompra = sc.nextInt();
                    System.out.println("Digite o ID do Cliente:");
                    idClienteCompra = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite o código do Produto:");
                    codigoProdutoCompra = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Digite a quantidade a ser comprada:");
                    quantidadeCompra = sc.nextInt();
                    sc.nextLine();
                    Produto produtoCompra = produtoDAO.buscarProdutoPorCodigo(codigoProdutoCompra);
                    Compra compra = new Compra(idCompra,codigoProdutoCompra, idClienteCompra, quantidadeCompra, produtoCompra);
                    compraDAO.realizarCompra(compra);
                    break;
                case 4:
                	System.out.println("Insira o numero da ficha:");
                	num_ficha = sc.nextInt();
                	System.out.println("Insira idCompa");
                	int id_compra = sc.nextInt();
                	ficha = new Ficha(num_ficha);
                	
                	break;
                case 0:
                	System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        sc.close();
    }
}