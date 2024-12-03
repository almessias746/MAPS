# MAPS

Meu nome é André Lima Messias , o nível pretendido é o Nivel 2 e possivelmente o Nível 3 e optamos pela "Opção A: Multi-usuário".

O Banco de dados escolhido foi o HSQLDB , banco embarcado , conforme solicitado na avaliação.

Para calculos e melhor performance "André Lima Messias" optaria por um banco de dados com "DOCKER" da Redis , pelos seguintes motivos :
	Datastore na memória.
	Estruturas flexíveis de dados.
	Simplicidade e facilidade de uso.
	Replicação e persistência.
	Alta disponibilidade e escalabilidade.
	Extensibilidade.

Porém selecionamos o HSQLDB pela simplicidade e facilidade de uso e estruturas flexíveis de dados.

Como montamos a estrutura de dados?

LEMBRANDO QUE É PARA UM AMIGO ....

maps.finances.api ( API - JAVA 8 - Spring Boot , Lombok )


	ROLE = > Definição de Perfil "ADMIN" e "USUÁRIO"
	USER = > Definição de Usuários que o banco de dados irá utilizar
	ACCOUNT = > Definição de CONTA CORRENTE que cada usuário irá utlizar , lembrando que o ADMIN ( MEU AMIGO ) pode visualizar todas as contas correntes.
	ASSETS = > Definição de CONTA DE ATIVOS que cada usuário possui e vinculado a uma CONTA CORRENTE.
	ENTRY = > São as entradas da conta corrente ou mesmo dos ativos , podendo ser negativas ou positivas.
	ASSETS_TYPE = > Seria os tipos de ativos permitidos e que são vinculados a movimentaçãos dos ATIVOS.


	Na estrutura de código organizamos da seguinte maneira:

	Repository --> Service --> Adapter --> Controller 

	Dividido em DOMAIN para acessos direto ao BANCO DE DADOS.

	E API para acessos e interação com usuário.


maps-finances-cli - CLIENT

	Quanto a Client , optamos fazer em Angular 11 com PrimeNg.

	Infelizmente , deixamos apenas a estrutura e os serviços disponibilizados , não tive tempo hábil para realizar os códigos.


Nosso objetivo foi confirmar o nosso conhecimento e nosso raciocínio lógico na montagem deste projeto.

André Lima Messias



