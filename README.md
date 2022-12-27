# OneToOne

### 1. Pessoa 1 <--------------------------> 1 Licenca
### 2. Estudante 1 <--------------------------> 1 MatriculaBiblioteca
#### A. Exemplo OneToOne:
##### 1. Pessoa e Licenca
|   Pessoa   | Licenca |
|   :---:     |   :---:     |
| Licenca licenca;  | Person person; |
|   | |
##### 2. Estudante e MatriculaBiblioteca
|   Estudante   | MatriculaBiblioteca |
|   :---:     |   :---:     |
| MatriculaBiblioteca matriculaBib;  | Estudante estudante; |
|   | |
### 3. Há dois tipos de relacionamento OneToOne:
#### A. Primary Key Association ( Relacionamento Bidirecional obrigatoriamente ):
##### 1. O Pai ou os dois objetos associados podem ser diretamente ligados ou eles compartilharão a mesma Primary Key.
##### 2. No caso de estudante, a Primary Key de Estudante também será utilizada como uma Primary key em MatriculaBiblioteca, onde o ID 1 é o mesmo ID 1 de MatriculaBiblioteca:
|   Estudante   | :---: | :---: |
|   :---:     |   :---:     |   :---:     |
| 1 |:---: | :---:  |
| 2 |:---: | :---:  |
#####
|   MatriculaBiblioteca   | :---: | :---: |
|   :---:     |   :---:     |   :---:     |
| 1 |:---: | :---:  |
| 2 |:---: | :---:  |
##### 3. Um Estudante sempre terá "um"(uma) MatriculaBiblioteca e uma MatriculaBiblioteca sempre estará associada a Estudante.
#### B. Foreign Key Association ( Relacionamento Unidirecional obrigatoriamente ):
##### 1. Uma Pessoa pode não ter uma licenca de motorista, mas uma licenca deveria sempre ser associada a Pessoa.
##### 2. Nestes casos, nós perdemos o tipo Foreign Key do relacionamento OneToOne que em cada uma destas entidades terão seu próprio ID.
##### 3. Mas Licenca terá uma Foreign Key que fará referência a Primary Key da tabela Pai, neste caso, a tabela Pessoa.
|   Pessoa   | :---: | :---: |
|   :---:     |   :---:     |   :---:     |
| 1 |:---: | :---:  |
| 2 |:---: | :---:  |
#####
|   Licenca   | :---: | :---: |
|   :---:     |   :---:     |   :---:     |
| PK | FK | :---:  |
| 10 | 1 | :---:  |
| 20 | 2 | :---:  |
##### 4. Uma Pessoa pode não ter uma licenca para dirigir mas as licencas para dirigir tem de ser sempre associada a uma Pessoa.
