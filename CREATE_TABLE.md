`\conninfo`

```
create user client1 with encrypted password '1';
create user client2 with encrypted password '2';
create user client3 with encrypted password '3';
create user client4 with encrypted password '4';

CREATE ROLE server1;
CREATE DATABASE server1 WITH ENCODING = 'UTF8' OWNER = server1;
CREATE ROLE server2;
CREATE DATABASE server2 WITH ENCODING = 'UTF8' OWNER = server2;

CREATE ROLE peer1;
CREATE DATABASE peer1 WITH ENCODING = 'UTF8' OWNER = peer1;
CREATE ROLE peer2;
CREATE DATABASE peer2 WITH ENCODING = 'UTF8' OWNER = peer2;

CREATE ROLE client1;
CREATE DATABASE client1 WITH ENCODING = 'UTF8' OWNER = client1;
CREATE ROLE client2;
CREATE DATABASE client2 WITH ENCODING = 'UTF8' OWNER = client2;
CREATE ROLE client3;
CREATE DATABASE client3 WITH ENCODING = 'UTF8' OWNER = client3;
CREATE ROLE client4;
CREATE DATABASE client4 WITH ENCODING = 'UTF8' OWNER = client4;

ALTER ROLE "server1" WITH LOGIN;
ALTER ROLE "server2" WITH LOGIN;
ALTER ROLE "peer1" WITH LOGIN;
ALTER ROLE "peer2" WITH LOGIN;
ALTER ROLE "client1" WITH LOGIN;
ALTER ROLE "client2" WITH LOGIN;
ALTER ROLE "client3" WITH LOGIN;
ALTER ROLE "client4" WITH LOGIN;

ALTER ROLE server1 WITH PASSWORD 'password';
ALTER ROLE server2 WITH PASSWORD 'password';
ALTER ROLE peer1 WITH PASSWORD 'password';
ALTER ROLE peer2 WITH PASSWORD 'password';
ALTER ROLE client1 WITH PASSWORD 'password';
ALTER ROLE client2 WITH PASSWORD 'password';
ALTER ROLE client3 WITH PASSWORD 'password';
ALTER ROLE client4 WITH PASSWORD 'password';




\connect demodb
\dt

\c peer1
ALTER TABLE public.flyway_schema_history OWNER TO peer1;
\c peer2
ALTER TABLE public.flyway_schema_history OWNER TO peer2;
\c server1
ALTER TABLE public.flyway_schema_history OWNER TO server1;
\c server2
ALTER TABLE public.flyway_schema_history OWNER TO server2;


DROP TABLE PERSON;
CREATE TABLE PERSON (
	person_id UUID PRIMARY KEY,
	name VARCHAR ( 50 ) UNIQUE NOT NULL
);
ALTER TABLE public.gauss_unit OWNER TO peer1;
ALTER TABLE public.u_person_data OWNER TO server2;


\c server1
\c server2
DROP TABLE IF EXISTS U_PERSON_DATA; 
CREATE TABLE U_PERSON_DATA (
	data_id UUID PRIMARY KEY,
	name VARCHAR ( 50 ) UNIQUE NOT NULL,
	u1 bigint[],
	u2 bigint[],
	verified boolean	
);
DROP TABLE IF EXISTS GAUSS_UNIT;
CREATE TABLE GAUSS_UNIT (
	unit_id UUID PRIMARY KEY,
	name VARCHAR ( 50 ) UNIQUE NOT NULL,
	x integer,
	y integer	
);



\c peer1
\c peer2
DROP TABLE V_PERSON_DATA;
CREATE TABLE V_PERSON_DATA (
	data_id UUID PRIMARY KEY,
	name VARCHAR ( 50 ) UNIQUE NOT NULL,
	v1 bigint[],
	v2 bigint[],
	verified boolean	
);
DROP TABLE V_HashMatrix;
CREATE TABLE V_HashMatrix (
	data_id UUID PRIMARY KEY,
	name VARCHAR ( 50 ) UNIQUE NOT NULL,
	rcType VARCHAR ( 50 ) UNIQUE NOT NULL,
	index_num integer,
	index_Hash bigint[]
);

ALTER TABLE public.v_hashmatrix OWNER TO peer2;
ALTER TABLE public.v_person_data OWNER TO peer2;
ALTER TABLE public.person OWNER TO peer2;








# https://www.postgresqltutorial.com/postgresql-administration/postgresql-create-database/
CREATE DATABASE 

grant connect ON DATABSE PEER1_DB to peer1;
grant connect ON DATABSE PEER2_DB to peer2;

grant connect ON DATABSE SERVER1_DB to server1;
grant connect ON DATABSE SERVER2_DB to server2;

CREATE SCHEMA "schema_name"; 

grant select,insert,update,delete ON  ALL TABLES IN SCHEMA abc to abc;

```

```
创建用户
create user abc with ENCRYPTED password '';
GRANT abc to abc;
ALTER ROLE abc WITH abc;

##创建读写账号
CREATE ROLE abc_rw;
CREATE ROLE abc_rr;

##赋予访问数据库权限，schema权限
grant connect ON DATABASE abc to abc_rw;
GRANT USAGE ON SCHEMA scm TO abc_rw;
```
### List all tables
1. SQL Query
```
SELECT * FROM schema.tables;
SELECT * FROM schema.tables WHERE table_schema = 'singapore';
```






```aidl
CREATE TABLE SUSERDATA (
	data_id serial PRIMARY KEY,
	username VARCHAR ( 50 ) UNIQUE NOT NULL,
    u1 INTEGER NOT NULL,
    u2 INTEGER NOT NULL,
	created_on TIMESTAMP NOT NULL,
        last_login TIMESTAMP 
);
```