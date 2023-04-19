CREATE TABLE adocoes(

    id bigint not null auto_increment,
    pet_id bigint not null,
    tutor_id bigint not null,
    data date not null,

    primary key(id),
    foreign key(pet_id) references pets(id),
    foreign key(tutor_id) references tutores(id)

);