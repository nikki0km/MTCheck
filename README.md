# MTCheck

# Bug List

整理的bug暂时如下.
| ID | DBMS    | Link | Status    | Isolation Bug |  备注 | 是否回复 |
|----|---------|------|-----------|---------------|---------|--------|
| 1  | MySQL   | [bug#119801](https://bugs.mysql.com/bug.php?id=119801) | 验证  | Yes           | 与本表第6个bug一样 |已回复|
| 2  | MySQL   | [bug#119632](https://bugs.mysql.com/bug.php?id=119632) | 重复  | Yes           |[与bug#107066一样](https://bugs.mysql.com/bug.php?id=107066&thanks=4)  |未回复|
| 3  | MySQL   | [bug#119648](https://bugs.mysql.com/bug.php?id=119648) | 误报  | Yes           | [与bug#117835一样](https://bugs.mysql.com/bug.php?id=117835&thanks=4)   |回复，说不是bug|
| 4  | MySQL   | [bug#119649](https://bugs.mysql.com/bug.php?id=119649) | 重复  | Yes           | [与bug#117860一样](https://bugs.mysql.com/bug.php?id=117860)   |未回复|
| 5  | MySQL   | [bug#119707](https://bugs.mysql.com/bug.php?id=119707) | 重复  | Yes           | -----------  |未回复|
| 6  | MySQL   | [bug#120129](https://bugs.mysql.com/bug.php?id=120129) | 未验证  | Yes           |  |未回复|
| 7  | MariaDB | [bug#38301](https://jira.mariadb.org/browse/MDEV-38301?filter=-2) | 验证  | Yes           ||已回复|
| 8  | MariaDB | [bug#37318](https://jira.mariadb.org/browse/MDEV-37318) | 重复  | Yes           | [与bug#32898一样](https://jira.mariadb.org/browse/MDEV-32898)|已回复，重复|
| 9  | MariaDB | [bug#39151](https://jira.mariadb.org/browse/MDEV-39151) | 未验证  | Yes           | 与mysql的120129 是同一个 |未回复|
| 10 | TiDB    | [pingcap/tidb#65444](https://github.com/pingcap/tidb/issues/65444) | 重复 | Yes |[与bug#36581一样，新版本中已经没有这个错](https://github.com/pingcap/tidb/issues/36581) |回复测试版本太旧，但新版本中这个错误已经消失了|
| 11 | TiDB    | [pingcap/tidb#67213](https://github.com/pingcap/tidb/issues/67213) | 验证 | Yes |已回复 |

----------------------下面的是更全的记录，误报也放上去了

| ID | DBMS    | Link | Status    | Isolation Bug |  备注 | 是否回复 |
|----|---------|------|-----------|---------------|---------|--------|
| 1  | MySQL   | [bug#119409](https://bugs.mysql.com/bug.php?id=119409) | 未验证  | Yes           | 与本表第6个bug一样 ，我又上报了一次：https://bugs.mysql.com/bug.php?id=119801|未回复|
| 2  | MySQL   | [bug#119632](https://bugs.mysql.com/bug.php?id=119632) | 重复  | Yes           |[与bug#107066一样](https://bugs.mysql.com/bug.php?id=107066&thanks=4)  |未回复|
| 3  | MySQL   | [bug#119648](https://bugs.mysql.com/bug.php?id=119648) | 重复  | Yes           | [与bug#117835一样](https://bugs.mysql.com/bug.php?id=117835&thanks=4)   |未回复|
| 4  | MySQL   | [bug#119649](https://bugs.mysql.com/bug.php?id=119649) | 重复  | Yes           | [与bug#117860一样](https://bugs.mysql.com/bug.php?id=117860)   |未回复|
| 5  | MySQL   | [bug#119707](https://bugs.mysql.com/bug.php?id=119707) | 重复  | Yes           | -----------  |未回复|
| 6  | MariaDB | [bug#38301](https://jira.mariadb.org/browse/MDEV-38301?filter=-2) | 验证  | Yes           ||已回复|
| 7  | MariaDB | [bug#37318](https://jira.mariadb.org/browse/MDEV-37318) | 重复  | Yes           | [与bug#32898一样](https://jira.mariadb.org/browse/MDEV-32898)|已回复，重复|
| 8  | MariaDB | [bug#38489](https://jira.mariadb.org/browse/MDEV-38489) | 误报  | Yes           | 与本表第2个bug一样 |已经回复，不是bug|
| 9  | MariaDB | [bug#38572](https://jira.mariadb.org/browse/MDEV-38572) | 误报  | Yes           | 与bug5，bug7一样  |未回复|
| 10 | TiDB    | [pingcap/tidb#65444](https://github.com/pingcap/tidb/issues/65444) | 重复 | Yes |[与bug#36581一样，新版本中已经没有这个错](https://github.com/pingcap/tidb/issues/36581) |回复测试版本太旧，但新版本中这个错误已经消失了|
| 11 | TiDB    | [pingcap/tidb#65440](https://github.com/pingcap/tidb/issues/65440) | 误报 | Yes ||回复不是|
| 12 | TiDB    | [pingcap/tidb#30239](https://github.com/pingcap/tidb/issues/65416) | 误报 | Yes || 未回复|

```sql
/* init */ DROP TABLE IF EXISTS mtest;
/* init */ CREATE TABLE mtest(c0 CHAR(12), c1 INT, INDEX i0 (c0(5), c1));
/* init */ INSERT INTO mtest VALUES ('', 97);
/* init */ INSERT INTO mtest VALUES ('', 72);
/* init */ INSERT INTO mtest VALUES (NULL, 9);

/* s2 */ BEGIN;
/* s2 */ UPDATE mtest SET c0='', c1=13 WHERE c1 IN (9, 97);
/* s1 */ BEGIN;
/* s1 */ UPDATE mtest SET c0='L', c1=77 WHERE c0='';  -- blocked
/* s2 */ COMMIT;
/* s1 */ COMMIT; 
-- ERROR 1105 (HY000): tikv aborts txn: 
-- Error(Txn(Error(Mvcc(Error(PessimisticLockNotFound { ..., reason: LockMissingAmendFail })))))


/* init */ CREATE TABLE mtest(x INT DEFAULT 0, c0 INT PRIMARY KEY, c1 INT);
/* init */ INSERT INTO mtest VALUES (0, 1, 1), (0, 99, 2);

/* s1 */SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;
/* s1 */BEGIN;
/* s2 */SET SESSION TRANSACTION ISOLATION LEVEL READ COMMITTED;
/* s2 */BEGIN;
/* s2 */UPDATE mtest SET c0=37 WHERE c1=2;
/* s1 */UPDATE mtest SET x = x + 10 WHERE True;（block）
/* s2 */COMMIT;
/* s1 */SELECT * FROM mtest;   -- Actual result:    [(10, 1, 1), (0, 37, 2)]
-- Expected result:  [(10, 1, 1), (10, 37, 2)]  -- Both rows should have x increased by 10
/* s1 */COMMIT;
