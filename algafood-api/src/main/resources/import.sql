insert into cozinha(id,nome) values (1,'Tailandesa');
insert into cozinha(id,nome) values (2,'Indiana');
insert into cozinha(id,nome) values (3,'Italiana');

insert into restaurante(nome,taxa_frete,cozinha_id) values('Peixes e Cia',8.00,1);
insert into restaurante(nome,taxa_frete,cozinha_id) values('Churrasco Grill',5.00,2);
insert into restaurante(nome,taxa_frete,cozinha_id) values('Pizzaria DiTalia',5.00,3);

insert into estado(id,nome) values (1,'São Paulo');
insert into estado(id,nome) values (2,'Minas Gerais');
insert into estado(id,nome) values (3,'Paraná');

insert into cidade(id,nome,estado_id) values(1,'Analândia',1);
insert into cidade(id,nome,estado_id) values(2,'Andradas',2);
insert into cidade(id,nome,estado_id) values(3,'Curitiba',3);

insert into permissao(id,nome,descricao) values(1,'CRIAR_USUARIO','Permite criar um usuario do sistema');
insert into permissao(id,nome,descricao) values(2,'CONSULTAR_COZINHA','Permite para consultar cozinhas');
insert into permissao(id,nome,descricao) values(3,'EDITAR_COZINHA','Permite editar cozinhas');

insert into forma_pagamento(id,nome) values (1,'Boleto');
insert into forma_pagamento(id,nome) values (2,'Cartao de crédito');
insert into forma_pagamento(id,nome) values (3,'Cartão de débito');