package controledeestoque;

import java.util.ArrayList;

public class Produto {
    private String nome;
    private float preco;
    private String unidade;
    private int quantidade;
    ArrayList<Produto> ListProd;
    
    public Produto(){
        ListProd = new ArrayList();
    }
    
    public Produto (String nome, float preco, String unidade, int quantidade){
        this.nome = nome;
        this.preco = preco;
        this.unidade = unidade;
        this.quantidade = quantidade;
        ListProd = new ArrayList();

    }
        
    
    public String getNome(){
        return nome;
    }
    
    public void setNome (String nome){
        this.nome = nome;
    }
    
    public float getPreco(){
        return preco;
    }
    
    public void setPreco (float preco){
        this.preco = preco;
    }
    
    public String getUnidade(){
        return unidade;
    }
    
    public void setUnidade (String unidade){
        this.unidade = unidade;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public void setQuantidade (int quantidade){
        this.quantidade = quantidade;
    }
    
    public ArrayList<Produto> getListProd(){
        return ListProd;
    }
    
    public void setListProd (ArrayList<Produto> ListProd){
        this.ListProd = ListProd;
    }
    
    

}
