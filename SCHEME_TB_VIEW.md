```
Create a schema and create a table and view within it:

CREATE SCHEMA hollywood
    CREATE TABLE films (title text, release date, awards text[])
    CREATE VIEW winners AS
        SELECT title, release FROM films WHERE awards IS NOT NULL;
```
https://www.postgresqltutorial.com/postgresql-administration/postgresql-create-schema/

### a schema for a user
1. Create new role
```
CREATE ROLE john 
LOGIN
PASSWORD 'Postgr@s321!';
```
2. Create Schema for `John`
```
CREATE SCHEMA AUTHORIZATION john;
CREATE SCHEMA IF NOT EXISTS doe AUTHORIZATION john; 
```
creates a table deliveries and a view  delivery_due_list that 
belongs to the scm schema:
### Create Schema and its objects example
```
CREATE SCHEMA scm 
    CREATE TABLE deliveries(
        id SERIAL NOT NULL, 
        customer_id INT NOT NULL, 
        ship_date DATE NOT NULL
    )
    CREATE VIEW delivery_due_list AS 
        SELECT ID, ship_date 
        FROM deliveries 
        WHERE ship_date <= CURRENT_DATE;

```
