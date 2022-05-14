```
\c peer1
DROP TABLE V_PERSON_DATA;
DROP TABLE IF EXISTS person_rc;
DROP TABLE IF EXISTS PERSON_STATS;

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
    user_id UUID PRIMARY,
    count integer
);

ALTER TABLE V_PERSON_DATA OWNER TO peer1;
ALTER TABLE person_rc OWNER TO peer1;
ALTER TABLE PERSON_STATS OWNER TO peer1;
```


