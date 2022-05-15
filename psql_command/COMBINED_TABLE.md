```
\c peer1
DROP TABLE V_PERSON_DATA;
DROP TABLE IF EXISTS person_rc;
DROP TABLE IF EXISTS PERSON_STATS;
DROP TABLE IF EXISTS HashList;
CREATE TABLE V_PERSON_DATA (
    data_id UUID PRIMARY KEY,
    name VARCHAR ( 50 ) NOT NULL,
    v1 text[],
    v2 text[],
    verified boolean
);
CREATE TABLE person_rc (
    rc_id UUID PRIMARY KEY, 
    user_id UUID,
    row integer,
    col integer
);
CREATE TABLE PERSON_STATS (
    user_id UUID PRIMARY KEY,
    count integer
);
CREATE TABLE HashList (
    hash_id UUID PRIMARY KEY,
    rowOrCol TEXT,
    index integer,
    concatedResult TEXT,
    HashResult Integer
);
ALTER TABLE V_PERSON_DATA OWNER TO peer1;
ALTER TABLE person_rc OWNER TO peer1;
ALTER TABLE PERSON_STATS OWNER TO peer1;
ALTER TABLE HashList OWNER TO peer1;



\c client1
DROP TABLE IF EXISTS VHashMatrix;
DROP TABLE IF EXISTS DiUnitRange;
DROP TABLE IF EXISTS HashList;
CREATE TABLE VHashMatrix (
    v_id UUID PRIMARY KEY,
    row text,
    col text,
    vi text[]
);
CREATE TABLE DiUnitRange (
    d_id serial PRIMARY KEY,
    unitrange TEXT,
    di TEXT[]
);
CREATE TABLE HashList (
    hash_id UUID PRIMARY KEY,
    rowOrCol TEXT,
    index integer,
    concatedResult TEXT,
    HashResult Integer
);
ALTER TABLE VHashMatrix OWNER TO client1;
ALTER TABLE DiUnitRange OWNER TO client1;
ALTER TABLE HashList OWNER TO client1;



\c server1
DROP TABLE IF EXISTS U_PERSON_DATA; 
CREATE TABLE U_PERSON_DATA (
	data_id UUID PRIMARY KEY,
	name VARCHAR ( 50 )  NOT NULL,
	u1 text[],
	u2 text[],
	verified boolean	
);
ALTER TABLE U_PERSON_DATA OWNER TO server1;
```