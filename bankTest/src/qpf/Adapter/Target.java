package qpf.Adapter;

import java.sql.SQLException;

/**Target��Ŀ������ࣩ��Ŀ������ඨ��ͻ�����ӿڣ�
 * ������һ���������ӿڣ�Ҳ�����Ǿ����ࡣ
 */
//����һ��Ŀ��ӿ�
public interface Target {
	//void request();

	void request(String cardID, String cardPassword) throws SQLException;
}
