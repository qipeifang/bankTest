package yx.Singleton;

import yx.Test4;

public class LogonState extends LoginState {
	public LogonState(Login log) {
		this.log = log;
	}

	public LogonState(LoginState ls) {
		this.log = ls.log;
	}
	
	public void optCard() throws Exception {
		Test4.choosesCard();
	}

	public void exit() {
		System.exit(0);
		System.out.println("���˳���¼��");
		stateCheck();
	}

	public void activateCard() {
		System.out.println("�ѵ�¼�������Կ�����");
	}

	public void post() {
		System.out.println("�ѵ�¼������ע��");
	}
	
	public void stateCheck()
	{
		if(log == null)
		{
			log.setState(new NoLogonState(this));
		}
	}

}
