create schema anotacao;

use anotacao;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on anotacao.* to user@'localhost';

create table usr_usuario (
  usr_id bigint unsigned auto_increment,
  usr_nome varchar(20) not null,
  usr_senha varchar(100) not null,
  usr_autorizacao varchar(50) not null,
  primary key (usr_id),
  unique key uni_usuario_nome (usr_nome)
);

create table aut_autorizacao (
  aut_id bigint unsigned auto_increment,
  aut_nome varchar(20) not null,
  primary key (aut_id),
  unique key uni_aut_nome (aut_nome)
);

create table uau_usuario_autorizacao (
  usr_id bigint unsigned not null,
  aut_id bigint unsigned not null,
  primary key (usr_id, aut_id),
  foreign key aut_usuario_fk (usr_id) references usr_usuario (usr_id) on delete restrict on update cascade,
  foreign key aut_autorizacao_fk (aut_id) references aut_autorizacao (aut_id) on delete restrict on update cascade
);

create table ant_anotacao (
  ant_id bigint unsigned auto_increment,
  ant_texto varchar(200) not null,
  usr_id bigint unsigned not null,
  primary key (ant_id),
  foreign key ant_usuario_fk (usr_id) references usr_usuario (usr_id) on delete restrict on update cascade
);

create table gst_gasto (
  gst_id bigint unsigned auto_increment,
  gst_valor numeric(10,2) not null,
  gst_descricao varchar(100),
  primary key (gst_id)
);

create table lnc_lance (
  lnc_id bigint unsigned auto_increment,
  lnc_data_hora datetime not null,
  lnc_jogador varchar(50) not null,
  lnc_descricao varchar(200) not null,
  primary key (lnc_id)
);

create table lcl_localidade (
  lcl_id bigint unsigned auto_increment,
  lcl_latitude numeric(10,8) not null,
  lcl_longitude numeric(10,8) not null,
  lcl_descricao varchar(200) not null,
  primary key (lcl_id),
  unique (lcl_latitude, lcl_longitude)
);

insert into usr_usuario (usr_nome, usr_senha, usr_autorizacao)
  values ('admin', '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C', 'ROLE_ADMIN');
insert into aut_autorizacao (aut_nome)
  values ('ROLE_ADMIN');
insert into uau_usuario_autorizacao values (1, 1);
insert into ant_anotacao (ant_texto, usr_id)
  values ('Lembrete', 1);
insert into gst_gasto (gst_valor, gst_descricao)
  values (10.20, 'Sorvete');
insert into lnc_lance (lnc_data_hora, lnc_jogador, lnc_descricao)
  values ('2022-11-29 11:00', 'Paul', 'Errou!');
insert into lcl_localidade (lcl_latitude, lcl_longitude, lcl_descricao)
  values (20.0741, -15.1020, 'Algo');
