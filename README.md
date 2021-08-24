# GQS-PlanejamentoTestes

**Gestão de Qualidade de Software - Planejamento e execução de testes unitários**

Autor: Maycon Rodrigues

Revisor: Pedro Henrique Robadel

A partir de uma análise caixa-branca do código do projeto em  anexo,  implementar casos de testes utilizando as técnicas e estratégias   estudadas de modo a garantir a qualidade do código.

Alguns  casos de teste, sem indicação do padrão AAA  (Arrange-Act-Assert) no  código estão implmenetados na classe  FuncionarioBonusTest. Implemente os demais casos de teste nessa classe,  indicando o padrão AAA para os  novos testes. Antes, faça uma planilha  no Google Sheets (com link  público) e cole o link de acesso na  definição da classe  FuncionarioBonusTest.

Cada caso de teste devem a seguinte estrutura:

- 1 - CT999 - Código identificador do caso de teste, iniciando em 01 até 99
- 2 - Dados de entrada para o teste
- 3 - Resultado que se espera que o teste apresente - Espera-se que  com as  entradas informadas o código seja executado com sucesso ou  apresente  falha? No caso de falha, que mensagem deverá ser apresentada?
- 4 - Resultado obtido pelo teste realizado - O resultado obtido foi o mesmo esperado? Ou algo deu errado?
- 5 - Passou/Falhou - O resultado obtido foi o mesmo do resultado esperado? Se sim o teste Passou, caso contrário ele falhou.

Primeiramente planeje um conjunto de casos de testes na planilha e só depois  execute-os. Após a execução, registre o resultado da primeira  execução  na planilha. Depois disso, duplique a planilha e a renomeie  para  "Segunda execução", rode novamente os testes e faça as correções   necessárias.

Observe que um caso de teste deve prever a falha durante a execução do código. Você pode utilizar o recurso de `@Rule` do  Junit, veja exemplos em https://mkyong.com/unittest/junit-4-tutorial-2-expected-exception-test/.

Faça uma terceira planilha com o nome "Registro de esforço em testes" para o registro do número de horas que você investiu (cada item abaixo  deve  ser uma coluna na planilha): **a)** No planejamento dos casos de teste **b)** Na codificação dos testes automatizados **c)** Na primeira execução, análise e anotações dos resultados **d)** Na segunda execução, análise e anotações dos resultados **e)** Esforço total em testes

### 

### Planilha

[Planilha Planejamento e execução de testes unitários](https://docs.google.com/spreadsheets/d/1kWf0JLfYjsdoAxqHmqO5hAxkCbFEoIhgqFXptL6J7y4/edit?usp=sharing)

[Planilha Planejamento da correção e execução de testes unitários](https://docs.google.com/spreadsheets/d/1F413YpukWVL8QXu7qoo5YyijwCCshomAhUacHehVPl4/edit?usp=sharing)

