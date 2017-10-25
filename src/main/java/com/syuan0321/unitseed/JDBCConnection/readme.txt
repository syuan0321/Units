/**********************************************************
DataSource VS DriverManager
----
new Connection() is not light.Have to use connection pool.
We are using Data Source rather than DriverManager, because DataSource implemented connectionPool automatically. 
 
---
DBCP & CP30

dbcp: BasicDataSource ds = new BasicDataSource(); con = ds.getConnection();
cp30: ComboPooledDataSource ds = new ComboPooledDataSource(); con = ds.getConnection();

DBCP(TomCat default) vs CP30（Spring default）

dbcp没有自动的去回收空闲连接的功能  c3p0有自动回收空闲连接功能。DBCP 无限等待时间去连接  (Could set up parameter to do this.)
两者主要是对数据连接的处理方式不同！
C3P0提供最大空闲时间，DBCP提供最大连接数。 
C3P0当连接超过最大空闲连接时间时，当前连接就会被断掉。DBCP当连接数超过最大连接数时，所有连接都会被断开

---
Transaction Isolation Lvl: (Lock system)
DR==>Dirty Read ; RR==> Repeatable Read ; PR==>Phantom Read

				    DR	RR	PR				
Read uncommitted	√	√	√
Read committed		×	√	√
Repeatable read		×	×	√
Serializable		×	×	×














***********************************************************/