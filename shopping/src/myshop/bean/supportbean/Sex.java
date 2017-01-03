package myshop.bean.supportbean;

public enum Sex
{
	MAN{
		public String getName(){return "男";}
	},
	WOMAN{
		public String getName(){return "女";}
	},
	NONE{
		public String getName(){return "男女不限";}
	};
	public abstract String getName();

}
