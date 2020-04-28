package qpf.Bridge;

import java.sql.SQLException;

//�����Ž���Abstraction�������ж�Implementor�ӿڵ�����
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