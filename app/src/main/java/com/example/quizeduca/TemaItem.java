package com.example.quizeduca;

public class TemaItem {
    private int imageResId;
    private String nome;

    public TemaItem(int imageResId, String nome) {
        this.imageResId = imageResId;
        this.nome = nome;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getNome() {
        return nome;
    }
}