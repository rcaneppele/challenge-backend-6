CREATE TABLE usuarios(

    id bigint not null auto_increment,
    login varchar(255) not null,
    senha varchar(255) not null,

    primary key(id)

);

CREATE TABLE perfis(

    id bigint not null auto_increment,
    nome varchar(255) not null,

    primary key(id)

);

CREATE TABLE usuarios_perfis(

    usuario_id bigint not null,
    perfil_id bigint not null,

    foreign key(usuario_id) references usuarios(id),
    foreign key(perfil_id) references perfis(id),
    primary key(usuario_id, perfil_id)

);

insert into perfis values(1, 'ROLE_TUTOR');
insert into perfis values(2, 'ROLE_ABRIGO');