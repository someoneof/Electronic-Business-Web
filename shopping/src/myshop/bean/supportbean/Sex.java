package myshop.bean.supportbean;

public enum Sex
{
	MAN{
		public String getName(){return "��";}
	},
	WOMAN{
		public String getName(){return "Ů";}
	},
	NONE{
		public String getName(){return "��Ů����";}
	};
	public abstract String getName();

}
