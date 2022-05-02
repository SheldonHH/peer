When you reference a table using its name only, 
PostgreSQL searches for the table by using the **schema search path**, which is a list of schemas to look in.

SQL 标准里，在同一个模式里的对象被不同的用户所有的概念是不存在的。而且，有些实现不允许你创建和它们的所有者不同名的模式。
实际上，模式的概念和用户在那些只实现了标准中规定的基本模式支持的数据库系统里几乎是一样的。因此，许多用户考虑对名字加以修饰，使它们真正由username.tablename 组成。
如果你为每个用户都创建了一个模式，这实际上就是PostgreSQL的行为。
同样，在 SQL 标准里也没有public模式的概念。为了最大限度地遵循标准，你不应该使用(可能甚至是应该删除)public模式。
当然，有些数据库系统可能根本没有模式，或者是通过允许跨数据库访问来提供模式的功能。如果你需要在这些系统上干活，那么为了最大限度的移植性，应该根本不使用Scheme

schema，但是最常用的主要有两种：1.查看系统目录视图；2.使用psql短命令
```
select schemaname from pg_tables where tablename ='t1';
GRANT USAGE ON SCHEMA schema_name TO username;
```