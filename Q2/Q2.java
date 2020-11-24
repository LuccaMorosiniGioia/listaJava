import sun.tools.serialver.resources.serialver;

class Texto{

    private String txt;

    Texto(String txt){
        this.txt = txt;
    }
    Texto(){
        this.txt = "";
    }


    public String getTxt() {
        return txt;
    }
    public void setTxt(String txt) {
        this.txt = txt;
    }

    public int getLen(){
        return txt.length();
    }
    public void printTxt(){
        System.out.println(txt);
    }

    public int quantPalavras(){
        int n=0;
        char[] s = txt.toCharArray();
        for(int i=0; i<s.length; i++){
            if(!Character.isLetterOrDigit(s[i])){
                 n++;
            }
        }
        return n;
    }

    public int freqPalavra(String palavra){
        String buffer = "";
        int cont = 0;
        for(int i=0; i<txt.length(); i++){
            char chr = txt.charAt(i);
            if(Character.isLetterOrDigit(chr)){
                buffer += chr;
            }
            else{
                if(buffer.equals(palavra)){
                    cont++;
                }
                buffer = "";
            }   
        }
        if(buffer.equals(palavra)){
            cont++;
        }
        return cont;
    }

    public void subsStr(String str1, String str2){
        
        String buffer = "";
        String[] palavras = new String[100];
        String aux = "";
        int n = 0;
        for(int i=0; i<txt.length(); i++){
            char chr = txt.charAt(i);
            if(Character.isLetterOrDigit(chr)){
                buffer += chr;
            }
            else{
                if(buffer.equals(str1)){
                    palavras[n] = str2;
                }
                else{
                    palavras[n] = buffer;
                }
                n++;
                buffer = "";
                aux += chr;
            }   
        }
        if(buffer.equals(str1)){
            palavras[n] = str2;
        }
        else{
            palavras[n] = buffer;
        }
        n++;

        String ans = "";
        for(int i=0; i<n; i++){
            ans += palavras[i];
            if(i != n-1){
                ans += aux.charAt(i);
            }
        }
        txt = ans;
    }

}



public class Q2 {
    public static void main(String args[]){
        Texto t = new Texto("ab dsdsa.ab asdsda;ab; abab");
        System.out.println("Texto original: "  + t.getTxt());
        t.subsStr("ab", "cd");
        System.out.println("Substituindo 'ab' por 'cd': "  + t.getTxt());
        System.out.println("Tamanho do texto: " + t.getLen() +  ", quantidade de palavras: " + t.quantPalavras());
        System.out.println("Frequencia de 'cd':" + t.freqPalavra("cd"));
        System.out.println("Alterando o texto para 'abcd'");
        t.setTxt("abcd");
        System.out.println("Novo texto: ");
        t.printTxt();
    }
}
