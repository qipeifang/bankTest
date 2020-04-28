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
		System.out.println("已退出登录。");
		stateCheck();
	}

	public void activateCard() {
		System.out.println("已登录，不可以开卡。");
	}

	public void post() {
		System.out.println("已登录，不可注册");
	}
	
	public void stateCheck()
	{
		if(log == null)
		{
			log.setState(new NoLogonState(this));
		}
	}

}
