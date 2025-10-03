package com.example.quizeduca;

public class Pergunta {
    private int id;
    private String tema;
    private String textoBase;
    private String resposta;

    public Pergunta(int id, String tema, String textoBase, String resposta) {
        this.id = id;
        this.tema = tema;
        this.textoBase = textoBase;
        this.resposta = resposta;
    }

    public int getId() { return id; }
    public String getTema() { return tema; }
    public String getTextoBase() { return textoBase; }
    public String getResposta() { return resposta; }
}
