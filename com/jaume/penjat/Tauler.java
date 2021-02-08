package com.jaume.penjat;

public class Tauler {
    //atributos
    private char[] ParaulaSecreta;
    private Integer totalNumIntents;
    private Integer NumIntents;
    private String introLetra;
    private String[] palabraEndevinada;
    private String[] historico;


    //constructor
    public Tauler() {
    }

    //getters and setters
    public Integer getTotalIntents() {
        return totalNumIntents;
    } //TOTAL INTENTS (FINAL)
    public void setTotalIntents(Integer numIntents) { /*TOTAL INTENTS (FINAL)*/ this.totalNumIntents = numIntents; }

    public Integer getIntents() {
        return NumIntents;
    }

    public void setNumIntents(Integer numIntents) {
        this.NumIntents = numIntents;
    }

    public char[] getParaulaSecreta() {
        return ParaulaSecreta;
    }

    public void setParaulaSecreta(char[] ch) {
        this.ParaulaSecreta = ch;
    }

    public String getLetra() {
        return introLetra;
    }

    public void setLetra(String introLetra) {
        this.introLetra = introLetra;
    }

    //métodos
    public void inicialitzarPartida(String ParaulaSecreta, Integer NumIntents) {
        char[] ch;
        ch = ParaulaSecreta.toCharArray();
        this.setParaulaSecreta(ch);
        this.setNumIntents(NumIntents);
        this.setTotalIntents(NumIntents);
    }

    public String verificar(String introLetra) {
        Integer vides = this.getIntents();
        char[] word = this.getParaulaSecreta();
        this.setLetra(introLetra);
        String frase="";
        for (int i = 0; i < word.length; i++) {
            if(word[i]==introLetra.charAt(0) && introLetra.length()==1){
                frase="Lletra correcta";
                break;
            }
            else
            {
                frase="Lletra incorrecta";
                vides--;
                this.setNumIntents(vides);
            }
        }

        return frase;
    }

    public String imprimir() {
        char[] palabra = this.getParaulaSecreta();
        String paraula=new String(palabra);
        String[] word=paraula.split(""); //pasamos la palabra a string array
        String introLetra = this.getLetra();
        String espacios = "";
        for (int i = 0; i < word.length; i++) {
            if (word[i]==introLetra){
                espacios +=introLetra;
            } else if (word[i]==" ") {
                espacios += " ";
            } else {
                espacios += "_";
            }
        }
        String[] arrayEspacios=espacios.split("");
        this.setPalabraEndevinada(arrayEspacios);
        return espacios;
    }

    public boolean hasGuanyat() {
        /*si se ha completado la palabra --> return true;*/
        boolean verify = true;
        char[] palabra = this.getParaulaSecreta();
        for (int i = 0; i < palabra.length; i++) {
            if (palabra[i] == '_') {
                verify = false;
            }
        }
        return verify;
    }


    public String imprimirVides() {
        Integer vides=this.getIntents();
        String verificacion="";
        Integer totalVides=this.getTotalIntents();
        if(vides>1){
            verificacion= ("Et queden "+vides+" vides de "+totalVides );
        }
        else if(vides<1){
            verificacion= ("Et queda "+vides+" vida de "+totalVides);
        }
        else{
            verificacion= ("No et queden "+vides+" vides"+totalVides);
        }

        return verificacion;
    }

    public String[] getPalabraEndevinada(){ return palabraEndevinada; }

    public void setPalabraEndevinada(String[] palabraEndevinada) {
        palabraEndevinada = palabraEndevinada;
    }
}
