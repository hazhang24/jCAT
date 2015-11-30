-- preenchimento totalitário
INSERT INTO `brodus`.`Classificacao`
(`id`,
`acertos`,
`descricao`,
`valor`)
VALUES
(
1,
4,
"Neste nível, encontram-se alunos que estão em um estágio muito inicial em relação à aprendizagem da linguagem escrita. Estão começando a se apropriar das habilidades referentes ao domínio das regras que orientam o uso do sistema alfabético para ler e escrever.",
1
);
INSERT INTO `brodus`.`Classificacao`
(`id`,
`acertos`,
`descricao`,
`valor`)
VALUES
(
2,
9,
"Os alunos que se encontram neste nível, além de já terem consolidado as habilidades do nível anterior, referentes ao conhecimento e uso do sistema de escrita, já associam adequadamente letras e sons. Embora ainda apresentem algumas dificuldades na leitura de palavras com ortografia mais complexa, neste nível, demonstram ser capazes de ler palavras com vários tipos de estrutura silábica.",
2
);
INSERT INTO `brodus`.`Classificacao`
(`id`,
`acertos`,
`descricao`,
`valor`)
VALUES
(
3,
15,
"Neste nível, os alunos demonstram que consolidaram a capacidade de ler palavras de diferentes tamanhos e padrões silábicos, conseguem ler frases com sintaxe simples (sujeito + verbo + objeto) e utilizam algumas estratégias que permitem ler textos de curta extensão.",
3
);
INSERT INTO `brodus`.`Classificacao`
(`id`,
`acertos`,
`descricao`,
`valor`)
VALUES
(
4,
18,
"Neste nível, os alunos leem textos simples e são capazes de interpretá-los, localizando informações, realizando inferências e reconhecendo o assunto ou a finalidade a partir da leitura autônoma desses textos.",
4
);
INSERT INTO `brodus`.`Classificacao`
(`id`,
`acertos`,
`descricao`,
`valor`)
VALUES
(
5,
20,
"Neste nível, os alunos demonstram ter alcançado o domínio do sistema de escrita e a compreensão do princípio alfabético, apresentando um excelente desempenho, tendo em vista as habilidades que definem o aluno como alfabetizado e considerando as que são desejáveis para o fim do segundo ano de escolarização.
Demonstram compreender textos informativos e narrativos de vocabulário complexo, estabelecendo relações entre as partes que o compõem, inferindo o assunto principal e localizando informações que não são evidentes.
Assim, as crianças que atingiram este nível já avançaram expressivamente no processo de alfabetização e letramento inicial.",
5
);
INSERT INTO `brodus`.`TipoUsuario`
(`id`,
`descricao`)
VALUES
(
1,
"Aplicador"
);
INSERT INTO `brodus`.`TipoUsuario`
(`id`,
`descricao`)
VALUES
(
2,
"Elaborador"
);
INSERT INTO `brodus`.`TipoUsuario`
(`id`,
`descricao`)
VALUES
(
3,
"Secretaria"
);
INSERT INTO `brodus`.`TipoUsuario`
(`id`,
`descricao`)
VALUES
(
4,
"INEP"
);
INSERT INTO `brodus`.`Usuario`
(`id`,
`email`,
`nome`,
`senha`,
`sobrenome`,
`tipoUsuario_id`)
VALUES
(
1,
"aplicador@teste.com",
"Aplicador",
"7b7b55f22e61983dca5d4a69238a6a92", -- aplicador
"da Silva",
1
);
INSERT INTO `brodus`.`Usuario`
(`id`,
`email`,
`nome`,
`senha`,
`sobrenome`,
`tipoUsuario_id`)
VALUES
(
2,
"elaborador@teste.com",
"Elaborador",
"df3e1d81c4809d5ce4958d1d5de7925b", -- elaborador
"de Souza",
2
);
INSERT INTO `brodus`.`Usuario`
(`id`,
`email`,
`nome`,
`senha`,
`sobrenome`,
`tipoUsuario_id`)
VALUES
(
3,
"secretaria@teste.com",
"Secretária",
"fd09accffacf03d7393c2a23a9601b43", -- secretaria
"de Carvalho",
3
);
INSERT INTO `brodus`.`Usuario`
(`id`,
`email`,
`nome`,
`senha`,
`sobrenome`,
`tipoUsuario_id`)
VALUES
(
4,
"admin@teste.com",
"Administrador",
"21232f297a57a5a743894a0e4a801fc3", -- admin
"Schoppenhauer",
4
);
INSERT INTO `brodus`.`Elaborador`
(`id`)
VALUES
(
2
);
INSERT INTO `brodus`.`Inep`
(`bogus`,
`id`)
VALUES
(
0,
3
);
INSERT INTO `brodus`.`Escola`
(`id`,
`codigo`,
`nome`)
VALUES
(
1,
6189160,
"Escola Primária X"
);
INSERT INTO `brodus`.`Secretaria`
(`id`,
`escola_id`)
VALUES
(
4,
1
);
INSERT INTO `brodus`.`Aplicador`
(`id`)
VALUES
(
1
);
INSERT INTO `brodus`.`Turma`
(`id`,
`nome`,
`aplicador_id`,
`escola_id`)
VALUES
(
1,
"1º ano A",
1,
1
);
UPDATE `brodus`.`Aplicador`
SET
`turma_id` = 1
WHERE `id` = 1;
INSERT INTO `brodus`.`Aluno`
(`id`,
`ensinoInfantil`,
`nascimento`,
`nome`,
`turma_id`)
VALUES
(
1,
False,
"1992-09-15",
"Douglas",
1
);
INSERT INTO `brodus`.`Item`
(`id`,
`altA`,
`altB`,
`altC`,
`altD`,
`correta`,
`descritor`,
`imgA`,
`imgB`,
`imgC`,
`imgD`,
`imgEnunciado`,
`narracao`,
`ultimaUtilizacao`,
`elaborador_id`)
VALUES
(
1,
null,
null,
null,
null,
"A",
null,
"http://localhost:8080/uploads/1/imgA.png",
"http://localhost:8080/uploads/1/imgB.png",
"http://localhost:8080/uploads/1/imgC.png",
"http://localhost:8080/uploads/1/imgD.png",
null,
"http://localhost:8080/uploads/1/narracao.wma",
null,
2
);
INSERT INTO `brodus`.`Item`
(`id`,
`altA`,
`altB`,
`altC`,
`altD`,
`correta`,
`descritor`,
`imgA`,
`imgB`,
`imgC`,
`imgD`,
`imgEnunciado`,
`narracao`,
`ultimaUtilizacao`,
`elaborador_id`)
VALUES
(
2,
"LMZ",
"TNV",
"FVN",
"JZH",
"C",
null,
null,
null,
null,
null,
null,
"http://localhost:8080/uploads/2/narracao.wma",
null,
2
);