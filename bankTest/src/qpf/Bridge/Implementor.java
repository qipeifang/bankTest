package qpf.Bridge;

import java.sql.SQLException;

//定义Implementor接口，其中定义了其实现类必须要实现的接口operation()
public interface Implementor {
    public void operation(String cardID1,String cardID2,long amount) throws SQLException;
}
