package yx.Singleton;

public abstract class LoginState {
	protected Login log;
	
	public abstract void optCard() throws Exception;//ѡ�����п�
	public abstract void exit();//�˳�
	public abstract void activateCard() throws Exception;//����
	public abstract void post() throws Exception;//ע��
	public abstract void stateCheck();

}
