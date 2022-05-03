# Projeto_MVC

Gerando container Docker para mysql : 
* sudo docker run -p 3306:3306 --name mvc-course-db -e MYSQL_ROOT_PASSWORD=root -d mysql --default-authentication-plugin=mysql_native_password -h 127.0.0.1

Usando o mysql dentro do container : 
* sudo docker exec -it mvc-course-db mysql -uroot -proot

Inserir valores na tabela pedido :
* insert into pedido (descricao, nome, url_imagem,url_produto) VALUES('Celular','Celular','https://images-na.ssl-images-amazon.com/images/I/81UgYuadkpL._AC_SL1500_.jpg','https://www.amazon.com.br/Smartphone-Xiaomi-Redmi-Note-64GB/dp/B07Y8YWTFL/ref=sr_1_6?__mk_pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&dchild=1&keywords=Xiaomi+Redmi+Note+8&qid=1600346040&sr=8-6','ENTREGUE');
* insert into pedido (descricao, nome, url_imagem,url_produto) VALUES('Livro','Livro','https://images-submarino.b2w.io/produtos/130884182/imagens/livro-a-garota-do-lago/130884182_1_large.jpg','https://www.submarino.com.br/produto/130884182?opn=XMLGOOGLE&offerId=5e5d0390657407f871434e59','ENTREGUE');

Criar tabela para senhas: 
* create table users(
    username varchar(50) not null primary key,
    password varchar(200) not null,
    enabled boolean not null
);

* create table authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    constraint fk_authorities_users foreign key(username) references users(username)
);
* create unique index ix_auth_username on authorities (username,authority);

Atualizando pedidos com o username:
* UPDATE pedido SET user_username='joao' WHERE id=1;



