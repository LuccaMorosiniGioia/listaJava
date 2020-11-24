public enum Generos{
    CISGENERO, TRANSGENERO, GENERO_FLUIDO, NAO_BINARIO;
}

class Pessoa{
    protected String nome;
    protected int idade;
    protected String grauEscolaridade;
    protected String orientSexual;
    protected String sexoBio;
    private Generos identidadeDeGenero;

    Pessoa(String nome, int idade, String grauEscolaridade, Generos identidadeDeGenero, String orientSexual,
            String sexoBio) {
        this.nome = nome;
        this.idade = idade;
        this.grauEscolaridade = grauEscolaridade;
        this.identidadeDeGenero = identidadeDeGenero;
        this.orientSexual = orientSexual;
        this.sexoBio = sexoBio;
    }
    Pessoa(){

    }

    public String getGrauEscolaridade() {
        return grauEscolaridade;
    }
    public void setGrauEscolaridade(String grauEscolaridade) {
        this.grauEscolaridade = grauEscolaridade;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Generos getIdentidadeDeGenero() {
        return identidadeDeGenero;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOrientSexual() {
        return orientSexual;
    }

    public String getSexoBio() {
        return sexoBio;
    }

    public void dormir(){
        System.out.println("Dormindo");
    }

    public void cagar(){
        System.out.println("Cagando");
    }

    public void estudar(){
        System.out.println("Estudando");
    }

    public void sobreviver(){
        System.out.println("Sobrevivendo");
    }

    public void trabalhar(){
        System.out.println("Trabalhando");
    }

}


public class Q3 {
    public static void main(String args[]){
        Pessoa p1 = new Pessoa();
        Pessoa p2 = new Pessoa("Roberto", 50, "Superior", Generos.NAO_BINARIO, "Hetero", "Masculino");
        
        System.out.println(p2.getGrauEscolaridade());
        System.out.println(p2.getNome());
        System.out.println(p2.getIdentidadeDeGenero());

        p2.dormir();
        p2.estudar();
        
    }
}
