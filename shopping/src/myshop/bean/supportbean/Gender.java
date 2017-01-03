package myshop.bean.supportbean;

public enum Gender
{
	
	MAN{
		public String getName(){return "ÄÐ";}
	},
	WOMAN{
		public String getName(){return "Å®";}
	};

	public abstract String getName();
}
