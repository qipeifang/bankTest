package qpf.Bridge;

import java.sql.SQLException;

//下面是Abstraction类的子类RefinedAbstraction
public class RefinedAbstraction extends Abstraction {
     protected void operation(String cardID1,String cardID2,long amount) throws SQLException {
         super.getImplementor().operation(cardID1,cardID2,amount);
     }
 }
