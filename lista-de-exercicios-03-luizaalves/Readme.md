### Programação Orientada a Objetos - POO29004

#### Engenharia de Telecomunicações

##### Instituto Federal de Santa Catarina



## Compactação de arquivos

Faça um programa que receba dois argumentos de linha de comando:

* Caminho do diretório que contém arquivos que deverão ser compactados (**diretório de entrada**)
* Caminho do diretório onde serão salvos os arquivos compactados (**diretório de saída**)

Deve-se criar um arquivo ZIP para cada um dos arquivos (regulares ou diretórios) presentes dentro do **diretório de entrada**. O nome do arquivo ZIP deverá ser o nome do arquivo original acrescido da extensão `.zip`.

Exemplo:

O diretório `/tmp/teste` possui o seguinte conteúdo:

```
teste
`-- a
    |-- b
    |   `-- terceiro.dat
    |-- c
    |   `-- d
    |       `-- ultimo.dat
    |-- primeiro.dat
    `-- segundo.dat
```

O programa deverá apresentar um retorno visual indicando o progresso da compressão de cada um dos arquivos.  Por exemplo, ao executar `java Lista03 /tmp/teste /tmp/saida`, deve-se obter um retorno visual semelhante ao exemplo abaixo:

```shell
b.zip - 70% #######
c.zip - 10% #
primeiro.dat.zip - 50% #####
segundo.dat.zip - 90% #########
```

Após a execução do programa deve-se ter os seguintes arquivos ZIP dentro do **diretório de saída**:

```
b.zip
c.zip
primeiro.dat.zip
segundo.dat.zip
```

A classe utilitária [ProgressBar](src/main/java/poo/ProgressBar.java) tem um exemplo de como fazer uma barra de progresso no console.

### Requisitos do projeto

- Fazer uso de Threads
- Testes de unidade com [JUnit4](https://github.com/junit-team/junit4/wiki/Assertions) para validar as implementações das principais classes
- Respeitar o conceito de encapsulamento, fazendo uso adequado dos modificadores de acesso
- Documentar os principais métodos seguindo a sintaxe do JavaDOC
- Respeitar convenção Java que é usada nas aulas



### Data para entrega: 20/05/2018