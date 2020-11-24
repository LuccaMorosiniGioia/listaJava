import jdk.internal.agent.resources.agent;

class Senha{
    protected String alphaNum;
    protected String num;

    Senha(String a, String n){
        alphaNum = a;
        num = n;
    }
    Senha(){

    }

    protected String getAlphaNum() {
        return alphaNum;
    }
    protected void setAlphaNum(String alphaNum) {
        this.alphaNum = alphaNum;
    }

    protected String getNum() {
        return num;
    }
    protected void setNum(String num) {
        this.num = num;
    }
}


class Conta{
    protected int numId;
    protected String agencia;
    protected Senha senha;

    Conta(int numId, String agencia, Senha senha){
        this.numId = numId;
        this.agencia = agencia;
        this.senha = senha;
    }
    Conta(){

    }

    protected String getAgencia() {
        return agencia;
    }
    protected void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    protected int getNumId() {
        return numId;
    }
    protected void setNumId(int numId) {
        this.numId = numId;
    }

    protected Senha getSenha() {
        return senha;
    }
    protected void setSenha(Senha senha) {
        this.senha = senha;
    }
}


public class Q4 {
    public static void main(String args[]){
        Conta conta = new Conta(123, "abc", new Senha("a1b2c3", "123"));
        System.out.println(conta.senha.getAlphaNum());
        System.out.println(conta.getNumId());
        conta.senha.setAlphaNum("senhaModificada");
        System.out.println(conta.senha.getAlphaNum());
    }
}
