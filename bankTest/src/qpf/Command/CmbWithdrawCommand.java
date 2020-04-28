package qpf.Command;

import java.sql.SQLException;

//»°øÓ√¸¡Ó
public class CmbWithdrawCommand implements Command{
	private Cmb cmb = new Cmb();
	public void execute(long money, String cardID) throws SQLException {
		cmb.getMoney(money,cardID);
	}
	public void undo(long money, String cardID) throws SQLException {
		cmb.saveMoney(money,cardID);
	}
}
