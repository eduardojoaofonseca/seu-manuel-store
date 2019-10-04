# Running Mongo Db

Open new terminal and run the follow command to start mongo:

```
docker run -d --name "mongodb" -p "27016:27017" mongo
```

To start the application run the follow command:

```
mvn spring-boot:run
```


# Exercise:

## A loja do "seu" Manuel
Seu Manuel deseja expandir seus negócios e vender online, para isso ele te contratou para realizar o desenvolvimento do sistema que vai dar suporte à operação da loja. São listados abaixo os serviços que devem ser disponibilizados pelo sistema.

### Produtos
Serviço de produtos para que seja possível cadastrar, recuperar, atualizar e deletar os produtos de sua loja.
Os produtos serão identificados por um código e terá as informações de nome, descrição, estoque, preço e mais alguns atributos que variam de produto para produto (customizáveis).
### Pedidos
Serviço de pedidos que permitirá registrar, recuperar e atualizar as vendas dos seus produtos. As informações dos pedido consistem em um código identificador, data da compra, nome do comprador, estado (ex: novo, aprovado, entregue e cancelado), valor do frete e a lista de itens que foram vendidos - cada item possui: código do produto; quantidade; e o preço de venda.
### Relatórios
Por fim, o sistema também deve fornecer a possibilidade de extrair um relatório que informa o ticket médio dado um intervalo de tempo (data inicial e final) - a definição de ticket médio é facilmente encontrada na web, mas fique à vontade para indicar a definição utilizada na solução.
#### Considerações
Considere que o sistema deve:
 - Recusar a criação de um pedido com item não cadastrado;
 - Decrementar o estoque do(s) produto(s) sempre que um pedido é realizado;
 - Evitar o cadastro de pedidos cujo item não tem estoque suficiente.

#### Observações:
 - Desenvolva as APIs do Sistema
 - Produto:
     - Cadastrar **ok**
     - Atualizar **ok**
     - Excluir **ok**
     - Consultar pelo codigo **ok**
     - Consultar por parte do nome **ok**
     - Consultar por preços dos produtos(preços entre um min e um max)
 - Pedido:
     - Criar um novo pedido **ok**
     - Cancelar o pedido(lembrar da regra de negocio) **ok**
     - Entregar o pedido **ok**
     - Confirmar o pedido **ok**
 - A API deve usar dados no formato JSON para realizar as operações;
 - Os dados devem ser armazenados em um banco de dados;
 - É necessário escrever testes automáticos para os serviços;
 
 cenas
