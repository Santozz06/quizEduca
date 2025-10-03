package com.example.quizeduca;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

public class QuizActivity extends AppCompatActivity {

    private TextView txtTemaQuiz, txtTextoBase;
    private GridLayout gridLetras;
    private List<MaterialButton> teclas;
    private List<TextView> celulas;

    private Pergunta perguntaAtual;
    private String palavraCorreta;
    private String respostaOriginal;
    private int tentativaAtual = 0;
    private int posicaoAtual = 0;
    private final int MAX_TENTATIVAS = 6;

    private List<Integer> posicoesValidas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        inicializarViews();

        String temaSelecionado = getIntent().getStringExtra("TEMA_SELECIONADO");
        QuizDbHelper dbHelper = new QuizDbHelper(this);


        int totalPerguntas = dbHelper.getTotalPerguntas();
        System.out.println("DEBUG: Total de perguntas no banco: " + totalPerguntas);

        if (temaSelecionado != null && !temaSelecionado.equals("GERAL")) {
            txtTemaQuiz.setText(temaSelecionado);
            perguntaAtual = dbHelper.getRandomPerguntaByTemaCaseInsensitive(temaSelecionado);
            System.out.println("DEBUG: Buscando por tema: " + temaSelecionado);
        } else {
            txtTemaQuiz.setText("GERAL");
            perguntaAtual = dbHelper.getRandomPerguntaFromAll();
            System.out.println("DEBUG: Buscando de todos os temas");
        }

        if (perguntaAtual != null) {
            txtTextoBase.setText(perguntaAtual.getTextoBase());
            respostaOriginal = perguntaAtual.getResposta().toUpperCase();
            palavraCorreta = normalizarTexto(respostaOriginal);
            inicializarGrid();
            configurarTeclado();

            System.out.println("DEBUG: Tema encontrado: " + perguntaAtual.getTema());
            System.out.println("DEBUG: Resposta: " + respostaOriginal);
        } else {
            txtTextoBase.setText("Nenhuma pergunta encontrada!");
            System.out.println("DEBUG: Nenhuma pergunta retornada do banco");
        }
    }

    private void inicializarViews() {
        txtTemaQuiz = findViewById(R.id.txtTemaQuiz);
        txtTextoBase = findViewById(R.id.txtTextoBase);
        gridLetras = findViewById(R.id.gridRespostas);
        teclas = new ArrayList<>();
        celulas = new ArrayList<>();
        posicoesValidas = new ArrayList<>();
    }

    private void inicializarGrid() {
        gridLetras.removeAllViews();
        celulas.clear();
        posicoesValidas.clear();

        int colunas = respostaOriginal.length();
        gridLetras.setColumnCount(colunas);
        gridLetras.setRowCount(MAX_TENTATIVAS);

        float density = getResources().getDisplayMetrics().density;
        int cellSize = (int) (42 * density);
        int cellMargin = (int) (3 * density);

        for (int row = 0; row < MAX_TENTATIVAS; row++) {
            for (int col = 0; col < colunas; col++) {
                TextView cell = new TextView(this);
                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.width = cellSize;
                params.height = cellSize;
                params.rowSpec = GridLayout.spec(row);
                params.columnSpec = GridLayout.spec(col);
                params.setMargins(cellMargin, cellMargin, cellMargin, cellMargin);

                cell.setLayoutParams(params);
                cell.setGravity(Gravity.CENTER);
                cell.setTextSize(14);
                cell.setText("");

                char c = respostaOriginal.charAt(col);
                if (c == ' ' || c == '-') {
                    cell.setBackgroundColor(getColor(android.R.color.darker_gray));
                    cell.setText(String.valueOf(c));
                    cell.setTextColor(getColor(android.R.color.white));
                } else {
                    cell.setBackgroundResource(R.drawable.cell_background);
                    cell.setTextColor(getColor(android.R.color.white));
                    if (row == tentativaAtual) {
                        posicoesValidas.add(row * colunas + col);
                    }
                }

                gridLetras.addView(cell);
                celulas.add(cell);
            }
        }
    }

    private void configurarTeclado() {
        View tecladoLayout = findViewById(R.id.tecladoLayout);
        configurarTeclasRecursivamente(tecladoLayout);
    }

    private void configurarTeclasRecursivamente(View view) {
        if (view instanceof MaterialButton) {
            MaterialButton tecla = (MaterialButton) view;
            teclas.add(tecla);

            tecla.setOnClickListener(v -> {
                String textoTecla = tecla.getText().toString();
                if (textoTecla.equals("ENTER")) {
                    verificarPalavra();
                } else if (textoTecla.equals("⌫")) {
                    apagarLetra();
                } else {
                    adicionarLetra(textoTecla);
                }
            });
        } else if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            for (int i = 0; i < group.getChildCount(); i++) {
                configurarTeclasRecursivamente(group.getChildAt(i));
            }
        }
    }

    private void adicionarLetra(String letra) {
        if (posicaoAtual < posicoesValidas.size() && tentativaAtual < MAX_TENTATIVAS) {
            int index = posicoesValidas.get(posicaoAtual);
            celulas.get(index).setText(letra);
            System.out.println("DEBUG: Letra '" + letra + "' adicionada na posição " + posicaoAtual + " (índice " + index + ")");
            posicaoAtual++;
        } else {
            System.out.println("DEBUG: Não pode adicionar - posição: " + posicaoAtual + ", tamanho: " + posicoesValidas.size() + ", tentativa: " + tentativaAtual);
        }
    }

    private void apagarLetra() {
        if (posicaoAtual > 0) {
            posicaoAtual--;
            int index = posicoesValidas.get(posicaoAtual);
            celulas.get(index).setText("");
        }
    }

    private void verificarPalavra() {
        System.out.println("DEBUG: Verificando palavra - Posição atual: " + posicaoAtual + "/" + posicoesValidas.size());

        if (posicaoAtual != posicoesValidas.size()) {
            int letrasFaltando = posicoesValidas.size() - posicaoAtual;
            mostrarToast("Preencha mais " + letrasFaltando + " letra(s)! " + posicaoAtual + "/" + posicoesValidas.size());
            return;
        }

        StringBuilder palavraDigitada = new StringBuilder();
        for (int i = 0; i < posicoesValidas.size(); i++) {
            int index = posicoesValidas.get(i);
            String letra = celulas.get(index).getText().toString();
            palavraDigitada.append(letra);
        }

        String palavra = normalizarTexto(palavraDigitada.toString());
        System.out.println("DEBUG: Palavra digitada: '" + palavra + "'");
        System.out.println("DEBUG: Palavra correta: '" + palavraCorreta + "'");
        System.out.println("DEBUG: Tamanho digitado: " + palavra.length() + ", Tamanho correto: " + palavraCorreta.length());

        verificarLetras(palavra);

        if (palavra.equals(palavraCorreta)) {
            System.out.println("DEBUG: ACERTOU!");
            new Handler().postDelayed(() -> {
                mostrarDialogoVitoria();
            }, 500);
        } else {
            System.out.println("DEBUG: ERROU!");
            tentativaAtual++;
            if (tentativaAtual < MAX_TENTATIVAS) {
                atualizarPosicoesValidas();
            }
            posicaoAtual = 0;
            if (tentativaAtual >= MAX_TENTATIVAS) {
                new Handler().postDelayed(() -> {
                    mostrarDialogoDerrota();
                }, 500);
            }
        }
    }

    private void atualizarPosicoesValidas() {
        posicoesValidas.clear();
        int colunas = respostaOriginal.length();

        for (int col = 0; col < colunas; col++) {
            char c = respostaOriginal.charAt(col);
            if (c != ' ' && c != '-') {
                posicoesValidas.add(tentativaAtual * colunas + col);
            }
        }

        System.out.println("DEBUG: Posições válidas atualizadas para linha " + tentativaAtual + ": " + posicoesValidas.size());
    }

    private void verificarLetras(String palavra) {
        int tamanhoMinimo = Math.min(palavra.length(), palavraCorreta.length());

        for (int i = 0; i < tamanhoMinimo; i++) {
            int index = posicoesValidas.get(i);
            TextView cell = celulas.get(index);
            char letra = palavra.charAt(i);

            if (letra == palavraCorreta.charAt(i)) {
                cell.setBackgroundColor(getColor(android.R.color.holo_green_dark));
                atualizarTecla(String.valueOf(letra), "verde");
            } else if (palavraCorreta.contains(String.valueOf(letra))) {
                cell.setBackgroundColor(getColor(android.R.color.holo_orange_dark));
                atualizarTecla(String.valueOf(letra), "amarelo");
            } else {
                cell.setBackgroundColor(getColor(android.R.color.darker_gray));
                atualizarTecla(String.valueOf(letra), "cinza");
            }
        }
    }

    private void atualizarTecla(String letra, String estado) {
        for (MaterialButton tecla : teclas) {
            if (tecla.getText().toString().equals(letra)) {
                switch (estado) {
                    case "verde":
                        tecla.setBackgroundColor(getColor(android.R.color.holo_green_dark));
                        tecla.setTextColor(getColor(android.R.color.white));
                        break;
                    case "amarelo":
                        tecla.setBackgroundColor(getColor(android.R.color.holo_orange_dark));
                        tecla.setTextColor(getColor(android.R.color.white));
                        break;
                    case "cinza":
                        tecla.setBackgroundColor(getColor(android.R.color.darker_gray));
                        tecla.setTextColor(getColor(android.R.color.white));
                        break;
                }
            }
        }
    }

    private void mostrarDialogoVitoria() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialogo_vitoria, null);
        builder.setView(view);

        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);

        Button btnProxima = view.findViewById(R.id.btnProximaPergunta);
        btnProxima.setOnClickListener(v -> {
            dialog.dismiss();
            carregarNovaPergunta();
        });

        dialog.show();
    }

    private void mostrarDialogoDerrota() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.dialogo_derrota, null);
        builder.setView(view);

        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);

        Button btnTentarNovamente = view.findViewById(R.id.btnTentarNovamente);
        Button btnProxima = view.findViewById(R.id.btnProximaPergunta);

        btnTentarNovamente.setOnClickListener(v -> {
            dialog.dismiss();
            reiniciarQuiz();
        });

        btnProxima.setOnClickListener(v -> {
            dialog.dismiss();
            carregarNovaPergunta();
        });

        dialog.show();
    }

    private void reiniciarQuiz() {
        tentativaAtual = 0;
        posicaoAtual = 0;
        inicializarGrid();
        resetarTeclado();
        atualizarPosicoesValidas();
    }

    private void carregarNovaPergunta() {
        String temaSelecionado = getIntent().getStringExtra("TEMA_SELECIONADO");
        QuizDbHelper dbHelper = new QuizDbHelper(this);

        if (temaSelecionado != null && !temaSelecionado.equals("GERAL")) {
            perguntaAtual = dbHelper.getRandomPerguntaByTemaCaseInsensitive(temaSelecionado);
        } else {
            perguntaAtual = dbHelper.getRandomPerguntaFromAll();
        }

        if (perguntaAtual != null) {
            txtTextoBase.setText(perguntaAtual.getTextoBase());
            respostaOriginal = perguntaAtual.getResposta().toUpperCase();
            palavraCorreta = normalizarTexto(respostaOriginal);
            reiniciarQuiz();


            if (temaSelecionado != null && !temaSelecionado.equals("GERAL")) {
                txtTemaQuiz.setText(temaSelecionado);
            } else {
                txtTemaQuiz.setText("GERAL");
            }

            System.out.println("DEBUG: Nova pergunta - Tema: " + perguntaAtual.getTema());
        } else {
            System.out.println("DEBUG: Nenhuma pergunta encontrada ao carregar nova");
        }
    }

    private void resetarTeclado() {
        for (MaterialButton tecla : teclas) {
            tecla.setBackgroundColor(getColor(android.R.color.white));
            tecla.setTextColor(getColor(android.R.color.black));
        }
    }

    private void mostrarToast(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }

    private String normalizarTexto(String texto) {
        return Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .replaceAll("[\\s\\-]", "")
                .toUpperCase();
    }
}