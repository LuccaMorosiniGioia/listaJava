interface Expression{
    String avaliar(String expr);
    String imprimirArvore(String expr);
}

class ExprAritmetica implements Expression{

    String expr;

    ExprAritmetica(String expr){
        this.expr = expr;
    }
    ExprAritmetica(){

    }

    public String getExpr() {
        return expr;
    }
    public void setExpr(String expr) {
        this.expr = expr;
    }

    public String toString(){
        return expr;
    }

    public String imprimirArvore(String expr){
        int n = expr.length();
        int sum = -1, sub = -1, mul = -1, div = -1;
        for(int i=n-1; i>=0; i--){
            if(sum == -1){
                if(expr.charAt(i) == '+') sum = i;
            }
            if(sub == -1){
                if(expr.charAt(i) == '-') sub = i;
            }
            if(mul == -1){
                if(expr.charAt(i) == '*') mul = i;
            }
            if(div == -1){
                if(expr.charAt(i) == '/') div = i;
            }
        }

        if(sum != -1){
           return '(' + imprimirArvore(expr.substring(0, sum)) +  '+' + imprimirArvore(expr.substring(sum+1)) + ')';
        }
        else if(sub != -1){
            return '(' + imprimirArvore(expr.substring(0, sub)) +  '-' + imprimirArvore(expr.substring(sub+1)) + ')';
        }
        else if(mul != -1){
            return '(' + imprimirArvore(expr.substring(0, mul)) +  '*' + imprimirArvore(expr.substring(mul+1)) + ')';
        }
        else if(div != -1){
            return '(' + imprimirArvore(expr.substring(0, div)) +  '/' + imprimirArvore(expr.substring(div+1)) + ')';
        }

        return '(' + expr + ')';

    }


    private Double avaliarAux(String expr){

        int n = expr.length();
        int sum = -1, sub = -1, mul = -1, div = -1;
        for(int i=n-1; i>=0; i--){
            if(sum == -1){
                if(expr.charAt(i) == '+') sum = i;
            }
            if(sub == -1){
                if(expr.charAt(i) == '-') sub = i;
            }
            if(mul == -1){
                if(expr.charAt(i) == '*') mul = i;
            }
            if(div == -1){
                if(expr.charAt(i) == '/') div = i;
            }
        }
        /*System.out.println("Sum: " + sum);
        System.out.println("Sub: " + sub);
        System.out.println("Mul: " + mul);
        System.out.println("Div: " + div);*/
        if(sum != -1){
            return avaliarAux(expr.substring(0, sum)) + avaliarAux(expr.substring(sum+1));
        }
        else if(sub != -1){
            return avaliarAux(expr.substring(0, sub)) - avaliarAux(expr.substring(sub+1));
        }
        else if(mul != -1){
            return avaliarAux(expr.substring(0, mul)) * avaliarAux(expr.substring(mul+1));
        }
        else if(div != -1){
            return avaliarAux(expr.substring(0, div)) / avaliarAux(expr.substring(div+1));
        }
        return Double.parseDouble(expr);
    }
    public String avaliar(String expr){
        Double ans = avaliarAux(expr);
        return String.valueOf(ans);
    }
}

class ExprLogica implements Expression{

    String expr;

    ExprLogica(String expr){
        this.expr = expr;
    }
    ExprLogica(){
        
    }

    public String getExpr() {
        return expr;
    }
    public void setExpr(String expr) {
        this.expr = expr;
    }

    public String toString(){
        return expr;
    }

    ExprAritmetica exp = new ExprAritmetica();

    public String imprimirArvore(String expr){
        for(int i=0; i<expr.length(); i++){
            char chr = expr.charAt(i);
            if(chr == '<' || chr == '>' || chr == '!' || chr == '='){
                char chr1 = expr.charAt(i+1);
                if(!Character.isDigit(chr1)){
                    return '(' + exp.imprimirArvore(expr.substring(0, i)) + chr + chr1 + exp.imprimirArvore(expr.substring(i+2)) + ')';
                }
                else{
                    return '(' + exp.imprimirArvore(expr.substring(0, i)) + chr + exp.imprimirArvore(expr.substring(i+1)) + ')';
                }
            }
        }
        return "";
    }

    public String avaliar(String expr){
        return String.valueOf(avaliar2(expr));
    }

    private boolean avaliar2(String expr){
        for(int i=0; i<expr.length(); i++){
            char chr = expr.charAt(i);
            if(chr == '<'){
                chr = expr.charAt(i+1);
                if(chr == '='){
                    return (avaliarAux(expr.substring(0, i)) <= avaliarAux(expr.substring(i+2)));
                }
                else{
                    return (avaliarAux(expr.substring(0, i)) < avaliarAux(expr.substring(i+1)));
                }
            }
            else if(chr == '>'){
                chr = expr.charAt(i+1);
                if(chr == '='){
                    return (avaliarAux(expr.substring(0, i)) >= avaliarAux(expr.substring(i+2)));
                }
                else{
                    return (avaliarAux(expr.substring(0, i)) > avaliarAux(expr.substring(i+1)));
                }
            }
            else if(chr == '='){
                chr = expr.charAt(i-1);
                if(chr == '='){
                    return (avaliarAux(expr.substring(0, i-1)) == avaliarAux(expr.substring(i+1)));
                }
                else if(chr == '!'){
                    return (avaliarAux(expr.substring(0, i-1)) != avaliarAux(expr.substring(i+1)));
                }
            }
        }
        return false;
    }

    private double avaliarAux(String expr){

        int n = expr.length();
        int sum = -1, sub = -1, mul = -1, div = -1;
        for(int i=n-1; i>=0; i--){
            if(sum == -1){
                if(expr.charAt(i) == '+') sum = i;
            }
            if(sub == -1){
                if(expr.charAt(i) == '-') sub = i;
            }
            if(mul == -1){
                if(expr.charAt(i) == '*') mul = i;
            }
            if(div == -1){
                if(expr.charAt(i) == '/') div = i;
            }
        }
        if(sum != -1){
            return avaliarAux(expr.substring(0, sum)) + avaliarAux(expr.substring(sum+1));
        }
        else if(sub != -1){
            return avaliarAux(expr.substring(0, sub)) - avaliarAux(expr.substring(sub+1));
        }
        else if(mul != -1){
            return avaliarAux(expr.substring(0, mul)) * avaliarAux(expr.substring(mul+1));
        }
        else if(div != -1){
            return avaliarAux(expr.substring(0, div)) / avaliarAux(expr.substring(div+1));
        }
        return Double.parseDouble(expr);
    }
}

class ExprOpTernario implements Expression{

    String expr;

    ExprOpTernario(String expr){
        this.expr = expr;
    }
    ExprOpTernario(){
        
    }

    public String getExpr() {
        return expr;
    }
    public void setExpr(String expr) {
        this.expr = expr;
    }

    public String toString(){
        return expr;
    }

    private boolean descobreTipoDeExpr(String expr){
        for(int i=0; i<expr.length(); i++){
            char chr = expr.charAt(i);
            if(chr == '<' || chr == '>' || chr == '=' || chr == '!'){
                return false;
            }
        }
        return true;
    }


    public String avaliar(String expr){
        for(int i=0; i<expr.length(); i++){
            char chr = expr.charAt(i);
            if(chr == '?'){
                String aux = expr.substring(0, i);
                ExprLogica exprL = new ExprLogica(aux);
                String ans = exprL.avaliar(exprL.getExpr());
                for(int j=i+1; j<expr.length(); j++){
                    chr = expr.charAt(j);
                    if(chr == ':'){
                        if(ans == "true") aux = expr.substring(i+1, j);
                        else aux = expr.substring(j+1);
                        if(descobreTipoDeExpr(aux)){
                            ExprAritmetica exprA = new ExprAritmetica(aux);
                            return exprA.avaliar(exprA.getExpr());
                        }
                        else{
                            exprL.setExpr(aux);
                            return exprL.avaliar(exprL.getExpr());
                        }
                    }
                }
            }
        }
        return "";
    }

    public String imprimirArvore(String expr){
        String ans = "";
        for(int i=0; i<expr.length(); i++){
            char chr = expr.charAt(i);
            if(chr == '?'){
                String aux = expr.substring(0, i);
                ExprLogica exprL = new ExprLogica(aux);
                ans += exprL.imprimirArvore(exprL.getExpr());
                ans += '?';
                for(int j=i+1; j<expr.length(); j++){
                    chr = expr.charAt(j);
                    if(chr == ':'){
                        aux = expr.substring(i+1, j);
                        if(descobreTipoDeExpr(aux)){
                            ExprAritmetica exprA = new ExprAritmetica(aux);
                            ans += exprA.imprimirArvore(exprA.getExpr());
                            ans += ':';
                            aux = expr.substring(j+1);
                            if(descobreTipoDeExpr(aux)){
                                exprA.setExpr(aux);
                                ans += exprA.imprimirArvore(exprA.getExpr());
                            }
                            else{
                                exprL.setExpr(aux);
                                ans += exprL.imprimirArvore(exprL.getExpr());
                            }
                        }
                        else{
                            exprL.setExpr(aux);
                            ans += exprL.imprimirArvore(exprL.getExpr());
                            ans += ':';
                            aux = expr.substring(j+1);
                            if(descobreTipoDeExpr(aux)){
                                ExprAritmetica exprA = new ExprAritmetica(aux);
                                ans += exprA.imprimirArvore(exprA.getExpr());
                            }
                            else{
                                exprL.setExpr(aux);
                                ans += exprL.imprimirArvore(exprL.getExpr());
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }

}


public class Q6 {
    public static void main(String args[]){


        ExprLogica exprL = new ExprLogica("2+5/10<12+16");
        System.out.println(exprL.imprimirArvore(exprL.getExpr()));
        System.out.println(exprL.avaliar(exprL.getExpr()) + "\n");

        ExprAritmetica exprA = new ExprAritmetica("2*3+4/6/6*4");
        System.out.println(exprA.imprimirArvore(exprA.getExpr()));
        System.out.println(exprA.avaliar(exprA.getExpr()) + '\n');

        ExprOpTernario exprOP = new ExprOpTernario("2*3+4/6!=3/4?96+45*3:26*7*6/4+3");
        System.out.println(exprOP.imprimirArvore(exprOP.getExpr()));
        System.out.println(exprOP.avaliar(exprOP.getExpr()) + '\n');

        exprOP.setExpr("2*3+4/6!=3/4?3<5+6:26*7*6/4+3");
        System.out.println(exprOP.imprimirArvore(exprOP.getExpr()));
        System.out.println(exprOP.avaliar(exprOP.getExpr()));
    }
}
