package qpf.Adapter;

import java.sql.SQLException;

/**Target（目标抽象类）：目标抽象类定义客户所需接口，
 * 可以是一个抽象类或接口，也可以是具体类。
 */
//定义一个目标接口
public interface Target {
	//void request();

	void request(String cardID, String cardPassword) throws SQLException;
}
