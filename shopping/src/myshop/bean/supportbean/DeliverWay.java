package myshop.bean.supportbean;

public enum DeliverWay
{
	GENERALPOST{
		public String getName(){
			return "ƽ��";
		}
	},
	EXPRESSDELIVERY{
		public String getName(){
			return "����ͻ�����";
		}
	},
	EXIGENCEEXPRESSDELIVERY{
		public String getName(){
			return "�Ӽ�����ͻ�����";
		}
	},
	EMS{
		public String getName(){
			return "�����ؿ�ר��EMS";
		}
	};
	public abstract String getName();
}
