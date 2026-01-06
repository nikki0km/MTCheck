# MTCheck

# Bug List

Troc has found 12 unique bugs in three widely-used DBMSs, i.e., MySQL, MariaDB, and TiDB. Among them, 10 bugs are isolation bugs. The remaining 2 bugs can be triggered by using only one transaction, no matter what isolation level is used.

| ID | DBMS    | Link | Status    | Isolation Bug |
|----|---------|------|-----------|---------------|
| 1  | MySQL   | 链接8 | Verified  | Yes           |
| 2  | MySQL   | 链接1 | Duplicate | Yes           |
| 3  | MySQL   | 链接2 | Duplicate | Yes           |
| 4  | MySQL   | 链接3 | Duplicate | Yes           |
| 5  | MariaDB | 链接4 | Verified  | Yes           |
| 6  | MariaDB | 链接5 | Verified  | Yes           |
| 7  | MariaDB | 链接6 | Duplicate | Yes           |
| 8  | MariaDB | 链接7 | Fixed     | Yes           |
| 9  | TiDB    | pingcap/tidb#28092 | Verified | No  |
| 10 | TiDB    | pingcap/tidb#28095 | Verified | No  |
| 11 | TiDB    | pingcap/tidb#28212 | Verified | Yes |
| 12 | TiDB    | pingcap/tidb#30239 | Duplicate | Yes |
