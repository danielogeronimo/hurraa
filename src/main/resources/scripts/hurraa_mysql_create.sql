/*
  Hurraa http://code.google.com/p/hurraa/

  This file is part of Hurraa.

  Hurraa is free software: you can redistribute it and/or modify
  it under the terms of the GNU General Public License as published by
  the Free Software Foundation, either version 3 of the License, or
  (at your option) any later version.

  Hurraa is distributed in the hope that it will be useful,
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU General Public License for more details.

  You should have received a copy of the GNU General Public License
  along with Hurraa.  If not, see <http://www.gnu.org/licenses/>.
*/
drop table if exists fabricante;
drop table if exists autenticacao;
drop table if exists usuario_grupo;
drop table if exists grupo;
drop table if exists usuario;

create table fabricante (
  id   char(32)    not null,
  nome varchar(50) not null,
  tipo tinyint(1)      null
) engine innodb;

alter table fabricante add constraint pk_fabricante primary key (id);

create table usuario (
  id	char(32)     not null,
  nome	varchar(100) not null,
  email	varchar(100) not null,
  fone	varchar(10)      null
) engine innodb;

alter table usuario add constraint pk_usuario primary key (id);

create table autenticacao (
  id         char(32)     not null,
  usuario_id char(32)     not null,
  email      varchar(100) not null,
  senha      varchar(50)  not null
) engine innodb;

alter table autenticacao add constraint pk_autenticacao primary key (id);
create unique index idx_unique_autenticacao_email ON autenticacao (email);
alter table autenticacao add constraint fk_usuario_autenticacao foreign key (usuario_id) references usuario (id) on delete cascade;

create table grupo (
    id   char(32)    not null,
    nome varchar(50) not null
) engine innodb;

alter table grupo add constraint pk_grupo primary key (id);
create unique index idx_unique_grupo_nome on grupo (nome);

create table usuario_grupo (
    id         char(32) not null,
    grupo_id   char(32) not null,
    usuario_id char(32) not null
) engine innodb;

alter table usuario_grupo add constraint pk_usuario_grupo primary key (id);
create index idx_grupo_usuario on usuario_grupo (grupo_id);
create index idx_usuario_grupo on usuario_grupo (usuario_id);
alter table usuario_grupo add constraint fk_grupo_usuario foreign key (grupo_id) references grupo (id) on delete cascade;
alter table usuario_grupo add constraint fk_usuario_grupo foreign key (usuario_id) references usuario (id) on delete cascade;
