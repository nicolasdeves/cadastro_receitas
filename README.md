# cadastro_receitas

- Tenho dificuldade com a integração de back com front end, bem com a ligação do banco de dados no sistema, visto que tenho pouca experiência e não consegui conciliar o tempo disponível com este novo aprendizado. Por isso, decidi por fazer uma interface simples HTML, CSS & JS para demonstrar sucintamente minha ideia de como o sistema poderia funcionar. Também realizei um projeto em Java, no qual quis demonstrar a lógica que poderia ser integrada ao sistema.

- O que faria para continuar ambos projetos:
No sistema Java, criaria telas com o uso do JFrame, por exemplo, e integraria os dados a um sistema gerenciador de banco de dados.
No sistema web, adicionaria campo de edição e exclusão e integraria com o backend e mysql - como solicitado.

- Gostaria de concluir que tenho pouca experiência, porém vontade e capacidade de me especializar nas necessidades técnicas necessárias.

- No sistema gerenciador de banco de dados, organizaria da seguinte maneira:

ingrediente
	- id_ingrediente
	- nome_ingrediente

quantidade_ingrediente (tabela intermediária; liga muitos para muitos)
	- id_receita
	- id_ingrediente
	- quantidade

receita
	- id_receita
	- nome_receita
