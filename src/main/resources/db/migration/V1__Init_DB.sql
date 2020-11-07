create table kvvj_kau (
  kvvj_kau_0 int8 generated by default as identity,
  kvvj_kau_k varchar(255),
  kvvj_kau_n varchar(255),
  primary key (kvvj_kau_0)
);

create table kvvj_ks (
  kvvj_ks_0 int8 generated by default as identity,
  kvvj_ks_data date,
  kvvj_ks_db int4,
  kvvj_ks_dokd date,
  kvvj_ks_dokk varchar(255),
  kvvj_ks_dokn int4,
  kvvj_ks_kr int4,
  kvvj_ks_ks int4,
  kvvj_ks_ksn varchar(255),
  kvvj_ks_s int4,
  kvvj_ks_sn varchar(255),
  kvvj_ks_to varchar(255),
  primary key (kvvj_ks_0)
);

create table kvvj_nst (
  kvvj_nst_0 int8 generated by default as identity,
  kvvj_nst_datad date,
  kvvj_nst_datas date,
  kvvj_nst_datat date,
  kvvj_nst_firma varchar(255),
  kvvj_nst_s int4,
  kvvj_nst_sn varchar(255),
  primary key (kvvj_nst_0)
);

create table kvvj_opd (
  kvvj_opd_0 int8 generated by default as identity,
  kvvj_opd_av1 varchar(255),
  kvvj_opd_av2 varchar(255),
  kvvj_opd_av3 varchar(255),
  kvvj_opd_avt1 varchar(255),
  kvvj_opd_avt2 varchar(255),
  kvvj_opd_avt3 varchar(255),
  kvvj_opd_k varchar(255),
  kvvj_opd_n varchar(255),
  primary key (kvvj_opd_0)
);

create table kvvj_pd (
  kvvj_pd_0 int8 generated by default as identity,
  kvvj_pd_ak1 varchar(255),
  kvvj_pd_ak2 varchar(255),
  kvvj_pd_ak3 varchar(255),
  kvvj_pd_av1 varchar(255),
  kvvj_pd_av2 varchar(255),
  kvvj_pd_av3 varchar(255),
  kvvj_pd_avt1 varchar(255),
  kvvj_pd_avt2 varchar(255),
  kvvj_pd_avt3 varchar(255),
  kvvj_pd_db int4,
  kvvj_pd_dbn varchar(255),
  kvvj_pd_dokd date,
  kvvj_pd_dokk varchar(255),
  kvvj_pd_dokn int4,
  kvvj_pd_kr int4,
  kvvj_pd_krn varchar(255),
  kvvj_pd_rub int4,
  kvvj_pd_to varchar(255),
    primary key (kvvj_pd_0)
);

create table kvvj_ps (
  kvvj_ps_0 int8 generated by default as identity,
  kvvj_ps_av1 varchar(255),
  kvvj_ps_av2 varchar(255),
  kvvj_ps_n varchar(255),
  kvvj_ps_s int4,
  kvvj_ps_typ varchar(255),
  primary key (kvvj_ps_0)
);

create table kvvj_rj (
  kvvj_rj_0 int8 generated by default as identity,
  kvvj_rj_data date,
  kvvj_rj_db int4,
  kvvj_rj_dbn varchar(255),
  kvvj_rj_dokd date,
  kvvj_rj_dokk varchar(255),
  kvvj_rj_dokn int4,
  kvvj_rj_kr int4,
  kvvj_rj_krn varchar(255),
  kvvj_rj_rub int4,
  kvvj_rj_to varchar(255),
  primary key (kvvj_rj_0)
);

create table kvvj_txo (
  kvvj_txo_0 int8 generated by default as identity,
  kvvj_txo_db int4,
  kvvj_txo_dbn varchar(255),
  kvvj_txo_dokk varchar(255),
  kvvj_txo_k varchar(255),
  kvvj_txo_kr int4,
  kvvj_txo_krn varchar(255),
  primary key (kvvj_txo_0)
);

create table kvvj_va (
  kvvj_va_0 int8 generated by default as identity,
  kvvj_va_k varchar(255),
  kvvj_va_n varchar(255),
  primary key (kvvj_va_0)
);

create table user_role (
  user_id int8 not null,
  roles varchar(255)
);

create table users (
  id int8 generated by default as identity,
  password varchar(255),
  username varchar(255),
  primary key (id)
);

alter table if exists user_role
  add constraint user_role_user_fk
  foreign key (user_id) references users;