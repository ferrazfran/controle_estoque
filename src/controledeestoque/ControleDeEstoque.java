package controledeestoque;

import java.util.ArrayList;
import java.util.Scanner;

public class ControleDeEstoque {

    
    public static void main(String[] args) {
    
        Produto produto = new Produto();
        ArrayList<Produto> listProd = new ArrayList();
        Scanner scan = new Scanner(System.in);
        
        
        Produto produto1 = new Produto("nome 1",19,"kg",2);
        Produto produto2 = new Produto("nome 2",11,"L",22);
        Estoque.estoqueLista.add(produto1);
        Estoque.estoqueLista.add(produto2);
        System.out.println(Estoque.estoqueLista.indexOf(produto2));
        System.out.println(Estoque.estoqueLista.stream().filter(customer -> "nome 2".equals(customer.getNome())).findAny().orElse(null) == produto2);

        Functions functions = new Functions();
        functions.showMenu(produto, listProd, scan);
        
    }
}
