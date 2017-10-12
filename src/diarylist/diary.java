package diarylist;

public class diary {

	
		 String date;
		 String name;
		 String text;
		 byte[] imgdata;
		//getter and setter methods

	public String getDate()
	{
		return date;
		
	}
	
	public void setDate(String date)
	{
		
		this.date = date;
		
	}
	
	public  String getName()
	{
		return name;
		
	}
	
	public void setName(String name)
	{
		this.name = name;
		
	}
		
	public String getText()
	{
		return text;
		
	}
	
	public void setText(String text)
	{
		this.text = text;
		
	}
	  public byte[] getData() {
	        return imgdata;
	    }
	 
	    public void setData(byte[] imgdata) {
	        this.imgdata = imgdata;
	    }

		
}
