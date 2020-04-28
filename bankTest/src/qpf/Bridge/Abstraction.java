package qpf.Bridge;

import java.sql.SQLException;

//定义桥接类Abstraction，其中有对Implementor接口的引用
public abstract class Abstraction {
    private Implementor implementor;

    public Implementor getImplementor() {
        return implementor;
    }

    public void setImplementor(Implementor implementor) {
        this.implementor = implementor;
    }

    protected void operation(String cardID1,String cardID2,long amount) throws SQLException{
        implementor.operation(cardID1,cardID2,amount);
    }
}