package controledeestoque;

import java.util.*;

public class Functions {

    public void showMenu(Produto produto, ArrayList<Produto> listProd, Scanner scan) {
        int opcao;

        do {
            System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.");
            System.out.println("SISTEMA DE CONTROLE DE ESTOQUE:");
            System.out.println("MENU PRINCIPAL:");
            System.out.println("1 - CADASTRO DE PRODUTOS; 2 - MOVIMENTAÇÃO; 3 - REAJUSTE DE PREÇOS; 4 - RELATÓRIOS; 0 - FINALIZAR");
            System.out.println("OPÇÃO:_:");
            opcao = scan.nextInt();
            System.out.println(opcao);

            scan = new Scanner(System.in);

            switch (opcao) {
                case 1:
                    showMenuEstoque(produto, listProd, scan);
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    showProductsLists(listProd);
                    break;

                case 6:
                    continue;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }

        } while (opcao != 0);
    }

    private void showMenuEstoque(Produto produto, ArrayList<Produto> listProd, Scanner scan) {
        System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.");
        System.out.println("SISTEMA DE CONTROLE DE ESTOQUE:");
        System.out.println("ESTOQUE");
        System.out.println("1 - INCLUSÃO; 2 - ALTERAÇÃO; 3 - CONSULTA; 4 - EXCLUSÃO; 0 - RETORNAR");
        System.out.println("OPÇÃO:_");
        scan = new Scanner(System.in);
        int opcaoSubmenu = scan.nextInt();
        System.out.println("opcaoSubmenu");
        System.out.println(opcaoSubmenu);
        do {

            switch (opcaoSubmenu) {
                case 1:
                    opcaoSubmenu = showMenuInclusion(produto, listProd, scan);
                    System.out.println("opcaoSubmenu 2");
                    System.out.println(opcaoSubmenu);
                    break;
                case 2:
                    if (Estoque.estoqueLista.isEmpty()) {
                        System.out.println("NÃO TEM PRODUTOS CADASTRADOS.");
                        opcaoSubmenu = 0;
                        break;
                    }
                    opcaoSubmenu = showMenuUpdate(produto, scan);
                    break;
                case 3:
//                    opcaoSubmenu = showMenuConsultaProduto();
                    break;
                case 4:
                    showMenuExclusion(produto, scan);
                    break;
                case 6:
                    continue;
                default:
                    break;
            }

        } while (opcaoSubmenu != 0);
    }

    private int showMenuInclusion(Produto produto, ArrayList<Produto> listProd, Scanner scan) {
        System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.");
        System.out.println("SISTEMA DE CONTROLE DE ESTOQUE:");
        System.out.println("INCLUSÃO DE PRODUTO:");

        System.out.println("NOME:");//TODO Deve-se validar o nome do produto, não podem existir produtos de mesmo nome.
        String name = scan.next();
        System.out.println(name);
        produto.setNome(name);

        System.out.println("PREÇO:");
        scan = new Scanner(System.in);
        float valor = scan.nextFloat();
        System.out.println(valor);
        do {
            if (valor <= 0) {
                System.out.println("O preço deve ser maior que zero.");
                System.out.println("Preço:");
                scan = new Scanner(System.in);
                produto.setPreco(scan.nextFloat());
            } else {
                produto.setPreco(valor);
            }

        } while (valor <= 0);

        System.out.println("UNIDADE:");
        String unidade = scan.next();
        System.out.println(unidade);
        produto.setUnidade(unidade);

        System.out.println("QUANTIDADE:");
        scan = new Scanner(System.in);
        int qtd = scan.nextInt();
        System.out.println(qtd);
        do {
            if (qtd < 0) {
                System.out.println("A quantidade deve ser maior ou igual a zero.");
                System.out.println("Preço:");
                scan = new Scanner(System.in);
                produto.setQuantidade(scan.nextInt());
            } else {
                produto.setQuantidade(qtd);
            }
        } while (qtd < 0);

        System.out.println("CONFIRMA INCLUSÃO (S/N)? _");
        String confirmacao = scan.next();
        if (confirmacao.equals("s") || confirmacao.equals("S")) {
            //TODO salva no array
            Estoque.estoqueLista.add(produto);
        }
        produto = new Produto();
        System.out.println("REPETIR OPERAÇÃO (S/N)? _");
        scan = new Scanner(System.in);
        String confirmacaoRepetir = scan.next();
        if (!confirmacao.equals("s") || !confirmacao.equals("S")) {
            //TODO salva no array
            showMenuEstoque(produto, listProd, scan);
            return 0;
        }
        showMenuInclusion(produto, listProd, scan);
        return 6;
        //TODO Deve-se pedir a confirmação da inclusão antes de efetuá-la, caso não seja confirmada, deve-se ignorar o cadastro.
    }

    private int showMenuUpdate(Produto produto, Scanner scan) {
        System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.");
        System.out.println("SISTEMA DE CONTROLE DE ESTOQUE:");
        System.out.println("ALTERAÇÃO DE PRODUTO:");

        System.out.println("NOME:");//TODO Deve-se validar o nome do produto, não podem existir produtos de mesmo nome.
        scan = new Scanner(System.in);
        String nameToVerify = scan.nextLine();
        Produto produtoAuxToUpdate = Estoque.estoqueLista.stream().filter((product) -> nameToVerify.equals(product.getNome())).findAny().orElse(null);
        //consultaProduto(produto.getnome())
        if (produtoAuxToUpdate != null) {
            System.out.println("Nome: " + produtoAuxToUpdate.getNome());
            System.out.println("Preço: " + produtoAuxToUpdate.getPreco());
            System.out.println("Unidade: " + produtoAuxToUpdate.getUnidade());
            System.out.println("Quantidade: " + produtoAuxToUpdate.getQuantidade());

            System.out.println("NOME:");//TODO Deve-se validar o nome do produto, não podem existir produtos de mesmo nome.
            scan = new Scanner(System.in);
            String name = scan.nextLine();
            System.out.println(name);
            produto.setNome(name);

            System.out.println("PREÇO:");
            scan = new Scanner(System.in);
            float valor = scan.nextFloat();
            System.out.println(valor);
            do {
                if (valor <= 0) {
                    System.out.println("O preço deve ser maior que zero.");
                    System.out.println("Preço:");
                    scan = new Scanner(System.in);
                    produto.setPreco(scan.nextFloat());
                }

            } while (valor <= 0);

            System.out.println("UNIDADE:");
            String unidade = scan.next();
            System.out.println(unidade);
            produto.setUnidade(unidade);

            System.out.println("QUANTIDADE:");
            scan = new Scanner(System.in);
            int qtd = scan.nextInt();
            System.out.println(qtd);
            do {
                if (qtd < 0) {
                    System.out.println("A quantidade deve ser maior ou igual a zero.");
                    System.out.println("Preço:");
                    scan = new Scanner(System.in);
                    produto.setQuantidade(scan.nextInt());
                }
            } while (qtd < 0);
        } else {
            System.out.println("Produto não existe");
        }

        System.out.println("CONFIRMA INCLUSÃO (S/N)? _");
        String confirmacao = scan.next();
        if (confirmacao.equals("s") || confirmacao.equals("S")) {
            //TODO salva no array
            System.out.println(produtoAuxToUpdate);
            System.out.println(produto);
            Estoque.estoqueLista.remove(produtoAuxToUpdate);
            Estoque.estoqueLista.add(produto);
        }
        produto = new Produto();
        System.out.println("REPETIR OPERAÇÃO (S/N)? _");
        String confirmacaoRepetir = scan.next();
        if (!confirmacaoRepetir.equals("s") || !confirmacaoRepetir.equals("S")) {
            //TODO salva no array
            return 0;
        }
        return 6;

        //TODO Deve-se pedir a confirmação da inclusão antes de efetuá-la, caso não seja confirmada, deve-se ignorar o cadastro.
    }

    private void showProductsLists(ArrayList<Produto> listProd) {
        System.out.println(Estoque.estoqueLista.size());
        for (Produto produto : Estoque.estoqueLista) {
            System.out.println("---------------------------------");
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("Unidade: " + produto.getUnidade());
            System.out.println("Quantidade: " + produto.getQuantidade());
            System.out.println("---------------------------------");
        }
    }

    private int showMenuExclusion(Produto produto, Scanner scan) {
        System.out.println("EMPRESA DE IMPORTAÇÃO DE PRODUTOS LTDA.");
        System.out.println("SISTEMA DE CONTROLE DE ESTOQUE:");
        System.out.println("EXCLUSÃO DE PRODUTO:");
        System.out.println("NOME:");//TODO Deve-se validar o nome do produto, não podem existir produtos de mesmo nome.
        scan = new Scanner(System.in);
        String name = scan.nextLine();
        Produto produtoAux = Estoque.estoqueLista.stream().filter(product -> name.equals(product.getNome())).findAny().orElse(null);
        if (produtoAux != null) {
            Estoque.estoqueLista.remove(produtoAux);
        } else {
            System.out.println("Produto não existe");
        }

        return 0;

    }
    
    private Produto consultaProduto(String nome){
        Produto produtoAuxToUpdate = Estoque.estoqueLista.stream().filter((product) -> nome.equals(product.getNome())).findAny().orElse(null);
        return produtoAuxToUpdate;
    }

}
