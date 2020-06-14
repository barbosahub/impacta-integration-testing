# language: pt

Funcionalidade: Criar um novo Processo

  Fundo:
    Dado que o processo esteja no site do agapito


  Cenario: POST - Criando um simples processo

    Dado que preencha o campo "vara" com o valor "2598"
    E que preencha o campo "numero_processo" com o valor "2598"
    E que preencha o campo "natureza" com o valor "Divida"
    E que preencha o campo "partes" com o valor "Gasto x Planejado"
    E que preencha o campo "urgente" com o valor "N"
    E que preencha o campo "arbitramento" com o valor "S"
    E que preencha o campo "assistente_social" com o valor "Maria"
    E que preencha o campo "data_entrada" com o valor "20-10-2019"
    E que preencha o campo "data_saida" com o valor "20-10-2020"
    E que preencha o campo "data_agendamento" com o valor ""
    E que preencha o campo "status" com o valor "Em andamento"
    E que preencha o campo "observacao" com o valor "Agendado com sucesso"
    Quando o usuario clicar no botao salvar processo
    Entao o usuario deveria ver a mensagem de "salvo com sucesso"


  Esquema do Cenario: POST - Criando um simples processo com outline - <descricao>

    Dado que preencha o campo "vara" com o valor "<vara>"
    E que preencha o campo "numero_processo" com o valor "2598"
    E que preencha o campo "natureza" com o valor "Divida"
    E que preencha o campo "partes" com o valor "Gasto x Planejado"
    E que preencha o campo "urgente" com o valor "N"
    E que preencha o campo "arbitramento" com o valor "S"
    E que preencha o campo "assistente_social" com o valor "Maria"
    E que preencha o campo "data_entrada" com o valor "20-10-2019"
    E que preencha o campo "data_saida" com o valor "20-10-2020"
    E que preencha o campo "data_agendamento" com o valor ""
    E que preencha o campo "status" com o valor "Em andamento"
    E que preencha o campo "observacao" com o valor "Agendado com sucesso"
    Quando o usuario clicar no botao salvar processo sem id
    Entao o usuario deveria ver a mensagem de "<statuscode>"

    Exemplos:
      | descricao         | statuscode                     | vara |
      | processo com vara | salvo com sucesso              | 2598 |
      | processo sem vara | não pode ser deixado em branco |      |

