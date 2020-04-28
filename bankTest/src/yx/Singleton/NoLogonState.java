package yx.Singleton;

import yx.Builder.Test2;
import yx.Prototype.SimpleFactory.Test3;

public class NoLogonState extends LoginState {
	public NoLogonState(Login log) {
		this.log = log;
	}

	public NoLogonState(LoginState ls) {
		this.log = ls.log;
	}
	
	public void optCard() throws Exception {
		System.out.println("δ��¼������ѡ�����п���");
	}

	public void exit() {
		System.out.println("δ��¼�������˳���¼��");
		stateCheck();
	}

	public void activateCard() throws Exception {
		Test3.cjcard();
	}

	public void post() throws Exception {
		Test2.zhuce();
	}
	
	public void stateCheck()
	{
		if(log != null)
		{
			log.setState(new LogonState(this));
		}
	}

}
