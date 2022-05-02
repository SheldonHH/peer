pg_dump -U postgres -t flyway_schema_history demodb | psql server1  -U postgres
pg_dump -U postgres -t flyway_schema_history demodb | psql server2  -U postgres
pg_dump -U postgres -t flyway_schema_history demodb | psql peer1  -U postgres
pg_dump -U postgres -t flyway_schema_history demodb | psql peer2  -U postgres

```
docker exec -it $(docker ps | grep -E 'postgres-spring' | awk '{print $1}') /bin/bash
psql -U postgres
create database demodb

CREATE ROLE zhangsan LOGIN;
GRANT CONNECT ON DATABASE demodb TO zhangsan;
CREATE USER zjy1 WITH PASSWORD 'zjy1';


```
`schema_name.object_name`
Schema: contains database objects such as tables, views, indexes, data types, functions, stored procedures
- indexes:
Why Schema?
1. schema can organize database object: tables into logical groups
2. enable multiple users to use one database without interfering with each other.
   多个用户使用一个数据库互不干扰。
   将数据库对象组织成逻辑组以便更容易管理。
   第三方应用的对象可以放在独立的模式中，这样它们就不会与其他对象的名称发生冲突

## View ` select * from view `
Why View?
1. simplify query, using `SELECT` statement
2. grant permission to users through view that contains specific data that users are authorized to see
3. provide consistent layer even the columns of underlying table changes


```
 SELECT cu.customer_id AS id,
    cu.first_name || ' ' || cu.last_name AS name,
    a.address,
    a.postal_code AS "zip code",
    a.phone,
    city.city,
    country.country,
        CASE
            WHEN cu.activebool THEN 'active'
            ELSE ''
        END AS notes,
    cu.store_id AS sid
   FROM customer cu
     INNER JOIN address a USING (address_id)
     INNER JOIN city USING (city_id)
     INNER JOIN country USING (country_id);
```
