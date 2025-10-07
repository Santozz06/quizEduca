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
                "('História', 'Líder político brasileiro que marcou profundamente o século XX, governando em fases democráticas e autoritárias. Ficou conhecido por políticas trabalhistas, centralização do poder e forte influência no nacionalismo econômico.', 'Vargas')," +
                "('História', 'Movimento social e religioso no sertão baiano do fim do século XIX, liderado por Antônio Conselheiro. A comunidade enfrentou o Exército em uma guerra marcada pela desigualdade, violência e repressão às populações sertanejas.', 'Canudos')," +
                "('História', 'Primeiro-ministro britânico durante a Segunda Guerra Mundial, célebre por sua liderança e discursos de resistência contra o nazismo. Tornou-se símbolo da determinação do Reino Unido frente às adversidades do conflito.', 'Churchill')," +
                "('História', 'Revolução que transformou a economia com a introdução de máquinas, fábricas e produção em larga escala. Mudou as relações de trabalho, acelerou o crescimento urbano e gerou impactos sociais e ambientais.', 'Industrial')," +
                "('História', 'Revolta regional ocorrida no sul do Brasil no século XIX, marcada pela luta dos estancieiros contra o governo imperial. Foi um conflito de longa duração, que combinou reivindicações econômicas com ideias republicanas.', 'Farroupilha')," +


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

                // PORTUGUÊS
                "('Português', 'Movimento literário do século XIX, marcado pela valorização das emoções, da natureza e da identidade nacional. No Brasil, teve fases indianista, ultrarromântica e condoreira, influenciando fortemente a construção da ideia de \"nação\".', 'ROMANTISMO')," +
                "('Português', 'Gênero textual que se destaca pelo ritmo, pela musicalidade e pelo uso creativo da linguagem. Pode expressar sentimentos, ideias ou críticas, explorando metáforas, imagens e sonoridades que vão além do discurso cotidiano.', 'POESIA')," +
                "('Português', 'Figura de linguagem caracterizada pelo exagero intencional, usada para intensificar uma ideia ou emoção. É comum tanto na literatura quanto na fala do dia a dia.', 'HIPERBOLE')," +
                "('Português', 'Romance indianista de José de Alencar que simboliza a fusão entre o indígena e o europeu na formação do Brasil. Traz a heroína homônima, cuja história de amor é também uma alegoria sobre identidade nacional.', 'IRACEMA')," +
                "('Português', 'Área da linguística que estuda os significados das palavras, frases e textos. Analisa como os sentidos são construídos e interpretados na comunicação, levando em conta contexto e variações de uso.', 'SEMANTICA')," +
                "('Português', 'Gênero textual que mistura fatos do cotidiano com reflexões ou críticas sociais, geralmente escritas em tom leve e acessível. Pode abordar desde acontecimentos banais até grandes temas, sempre com um olhar subjetivo do autor. É muito utilizada em jornais e revistas.', 'Crônica')," +
                "('Português', 'Conjunto de regras que determinam o uso dos acentos gráficos na língua portuguesa. Ajuda a indicar a tonicidade e, em alguns casos, a diferenciar palavras de escrita igual, mas com significados distintos. É essencial para a clareza e correção da escrita.', 'Acentuação')," +
                "('Português', 'Estrutura que organiza a língua, estabelecendo normas sobre como as palavras devem ser usadas em frases e textos. Inclui morfologia, sintaxe, semântica e fonética. Embora possa parecer rígida, é uma ferramenta fundamental para a comunicação eficiente.', 'Gramática')," +
                "('Português', 'Refere-se à forma correta de escrever as palavras, seguindo as convenções da língua. Abrange o uso adequado de letras, hífen, maiúsculas e minúsculas. Mudanças como o Acordo Ortográfico mostram que a ortografia também acompanha a evolução da língua.', 'Ortografia')," +
                "('Português', 'Encontro de uma vogal com uma semivogal na mesma sílaba, formando um único som. Pode ser classificado em crescente (quando a semivogal vem antes) ou decrescente (quando vem depois). É um dos elementos que tornam a língua portuguesa rica em sonoridade.', 'Ditongo')," +

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

                // ARTE
                "('Arte', 'Movimento artístico e cultural do século XVII, marcado pelo exagero, o drama e a teatralidade. Nas artes plásticas e na arquitetura, valoriza o contraste de luz e sombra, ornamentação rica e emoções intensas, frequentemente ligado à religião.', 'BARROCO')," +
                "('Arte', 'Estilo artístico do século XVIII, mais leve e decorativo que o Barroco, caracterizado por cores suaves, curvas delicadas e cenas de elegância e intimidade. Aparece em pintura, arquitetura e decoração, refletindo o gosto da aristocracia europeia.', 'ROCOCO')," +
                "('Arte', 'Movimento do final do século XIX, centrado na percepção visual do instante e na captura da luz e da cor. Rompe com o realismo detalhado e busca transmitir sensações, impressões e movimento em pinceladas soltas.', 'IMPRESSIONISMO')," +
                "('Arte', 'Movimento modernista brasileiro que propunha \"devorar\" influências estrangeiras para criar uma arte genuinamente nacional. Defendia a mistura de culturas, tradição indígena e contemporaneidade, buscando identidade própria na literatura e nas artes.', 'ANTROPOFAGIA')," +
                "('Arte', 'Artista modernista brasileira, pioneira na introdução do modernismo no Brasil. Suas obras, marcadas por cores fortes e distorções expressivas, geraram debates sobre arte e renovação estética na década de 1910.', 'MALFATTI')," +
                "('Arte', 'Movimento artístico surgido no início do século XX, que propunha a libertação da mente racional, a exploração do inconsciente, dos sonhos e dos desejos ocultos. Nas artes visuais, utilizava figuras distorcidas e simbólicas.', 'Surrealismo')," +
                "('Arte', 'Artista modernista brasileira, conhecida por criar a obra “Abaporu”, que se tornou símbolo do movimento antropofágico. Suas pinturas exploram cores vibrantes, formas distorcidas e elementos da cultura brasileira, contribuindo para a construção de uma identidade nacional na arte.', 'Tarsila')," +
                "('Arte', 'Movimento artístico e cultural brasileiro, iniciado com a Semana de Arte Moderna de 1922. Propunha a ruptura com padrões acadêmicos e a valorização da identidade nacional, misturando influências europeias com elementos da cultura popular.', 'Modernismo')," +
                "('Arte', 'Forma de expressão artística mais antiga da humanidade, realizada nas paredes de cavernas e abrigos rochosos. Utiliza pigmentos naturais e representa cenas de caça, animais e símbolos, revelando aspectos da vida cotidiana e das crenças dos povos pré-históricos.', 'Rupestre')," +
                "('Arte', 'Técnica artística que utiliza pequenos fragmentos de materiais como pedras, cerâmicas ou vidros coloridos, formando imagens decorativas em paredes, pisos ou objetos. Foi amplamente usada na arte bizantina e em igrejas medievais.', 'Mosaico')," +

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
                "('Filosofia', 'Filósofa francesa do século XX que refletiu sobre a condição feminina, a liberdade e a construção social da mulher. Em sua obra mais conhecida, afirmou que “não se nasce mulher, torna-se mulher”, influenciando profundamente os debates sobre gênero e existencialismo. Simone de…', 'Beauvoir')," +

                // SOCIOLOGIA
                "('Sociologia', 'Teoria social e econômica baseada nas ideias de Karl Marx, que analisa a luta de classes e a desigualdade na sociedade. Propõe que a história seja marcada por conflitos entre quem detém os meios de produção e quem realiza o trabalho.', 'MARXISMO')," +
                "('Sociologia', 'Sistema econômico em que os meios de produção são privados e a organização da sociedade busca lucro e competição. Influencia nas relações de trabalho, consumo e desigualdade social, sendo predominante no mundo contemporâneo.', 'CAPITALISMO')," +
                "('Sociologia', 'Conceito que analisa de que forma diferentes formas de opressão, como gênero, raça e classe, se cruzam e se reforçam. É usado para entender experiências complexas de discriminação e desigualdade na sociedade.', 'INTERSECCIONALIDADE')," +
                "('Sociologia', 'Sistema de governo em que o poder político é exercido pelo povo, direta ou indiretamente, por meio de eleições e participação social. Inclui direitos civis, liberdade de expressão e mecanismos de fiscalização do poder.', 'DEMOCRACIA')," +
                "('Sociologia', 'Ideia associada à integração econômica, política e cultural entre os países, resultado da intensificação da globalização. É frequentemente usada em debates sobre perda de soberania nacional, fluxos migratórios e influência de potências mundiais nas decisões locais.', 'Globalismo'),"+
                "('Sociologia', 'Conjunto de direitos e deveres que garantem a participação do indivíduo na vida política e social de um país. Ser cidadão significa ter acesso à justiça, à educação, à saúde e poder opinar nas decisões coletivas. É base para a construção de uma sociedade democrática e igualitária.', 'Cidadania'),"+
                "('Sociologia', 'Sociólogo francês considerado um dos fundadores da Sociologia moderna. Defendia o estudo científico dos fatos sociais e a importância da coesão social para manter a ordem. Suas ideias sobre solidariedade e anomia influenciam até hoje as ciências humanas.', 'Durkheim'),"+
                "('Sociologia', 'Visão de mundo que coloca a própria cultura como superior às demais. Pode gerar preconceitos, intolerância e discriminação. A Sociologia combate o etnocentrismo ao valorizar a diversidade cultural e promover o respeito entre diferentes grupos sociais.', 'Etnocentrismo'),"+
                "('Sociologia', 'Forma de racismo enraizada nas instituições, práticas e estruturas sociais, muitas vezes invisível, mas persistente. Manifesta-se em desigualdades de acesso a oportunidades, cargos e reconhecimento. Entender o racismo estrutural é essencial para combater suas causas profundas.', 'Estrutural')");
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