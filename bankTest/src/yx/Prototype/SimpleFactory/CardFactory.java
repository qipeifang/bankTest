package yx.Prototype.SimpleFactory;

public class CardFactory {
	public static Card produceCard(String brand,String cardID, String cardPassword,String customerID,
			String openDate,int openMoney, int balance, int isReportLoss) throws Exception
	{
		if(brand.equalsIgnoreCase("���"))
		{
			System.out.println("�����ɹ����ɴ����");
			return new Card(cardID, cardPassword, customerID, openDate, openMoney, balance, isReportLoss);
		}
		else
		{
			throw new Exception("�Բ�����ʱû�д��࿨��");
		}
	}

}
