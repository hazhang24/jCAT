--
-- JBoss, Home of Professional Open Source
-- Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
-- contributors by the @authors tag. See the copyright.txt in the
-- distribution for a full listing of individual contributors.
--
-- Licensed under the Apache License, Version 2.0 (the "License");
-- you may not use this file except in compliance with the License.
-- You may obtain a copy of the License at
-- http://www.apache.org/licenses/LICENSE-2.0
-- Unless required by applicable law or agreed to in writing, software
-- distributed under the License is distributed on an "AS IS" BASIS,
-- WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
-- See the License for the specific language governing permissions and
-- limitations under the License.
--
 -- You can use this file to load seed data into the database using SQL statements
-- preenchimento totalitário

INSERT INTO `jcat`.`Classificacao` (`id`, `acertos`, `descricao`, `valor`)
VALUES (1,
        4,
        "Neste nível, encontram-se alunos que estão em um estágio muito inicial em relação à aprendizagem da linguagem escrita. Estão começando a se apropriar das habilidades referentes ao domínio das regras que orientam o uso do sistema alfabético para ler e escrever.",
        1);


INSERT INTO `jcat`.`Classificacao` (`id`, `acertos`, `descricao`, `valor`)
VALUES (2,
        9,
        "Os alunos que se encontram neste nível, além de já terem consolidado as habilidades do nível anterior, referentes ao conhecimento e uso do sistema de escrita, já associam adequadamente letras e sons. Embora ainda apresentem algumas dificuldades na leitura de palavras com ortografia mais complexa, neste nível, demonstram ser capazes de ler palavras com vários tipos de estrutura silábica.",
        2);


INSERT INTO `jcat`.`Classificacao` (`id`, `acertos`, `descricao`, `valor`)
VALUES (3,
        15,
        "Neste nível, os alunos demonstram que consolidaram a capacidade de ler palavras de diferentes tamanhos e padrões silábicos, conseguem ler frases com sintaxe simples (sujeito + verbo + objeto) e utilizam algumas estratégias que permitem ler textos de curta extensão.",
        3);


INSERT INTO `jcat`.`Classificacao` (`id`, `acertos`, `descricao`, `valor`)
VALUES (4,
        18,
        "Neste nível, os alunos leem textos simples e são capazes de interpretá-los, localizando informações, realizando inferências e reconhecendo o assunto ou a finalidade a partir da leitura autônoma desses textos.",
        4);


INSERT INTO `jcat`.`Classificacao` (`id`, `acertos`, `descricao`, `valor`)
VALUES (5, 20, "Neste nível,
                os alunos demonstram ter alcançado o domínio DO sistema de escrita e a compreensão DO princípio alfabético,
                                                                                                      apresentando um excelente desempenho,
                                                                                                                      tendo em vista AS habilidades que definem o aluno como alfabetizado e considerando AS que são desejáveis para o fim DO segundo ano de escolarização. Demonstram compreender textos informativos e narrativos de vocabulário complexo,
estabelecendo relações entre AS partes que o compõem,
                                           inferindo o assunto principal e localizando informações que não são evidentes. Assim, AS crianças que atingiram este nível já avançaram expressivamente NO processo de alfabetização e letramento inicial.", 5);


INSERT INTO `jcat`.`TipoUsuario` (`id`, `descricao`)
VALUES (1,
        "Aplicador");


INSERT INTO `jcat`.`TipoUsuario` (`id`, `descricao`)
VALUES (2,
        "Elaborador");


INSERT INTO `jcat`.`TipoUsuario` (`id`, `descricao`)
VALUES (3,
        "Secretaria");


INSERT INTO `jcat`.`TipoUsuario` (`id`, `descricao`)
VALUES (4,
        "INEP");


INSERT INTO `jcat`.`Usuario` (`id`, `email`, `nome`, `senha`, `sobrenome`, `tipoUsuario_id`)
VALUES (1,
        "aplicador@teste.com",
        "Aplicador",
        "7b7b55f22e61983dca5d4a69238a6a92",
        -- aplicador

        "da Silva",
        1);


INSERT INTO `jcat`.`Usuario` (`id`, `email`, `nome`, `senha`, `sobrenome`, `tipoUsuario_id`)
VALUES (2,
        "elaborador@teste.com",
        "Elaborador",
        "df3e1d81c4809d5ce4958d1d5de7925b",
        -- elaborador

        "de Souza",
        2);


INSERT INTO `jcat`.`Usuario` (`id`, `email`, `nome`, `senha`, `sobrenome`, `tipoUsuario_id`)
VALUES (3,
        "secretaria@teste.com",
        "Secretária",
        "fd09accffacf03d7393c2a23a9601b43",
        -- secretaria

        "de Carvalho",
        3);


INSERT INTO `jcat`.`Usuario` (`id`, `email`, `nome`, `senha`, `sobrenome`, `tipoUsuario_id`)
VALUES (4,
        "admin@teste.com",
        "Administrador",
        "21232f297a57a5a743894a0e4a801fc3",
        -- admin

        "Schoppenhauer",
        4);


INSERT INTO `jcat`.`Elaborador` (`id`)
VALUES (2);


INSERT INTO `jcat`.`Inep` (`bogus`, `id`)
VALUES (0,
        3);


INSERT INTO `jcat`.`Escola` (`id`, `codigo`, `nome`)
VALUES (1,
        6189160,
        "Escola Primária X");


INSERT INTO `jcat`.`Secretaria` (`id`, `escola_id`)
VALUES (4,
        1);


INSERT INTO `jcat`.`Aplicador` (`id`)
VALUES (1);


INSERT INTO `jcat`.`Turma` (`id`, `nome`, `aplicador_id`, `escola_id`)
VALUES (1,
        "1º ano A",
        1,
        1);


UPDATE `jcat`.`Aplicador`
SET `turma_id` = 1
WHERE `id` = 1;


INSERT INTO `jcat`.`Aluno` (`id`, `ensinoInfantil`, `nascimento`, `nome`, `turma_id`)
VALUES (1,
        FALSE,
        "1992-09-15",
        "Douglas",
        1);


INSERT INTO `jcat`.`Item` (`id`, `altA`, `altB`, `altC`, `altD`, `correta`, `descritor`, `imgA`, `imgB`, `imgC`, `imgD`, `imgEnunciado`, `narracao`, `ultimaUtilizacao`, `elaborador_id`)
VALUES (1,
        NULL,
        NULL,
        NULL,
        NULL,
        "A",
        NULL,
        "http:\/\/localhost:8080\/uploads\/1\/imgA.png",
        "http:\/\/localhost:8080\/uploads\/1\/imgB.png",
        "http:\/\/localhost:8080\/uploads\/1\/imgC.png",
        "http:\/\/localhost:8080\/uploads\/1\/imgD.png",
        NULL,
        "http:\/\/localhost:8080\/uploads\/1\/narracao.wma",
        NULL,
        2);


INSERT INTO `jcat`.`Item` (`id`, `altA`, `altB`, `altC`, `altD`, `correta`, `descritor`, `imgA`, `imgB`, `imgC`, `imgD`, `imgEnunciado`, `narracao`, `ultimaUtilizacao`, `elaborador_id`)
VALUES (2,
        "LMZ",
        "TNV",
        "FVN",
        "JZH",
        "C",
        NULL,
        NULL,
        NULL,
        NULL,
        NULL,
        NULL,
        "http:\/\/localhost:8080\/uploads\/2\/narracao.wma",
        NULL,
        2);