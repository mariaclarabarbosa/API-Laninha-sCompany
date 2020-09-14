# API Laninhas's Company
--------------------------------------------------------------------------------------------------------------------

Uma empresa do comércio varejista deseja realizar a venda de seus produtos pela internet e para isso precisa de um sistema capaz de realizar o controle de estoque e cadastro de clientes. A empresa é responsável pela produção de seus próprios produtos e por isso não precisa registrar dados de fornecedores externos. O sistema não tem como objetivo registrar detalhes da produção. Sendo assim, a seguir são descritos os requisitos e os dados que a empresa julga serem necessários para o funcionamento do sistema:

1. O sistema deve ser capaz de armazenar informações sobre os produtos da empresa, sendo eles: código, nome, descrição, quantidade em estoque, data de fabricação e valor unitário.

2. Ao cadastrar um produto no sistema, os funcionários da empresa devem ser capazes de associá-lo à uma categoria. Cada produto só poderá pertencer à uma categoria.

3. Se o produto já estiver cadastrado no sistema, o colaborador deverá apenas atualizar a quantidade de itens no estoque.

4. Para cada categoria de produto, é necessário registrar: código, nome e descrição.

5. O sistema deverá armazenar dados dos clientes, que devem ser: código, nome completo, nome de usuário, e-mail, cpf, data de nascimento e endereço.

6. Através do sistema, os clientes podem realizar pedidos.

7. Cada pedido deve conter um ou mais produtos, a data em que foi realizado e por quem foi realizado.

8. Um pedido pode ter mais de um item de um mesmo produto, de acordo com a quantidade disponível em estoque.


---------------------------------------------------------------------------------------------------------------------------------------------
# Requisitos de entrega:
	
- Código fonte de backend Java Spring Boot com endpoints necessários para funcionalidades descritas, validações e persistência em banco de dados (H2 ou PostgreSQL).

- Documentação do projeto utilizando Swagger.
