package yx.Singleton;

public abstract class LoginState {
	protected Login log;
	
	public abstract void optCard() throws Exception;//选择银行卡
	public abstract void exit();//退出
	public abstract void activateCard() throws Exception;//开卡
	public abstract void post() throws Exception;//注册
	public abstract void stateCheck();

}
