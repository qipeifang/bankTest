package qpf.Command;

import java.sql.SQLException;

//´æ¿îÃüÁî
public class CmbDepositCommand implements Command{
	private Cmb cmb = new Cmb();
	//@Override
	public void execute(long money, String cardID) throws SQLException {
		cmb.saveMoney(money,cardID);
	}
	//@Override
	public void undo(long money, String cardID) throws SQLException {
		cmb.getMoney(money,cardID);
	}
}
