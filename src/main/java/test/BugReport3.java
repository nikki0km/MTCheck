package test;

import lombok.Data;
import java.util.List;

@Data
public class BugReport3 {
    private boolean bugFound = false; // 表示是否发现 bug

    private String createTableSQL; // 用于存储创建表的 SQL 语句
    private List<String> initializeStatements; // 用于存储初始化 SQL 语句
    private String initialTable; // 用于存储初始表的内容

    // 存储三组事务
    private Transaction tx1, tx2; // 并发执行的源事务
    private Transaction tx3, tx4; // 串行执行 A (模拟 Tx1->Tx2)
    private Transaction tx5, tx6; // 串行执行 B (模拟 Tx2->Tx1)

    private String inputSchedule; // 用于存储输入的调度信息
    private String submittedOrder; // 用于存储提交的顺序

    // 存储三个执行结果
    private TxnPairResult execRes;      // 并发执行结果
    private TxnPairResult inferredResA; // 串行执行结果 A (Tx3 -> Tx4)
    private TxnPairResult inferredResB; // 串行执行结果 B (Tx6 -> Tx5)

    @Override
    public String toString() { // 重写 toString 方法
        StringBuilder sb = new StringBuilder("\n============================= BUG REPORT =============================\n");
        sb.append(" [Schema & Init]\n");
        sb.append(" -- Create Table SQL: ").append(createTableSQL).append("\n");
        sb.append(" -- InitializeStatements:\n");
        if (initializeStatements != null) {
            for (String stmt : initializeStatements) {
                sb.append("\t").append(stmt).append(";\n");
            }
        }
        sb.append(" -- Initial Table: \n").append(initialTable).append("\n");

        sb.append("\n [Transactions]\n");
        sb.append(" -- Concurrent Group (Source):\n");
        sb.append("    Tx1: ").append(tx1).append("\n");
        sb.append("    Tx2: ").append(tx2).append("\n");
        
        sb.append(" -- Serial Group A (Tx3 -> Tx4):\n");
        sb.append("    Tx3: ").append(tx3).append("\n");
        sb.append("    Tx4: ").append(tx4).append("\n");

        sb.append(" -- Serial Group B (Tx6 -> Tx5):\n");
        sb.append("    Tx6: ").append(tx6).append("\n");
        sb.append("    Tx5: ").append(tx5).append("\n");

        sb.append("\n [Schedule Info]\n");
        sb.append(" -- Input Schedule: ").append(inputSchedule).append("\n");
        sb.append(" -- Submitted Order: ").append(submittedOrder).append("\n");

        sb.append("\n [Execution Results Comparison]\n");
        sb.append(" >> 1. Concurrent Result (Tx1 || Tx2):\n").append(execRes).append("\n");
        sb.append(" >> 2. Serial Result A   (Tx3 -> Tx4):\n").append(inferredResA).append("\n");
        sb.append(" >> 3. Serial Result B   (Tx6 -> Tx5):\n").append(inferredResB).append("\n");
        
        sb.append("======================================================================\n");
        return sb.toString();
    }
}