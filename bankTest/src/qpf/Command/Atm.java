package qpf.Command;

import java.sql.SQLException;

public class Atm {
	private Command[] command;
	
	public Atm(){
		this.command = new Command[]{new NoCommand()};
	}
	//����һ��Ҫִ�е�����
	public void setCommand(Command command[]) {
		this.command = command;
	}
	//ִ������ķ���
	public void action(int i,long money,String cardID) throws SQLException {
		this.command[i].execute(money,cardID);
	}
	//��������ķ���
	public void cancel(int i,long money,String cardID) throws SQLException {
		this.command[i].undo(money,cardID);
	}
}
