GRANTs on different objects are separate. GRANTing on a database doesn't GRANT rights to the schema within. Similiarly, GRANTing on a schema doesn't grant rights on the tables within.

If you have rights to SELECT from a table, 
but not the right to see it in the schema that contains it then you can't access the table.

- GRANT on DB doesn't Grant rights to `schema` within
- GRANT on schema doesn't grant rights on `table` within

must have USAGE on schema to use objects within it, but having USAGE on a schema is **not** by itself sufficient to use objects within schema

If create `dir` with `file` within it then set it so that only your own user can access directory


