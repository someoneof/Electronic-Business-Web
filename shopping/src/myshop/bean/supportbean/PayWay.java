package myshop.bean.supportbean;

public enum PayWay
{
	NET{
		public String getName(){
			return "网上支付";
		}
	},
	COD{
		public String getName(){
			return "货到付款";
		}
	},
	BANKREMITTANCE{
		public String getName(){
			return "银行电汇";
		}
	},
	POSTOFFICEREMITTANCE{
		public String getName(){
			return "邮局汇款";
		}
	};
	public abstract String getName();
}
