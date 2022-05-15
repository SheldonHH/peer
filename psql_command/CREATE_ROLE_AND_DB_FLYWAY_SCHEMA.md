```
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
```


```
\c server1
CREATE TABLE public.flyway_schema_history (
    installed_rank integer NOT NULL,
    version character varying(50),
    description character varying(200) NOT NULL,
    type character varying(20) NOT NULL,
    script character varying(1000) NOT NULL,
    checksum integer,
    installed_by character varying(100) NOT NULL,
    installed_on timestamp without time zone DEFAULT now() NOT NULL,
    execution_time integer NOT NULL,
    success boolean NOT NULL
);
ALTER TABLE public.flyway_schema_history OWNER TO server1;


\q
pg_dump -U postgres -t flyway_schema_history server3 | psql server1  -U postgres
pg_dump -U postgres -t flyway_schema_history server3 | psql server2  -U postgres
pg_dump -U postgres -t flyway_schema_history server3 | psql peer1  -U postgres
pg_dump -U postgres -t flyway_schema_history server3 | psql peer2  -U postgres
pg_dump -U postgres -t flyway_schema_history server3 | psql client1  -U postgres

psql -U postgres
\c server2
ALTER TABLE public.flyway_schema_history OWNER TO server2;
\c server3
ALTER TABLE public.flyway_schema_history OWNER TO server3;
\c peer1
ALTER TABLE public.flyway_schema_history OWNER TO peer1;
\c peer2
ALTER TABLE public.flyway_schema_history OWNER TO peer2;
\c client1
ALTER TABLE public.flyway_schema_history OWNER TO client1;
```

