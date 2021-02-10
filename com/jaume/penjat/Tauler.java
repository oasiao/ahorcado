package com.jaume.penjat;

public class Tauler {
    //atributos
    private char[] ParaulaSecreta;
    private Integer totalNumIntents;
    private Integer vides;
    private String introLetra;
    private String [] palabraEndevinada;

    public void setPalabraEndevinada(String[] palabraEndevinada) {
        this.palabraEndevinada = palabraEndevinada;
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
        for (int i = 0; i < word.length; i++) {
            if(word[i]==letra.charAt(0) && letra.length()==1){
                frase="Lletra correcta";
                String[] palabraEndevinada = new String[word.length];
                palabraEndevinada[i] = String.valueOf(word[i]);//nos interesa pasar los valores coincidentes
                setPalabraEndevinada(palabraEndevinada);
                //this.palabraEndevinada[i]=String.valueOf(introLetra.charAt(0));
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
/*
    public String imprimir() {
        char[] word = this.getParaulaSecreta();
        String introLetra = this.getLetra();
        String espacios = "";
        for (int i = 0; i < word.length; i++) {
            if (word[i] == introLetra.charAt(0)){ //introLetra!=null === true
                espacios += introLetra;
            } else if (word[i]==' ') {
                espacios += " ";
            } else {
                espacios += "_";
            }
        }
        return espacios;
    }*/

    public boolean hasGuanyat() {
        return (String.valueOf(ParaulaSecreta).equals(String.join("",palabraEndevinada)));
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