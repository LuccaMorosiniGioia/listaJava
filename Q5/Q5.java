interface Colecao{
    void inserir(Pessoa p);
    int tamanhoColecaoNaoNull();
}

abstract class Pessoa{
    protected String nome;
    protected String cpf;

    Pessoa(String nome, String cpf){
        this.cpf = cpf;
        this.nome = nome;
    }
    Pessoa(){

    }

    public abstract void setCpf(String cpf);
    public String getCpf(){
        return cpf;
    }

    public abstract void setNome(String nome);
    public String getNome(){
        return nome;
    }
    
}

class Professor extends Pessoa{
    protected String formacao;
    protected String area;

    Professor(String nome, String cpf, String formacao, String area){
        super(nome, cpf);
        //this.nome = nome;
        //this.cpf = cpf;
        this.formacao = formacao;
        this.area = area;
    }
    Professor(){
        super();
    }
    
    
    public void setCpf(String cpf) {
        super.cpf = cpf;
    }

    public void setNome(String nome) {
       super.nome = nome;
    }

    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }

    public String getFormacao() {
        return formacao;
    }
    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }
    
    
}

class Aluno extends Pessoa{
    protected String matricula;
    protected String curso;

    Aluno(String nome, String cpf, String matricula, String curso){
        super(nome, cpf);
        //this.nome = nome;
        //this.cpf = cpf;
        this.matricula = matricula;
        this.curso = curso;
    }
    Aluno(){
        super();
    }

    public void setCpf(String cpf) {
        super.cpf = cpf;
    }

    public void setNome(String nome) {
       super.nome = nome;
    }

    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}

class ColecaoVetor implements Colecao{
    protected Pessoa dados[];
    protected int n;
    
    ColecaoVetor(){
        dados = new Pessoa[5];
        n = 0;
    }

    public void inserir(Pessoa p){
        if(n < 5){
            dados[n++] = p;
        }
    }

    public int tamanhoColecaoNaoNull(){
        return n;
    }


}


public class Q5 {//Principal
    public static void main(String args[]){
        int aux;
        ColecaoVetor cv = new ColecaoVetor();
        Pessoa p1 = new Aluno("Jose", "1", "123", "EC");
        Pessoa p2 = new Professor("Alberto", "2", "EC", "Computacao");
        Pessoa p3 = new Aluno("Carlos", "3", "234", "CC");

        cv.inserir(p1);
        aux = cv.tamanhoColecaoNaoNull();
        System.out.println(cv.dados[aux-1].getNome() + " foi inserido\n" + aux + " pessoas inseridas" + " de um total de 5");

        cv.inserir(p2);
        aux = cv.tamanhoColecaoNaoNull();
        System.out.println(cv.dados[aux-1].getNome() + " foi inserido\n" + aux + " pessoas inseridas" + " de um total de 5");

        cv.inserir(p3);
        aux = cv.tamanhoColecaoNaoNull();
        System.out.println(cv.dados[aux-1].getNome() + " foi inserido\n" + aux + " pessoas inseridas" + " de um total de 5");
    }
}
