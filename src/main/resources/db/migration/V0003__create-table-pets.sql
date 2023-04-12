CREATE TABLE pets(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    descricao varchar(100) not null,
    adotado tinyint(1) not null,
    idade varchar(50) not null,
    imagem varchar(255) not null,
    abrigo_id bigint not null,

    primary key(id),
    foreign key(abrigo_id) references abrigos(id)

);