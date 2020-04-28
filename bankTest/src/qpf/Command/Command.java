package qpf.Command;

import java.sql.SQLException;

public interface Command {
	public void execute(long money,String cardID) throws SQLException;
	public void undo(long money,String cardID) throws SQLException;
}
