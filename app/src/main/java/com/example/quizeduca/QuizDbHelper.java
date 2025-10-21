package com.example.quizeduca;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class QuizDbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "quiz.db";
    private static final int DATABASE_VERSION = 5;

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

        // PERGUNTAS
        db.execSQL("INSERT INTO " + TABLE_PERGUNTAS + " (" + COLUMN_TEMA + ", " + COLUMN_TEXTO_BASE + ", " + COLUMN_RESPOSTA + ") VALUES " +
                // HISTÓRIA
                "('História', 'Sistema medieval em que um senhor oferecia proteção e terras a um vassalo, que em troca prestava serviços e jurava fidelidade. Baseava-se em relações pessoais e obrigações mútuas, estruturando poder e hierarquia na sociedade feudal.', 'VASSALAGEM')," +
                "('História', 'Situação de forte divisão política, social ou ideológica entre grupos opostos. Na Guerra Fria, manifestava-se na disputa entre blocos liderados por potências rivais, com impactos globais em economia e política.', 'POLARIZAÇÃO')," +
                "('História', 'Figura histórica símbolo da luta por liberdade e resistência à opressão colonial. Liderou ou se envolveu em movimentos que contestavam o poder português no Brasil, sendo lembrado como mártir da Inconfidência Mineira.', 'TIRADENTES')," +
                "('História', 'Regime autoritário em que o poder está concentrado, direitos políticos são suspensos e opositores sofrem repressão. Caracteriza-se pelo controle sobre a sociedade, censura e uso da força para manter a ordem.', 'DITADURA')," +
                "('História', 'Forma de governo em que um monarca concentra grande parte do poder político e exerce autoridade sobre um território extenso. No contexto brasileiro, marcou a transição da independência à formação do Estado nacional.', 'IMPERIO')," +
                "('História', 'Líder político brasileiro que marcou profundamente o século XX, governando em fases democráticas e autoritárias. Ficou conhecido por políticas trabalhistas, centralização do poder e forte influência no nacionalismo econômico.', 'Vargas')," +
                "('História', 'Movimento social e religioso no sertão baiano do fim do século XIX, liderado por Antônio Conselheiro. A comunidade enfrentou o Exército em uma guerra marcada pela desigualdade, violência e repressão às populações sertanejas.', 'Canudos')," +
                "('História', 'Primeiro-ministro britânico durante a Segunda Guerra Mundial, célebre por sua liderança e discursos de resistência contra o nazismo. Tornou-se símbolo da determinação do Reino Unido frente às adversidades do conflito.', 'Churchill')," +
                "('História', 'Revolução que transformou a economia com a introdução de máquinas, fábricas e produção em larga escala. Mudou as relações de trabalho, acelerou o crescimento urbano e gerou impactos sociais e ambientais.', 'Industrial')," +
                "('História', 'Revolta regional ocorrida no sul do Brasil no século XIX, marcada pela luta dos estancieiros contra o governo imperial. Foi um conflito de longa duração, que combinou reivindicações econômicas com ideias republicanas.', 'Farroupilha')," +
                "('História', 'Presidente do Brasil durante o período mais rígido da Ditadura Civil-Militar (1969–1974). Seu governo ficou marcado pela intensa censura, repressão política e pelo \"milagre econômico\", que aumentou o PIB, mas ampliou desigualdades sociais e a violência estatal.', 'Médici')," +
                "('História', 'Processo de transição do regime autoritário para a volta das liberdades políticas no Brasil, iniciado no fim dos anos 1970 e consolidado em 1985. Representou a retomada das eleições diretas, da liberdade de imprensa e da participação popular nas decisões políticas.', 'Redemocratização')," +
                "('História', 'Processo histórico de dominação e exploração de territórios por potências estrangeiras. No caso do Brasil, envolveu a ocupação portuguesa, o uso da mão de obra escravizada e a imposição cultural e religiosa sobre os povos indígenas. Suas marcas persistem até hoje.', 'Colonização')," +
                "('História', 'Conflito diplomático entre Brasil e França ocorrido entre 1961 e 1963, motivado pela pesca de lagostas na costa nordeste brasileira. Apesar de não ter resultado em guerra armada, foi um episódio simbólico da afirmação da soberania marítima do Brasil. Guerra das…', 'Lagostas')," +
                "('História', 'Conjunto de países que se uniram contra o Eixo durante a Segunda Guerra Mundial. Incluíam, entre outros, Estados Unidos, União Soviética, Reino Unido e França. A vitória deles em 1945 redesenhou o mapa político mundial.', 'Aliados')," +
                "('História', 'Regime político em que o poder se concentra nas mãos de um único governante. Na Europa, especialmente na França, esse sistema atingiu seu auge durante os séculos XVII e XVIII. O monarca controlava legislação, finanças e decisões militares.', 'Absolutismo')," +
                "('História', 'Movimento intelectual que valorizava a razão e a ciência. Filósofos questionavam o poder da Igreja e do absolutismo. Seus ideais influenciaram revoluções políticas e a valorização da liberdade individual.', 'Iluminismo')," +
                "('História', 'Processo de expansão europeia que estabelecia domínio político, econômico e cultural sobre povos de outros continentes. Envolvia exploração de recursos naturais e subjugação das populações locais durante séculos.', 'Colonialismo')," +
                "('História', 'Tratado histórico assinado em 1494 que dividiu as terras recém-descobertas entre Portugal e Espanha. Definia uma linha imaginária no Atlântico para delimitar as regiões de colonização de cada potência.', 'Tordesilhas')," +
                "('História', 'Período pré-histórico marcado pelo desenvolvimento da agricultura e domesticação de animais. Humanos deixaram de ser nômades e começaram a construir assentamentos permanentes e sociedades mais complexas.', 'Neolítica')," +
                "('História', 'Movimento religioso iniciado no século XVI que questionava as práticas da Igreja Católica. Defendia leitura da Bíblia e acesso direto à fé sem intermediários. Gerou profundas divisões políticas e religiosas na Europa.', 'Protestantismo')," +
                "('História', 'Militar e imperador francês que conquistou grande parte da Europa no início do século XIX. Suas campanhas transformaram fronteiras políticas e espalharam ideias revolucionárias pelo continente.', 'Napoleão')," +
                "('História', 'Sistema econômico que priorizava acúmulo de metais preciosos e balança comercial favorável. As metrópoles coloniais extraiam recursos das colônias para enriquecer a nação europeia.', 'Mercantilismo')," +
                "('História', 'Ideologia que valoriza a nação e sua soberania acima de tudo. Gerou conflitos políticos, movimentos independentistas e guerras durante os séculos XIX e XX.', 'Nacionalismo')," +
                "('História', 'Movimento de banditismo social no sertão brasileiro durante séculos XVII a XX. Grupos armados atacavam gado, alimentos e dinheiro, tornando-se heróis populares para o povo oprimido.', 'Cangaço')," +

                // GEOGRAFIA
                "('Geografia', 'Ação humana que remove a cobertura vegetal nativa, alterando ecossistemas e ciclos naturais. Está ligada a problemas como a perda da biodiversidade, mudanças climáticas e conflitos sociais.', 'DESMATAMENTO')," +
                "('Geografia', 'Fenômeno geológico associado à liberação de magma, gases e cinzas vindos do interior da Terra, formando montanhas e ilhas. Além de modificar a paisagem, exerce impacto direto sobre populações e o clima.', 'VULCANISMO')," +
                "('Geografia', 'Tipo climático marcado por estações bem definidas, com verões quentes e invernos frios, além de chuvas bem distribuídas ao longo do ano. Presente em regiões do sul do Brasil e de outros continentes.', 'SUBTROPICAL')," +
                "('Geografia', 'Processo urbano em que áreas degradadas ou populares passam por revitalização, recebendo investimentos e novos moradores de maior renda. Embora valorize o espaço, provoca expulsão da população original.', 'GENTRIFICACAO')," +
                "('Geografia', 'Movimento político e econômico que resultou na saída de um país europeu da União Europeia, após intenso debate nacional. Representa impactos nas relações comerciais, políticas migratórias e identidade nacional.', 'BREXIT')," +
                "('Geografia', 'Sistema agrícola típico de áreas montanhosas, no qual os cultivos são feitos em terrenos inclinados. Exige técnicas de adaptação do solo para evitar erosão e garantir a produção em locais de difícil acesso.', 'Penduralismo')," +
                "('Geografia', 'Indicador demográfico que mede a média de filhos por mulher em determinada população. É usado para compreender dinâmicas populacionais, políticas públicas e projeções de crescimento ou envelhecimento social.', 'Fecundidade')," +
                "('Geografia', 'Processo natural em que a água das chuvas infiltra no solo, carregando sais minerais e nutrientes para camadas mais profundas. Pode empobrecer o solo superficial e afetar atividades agrícolas.', 'Lixiviação')," +
                "('Geografia', 'Tipo de solo fértil, rico em matéria orgânica, encontrado principalmente em regiões de clima temperado. É conhecido por sua cor escura e grande importância para a produção agrícola.', 'Chernozion')," +
                "('Geografia', 'Tipo de limite entre placas tectônicas em que elas colidem, podendo gerar cadeias de montanhas, terremotos e atividade vulcânica. Representa um dos movimentos mais intensos da dinâmica terrestre.', 'Convergentes')," +
                "('Geografia', 'Processo urbano em que áreas antes ocupadas por populações de baixa renda passam por valorização imobiliária. Com isso, moradores antigos são expulsos, o perfil social muda e o espaço é transformado, muitas vezes apagando identidades locais.', 'Gentrificação')," +
                "('Geografia', 'Tipo de clima caracterizado por altas temperaturas e chuvas abundantes durante o ano, comum em regiões próximas à linha do Equador.', 'Equatorial')," +
                "('Geografia', 'Processo de degradação do solo em áreas áridas ou semiáridas, causado por fatores naturais e humanos, como desmatamento e uso inadequado da terra.', 'Desertificação')," +
                "('Geografia', 'Processo de deslocamento de pessoas de um país para outro, motivado por fatores econômicos, sociais, políticos ou ambientais. Pode ser voluntário ou forçado.', 'Migração')," +
                "('Geografia', 'Área de vegetação típica do Brasil central, marcada por árvores retorcidas, clima seco e biodiversidade adaptada às estações.', 'Cerrado')," +
                "('Geografia', 'Estudo das águas continentais e oceânicas do planeta. Inclui rios, lagos, geleiras e aquíferos, fundamentais para entender o clima, a vida e a ocupação humana.', 'Hidrografia')," +
                "('Geografia', 'Grande centro urbano que concentra população, economia e poder político. Funciona como núcleo que comanda a região, atraindo recursos e exercendo influência sobre cidades menores.', 'Metrópole')," +
                "('Geografia', 'Processo de integração econômica, política e cultural entre países. Facilitado por tecnologia e transportes, gerou interdependência entre nações e fluxos de informação', 'Globalização')," +
                "('Geografia', 'Concentração de várias metrópoles próximas que formam uma megacidade. Exemplo clássico: região entre Rio de Janeiro e São Paulo, com milhões de habitantes.', 'Megalópole')," +
                "('Geografia', 'Processo crescente de concentração de população em cidades. Envolve transformação do espaço, construção de infraestrutura e mudanças nos modos de vida da população.', 'Urbanização')," +
                "('Geografia', 'Forma de relevo plana ou com pouca declividade. Geralmente favorável à agricultura, aos assentamentos humanos e com facilidade de deslocamento.', 'Planície')," +
                "('Geografia', 'Extensa área elevada em relação ao nível do mar. Possui topo aplainado, embora possa ter vales profundos e encostas íngremes em suas bordas.', 'Planalto')," +
                "('Geografia', 'Deslocamento de populações de um lugar para outro, em busca de melhores oportunidades ou fugindo de problemas. Configura mudanças demográficas e culturais.', 'Migração')," +
                "('Geografia', 'Estudo estatístico das populações humanas. Analisa crescimento, distribuição, idade, mortalidade e natalidade de grupos sociais em determinados territórios.', 'Demografia')," +
                "('Geografia', 'Forma de relevo caracterizada por elevação natural do terreno com altitude superior a 300 metros. Possui áreas de maior declividade e cume mais ou menos estreito.', 'Montanha')," +

                // BIOLOGIA
                "('Biologia', 'Conjunto de informações hereditárias presentes no DNA de um indivíduo, que determinam suas características potenciais. Nem sempre o que está nos genes se expressa diretamente na aparência, já que o ambiente também influencia.', 'GENOTIPO')," +
                "('Biologia', 'Estrutura celular responsável pela respiração aeróbica, onde ocorre a produção de ATP, a principal forma de energia utilizada pelas células. Famosa por ser chamada de \"usina da célula\".', 'MITOCONDRIA')," +
                "('Biologia', 'Teoria científica da evolução que explica como as espécies se modificam ao longo do tempo por meio da seleção natural. Indivíduos mais adaptados ao ambiente têm maiores chances de sobrevivência e reprodução.', 'DARWINISMO')," +
                "('Biologia', 'Processo bioquímico realizado por plantas, algas e algumas bactérias, que converte energia luminosa em energia química. É fundamental para a produção de oxigênio e a base da cadeia alimentar.', 'FOTOSSINTESE')," +
                "('Biologia', 'Moléculas orgânicas que funcionam como principal fonte de energia imediata para o organismo. Estão presentes em alimentos como pães, massas e frutas, sendo essenciais para manter as funções vitais.', 'CARBOIDRATOS')," +
                "('Biologia', 'Teoria evolutiva que defendia a ideia de que os seres vivos poderiam modificar suas características ao longo da vida e transmitir essas mudanças aos descendentes. Ficou marcada pela lei do uso e desuso e pela herança dos caracteres adquiridos.', 'Lamarckismo')," +
                "('Biologia', 'Estratégia biológica em que um organismo imita características visuais, sonoras ou químicas de outro para obter vantagens de sobrevivência. Pode servir para enganar predadores, atrair presas ou confundir competidores.', 'Mimetismo')," +
                "('Biologia', 'Conjunto formado por fatores bióticos (seres vivos) e abióticos (clima, solo, água, luz) que interagem em equilíbrio. Funciona como uma rede complexa de relações, em que energia e matéria circulam continuamente.', 'Ecossistema')," +
                "('Biologia', 'Conjunto de características observáveis de um organismo, como cor dos olhos, altura ou comportamento. É resultado da interação entre o genótipo (informações genéticas) e o ambiente em que o indivíduo vive.', 'Fenótipo')," +
                "('Biologia', 'Membrana que envolve a célula, controlando a entrada e saída de substâncias. É formada por uma bicamada lipídica com proteínas, garantindo proteção, comunicação celular e manutenção do equilíbrio interno.', 'Plasmática')," +
                "('Biologia', 'Relação ecológica entre indivíduos de espécies diferentes que convivem de forma próxima e contínua. Pode ser benéfica para ambos (mutualismo), apenas para um (comensalismo) ou prejudicial para um dos envolvidos (parasitismo). É essencial para o equilíbrio dos ecossistemas.', 'Simbiose')," +
                "('Biologia', 'Processo de divisão celular que reduz pela metade o número de cromossomos, originando células haplóides. É fundamental para a reprodução sexuada, pois garante a variabilidade genética nas espécies. Ocorre em duas etapas principais.', 'Meiose')," +
                "('Biologia', 'Tipo de divisão celular que gera duas células-filhas idênticas à célula-mãe, com o mesmo número de cromossomos. É responsável pelo crescimento, regeneração de tecidos e manutenção dos organismos multicelulares. Divide-se em fases: prófase, metáfase, anáfase e telófase.', 'Mitose')," +
                "('Biologia', 'Processo biológico que ocorre após a fecundação do óvulo pelo espermatozóide, resultando no desenvolvimento de um embrião dentro do útero. Dura aproximadamente 40 semanas e envolve intensas transformações hormonais e fisiológicas no corpo da mulher.', 'Gravidez')," +
                "('Biologia', 'Conjunto de órgãos responsáveis pelas trocas gasosas entre o corpo e o ambiente. Inclui nariz, traqueia, brônquios e pulmões, que garantem a entrada de oxigênio e a eliminação do gás carbônico. É essencial para o metabolismo e a produção de energia celular. Sistema…', 'Respiratório')," +
                "('Biologia', 'Capacidade do organismo de manter condições internas estáveis apesar de variações externas. Envolve regulação de temperatura, pH e concentração de substâncias.', 'Homeostase')," +
                "('Biologia', 'Alteração no material genético que pode ser herdada. Gera variação nas espécies e é matéria-prima para a seleção natural evoluir.', 'Mutação')," +
                "('Biologia', 'Substância química produzida por glândulas que regula funções do organismo. Circula pela corrente sanguínea influenciando metabolismo, crescimento e comportamento.', 'Hormônio')," +
                "('Biologia', 'Vírus que possui RNA como material genético. Inverte seu material genético para se replicar dentro da célula hospedeira, como no caso do HIV.', 'Retrovírus')," +
                "('Biologia', 'Variedade de espécies, ecossistemas e genes em um determinado ambiente. Quanto maior, mais resiliente é o ecossistema frente a mudanças.', 'Biodiversidade')," +
                "('Biologia', 'Estrutura que contém material genético em forma de DNA. Presente no núcleo celular e carrega os genes responsáveis pelas características hereditárias.', 'Cromossomo')," +
                "('Biologia', 'Movimento de água através de membrana semipermeável. Segue da região com menor concentração de soluto para a com maior concentração.', 'Osmose')," +
                "('Biologia', 'Organela celular responsável pela fotossíntese. Contém clorofila e transforma energia solar em energia química para a célula vegetal.', 'Cloroplasto')," +
                "('Biologia', 'Proteína que acelera reações químicas no organismo. Atua como catalisador, permitindo que processos biológicos ocorram em velocidade adequada.', 'Enzima')," +
                "('Biologia', 'Estrutura celular responsável pela síntese de proteínas. Lê a informação do RNA e traduz em cadeias de aminoácidos.', 'Ribossomo')," +

                // MATEMÁTICA
                "('Matemática', 'Medida de tendência central que representa o valor que ocupa a posição do meio em um conjunto de dados ordenados. É muito útil quando se quer evitar distorções causadas por valores muito altos ou muito baixos.', 'MEDIANA')," +
                "('Matemática', 'O maior lado de um triângulo retângulo, sempre oposto ao ângulo de 90 graus. É a base de muitos cálculos geométricos, como no famoso Teorema de Pitágoras.', 'HIPOTENUSA')," +
                "('Matemática', 'Operação matemática que responde à pergunta: \"qual expoente deve ser aplicado a uma base para se obter um certo número?\". É bastante usado em escalas, como pH, intensidade sonora e crescimento populacional.', 'LOGARITMO')," +
                "('Matemática', 'Tabelas numéricas organizadas em linhas e colunas que permitem representar e resolver sistemas lineares, além de modelar fenômenos em diversas áreas. São muito utilizadas em computação e estatística.', 'MATRIZES')," +
                "('Matemática', 'Ramo da matemática que estuda relações entre ângulos e lados de triângulos. Suas funções são aplicadas em áreas como engenharia, navegação, astronomia e até em gráficos de ondas sonoras.', 'TRIGONOMETRIA')," +
                "('Matemática', 'Triângulo em que todos os lados possuem medidas diferentes, assim como os ângulos internos. Essa característica o torna assimétrico, e nenhum dos seus lados pode ser usado como base de simetria. É um exemplo importante para o estudo das desigualdades entre lados e ângulos de triângulos.', 'Escaleno')," +
                "('Matemática', 'Triângulo que possui dois lados iguais e, consequentemente, dois ângulos opostos com a mesma medida. Essa propriedade o torna mais previsível em problemas de geometria, sendo muito usado em construções e cálculos de área. Representa um equilíbrio entre simetria e diversidade.', 'Isósceles')," +
                "('Matemática', 'Expressão matemática que relaciona números e incógnitas por meio de uma igualdade. Resolver uma equação significa encontrar os valores que tornam a igualdade verdadeira. Pode ser simples, como equações lineares, ou complexas, envolvendo funções e sistemas.', 'Equação')," +
                "('Matemática', 'Representação visual de informações ou relações matemáticas, usada para organizar dados e facilitar a compreensão. Pode aparecer em gráficos, diagramas de Venn, fluxogramas ou representações geométricas. É uma ponte entre a linguagem abstrata da matemática e a visualização concreta.', 'Diagrama')," +
                "('Matemática', 'Função representada pela fórmula f(x)=ax2+bx+cf(x) = ax^2 + bx + cf(x)=ax2+bx+c, cujo gráfico tem formato de parábola. É fundamental para estudar máximos e mínimos, raízes de equações e movimentos parabólicos. Seu uso aparece em áreas como física, economia e engenharia.', 'Quadrática')," +
                "('Matemática', 'Termo usado para designar ângulos ou linhas que não são perpendiculares nem paralelas entre si. Um triângulo [...], por exemplo, é aquele que não possui ângulo reto. Esse conceito é fundamental para o estudo da geometria e da trigonometria.', 'Oblíquo')," +
                "('Matemática', 'Polígono de quatro lados e quatro ângulos retos, caracterizado pelos lados opostos paralelos e de medidas iguais. É uma das figuras mais comuns na geometria plana e serve de base para cálculos de área, perímetro e aplicações em arquitetura e design.', 'Retangulo')," +
                "('Matemática', 'Conjunto de todos os pontos de um plano que estão à mesma distância de um ponto fixo chamado centro. É amplamente usada em problemas que envolvem movimento circular, medições de ângulo e relações com o número π (pi).', 'Circunferência')," +
                "('Matemática', 'Fórmula matemática usada para resolver equações do segundo grau. Permite encontrar as raízes de uma parábola. É uma das ferramentas mais conhecidas e aplicadas do ensino de álgebra.', 'Bhaskara')," +
                "('Matemática', 'Resultado da multiplicação entre dois ou mais números ou expressões. O conceito vai além da aritmética, aparecendo também em áreas como álgebra, matrizes e funções. É essencial para compreender relações de proporcionalidade e crescimento.', 'Produto')," +
                "('Matemática', 'Medida matemática da chance de um evento ocorrer. Expressa como número entre 0 e 1, onde 0 significa impossível e 1 significa certeza.', 'Probabilidade')," +
                "('Matemática', 'Área da matemática que usa símbolos para representar números e operações. Permite resolver equações e trabalhar com relações entre variáveis.', 'Álgebra')," +
                "('Matemática', 'Coleção de elementos bem definidos e distintos. Fundamento da matemática moderna para organizar e estudar relações entre objetos.', 'Conjunto')," +
                "('Matemática', 'Expressão algébrica com múltiplos termos compostos de variáveis e constantes. Cada termo possui um grau determinado pela potência da variável.', 'Polinômio')," +
                "('Matemática', 'Conceito de cálculo que mede a taxa de variação de uma função. Indica a inclinação da reta tangente à curva em um ponto específico.', 'Derivada')," +
                "('Matemática', 'Reta que toca uma curva em apenas um ponto. Em trigonometria, razão entre seno e cosseno de um ângulo.', 'Tangente')," +
                "('Matemática', 'Medida de superfície de uma forma geométrica bidimensional. Expressa em unidades quadradas e varia conforme o tipo de figura.', 'Área')," +
                "('Matemática', 'Relação matemática de igualdade entre razões. Indica que duas frações têm o mesmo valor quando multiplicadas em cruz.', 'Proporção')," +
                "('Matemática', 'Símbolo gráfico usado para representar números. O sistema decimal utiliza 10 números: de 0 a 9.', 'Algarismo')," +
                "('Matemática', 'Medida do espaço tridimensional ocupado por um objeto. Expressa em unidades cúbicas e varia conforme a forma geométrica.', 'Volume')," +

                // PORTUGUÊS
                "('Português', 'Movimento literário do século XIX, marcado pela valorização das emoções, da natureza e da identidade nacional. No Brasil, teve fases indianista, ultrarromântica e condoreira, influenciando fortemente a construção da ideia de \"nação\".', 'ROMANTISMO')," +
                "('Português', 'Gênero textual que se destaca pelo ritmo, pela musicalidade e pelo uso creativo da linguagem. Pode expressar sentimentos, ideias ou críticas, explorando metáforas, imagens e sonoridades que vão além do discurso cotidiano.', 'POESIA')," +
                "('Português', 'Figura de linguagem caracterizada pelo exagero intencional, usada para intensificar uma ideia ou emoção. É comum tanto na literatura quanto na fala do dia a dia.', 'HIPERBOLE')," +
                "('Português', 'Romance indianista de José de Alencar que simboliza a fusão entre o indígena e o europeu na formação do Brasil. Traz a heroína homônima, cuja história de amor é também uma alegoria sobre identidade nacional.', 'IRACEMA')," +
                "('Português', 'Área da linguística que estuda os significadas das palavras, frases e textos. Analisa como os sentidos são construídos e interpretados na comunicação, levando em conta contexto e variações de uso.', 'SEMANTICA')," +
                "('Português', 'Gênero textual que mistura fatos do cotidiano com reflexões ou críticas sociais, geralmente escritas em tom leve e acessível. Pode abordar desde acontecimentos banais até grandes temas, sempre com um olhar subjetivo do autor. É muito utilizada em jornais e revistas.', 'Crônica')," +
                "('Português', 'Conjunto de regras que determinam o uso dos acentos gráficos na língua portuguesa. Ajuda a indicar a tonicidade e, em alguns casos, a diferenciar palavras de escrita igual, mas com significados distintos. É essencial para a clareza e correção da escrita.', 'Acentuação')," +
                "('Português', 'Estrutura que organiza a língua, estabelecendo normas sobre como as palavras devem ser usadas em frases e textos. Inclui morfologia, sintaxe, semântica e fonética. Embora possa parecer rígida, é uma ferramenta fundamental para a comunicação eficiente.', 'Gramática')," +
                "('Português', 'Refere-se à forma correta de escrever as palavras, seguindo as convenções da língua. Abrange o uso adequado de letras, hífen, maiúsculas e minúsculas. Mudanças como o Acordo Ortográfico mostram que a ortografia também acompanha a evolução da língua.', 'Ortografia')," +
                "('Português', 'Encontro de uma vogal com uma semivogal na mesma sílaba, formando um único som. Pode ser classificado em crescente (quando a semivogal vem antes) ou decrescente (quando vem depois). É um dos elementos que tornam a língua portuguesa rica em sonoridade.', 'Ditongo')," +
                "('Português', 'Classe de palavras que nomeia seres, objetos, sentimentos ou ideias, podendo variar em gênero e número.', 'Substantivo')," +
                "('Português', 'Tipo de sujeito que não aparece de forma explícita na oração, mas pode ser identificado pelo contexto verbal.', 'Oculto')," +
                "('Português', 'Palavra que indica circunstâncias de tempo, lugar, modo ou intensidade, modificando verbos, adjetivos ou outros advérbios.', 'Advérbio')," +
                "('Português', 'Escritora brasileira que explorou a subjetividade, os sentimentos e os silêncios da alma humana. Com estilo intimista e reflexivo, é autora de obras como \"A Hora da Estrela\". Clarice…', 'Lispector')," +
                "('Português', 'Movimento literário que surgiu no Brasil na década de 1920, rompendo com padrões estéticos tradicionais e valorizando a liberdade de expressão, a linguagem coloquial e a identidade nacional.', 'Modernismo')," +
                "('Português', 'Linguagem específica de um grupo profissional ou social. Facilita comunicação entre membros do grupo, mas pode excluir quem não conhece os termos.', 'Jargão')," +
                "('Português', 'Tipo de texto que apresenta argumentos sobre um tema. Busca convencer o leitor através da exposição lógica de ideias e exemplos.', 'Dissertativo')," +
                "('Português', 'Regra gramatical que harmoniza palavras em gênero e número. Garante coerência entre artigos, adjetivos e substantivos na oração.', 'Concordância')," +
                "('Português', 'Sequência de eventos e ações que compõem a história de uma narrativa. É o fio condutor que mantém a trama unida do início ao fim.', 'Enredo')," +
                "('Português', 'Tipo de texto que conta uma história com personagens, tempo e espaço. Apresenta conflitos e suas resoluções em ordem sequencial.', 'Narrativa')," +
                "('Português', 'Recurso linguístico que expressa o oposto do que se diz literalmente. Geralmente gera efeito de humor, crítica ou sarcasmo.', 'Ironia')," +
                "('Português', 'Divisão de um texto que agrupa ideias relacionadas. Iniciado com recuo ou espaço em branco e encerra uma unidade de pensamento.', 'Parágrafo')," +
                "('Português', 'Raciocínio ou evidência usada para sustentar uma tese ou posição. Base lógica sobre a qual uma afirmação se estabelece.', 'Argumento')," +
                "('Português', 'Repetição desnecessária de ideias já expressas. Torna o texto verboso e prejudica a clareza da comunicação.', 'Redundância')," +
                "('Português', 'Unidade mínima de som de uma língua. Diferente de letra, pois um fonema pode ser representado por diferentes letras.', 'Fonema')," +

                // INGLÊS
                "('Inglês', 'Science that studies human behavior and mental processes. It analyzes emotions, thoughts, and actions to understand how individuals and groups interact with and respond to their environment.', 'PSYCHOLOGY')," +
                "('Inglês', 'Phenomenon that connects economies, cultures, and societies on a global scale. It impacts trade, communication, and cultural exchange, but also sparks debates about inequality and the loss of local identity.', 'GLOBALIZATION')," +
                "('Inglês', 'Word or expression that can have more than one meaning, depending on the context. It is used to create doubt, ambiguity, or different interpretations in texts or speeches.', 'AMBIGUOUS')," +
                "('Inglês', 'Words that establish relationships between terms in a sentence, indicating place, time, direction, or cause. They are essential for building correct and meaningful sentences in English.', 'PREPOSITIONS')," +
                "('Inglês', 'Words that have similar or related meanings. They are important for varying language, avoiding repetition, and understanding nuances of interpretation in texts.', 'SYNONYMS')," +
                "('Inglês', 'The study of past events, societies, and civilizations, aiming to understand how they shaped the present and may influence the future. It includes political, cultural, social, and economic aspects, helping us build a sense of identity and continuity over time.', 'History')," +
                "('Inglês', 'A small but fundamental word in English grammar used before nouns to define them as specific or unspecific. Articles can be definite (the) or indefinite (a, an), and their correct use is essential for clear communication and sentence structure.', 'Article')," +
                "('Inglês', 'Words that replace nouns in sentences to avoid repetition and improve fluency in communication. They include personal pronouns (I, you, he, she), possessive pronouns (mine, yours), and relative pronouns (who, which), among others.', 'Pronouns')," +
                "('Inglês', 'The application of knowledge, tools, and techniques to create solutions that solve problems or make tasks easier. It evolves rapidly and affects many areas of human life, such as communication, health, education, and entertainment.', 'Technology')," +
                "('Inglês', 'The system or group of people that organizes and manages a society, creating laws, enforcing rules, and providing services. Governments can take different forms, such as democracy, monarchy, or dictatorship, each with its own way of exercising power.', 'Government')," +
                "('Inglês', 'System of beliefs, values, and practices shared by a group of people. It shapes identity, influences behavior, and is passed down through generations.', 'Culture')," +
                "('Inglês', 'Ability to understand and share the feelings of others. It plays a key role in relationships, communication, and emotional intelligence.', 'Empathy')," +
                "('Inglês', 'Political and economic system in which the means of production are privately owned, and profit drives decision-making. It often leads to social inequality.', 'Capitalism')," +
                "('Inglês', 'Form of government in which power is held by the people, often through elected representatives. It values participation, freedom, and equality.', 'Democracy')," +
                "('Inglês', 'Natural satellite that orbits the Earth, influences tides, and has been a source of fascination and exploration throughout human history.', 'Moon')," +
                "('Inglês', 'Part of speech that modifies verbs, adjectives, or other adverbs. Usually indicates manner, time, place, or degree of an action or quality.', 'Adverb')," +
                "('Inglês', 'Word that describes or modifies a noun or pronoun. Adds information about qualities, colors, quantities, or states of being.', 'Adjective')," +
                "('Inglês', 'Grammatical unit that expresses a complete thought. Contains a subject and predicate, conveying meaning independently.', 'Sentence')," +
                "('Inglês', 'Spoken exchange of ideas between two or more people. Requires active listening and appropriate turn-taking between participants.', 'Conversation')," +
                "('Inglês', 'Collection of words known and understood by a person or group. Essential for reading comprehension and effective communication.', 'Vocabulary')," +
                "('Inglês', 'System of rules that governs the structure of language. Ensures correct arrangement of words to convey meaning clearly.', 'Grammar')," +
                "('Inglês', 'Skill of composing and organizing ideas into written form. Requires planning, drafting, and revision for effective communication.', 'Writing')," +
                "('Inglês', 'Unit of written text dealing with a single topic or idea. Contains a main point supported by relevant details and examples.', 'Paragraph')," +
                "('Inglês', 'Exchange of information, ideas, or feelings between individuals. Can be verbal, non-verbal, or written in various contexts.', 'Communication')," +
                "('Inglês', 'Converting text from one language to another while preserving meaning. Requires understanding cultural nuances and linguistic differences.', 'Translation')," +

                // FÍSICA
                "('Física', 'Parte da física que estuda cargas elétricas em movimento e os efeitos que produzem, como correntes, campos magnéticos e circuitos. Fundamental para entender o funcionamento de motores, geradores e eletrônicos.', 'ELETRODINAMICA')," +
                "('Física', 'Ramo da física que analisa a propagação de ondas, sejam elas mecânicas ou eletromagnéticas. Estuda fenômenos como reflexão, refração, difração e interferência, presentes no som, luz e rádio.', 'ONDULATORIA')," +
                "('Física', 'Área que investiga o comportamento da luz, sua propagação, reflexão e refração. Aplicada em instrumentos como lentes, telescópios, microscópios e no estudo de cores e imagens.', 'OPTICA')," +
                "('Física', 'Conceito central da mecânica que relaciona a intensidade de uma interação à massa e à aceleração de um corpo. Permite calcular movimentos e entender como objetos respondem a empurrões ou puxões.', 'FORCA')," +
                "('Física', 'Cientista conhecido pela experiência com tubos cheios de mercúrio, que permitiu medir pressão atmosférica. Inventou o barômetro e contribuiu para o estudo de fluidos e gases.', 'TORRICELLI')," +
                "('Física', 'Grandeza física que indica a variação da posição de um corpo em relação ao tempo. É um vetor, ou seja, possui direção e sentido, diferindo da rapidez, que é apenas escalar. É fundamental no estudo do movimento, desde carros em estradas até planetas no espaço.', 'Velocidade')," +
                "('Física', 'Ramo da Física que estuda as relações entre calor, trabalho, energia e temperatura. Suas leis explicam desde o funcionamento de motores e geladeiras até fenômenos naturais como a propagação do calor na atmosfera. É essencial para a compreensão de sistemas energéticos.', 'Termodinâmica')," +
                "('Física', 'Força resultante da deformação de corpos elásticos, descrita pela Lei de Hooke. Quando um objeto, como uma mola, é comprimido ou esticado, essa força atua para devolver o corpo à sua forma original. Está presente em inúmeros sistemas mecânicos e engenharias.', 'Elástica')," +
                "('Física', 'Dispositivos capazes de armazenar energia elétrica em forma de campo elétrico. São compostos por duas placas condutoras separadas por um isolante, o dielétrico. Têm aplicações em eletrônicos, como filtros, fontes de energia e circuitos de temporização.', 'Capacitores')," +
                "('Física', 'Área da Física que analisa as interações entre cargas elétricas em repouso. Explica fenômenos como a atração de objetos leves por um pente eletrizado ou os raios durante tempestades. É a base para o entendimento dos campos elétricos e potenciais.', 'Eletrostática')," +
                "('Física', 'Unidade de medida usada para expressar força no Sistema Internacional, equivalente a kg·m/s².', 'Newton')," +
                "('Física', 'Unidade de medida de temperatura usada no Sistema Internacional, especialmente em estudos científicos. Parte do zero absoluto, onde não há movimento molecular, e é essencial na física térmica e na termodinâmica.', 'Kelvin')," +
                "('Física', 'Escala de temperatura usada principalmente em países como os Estados Unidos. Nela, a água congela a 32° e ferve a 212°, sendo diferente das escalas Celsius e Kelvin.', 'Fahrenheit')," +
                "('Física', 'Escala de temperatura usada no Brasil e em muitos países. Nela, a água congela a 0 °C e ferve a 100 °C, sob condições normais de pressão. É comum em termômetros, previsões do tempo e estudos escolares.', 'Celsius')," +
                "('Física', 'Fenômeno em que a luz muda de direção ao passar de um meio para outro, como do ar para a água.', 'Refração')," +
                "('Física', 'Taxa de mudança da velocidade de um objeto. Pode ser positiva ou negativa (frenagem).', 'Aceleração')," +
                "('Física', 'Fenômeno onde ondas contornam obstáculos ou passam por aberturas. Evidencia a natureza ondulatória de fenômenos como luz e som.', 'Difração')," +
                "('Física', 'Taxa de transferência ou consumo de energia por unidade de tempo. Medida em watts e indica a intensidade do trabalho realizado.', 'Potência')," +
                "('Física', 'Força de atração entre massas. Mantém objetos presos à Terra e governa movimentos de corpos celestes.', 'Gravidade')," +
                "('Física', 'Transferência de energia quando uma força atua sobre um objeto em movimento. Calculado como produto da força pela distância percorrida.', 'Trabalho')," +
                "('Física', 'Força que se opõe ao movimento relativo entre superfícies em contato. Dissipa energia em forma de calor e som.', 'Atrito')," +
                "('Física', 'Onda mecânica que se propaga através de um meio. Gerada por vibrações e viaja mais lentamente que a luz.', 'Som')," +
                "('Física', 'Dimensão na qual eventos ocorrem em sequência. Medido em segundos, minutos, horas e outros intervalos padronizados.', 'Tempo')," +
                "('Física', 'Trajetória curved seguida por um objeto em torno de outro. Resultado do equilíbrio entre velocidade tangencial e atração gravitacional.', 'Órbita')," +
                "('Física', 'Dimensão tridimensional onde todos os objetos existem. Infinito e intangível, sendo o palco para todos os fenômenos físicos.', 'Espaço')," +

                // QUÍMICA
                "('Química', 'Elemento químico essencial para a vida, presente em moléculas orgânicas como carboidratos, lipídios, proteínas e ácidos nucleicos. Possui grande capacidade de formar cadeias e anéis, permitindo diversidade molecular.', 'CARBONO')," +
                "('Química', 'Ramo da química que estuda as proporções entre reagentes e produtos em uma reação. Permite calcular quantidades necessárias ou produzidas, garantindo que as reações químicas ocorram de forma balanceada.', 'ESTEQUIOMETRIA')," +
                "('Química', 'Função orgânica caracterizada por um grupo carbonila ligado a pelo menos um átomo de hidrogênio. Está presente em substâncias como formaldeído, vanilina e alguns açúcares.', 'ALDEIDOS')," +
                "('Química', 'Elementos do grupo 17 da Tabela Periódica, altamente reativos, usados em desinfetantes, lâmpadas e compostos orgânicos. Incluem flúor, cloro, bromo, iodo e astato.', 'HALOGENIOS')," +
                "('Química', 'Cientista que propôs o modelo nuclear do átomo, demonstrando que a maior parte da massa está concentrada no núcleo. Famoso por seu experimento com partículas alfa e lâmina de ouro.', 'RUTHERFORD')," +
                "('Química', 'Partículas com carga negativa que orbitam o núcleo do átomo, sendo essenciais nas ligações químicas.', 'Elétron')," +
                "('Química', 'Processo em que uma substância passa do estado sólido diretamente para o gasoso, sem passar pelo estado líquido.', 'Sublimação')," +
                "('Química', 'Tipo de ligação química que ocorre quando dois ou mais átomos compartilham pares de elétrons entre si, buscando alcançar a estabilidade eletrônica. Essa ligação é comum entre elementos não metálicos e está presente em moléculas como a da água e do gás oxigênio.', 'Covalente')," +
                "('Química', 'Quantidade de matéria que contém o mesmo número de partículas que há em 12 gramas de carbono-12. É usada para facilitar cálculos químicos.', 'Mol')," +
                "('Química', 'Grupo de elementos altamente reativos, encontrados na primeira coluna da Tabela Periódica. Possuem apenas um elétron na camada de valência e reagem intensamente com a água.', 'Alcalinos')," +
                "('Química', 'Partícula fundamental da matéria, composta por prótons, nêutrons e elétrons. É a menor unidade de um elemento químico.', 'Átomo')," +
                "('Química', 'Método usado para separar misturas homogêneas de líquidos com diferentes pontos de ebulição. O líquido que evapora primeiro é condensado e recolhido separadamente.', 'Destilação')," +
                "('Química', 'Tipo de ligação química que ocorre quando um átomo doa elétrons e outro os recebe, formando íons com cargas opostas. Essa atração eletrostática entre os íons resulta em compostos geralmente sólidos e com alto ponto de fusão, como o sal de cozinha.', 'Iônica')," +
                "('Química', 'Elemento não metálico presente em todos os seres vivos, base da química orgânica.', 'Carbono')," +
                "('Química', 'Metal que permanece líquido à temperatura ambiente. Foi muito usado em termômetros, mas é tóxico e seu uso diminuiu com o tempo.', 'Mercúrio')," +
                "('Química', 'Substância que doa prótons (H+) em solução aquosa. Possui pH menor que 7 e reage com bases formando sal e água.', 'Ácido')," +
                "('Química', 'Mistura homogênea de soluto e solvente. Mantém as propriedades uniformes em toda sua extensão.', 'Solução')," +
                "('Química', 'Processo de perda de elétrons por um elemento. Geralmente resulta em aumento do estado de oxidação e liberação de energia.', 'Oxidação')," +
                "('Química', 'Processo químico onde substâncias se transformam em outras. Envolve ruptura e formação de ligações entre átomos.', 'Reação')," +
                "('Química', 'Substância que aceita prótons (H+) em solução aquosa. Possui pH maior que 7 e neutraliza ácidos.', 'Base')," +
                "('Química', 'Transição de estado físico de sólido para líquido. Requer absorção de calor até atingir o ponto de fusão.', 'Fusão')," +
                "('Química', 'Substância que dissolve outra (soluto) formando uma solução. Geralmente presente em maior quantidade.', 'Solvente')," +
                "('Química', 'Substância dissolvida em um solvente. Presente em menor quantidade e determina as propriedades da solução.', 'Soluto')," +
                "('Química', 'Estado físico da matéria com forma e volume definidos. Moléculas vibram em posições fixas, estruturando-se em padrões.', 'Sólido')," +
                "('Química', 'Elemento químico que conduz eletricidade e calor. Geralmente brilhante, maleável e dúctil em temperatura ambiente.', 'Metal')," +

                // ARTE
                "('Arte', 'Movimento artístico e cultural do século XVII, marcado pelo exagero, o drama e a teatralidade. Nas artes plásticas e na arquitetura, valoriza o contraste de luz e sombra, ornamentação rica e emoções intensas, frequentemente ligado à religião.', 'BARROCO')," +
                "('Arte', 'Estilo artístico do século XVIII, mais leve e decorativo que o Barroco, caracterizado por cores suaves, curvas delicadas e cenas de elegância e intimidade. Aparece em pintura, arquitetura e decoração, refletindo o gosto da aristocracia europeia.', 'ROCOCO')," +
                "('Arte', 'Movimento do final do século XIX, centrado na percepção visual do instante e na captura da luz e da cor. Rompe com o realismo detalhado e busca transmitir sensações, impressões e movimento em pinceladas soltas.', 'IMPRESSIONISMO')," +
                "('Arte', 'Movimento modernista brasileiro que propunha \"devorar\" influências estrangeiras para criar uma arte genuinamente nacional. Defendia a mistura de culturas, tradição indígena e contemporaneidade, buscando identidade própria na literatura e nas artes.', 'ANTROPOFAGIA')," +
                "('Arte', 'Artista modernista brasileira, pioneira na introdução do modernismo no Brasil. Suas obras, marcadas por cores fortes e distorções expressivas, geraram debates sobre arte e renovação estética na década de 1910.', 'MALFATTI')," +
                "('Arte', 'Movimento artístico surgido no início do século XX, que propunha a libertação da mente racional, a exploração do inconsciente, dos sonhos e dos desejos ocultos. Nas artes visuais, utilizava figuras distorcidas e simbólicas.', 'Surrealismo')," +
                "('Arte', 'Artista modernista brasileira, conhecida por criar a obra \"Abaporu\", que se tornou símbolo do movimento antropofágico. Suas pinturas exploram cores vibrantes, formas distorcidas e elementos da cultura brasileira, contribuindo para a construção de uma identidade nacional na arte.', 'Tarsila')," +
                "('Arte', 'Movimento artístico e cultural brasileiro, iniciado com a Semana de Arte Moderna de 1922. Propunha a ruptura com padrões acadêmicos e a valorização da identidade nacional, misturando influências europeias com elementos da cultura popular.', 'Modernismo')," +
                "('Arte', 'Forma de expressão artística mais antiga da humanidade, realizada nas paredes de cavernas e abrigos rochosos. Utiliza pigmentos naturais e representa cenas de caça, animais e símbolos, revelando aspectos da vida cotidiana e das crenças dos povos pré-históricos.', 'Rupestre')," +
                "('Arte', 'Técnica artística que utiliza pequenos fragmentos de materiais como pedras, cerâmicas ou vidros coloridos, formando imagens decorativas em paredes, pisos ou objetos. Foi amplamente usada na arte bizantina e em igrejas medievais.', 'Mosaico')," +
                "('Arte', 'Estilo artístico que busca representar a realidade de forma objetiva e detalhada, retratando o cotidiano, o trabalho e as condições sociais sem idealizações.', 'Realismo')," +
                "('Arte', 'Estilo artístico que utiliza formas geométricas, linhas retas e cores primárias para criar composições abstratas e equilibradas. Teve destaque com o artista Piet Mondrian.', 'Neoplasticismo')," +
                "('Arte', 'Movimento artístico surgido na Alemanha no início do século XX, que valoriza a expressão emocional intensa. Utiliza cores fortes, traços marcantes e temas dramáticos para transmitir sentimentos profundos.', 'Expressionismo')," +
                "('Arte', 'Corrente artística que valoriza a simplicidade, o uso de formas básicas e a ausência de ornamentação. Presente em esculturas, instalações e arquitetura.', 'Minimalismo')," +
                "('Arte', 'Artista mexicana conhecida por suas pinturas intensas e autobiográficas, que misturam dor física, identidade cultural e elementos do surrealismo. Suas obras exploram temas como feminilidade, sofrimento e raízes indígenas, tornando-se símbolo de resistência e expressão pessoal (apenas primeiro nome).', 'Frida')," +
                "('Arte', 'Material negro feito de carbono grafítico usado em desenho. Permite trabalhar com intensidades variáveis de tom e pressão.', 'Grafite')," +
                "('Arte', 'Movimento artístico do tempo atual que questiona conceitos tradicionais. Utiliza diversos materiais e técnicas sem restrições.', 'Contemporâneo')," +
                "('Arte', 'Movimento artístico que retoma ideais greco-romanos. Valoriza a harmonia, simetria, proporção e representação realista.', 'Classicismo')," +
                "('Arte', 'Arte que organiza sons e silêncios em sequências estruturadas. Combina ritmo, melodia e harmonia para expressar emoções.', 'Música')," +
                "('Arte', 'Movimento artístico e cultural brasileiro dos anos 1960. Mesclava tradição popular com modernidade crítica e experimental.', 'Tropicália')," +
                "('Arte', 'Movimento artístico que fragmentava formas em múltiplas perspectivas. Picasso e Braque revolucionaram a representação do espaço visual.', 'Cubismo')," +
                "('Arte', 'Movimento de vanguarda que rejeitava lógica e razão. Utilizava absurdo e ironia como crítica ao sistema de valores burguês.', 'Dadaísmo')," +
                "('Arte', 'Arte de projetar e construir espaços e estruturas. Combina funcionalidade, estética e materiais em harmonia com o ambiente.', 'Arquitetura')," +
                "('Arte', 'Técnica de representação que cria ilusão de profundidade no desenho. Utiliza pontos de fuga para simular espaço tridimensional.', 'Perspectiva')," +
                "('Arte', 'Estilo artístico que não busca representação realista de objetos. Enfatiza formas, cores, linhas e texturas para expressar emoções e ideias.', 'Abstrato')," +

                // EDUCAÇÃO FÍSICA
                "('Educação Física', 'Manifestação cultural e artística brasileira que combina luta, dança, música e acrobacias. Surgiu como forma de resistência de povos africanos escravizados, desenvolvendo habilidades físicas como força, flexibilidade e coordenação, além de promover socialização e expressão cultural.', 'CAPOEIRA')," +
                "('Educação Física', 'Competição internacional que reúne atletas de diversos países em diferentes modalidades esportivas. Mais do que uma disputa, representam valores como disciplina, superação, respeito às regras e união entre povos, inspirando práticas esportivas e desenvolvimento físico.', 'OLIMPIADAS')," +
                "('Educação Física', 'Forma de expressão corporal que integra movimento, ritmo, criatividade e comunicação. Além de artística, é reconhecida como atividade física que melhora a coordenação, equilíbrio, resistência e saúde mental, sendo presente em culturas de todo o mundo.', 'DANCA')," +
                "('Educação Física', 'Conceito aplicado ao esporte e atividades físicas que busca eliminar barreiras para pessoas com diferentes habilidades. Inclui adaptações de espaços, materiais, regras e ensino, garantindo participação plena e inclusão social.', 'ACESSIBILIDADE')," +
                "('Educação Física', 'Estilo de vida caracterizado pela falta de atividade física regular, aumentando risco de doenças cardiovasculares, obesidade e problemas musculoesqueléticos. A educação física atua na prevenção, incentivando hábitos ativos e promoção da saúde.', 'SEDENTARISMO')," +
                "('Educação Física', 'Esporte coletivo amplamente praticado no Brasil e no mundo, jogado entre duas equipes de 11 jogadores. O objetivo é marcar gols na baliza adversária utilizando principalmente os pés. Além de ser uma paixão cultural, promove resistência física, agilidade e trabalho em equipe.', 'Futebol')," +
                "('Educação Física', 'Modalidade esportiva criada nos Estados Unidos, disputada por duas equipes de cinco jogadores cada. O objetivo é arremessar a bola no cesto adversário, localizado a 3,05 metros de altura. Desenvolve coordenação motora, velocidade de reação e habilidades táticas coletivas.', 'Basquete')," +
                "('Educação Física', 'Esporte coletivo em que duas equipes de sete jogadores buscam marcar gols utilizando as mãos para conduzir e arremessar a bola. A dinâmica rápida exige resistência, força e raciocínio estratégico. É muito praticado em ambientes escolares e competições internacionais.', 'Handebol')," +
                "('Educação Física', 'Jogo em que duas equipes de seis jogadores se enfrentam, separadas por uma rede. O objetivo é fazer a bola tocar o chão da quadra adversária, utilizando toques rápidos e organizados. Trabalha reflexos, impulsão, cooperação e sincronização dos movimentos.', 'Vôlei')," +
                "('Educação Física', 'Esporte de raquete praticado em uma mesa dividida por uma rede, onde os jogadores rebatem a bolinha buscando dificultar a devolução do adversário. Exige precisão, reflexos rápidos e concentração. É uma versão mais dinâmica e acessível do tênis tradicional.', 'Pingpong')," +
                "('Educação Física', 'Atividades lúdicas que envolvem regras, objetivos e interação entre os participantes. Podem ter caráter competitivo ou cooperativo e são fundamentais no desenvolvimento motor, cognitivo e social. Além do entretenimento, contribuem para o aprendizado e a socialização.', 'Jogos')," +
                "('Educação Física', 'Base de toda a prática corporal, é a expressão física e simbólica do corpo em ação. Está presente em esportes, danças, gestos e brincadeiras. Estudá-lo permite compreender o funcionamento do corpo e a importância da coordenação e do controle motor.', 'Movimento')," +
                "('Educação Física', 'Modalidade esportiva composta por provas de corrida, salto e arremesso, considerada uma das mais antigas do mundo. Trabalha resistência, força e técnica, sendo uma das bases das Olimpíadas modernas. Representa o esforço humano pela superação de limites.', 'Atletismo')," +
                "('Educação Física', 'Conjunto de práticas corporais que visam desenvolver força, equilíbrio, flexibilidade e coordenação. Pode ser artística, rítmica, laboral ou de condicionamento físico. Além do aspecto esportivo, é também uma forma de expressão e cuidado com o corpo.', 'Ginastica')," +
                "('Educação Física', 'Prática de exercícios físicos com sobrecarga (como pesos e máquinas) para o fortalecimento e desenvolvimento dos músculos. Melhora a postura, a resistência e o condicionamento físico. É utilizada tanto para fins estéticos quanto terapêuticos e de saúde.', 'Musculação')," +
                "('Educação Física', 'Estratégia planejada para vencer no esporte. Envolve posicionamento, movimentos sincronizados e leitura do jogo adversário.', 'Tática')," +
                "('Educação Física', 'Atividade onde participantes disputam por vitória ou prêmios. Estimula superação, respeito às regras e fair play.', 'Competição')," +
                "('Educação Física', 'Alongamento de fibras musculares e ligamentos. Essencial para aumentar flexibilidade e prevenir lesões no treinamento.', 'Distensão')," +
                "('Educação Física', 'Esporte radical praticado sobre tábua com rodas. Exige equilíbrio, coordenação e manejo técnico de diferentes obstáculos.', 'Skate')," +
                "('Educação Física', 'Prova de corrida onde atletas saltam sobre barreiras. Combina velocidade com coordenação motora para transpor obstáculos.', 'Hurdles')," +
                "('Educação Física', 'Princípio de trabalhar em grupo para objetivo comum. Valoriza colaboração, solidariedade e distribuição equitativa de benefícios.', 'Cooperativismo')," +
                "('Educação Física', 'Capacidade articular de alongar músculos e ligamentos. Permite maior amplitude de movimento e reduz risco de lesões.', 'Flexibilidade')," +
                "('Educação Física', 'Habilidade de mudar de direção rapidamente com controle. Essencial em esportes que exigem movimentos rápidos e precisos.', 'Agilidade')," +
                "('Educação Física', 'Capacidade do organismo de manter esforço prolongado. Envolve resistência cardiovascular, muscular e mental.', 'Resistência')," +
                "('Educação Física', 'Habilidade de manter o corpo em posição estável. Depende de visão, propriocepção e sistema vestibular.', 'Equilíbrio')," +

                // FILOSOFIA
                "('Filosofia', 'Filósofo francês conhecido como \"pai da filosofia moderna\", defensor do pensamento racional e da dúvida metódica. Sua famosa frase \"Penso, logo existo\" representa a busca por fundamentos seguros para o conhecimento.', 'DESCARTES')," +
                "('Filosofia', 'Filósofo grego que abordou diversas áreas do conhecimento, como lógica, ética, política e metafísica. Defendia a ideia de equilíbrio, a prática da virtude e a observação da realidade como caminho para o saber.', 'ARISTOTELES')," +
                "('Filosofia', 'Conceito filosófico e social que se refere à aplicação equilibrada de direitos e deveres. É discutido em diferentes correntes, considerando equidade, legalidade e moralidade na organização das relações humanas.', 'JUSTICA')," +
                "('Filosofia', 'Ramo da filosofia que estuda a conduta humana, princípios morais e o que é considerado certo ou errado. Serve como guia para decisões individuais e coletivas, refletindo sobre responsabilidade e valores.', 'ETICA')," +
                "('Filosofia', 'Teoria política que explica a origem e a legitimidade do Estado a partir de um acordo entre indivíduos. Filósofos como Hobbes, Locke e Rousseau discutem como contratos sociais garantem ordem, direitos e deveres na sociedade.', 'CONTRATUALISMO')," +
                "('Filosofia', 'Corrente filosófica que afirma que a razão é a principal fonte de conhecimento, valorizando a lógica e o pensamento dedutivo, especialmente a partir do século XVII.', 'Racionalismo')," +
                "('Filosofia', 'Doutrina filosófica que afirma que o conhecimento vem exclusivamente da experiência sensível, valorizando a observação e os sentidos como base da compreensão do mundo.', 'Empirismo')," +
                "('Filosofia', 'Filósofo grego da Antiguidade que não deixou obras escritas, mas influenciou o pensamento ocidental por meio dos diálogos de Platão. Defendia o autoconhecimento e a razão como caminho para a virtude, sendo condenado à morte por sua postura crítica.', 'Sócrates')," +
                "('Filosofia', 'Filósofo alemão do século XVIII que buscou conciliar razão e experiência como fontes do conhecimento. Defendia que o sujeito constrói a realidade por meio de estruturas mentais, influenciando profundamente a ética, a ciência e a política moderna.', 'Kant')," +
                "('Filosofia', 'Filósofa francesa do século XX que refletiu sobre a condição feminina, a liberdade e a construção social da mulher. Em sua obra mais conhecida, afirmou que \"não se nasce mulher, torna-se mulher\", influenciando profundamente os debates sobre gênero e existencialismo. Simone de…', 'Beauvoir')," +
                "('Filosofia', 'Corrente filosófica que defende que todo o conhecimento vem da experiência sensível, isto é, daquilo que percebemos com os sentidos. Filósofos como John Locke e David Hume argumentavam que a mente humana nasce como uma \"tábula rasa\", sendo moldada pelas vivências.', 'Empirismo')," +
                "('Filosofia', 'Alegoria criada por Platão para explicar a diferença entre aparência e realidade. Na história, prisioneiros confundem sombras com o mundo real, simbolizando a ignorância. A libertação representa a busca pelo conhecimento e pela verdade filosófica. Mito da…', 'Caverna')," +
                "('Filosofia', 'Qualidades morais que orientam o ser humano a agir corretamente, equilibrando razão e emoção. Aristóteles via elas como o \"meio-termo\" entre dois extremos, enquanto outras correntes filosóficas a associam à justiça, coragem e sabedoria.', 'Virtudes')," +
                "('Filosofia', 'Filósofo francês que analisou as relações entre poder, saber e controle social. Investigou como instituições como prisões, escolas e hospitais moldam comportamentos e subjetividades. Sua obra convida a questionar as estruturas invisíveis que regem a sociedade.', 'Foucault')," +
                "('Filosofia', 'Conjunto de pensamentos e tradições filosóficas originadas no continente africano, baseadas na coletividade, ancestralidade e ética comunitária. Valoriza o Ubuntu (\"sou porque nós somos\") e questiona o eurocentrismo como única forma de produzir conhecimento. Filosofia…', 'Africana')," +
                "('Filosofia', 'Filósofo iluminista que defendia soberania popular e contrato social. Influenciou revoluções democráticas com ideias sobre liberdade natural.', 'Rousseau')," +
                "('Filosofia', 'Pensador francês que analisou poder, conhecimento e disciplina. Estudou como as instituições controlam corpos e mentalidades.', 'Foucault')," +
                "('Filosofia', 'Filosofia que busca maximizar felicidade e minimizar sofrimento. Baseado na ideia de que ações são moralmente corretas se beneficiam a maioria.', 'Utilitarismo')," +
                "('Filosofia', 'Filósofo que questionou a moral tradicional e valores estabelecidos. Propôs superação de si mesmo e criação de novos valores.', 'Nietzsche')," +
                "('Filosofia', 'Filósofo grego que defendia o relativismo do conhecimento. Famoso pela máxima \"O homem é a medida de todas as coisas\".', 'Protágoras')," +
                "('Filosofia', 'Pensador renascentista que analisou o poder político pragmaticamente. Separava a moralidade da prática política ao buscar a manutenção do poder.', 'Maquiavel')," +
                "('Filosofia', 'Filosofia que busca virtude através de controle das emoções. Prega aceitação do destino e tranquilidade mental como ideais.', 'Estoicismo')," +
                "('Filosofia', 'Filosofia que valoriza prazer e ausência de dor. Contrário à crença popular, defende prazeres simples e moderados.', 'Epicurismo')," +
                "('Filosofia', 'Filosofia que enfatiza liberdade e responsabilidade individual. Sustenta que existência precede essência e cada um cria seu próprio significado.', 'Existencialismo')," +
                "('Filosofia', 'Método de raciocínio que avança por tese, antítese e síntese. Fundamental para compreender o desenvolvimento histórico e as contradições.', 'Dialética')," +

                // SOCIOLOGIA
                "('Sociologia', 'Teoria social e econômica baseada nas ideias de Karl Marx, que analisa a luta de classes e a desigualdade na sociedade. Propõe que a história seja marcada por conflitos entre quem detém os meios de produção e quem realiza o trabalho.', 'MARXISMO')," +
                "('Sociologia', 'Sistema econômico em que os meios de produção são privados e a organização da sociedade busca lucro e competição. Influencia nas relações de trabalho, consumo e desigualdade social, sendo predominante no mundo contemporâneo.', 'CAPITALISMO')," +
                "('Sociologia', 'Conceito que analisa de que forma diferentes formas de opressão, como gênero, raça e classe, se cruzam e se reforçam. É usado para entender experiências complexas de discriminação e desigualdade na sociedade.', 'INTERSECCIONALIDADE')," +
                "('Sociologia', 'Sistema de governo em que o poder político é exercido pelo povo, direta ou indiretamente, por meio de eleições e participação social. Inclui direitos civis, liberdade de expressão e mecanismos de fiscalização do poder.', 'DEMOCRACIA')," +
                "('Sociologia', 'Perspectiva teórica que entende a realidade social, econômica e histórica a partir das condições materiais e relações de produção. Destaca que a organização econômica influencia a cultura, a política e as ideias da sociedade.', 'Materialismo')," +
                "('Sociologia', 'Ideia associada à integração econômica, política e cultural entre os países, resultado da intensificação da globalização. É frequentemente usada em debates sobre perda de soberania nacional, fluxos migratórios e influência de potências mundiais nas decisões locais.', 'Globalismo')," +
                "('Sociologia', 'Conjunto de direitos e deveres que garantem a participação do indivíduo na vida política e social de um país. Ser cidadão significa ter acesso à justiça, à educação, à saúde e poder opinar nas decisões coletivas. É base para a construção de uma sociedade democrática e igualitária.', 'Cidadania')," +
                "('Sociologia', 'Sociólogo francês considerado um dos fundadores da Sociologia moderna. Defendia o estudo científico dos fatos sociais e a importância da coesão social para manter a ordem. Suas ideias sobre solidariedade e anomia influenciam até hoje as ciências humanas.', 'Durkheim')," +
                "('Sociologia', 'Visão de mundo que coloca a própria cultura como superior às demais. Pode gerar preconceitos, intolerância e discriminação. A Sociologia combate o etnocentrismo ao valorizar a diversidade cultural e promover o respeito entre diferentes grupos sociais.', 'Etnocentrismo')," +
                "('Sociologia', 'Forma de racismo enraizada nas instituições, práticas e estruturas sociais, muitas vezes invisível, mas persistente. Manifesta-se em desigualdades de acesso a oportunidades, cargos e reconhecimento. Entender o racismo estrutural é essencial para combater suas causas profundas.', 'Estrutural')," +
                "('Sociologia', 'Conceito desenvolvido por Karl Marx para descrever a perda de sentido e controle do trabalhador sobre seu próprio trabalho. No capitalismo, o indivíduo se torna uma peça da produção, distante do produto e do propósito do que cria. Essa separação afeta a consciência e a liberdade humana.', 'Alienação')," +
                "('Sociologia', 'Sistema social e cultural que privilegia o poder masculino e coloca as mulheres em posição de subordinação. Está presente nas instituições, nas leis e nas relações familiares. A Sociologia e o feminismo analisam como esse modelo perpetua desigualdades de gênero e limita direitos.', 'Patriarcado')," +
                "('Sociologia', 'Conceito formulado por Antonio Gramsci para explicar o domínio de uma classe social não apenas pela força, mas pela influência cultural e ideológica. Ela molda o pensamento coletivo, fazendo com que as ideias do grupo dominante pareçam naturais ou universais.', 'Hegemonia')," +
                "('Sociologia', 'Classe social que surgiu com o capitalismo e detém os meios de produção, como fábricas e empresas. Representa o grupo economicamente dominante, cujos interesses frequentemente entram em conflito com os do proletariado. É central na análise marxista da luta de classes.', 'Burguesia')," +
                "('Sociologia', 'Diferença de acesso a recursos, oportunidades e direitos entre grupos sociais. Pode se manifestar por fatores como renda, gênero, raça ou origem. A Sociologia busca compreender suas causas estruturais e propor caminhos para uma sociedade mais justa e inclusiva.', 'Desigualdade')" +
                "('Sociologia', 'Situação de ausência de normas sociais que regulam comportamento. Resulta em desorganização social, conflito e desvio das condutas esperadas.', 'Anomia')," +
                "('Sociologia', 'Corrente sociológica que vê sociedade como sistema equilibrado. Cada instituição tem função para manter coesão social.', 'Funcionalismo')," +
                "('Sociologia', 'Movimento que busca igualdade de direitos e oportunidades entre gêneros. Questiona estruturas patriarcais em esferas pública e privada.', 'Feminismo')," +
                "('Sociologia', 'Processo de padronização de características em uma população. Geralmente resultado de globalização e pressão cultural dominante.', 'Homogeneização')," +
                "('Sociologia', 'Relativo aos aspectos que definem a identidade de indivíduos ou grupos. Envolve etnia, classe, gênero, religião e nacionalidade.', 'Identitário')," +
                "('Sociologia', 'Sistema de ideias e valores que justifica ordem social. Molda percepção da realidade e interesses de grupos sociais.', 'Ideologia')," +
                "('Sociologia', 'Força que mantém grupo unido em torno de valores comuns. Essencial para estabilidade e funcionamento harmonioso da sociedade.', 'Coesão')," +
                "('Sociologia', 'Processo pelo qual indivíduos aprendem normas e valores culturais. Ocorre através de família, escola, mídia e outras instituições.', 'Socialização')," +
                "('Sociologia', 'Mecanismo pelo qual a sociedade regula comportamentos de seus membros. Pode ser exercido através de normas, leis, sanções e vigilância.', 'Controle')," +
                "('Sociologia', 'Movimento de indivíduos entre posições diferentes na hierarquia social. Pode ser vertical (mudança de classe) ou horizontal (mudança de ocupação).', 'Mobilidade')"
        );
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERGUNTAS);
        onCreate(db);
    }

    // buscar perguntas por tema
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

