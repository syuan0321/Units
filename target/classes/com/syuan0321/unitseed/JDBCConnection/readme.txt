/**********************************************************
DataSource VS DriverManager
----
new Connection() is not light.Have to use connection pool.
We are using Data Source rather than DriverManager, because DataSource implemented connectionPool automatically. 
 
---
DBCP & CP30

dbcp: BasicDataSource ds = new BasicDataSource(); con = ds.getConnection();
cp30: ComboPooledDataSource ds = new ComboPooledDataSource(); con = ds.getConnection();

---
Transaction Isolation Lvl: (Lock system)
DR==>Dirty Read ; RR==> Repeatable Read ; PR==>Phantom Read

				    DR	RR	PR				
Read uncommitted	√	√	√
Read committed		×	√	√
Repeatable read		×	×	√
Serializable		×	×	×














***********************************************************/