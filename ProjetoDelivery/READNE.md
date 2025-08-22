Projeto Individual - Sistema de Gerenciamento de Pedidos de Delivery 

Objetivo
Desenvolver um sistema em Java para gerenciamento de pedidos e entregas de um restaurante, aplicando ao menos quatro padrões de projeto para demonstrar domínio conceitual e prático sobre o tema.

⚙️ Funcionalidades e Padrões de Projeto Aplicados
Este projeto oferece uma interface de linha de comando interativa para o usuário e utiliza os seguintes padrões de projeto:

Singleton (Criacional):

Onde: Na classe Cardapio.

Como: O construtor é privado, e a única instância é acessada através do método estático getInstancia().

Por quê: Garante que haja apenas uma única lista de itens do cardápio em toda a aplicação, evitando inconsistências.

Builder (Criacional):

Onde: Na classe Pedido.

Como: A classe PedidoBuilder é usada para construir o objeto Pedido passo a passo, através de métodos como adicionarItem() e adicionarObservacoes(). Isso é demonstrado na opção "Fazer um novo pedido".

Por quê: Facilita a criação de objetos complexos (pedidos com múltiplos itens e observações), tornando o código mais legível e flexível.

Strategy (Comportamental):

Onde: No cálculo do frete.

Como: A interface EstrategiaFrete define um método calcularFrete(). O usuário pode escolher entre FretePadrao ou FretePromocional no momento de fazer o pedido, e o sistema utiliza a estratégia selecionada.

Por quê: Permite que o algoritmo de cálculo do frete seja alterado ou estendido sem modificar o código do sistema principal.

Observer (Comportamental):

Onde: Na notificação do status do pedido ao cliente.

Como: O GerenciadorPedidos é o "sujeito" que notifica, e a classe Cliente é o "observador" que recebe as atualizações. O usuário pode atualizar o status na opção "Atualizar status do pedido", e o sistema notifica o cliente automaticamente.

Por quê: Desacopla o objeto que tem o estado (o pedido) daqueles que dependem dele (o cliente), permitindo que múltiplas partes do sistema reajam às mudanças de estado de forma independente.

🚀 Como Executar o Projeto
Requisitos de Ambiente
Java Development Kit (JDK) 8 ou superior.

Instruções
Navegue até o diretório do seu projeto:

cd /caminho/para/seu/projeto_delivery_java

Compile o código-fonte:
Navegue até o diretório src e compile os arquivos .java.

cd src
javac -d ../bin -cp . */*.java *.java

Execute a aplicação:
Navegue de volta para o diretório principal do projeto e execute a classe Main.

cd ..
java -cp bin Main

O sistema irá iniciar em um console interativo, onde você poderá escolher as opções para criar um pedido, atualizar seu status e visualizar as notificações automáticas.