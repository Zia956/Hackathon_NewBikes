package MiniProject;

import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException, InterruptedException
	 {
		EnquiryOfBuildingProject test = new EnquiryOfBuildingProject();
		for (int i=0; i<2; i++) 
		{
			if(i==0) 
			{
				test.createEdgeDriver();
			}else 
			{
				test.createChromeDriver();
			}
		 test.livepop();
		 test.maximize();
		 test.complete();
		 test.scroll();
		 test.count();
		 test.first5();
		 test.contactusvalidation();
		 test.scrolltocontact();
		 test.printemail();
	 
	}
	 }
}
