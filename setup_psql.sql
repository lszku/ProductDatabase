drop database if exists productdb;
drop user if exists productuser;
CREATE ROLE productuser PASSWORD 'trudnehaslo123' LOGIN;
CREATE DATABASE productdb with owner='productuser';
grant all privileges on database productdb to productuser;
grant CONNECT on DATABASE productdb to productuser;

