package yx.Prototype.SimpleFactory;

public class CardFactory {
	public static Card produceCard(String brand,String cardID, String cardPassword,String customerID,
			String openDate,int openMoney, int balance, int isReportLoss) throws Exception
	{
		if(brand.equalsIgnoreCase("储蓄卡"))
		{
			System.out.println("工厂成功生成储蓄卡！");
			return new Card(cardID, cardPassword, customerID, openDate, openMoney, balance, isReportLoss);
		}
		else
		{
			throw new Exception("对不起，暂时没有此类卡！");
		}
	}

}
