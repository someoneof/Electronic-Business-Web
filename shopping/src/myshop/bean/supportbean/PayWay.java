package myshop.bean.supportbean;

public enum PayWay
{
	NET{
		public String getName(){
			return "����֧��";
		}
	},
	COD{
		public String getName(){
			return "��������";
		}
	},
	BANKREMITTANCE{
		public String getName(){
			return "���е��";
		}
	},
	POSTOFFICEREMITTANCE{
		public String getName(){
			return "�ʾֻ��";
		}
	};
	public abstract String getName();
}
