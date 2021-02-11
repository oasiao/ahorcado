package com.jaume.penjat;

public class Tauler {
    //atributos
    private char[] ParaulaSecreta;
    private Integer totalNumIntents;
    private Integer vides;
    private String introLetra;
    private static String [] palabraEndevinada;
    private String[] pal;

    public void setPalabraEndevinada(String[] palabraEndevinada) {
        pal=new String[palabraEndevinada.length];
        for (int i=0;i<palabraEndevinada.length;i++)
        {
            pal[i]=palabraEndevinada[i];
        }
        this.palabraEndevinada=pal;
    }

    public String [] getPalabraEndevinada()
    {
        return palabraEndevinada;
    }


    //constructor
    public Tauler() {
    }

    //getters and setters
    public Integer getTotalIntents() {
        return totalNumIntents;
    } //TOTAL INTENTS (FINAL)
    public void setTotalIntents(Integer numIntents) { /*TOTAL INTENTS (FINAL)*/ this.totalNumIntents = numIntents; }

    public Integer getVides() {
        return vides;
    }

    public void setVides(Integer vides) {
        this.vides = vides;
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
        this.setVides(NumIntents);
        this.setTotalIntents(NumIntents);
    }

    public String verificar(String introLetra) {
        Integer vides = this.getVides();
        char[] word = this.getParaulaSecreta();
        setLetra(introLetra);
        String letra = getLetra();
        String frase="";
        String[] pal = new String[word.length];
        for (int i = 0; i < word.length; i++) {
            if(word[i]==letra.charAt(0) && letra.length()==1){
                frase="Lletra correcta";
                pal[i]=letra;

            }
            else
            {
                frase="Lletra incorrecta";
            }
        }
        if(frase.equals("Lletra incorrecta"))
        {
            vides--;
            this.setVides(vides);
        }
        setPalabraEndevinada(pal);
        return frase;
    }
    public String imprimir(){
        String [] palabra = getPalabraEndevinada();
        String espacios ="";
        for (int i = 0; i < palabra.length; i++) {
            if (palabra[i]!=null){
                espacios += String.valueOf(palabra[i]);
            } else {
                espacios += "_";
            }
        }
        return espacios;
    }

    public boolean hasGuanyat() {
        String[] palabra = getPalabraEndevinada();
        String toString = "";
        for (int i = 0; i < palabra.length; i++) {
            toString += palabra[i];
        }
        char[] toChar = toString.toCharArray();
        if (toChar == getParaulaSecreta()) {
            return true;
        }
        else
        {
            return false;
        }
    }


    public String imprimirVides() {
        Integer vides=this.getVides();
        String verificacion;
        Integer totalVides=this.getTotalIntents();
        if(vides>1){
            verificacion = ("Et queden "+vides+" vides de "+totalVides );
        }
        else {
            verificacion= ("Et queda "+vides+" vida de "+totalVides);
        }
        return verificacion;
    }

}