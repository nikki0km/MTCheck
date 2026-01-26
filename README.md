# MTCheck

# Bug List

整理的bug暂时如下.

| ID | DBMS    | Link | Status    | Isolation Bug |  备注 | 是否回复 |
|----|---------|------|-----------|---------------|---------|--------|
| 1  | MySQL   | [bug#119409](https://bugs.mysql.com/bug.php?id=119409) | 未验证  | Yes           | 与本表第6个bug一样 |未回复|
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
