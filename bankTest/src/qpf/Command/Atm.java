package qpf.Command;

import java.sql.SQLException;

public class Atm {
	private Command[] command;
	
	public Atm(){
		this.command = new Command[]{new NoCommand()};
	}
	//设置一组要执行的命令
	public void setCommand(Command command[]) {
		this.command = command;
	}
	//执行命令的方法
	public void action(int i,long money,String cardID) throws SQLException {
		this.command[i].execute(money,cardID);
	}
	//撤销命令的方法
	public void cancel(int i,long money,String cardID) throws SQLException {
		this.command[i].undo(money,cardID);
	}
}
