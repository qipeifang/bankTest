package qpf.Bridge;

import java.sql.SQLException;

//����Implementor�ӿڣ����ж�������ʵ�������Ҫʵ�ֵĽӿ�operation()
public interface Implementor {
    public void operation(String cardID1,String cardID2,long amount) throws SQLException;
}
