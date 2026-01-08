# MTCheck

# Bug List

整理的bug暂时如下.

| ID | DBMS    | Link | Status    | Isolation Bug |  备注 | 是否回复 |
|----|---------|------|-----------|---------------|---------|
| 1  | MySQL   | [bug#119409](https://bugs.mysql.com/bug.php?id=119409) | 未验证  | Yes           ||未回复|
| 2  | MySQL   | [bug#119632](https://bugs.mysql.com/bug.php?id=119632&thanks=4) | Duplicate  | Yes           |[与bug#107066一样](https://bugs.mysql.com/bug.php?id=107066&thanks=4)  |未回复|
| 3  | MySQL   | [bug#119648](https://bugs.mysql.com/bug.php?id=119648&thanks=4) | Duplicate  | Yes           | [与bug#117835一样](https://bugs.mysql.com/bug.php?id=117835&thanks=4)   |未回复|
| 4  | MariaDB | [bug#38301](https://jira.mariadb.org/browse/MDEV-38301?filter=-2) | Verified  | Yes           ||已回复|
| 5  | MariaDB | [bug#37318](https://jira.mariadb.org/browse/MDEV-37318) | Duplicate  | Yes           | [与bug#32898一样](https://jira.mariadb.org/browse/MDEV-32898)|已回复，重复|
| 6  | MariaDB | [bug#38489](https://jira.mariadb.org/browse/MDEV-38489) | Duplicate  | Yes           ||未回复|
| 7 | TiDB    | [pingcap/tidb#65444](https://github.com/pingcap/tidb/issues/65444) | Duplicate | Yes |[与bug#36581一样，新版本中已经没有这个错](https://github.com/pingcap/tidb/issues/36581) |回复测试版本太旧|
| 8 | TiDB    | [pingcap/tidb#65440](https://github.com/pingcap/tidb/issues/65440) | 误报，TiDB中这个不算错 | Yes ||回复不是|
| 9 | TiDB    | [pingcap/tidb#30239](https://github.com/pingcap/tidb/issues/65416) | 未验证 | Yes || 未回复|
