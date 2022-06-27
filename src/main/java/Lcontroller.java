
import dev.izqalan.myukm.models.LibraryModel;


public class Lcontroller {

	String[] data;
	String [] Columnname;
	String query;
	String[] shortcolumn;

	LibraryModel LM = new LibraryModel();
	
	
	void setshortC()
	{
		shortcolumn = LM.ShortColumn;
		
	}
	
	String[] returnshortC()
	{
		setshortC();
		return shortcolumn;
		
	}
	void setquery(String Vquery)
	{
		query=Vquery;
	}
	
	String getquery(String Vquery)
	{
		setquery(Vquery);
		return query;
	}
	void setCname()
	{	
		Columnname=LM.columnNames;
	}
	
	String[] getCname()
	{
		setCname();
		return Columnname;
	}
	
	String[] getdata()
	{
	return data;	
	}

	void setdata()
	{
	data=LM.data;	
	}
	
	void setdata2()
	{
		data=LM.data2;
	}
	
	void setdata3()
	{
		data=LM.data3;
	}
	void setdata4()
	{
		data=LM.data4;
	}
	void setdata5()
	{
		data=LM.data5;
	}
	void setdata6()
	{
		data=LM.data6;
	}
	void setdata7()
	{
		data=LM.data7;
	}
	void setdata8()
	{
		data=LM.data8;
	}
	void setdata9()
	{
		data=LM.data9;
	}
	void setdata10()
	{
		data=LM.data10;
	}
	void setdata11()
	{
		data=LM.data11;
	}
	void setdata12()
	{
		data=LM.data12;
	}
	
}//end of class


