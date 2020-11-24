
public abstract class Livro{

    private String nome;
    private String autor;
    private int quantidadeEstoque;

    Livro(String nome, String autor, int quantidadeEstoque_){
        this.nome = nome;
        this.autor = autor;
        this.quantidadeEstoque = quantidadeEstoque_;
    }
    Livro(){
        nome = "";
        autor = "";
        quantidadeEstoque = 0;
    }

    public void setQuantidadeEstoque(double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    public double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public String getAutor() {
        return autor;
    }
    public String getNome() {
        return nome;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void decEstoque(){
        if(quantidadeEstoque > 0) quantidadeEstoque -= 1;
    }
    public void incEstoque(){
        quantidadeEstoque += 1;
    }
}

public class LivroLivraria extends Livro{

    private double preco;
    LivroLivraria(double preco, String nome, String autor, int quant){
        Super(nome, autor, quant);
        this.preco = preco;
    }
    LivroLivraria(){
        Super();
        preco = 0;
    }
    
    public void compraLivro(){
        if(getQuantidadeEstoque() > 0){
            decEstoque();
        }
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }
}

public class LivroBiblioteca extends Livro{

    private double aluguel;

    LivroBiblioteca(double aluguel, String nome, String autor, int quant){
        Super(nome, autor, quant);
        this.aluguel = aluguel;
    }
    LivroBiblioteca(){
        Super();
        aluguel = 0;
    }

    public double getAluguel() {
        return aluguel;
    }
    public void setAluguel(double aluguel) {
        this.aluguel = aluguel;
    }

    public void alugaLivro(){
        if(getQuantidadeEstoque() > 0){
            decEstoque();
        }
    }

    public void devolveLivro(){
        incEstoque();
    }

}


public class Q1{
    public static void main(String args[]){

    }

}