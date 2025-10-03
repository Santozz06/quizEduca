package com.example.quizeduca;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "quiz.db";
    private static final int DATABASE_VERSION = 3;

    public static final String TABLE_PERGUNTAS = "perguntas";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TEMA = "tema";
    public static final String COLUMN_TEXTO_BASE = "texto_base";
    public static final String COLUMN_RESPOSTA = "resposta";

    public QuizDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_PERGUNTAS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TEMA + " TEXT, " +
                COLUMN_TEXTO_BASE + " TEXT, " +
                COLUMN_RESPOSTA + " TEXT)";
        db.execSQL(CREATE_TABLE);

        // PERGUNTAS - 5 de cada matéria
        db.execSQL("INSERT INTO " + TABLE_PERGUNTAS + " (" + COLUMN_TEMA + ", " + COLUMN_TEXTO_BASE + ", " + COLUMN_RESPOSTA + ") VALUES " +
                // HISTÓRIA
                "('História', 'Sistema medieval em que um senhor oferecia proteção e terras a um vassalo, que em troca prestava serviços e jurava fidelidade. Baseava-se em relações pessoais e obrigações mútuas, estruturando poder e hierarquia na sociedade feudal.', 'VASSALAGEM')," +
                "('História', 'Situação de forte divisão política, social ou ideológica entre grupos opostos. Na Guerra Fria, manifestava-se na disputa entre blocos liderados por potências rivais, com impactos globais em economia e política.', 'POLARIZAÇÃO')," +
                "('História', 'Figura histórica símbolo da luta por liberdade e resistência à opressão colonial. Liderou ou se envolveu em movimentos que contestavam o poder português no Brasil, sendo lembrado como mártir da Inconfidência Mineira.', 'TIRADENTES')," +
                "('História', 'Regime autoritário em que o poder está concentrado, direitos políticos são suspensos e opositores sofrem repressão. Caracteriza-se pelo controle sobre a sociedade, censura e uso da força para manter a ordem.', 'DITADURA')," +
                "('História', 'Forma de governo em que um monarca concentra grande parte do poder político e exerce autoridade sobre um território extenso. No contexto brasileiro, marcou a transição da independência à formação do Estado nacional.', 'IMPERIO')," +

                // GEOGRAFIA
                "('Geografia', 'Ação humana que remove a cobertura vegetal nativa, alterando ecossistemas e ciclos naturais. Está ligada a problemas como a perda da biodiversidade, mudanças climáticas e conflitos sociais.', 'DESMATAMENTO')," +
                "('Geografia', 'Fenômeno geológico associado à liberação de magma, gases e cinzas vindos do interior da Terra, formando montanhas e ilhas. Além de modificar a paisagem, exerce impacto direto sobre populações e o clima.', 'VULCANISMO')," +
                "('Geografia', 'Tipo climático marcado por estações bem definidas, com verões quentes e invernos frios, além de chuvas bem distribuídas ao longo do ano. Presente em regiões do sul do Brasil e de outros continentes.', 'SUBTROPICAL')," +
                "('Geografia', 'Processo urbano em que áreas degradadas ou populares passam por revitalização, recebendo investimentos e novos moradores de maior renda. Embora valorize o espaço, provoca expulsão da população original.', 'GENTRIFICACAO')," +
                "('Geografia', 'Movimento político e econômico que resultou na saída de um país europeu da União Europeia, após intenso debate nacional. Representa impactos nas relações comerciais, políticas migratórias e identidade nacional.', 'BREXIT')," +

                // BIOLOGIA
                "('Biologia', 'Conjunto de informações hereditárias presentes no DNA de um indivíduo, que determinam suas características potenciais. Nem sempre o que está nos genes se expressa diretamente na aparência, já que o ambiente também influencia.', 'GENOTIPO')," +
                "('Biologia', 'Estrutura celular responsável pela respiração aeróbica, onde ocorre a produção de ATP, a principal forma de energia utilizada pelas células. Famosa por ser chamada de \"usina da célula\".', 'MITOCONDRIA')," +
                "('Biologia', 'Teoria científica da evolução que explica como as espécies se modificam ao longo do tempo por meio da seleção natural. Indivíduos mais adaptados ao ambiente têm maiores chances de sobrevivência e reprodução.', 'DARWINISMO')," +
                "('Biologia', 'Processo bioquímico realizado por plantas, algas e algumas bactérias, que converte energia luminosa em energia química. É fundamental para a produção de oxigênio e a base da cadeia alimentar.', 'FOTOSSINTESE')," +
                "('Biologia', 'Moléculas orgânicas que funcionam como principal fonte de energia imediata para o organismo. Estão presentes em alimentos como pães, massas e frutas, sendo essenciais para manter as funções vitais.', 'CARBOIDRATOS')," +

                // MATEMÁTICA
                "('Matemática', 'Medida de tendência central que representa o valor que ocupa a posição do meio em um conjunto de dados ordenados. É muito útil quando se quer evitar distorções causadas por valores muito altos ou muito baixos.', 'MEDIANA')," +
                "('Matemática', 'O maior lado de um triângulo retângulo, sempre oposto ao ângulo de 90 graus. É a base de muitos cálculos geométricos, como no famoso Teorema de Pitágoras.', 'HIPOTENUSA')," +
                "('Matemática', 'Operação matemática que responde à pergunta: \"qual expoente deve ser aplicado a uma base para se obter um certo número?\". É bastante usado em escalas, como pH, intensidade sonora e crescimento populacional.', 'LOGARITMO')," +
                "('Matemática', 'Tabelas numéricas organizadas em linhas e colunas que permitem representar e resolver sistemas lineares, além de modelar fenômenos em diversas áreas. São muito utilizadas em computação e estatística.', 'MATRIZES')," +
                "('Matemática', 'Ramo da matemática que estuda relações entre ângulos e lados de triângulos. Suas funções são aplicadas em áreas como engenharia, navegação, astronomia e até em gráficos de ondas sonoras.', 'TRIGONOMETRIA')," +

                // PORTUGUÊS
                "('Português', 'Movimento literário do século XIX, marcado pela valorização das emoções, da natureza e da identidade nacional. No Brasil, teve fases indianista, ultrarromântica e condoreira, influenciando fortemente a construção da ideia de \"nação\".', 'ROMANTISMO')," +
                "('Português', 'Gênero textual que se destaca pelo ritmo, pela musicalidade e pelo uso creativo da linguagem. Pode expressar sentimentos, ideias ou críticas, explorando metáforas, imagens e sonoridades que vão além do discurso cotidiano.', 'POESIA')," +
                "('Português', 'Figura de linguagem caracterizada pelo exagero intencional, usada para intensificar uma ideia ou emoção. É comum tanto na literatura quanto na fala do dia a dia.', 'HIPERBOLE')," +
                "('Português', 'Romance indianista de José de Alencar que simboliza a fusão entre o indígena e o europeu na formação do Brasil. Traz a heroína homônima, cuja história de amor é também uma alegoria sobre identidade nacional.', 'IRACEMA')," +
                "('Português', 'Área da linguística que estuda os significados das palavras, frases e textos. Analisa como os sentidos são construídos e interpretados na comunicação, levando em conta contexto e variações de uso.', 'SEMANTICA')," +

                // INGLÊS
                "('Inglês', 'Ciência que estuda o comportamento e os processos mentais dos seres humanos. Analisa emoções, pensamentos e ações para compreender como indivíduos e grupos se relacionam e reagem ao ambiente.', 'PSYCHOLOGY')," +
                "('Inglês', 'Fenômeno que conecta economias, culturas e sociedades em escala mundial. Impacta comércio, comunicação e intercâmbio cultural, mas também gera debates sobre desigualdade e perda de identidade local.', 'GLOBALIZATION')," +
                "('Inglês', 'Palavra ou expressão que pode ter mais de um significado, dependendo do contexto. É usada para provocar dúvida, ambivalência ou diferentes interpretações em textos ou discursos.', 'AMBIGUOUS')," +
                "('Inglês', 'Palavras que estabelecem relações entre termos em uma frase, indicando lugar, tempo, direção ou causa. São essenciais para construir sentenças corretas e com sentido em inglês.', 'PREPOSITIONS')," +
                "('Inglês', 'Palavras que possuem significados semelhantes ou próximos. São importantes para variar a linguagem, evitar repetições e compreender nuances de interpretação em textos.', 'SYNONYMS')," +

                // FÍSICA
                "('Física', 'Parte da física que estuda cargas elétricas em movimento e os efeitos que produzem, como correntes, campos magnéticos e circuitos. Fundamental para entender o funcionamento de motores, geradores e eletrônicos.', 'ELETRODINAMICA')," +
                "('Física', 'Ramo da física que analisa a propagação de ondas, sejam elas mecânicas ou eletromagnéticas. Estuda fenômenos como reflexão, refração, difração e interferência, presentes no som, luz e rádio.', 'ONDULATORIA')," +
                "('Física', 'Área que investiga o comportamento da luz, sua propagação, reflexão e refração. Aplicada em instrumentos como lentes, telescópios, microscópios e no estudo de cores e imagens.', 'OPTICA')," +
                "('Física', 'Conceito central da mecânica que relaciona a intensidade de uma interação à massa e à aceleração de um corpo. Permite calcular movimentos e entender como objetos respondem a empurrões ou puxões.', 'FORCA')," +
                "('Física', 'Cientista conhecido pela experiência com tubos cheios de mercúrio, que permitiu medir pressão atmosférica. Inventou o barômetro e contribuiu para o estudo de fluidos e gases.', 'TORRICELLI')," +

                // QUÍMICA
                "('Química', 'Elemento químico essencial para a vida, presente em moléculas orgânicas como carboidratos, lipídios, proteínas e ácidos nucleicos. Possui grande capacidade de formar cadeias e anéis, permitindo diversidade molecular.', 'CARBONO')," +
                "('Química', 'Ramo da química que estuda as proporções entre reagentes e produtos em uma reação. Permite calcular quantidades necessárias ou produzidas, garantindo que as reações químicas ocorram de forma balanceada.', 'ESTEQUIOMETRIA')," +
                "('Química', 'Função orgânica caracterizada por um grupo carbonila ligado a pelo menos um átomo de hidrogênio. Está presente em substâncias como formaldeído, vanilina e alguns açúcares.', 'ALDEIDOS')," +
                "('Química', 'Elementos do grupo 17 da Tabela Periódica, altamente reativos, usados em desinfetantes, lâmpadas e compostos orgânicos. Incluem flúor, cloro, bromo, iodo e astato.', 'HALOGENIOS')," +
                "('Química', 'Cientista que propôs o modelo nuclear do átomo, demonstrando que a maior parte da massa está concentrada no núcleo. Famoso por seu experimento com partículas alfa e lâmina de ouro.', 'RUTHERFORD')," +

                // ARTE
                "('Arte', 'Movimento artístico e cultural do século XVII, marcado pelo exagero, o drama e a teatralidade. Nas artes plásticas e na arquitetura, valoriza o contraste de luz e sombra, ornamentação rica e emoções intensas, frequentemente ligado à religião.', 'BARROCO')," +
                "('Arte', 'Estilo artístico do século XVIII, mais leve e decorativo que o Barroco, caracterizado por cores suaves, curvas delicadas e cenas de elegância e intimidade. Aparece em pintura, arquitetura e decoração, refletindo o gosto da aristocracia europeia.', 'ROCOCO')," +
                "('Arte', 'Movimento do final do século XIX, centrado na percepção visual do instante e na captura da luz e da cor. Rompe com o realismo detalhado e busca transmitir sensações, impressões e movimento em pinceladas soltas.', 'IMPRESSIONISMO')," +
                "('Arte', 'Movimento modernista brasileiro que propunha \"devorar\" influências estrangeiras para criar uma arte genuinamente nacional. Defendia a mistura de culturas, tradição indígena e contemporaneidade, buscando identidade própria na literatura e nas artes.', 'ANTROPOFAGIA')," +
                "('Arte', 'Artista modernista brasileira, pioneira na introdução do modernismo no Brasil. Suas obras, marcadas por cores fortes e distorções expressivas, geraram debates sobre arte e renovação estética na década de 1910.', 'MALFATTI')," +

                // EDUCAÇÃO FÍSICA
                "('Educação Física', 'Manifestação cultural e artística brasileira que combina luta, dança, música e acrobacias. Surgiu como forma de resistência de povos africanos escravizados, desenvolvendo habilidades físicas como força, flexibilidade e coordenação, além de promover socialização e expressão cultural.', 'CAPOEIRA')," +
                "('Educação Física', 'Competição internacional que reúne atletas de diversos países em diferentes modalidades esportivas. Mais do que uma disputa, representam valores como disciplina, superação, respeito às regras e união entre povos, inspirando práticas esportivas e desenvolvimento físico.', 'OLIMPIADAS')," +
                "('Educação Física', 'Forma de expressão corporal que integra movimento, ritmo, criatividade e comunicação. Além de artística, é reconhecida como atividade física que melhora a coordenação, equilíbrio, resistência e saúde mental, sendo presente em culturas de todo o mundo.', 'DANCA')," +
                "('Educação Física', 'Conceito aplicado ao esporte e atividades físicas que busca eliminar barreiras para pessoas com diferentes habilidades. Inclui adaptações de espaços, materiais, regras e ensino, garantindo participação plena e inclusão social.', 'ACESSIBILIDADE')," +
                "('Educação Física', 'Estilo de vida caracterizado pela falta de atividade física regular, aumentando risco de doenças cardiovasculares, obesidade e problemas musculoesqueléticos. A educação física atua na prevenção, incentivando hábitos ativos e promoção da saúde.', 'SEDENTARISMO')," +

                // FILOSOFIA
                "('Filosofia', 'Filósofo francês conhecido como \"pai da filosofia moderna\", defensor do pensamento racional e da dúvida metódica. Sua famosa frase \"Penso, logo existo\" representa a busca por fundamentos seguros para o conhecimento.', 'DESCARTES')," +
                "('Filosofia', 'Filósofo grego que abordou diversas áreas do conhecimento, como lógica, ética, política e metafísica. Defendia a ideia de equilíbrio, a prática da virtude e a observação da realidade como caminho para o saber.', 'ARISTOTELES')," +
                "('Filosofia', 'Conceito filosófico e social que se refere à aplicação equilibrada de direitos e deveres. É discutido em diferentes correntes, considerando equidade, legalidade e moralidade na organização das relações humanas.', 'JUSTICA')," +
                "('Filosofia', 'Ramo da filosofia que estuda a conduta humana, princípios morais e o que é considerado certo ou errado. Serve como guia para decisões individuais e coletivas, refletindo sobre responsabilidade e valores.', 'ETICA')," +
                "('Filosofia', 'Teoria política que explica a origem e a legitimidade do Estado a partir de um acordo entre indivíduos. Filósofos como Hobbes, Locke e Rousseau discutem como contratos sociais garantem ordem, direitos e deveres na sociedade.', 'CONTRATUALISMO')," +

                // SOCIOLOGIA
                "('Sociologia', 'Teoria social e econômica baseada nas ideias de Karl Marx, que analisa a luta de classes e a desigualdade na sociedade. Propõe que a história seja marcada por conflitos entre quem detém os meios de produção e quem realiza o trabalho.', 'MARXISMO')," +
                "('Sociologia', 'Sistema econômico em que os meios de produção são privados e a organização da sociedade busca lucro e competição. Influencia nas relações de trabalho, consumo e desigualdade social, sendo predominante no mundo contemporâneo.', 'CAPITALISMO')," +
                "('Sociologia', 'Conceito que analisa de que forma diferentes formas de opressão, como gênero, raça e classe, se cruzam e se reforçam. É usado para entender experiências complexas de discriminação e desigualdade na sociedade.', 'INTERSECCIONALIDADE')," +
                "('Sociologia', 'Sistema de governo em que o poder político é exercido pelo povo, direta ou indiretamente, por meio de eleições e participação social. Inclui direitos civis, liberdade de expressão e mecanismos de fiscalização do poder.', 'DEMOCRACIA')," +
                "('Sociologia', 'Perspectiva teórica que entende a realidade social, econômica e histórica a partir das condições materiais e relações de production. Destaca que a organização econômica influencia a cultura, a política e as ideias da sociedade.', 'MATERIALISMO')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERGUNTAS);
        onCreate(db);
    }

    // buscar perguntas
    public List<Pergunta> getPerguntasByTema(String tema, boolean caseInsensitive) {
        List<Pergunta> lista = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor;
        if (caseInsensitive) {
            cursor = db.rawQuery(
                    "SELECT * FROM " + TABLE_PERGUNTAS + " WHERE UPPER(" + COLUMN_TEMA + ") = UPPER(?)",
                    new String[]{tema}
            );
        } else {
            cursor = db.query(TABLE_PERGUNTAS,
                    null,
                    COLUMN_TEMA + "=?",
                    new String[]{tema},
                    null, null, null);
        }

        if (cursor != null) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
                String temaPergunta = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEMA));
                String textoBase = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXTO_BASE));
                String resposta = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_RESPOSTA));

                lista.add(new Pergunta(id, temaPergunta, textoBase, resposta));
            }
            cursor.close();
        }
        return lista;
    }

    // buscar pergunta aleatoria
    public Pergunta getRandomPerguntaByTema(String tema, boolean caseInsensitive) {
        SQLiteDatabase db = this.getReadableDatabase();
        Pergunta pergunta = null;

        Cursor cursor;
        if (caseInsensitive) {
            cursor = db.rawQuery(
                    "SELECT * FROM " + TABLE_PERGUNTAS + " WHERE UPPER(" + COLUMN_TEMA + ") = UPPER(?) ORDER BY RANDOM() LIMIT 1",
                    new String[]{tema}
            );
        } else {
            cursor = db.rawQuery(
                    "SELECT * FROM " + TABLE_PERGUNTAS + " WHERE " + COLUMN_TEMA + " = ? ORDER BY RANDOM() LIMIT 1",
                    new String[]{tema}
            );
        }

        if (cursor != null && cursor.moveToFirst()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID));
            String temaPergunta = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEMA));
            String textoBase = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TEXTO_BASE));
            String resposta = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_RESPOSTA));

            pergunta = new Pergunta(id, temaPergunta, textoBase, resposta);
            cursor.close();
        }

        return pergunta;
    }

    public List<Pergunta> getPerguntasByTema(String tema) {
        return getPerguntasByTema(tema, false);
    }

    public List<Pergunta> getPerguntasByTemaCaseInsensitive(String tema) {
        return getPerguntasByTema(tema, true);
    }

    public Pergunta getRandomPerguntaByTema(String tema) {
        return getRandomPerguntaByTema(tema, false);
    }

    public Pergunta getRandomPerguntaByTemaCaseInsensitive(String tema) {
        return getRandomPerguntaByTema(tema, true);
    }

    // Busca de pergunta aleatória de Todos os temas
    public Pergunta getRandomPerguntaFromAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Pergunta pergunta = null;

        String query = "SELECT * FROM " + TABLE_PERGUNTAS + " ORDER BY RANDOM() LIMIT 1";

        Cursor cursor = db.rawQuery(query, null);

        if (cursor != null && cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(COLUMN_ID);
            int textoBaseIndex = cursor.getColumnIndex(COLUMN_TEXTO_BASE);
            int respostaIndex = cursor.getColumnIndex(COLUMN_RESPOSTA);
            int temaIndex = cursor.getColumnIndex(COLUMN_TEMA);

            if (idIndex >= 0 && textoBaseIndex >= 0 && respostaIndex >= 0 && temaIndex >= 0) {
                int id = cursor.getInt(idIndex);
                String tema = cursor.getString(temaIndex);
                String textoBase = cursor.getString(textoBaseIndex);
                String resposta = cursor.getString(respostaIndex);


                pergunta = new Pergunta(id, tema, textoBase, resposta);
                System.out.println("DEBUG: Pergunta encontrada - Tema: " + tema + ", Texto: " + textoBase + ", Resposta: " + resposta);
            } else {
                System.out.println("DEBUG: Colunas não encontradas no cursor");
            }
            cursor.close();
        } else {
            System.out.println("DEBUG: Nenhuma pergunta encontrada na tabela");
        }
        db.close();
        return pergunta;
    }


    public int getTotalPerguntas() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT COUNT(*) FROM " + TABLE_PERGUNTAS;
        Cursor cursor = db.rawQuery(query, null);
        int count = 0;
        if (cursor != null && cursor.moveToFirst()) {
            count = cursor.getInt(0);
            cursor.close();
        }
        db.close();
        return count;
    }
}