package projet;

import java.awt.Toolkit;

import com.sinch.xms.ApiConnection;
import com.sinch.xms.SinchSMSApi;
import com.sinch.xms.api.MtBatchTextSmsResult;

public class SMSSender {

	
	public int send(String number,String message) {
		 try (ApiConnection conn =
			        ApiConnection.builder().servicePlanId("7adcbd47c36b4e6585048ad06f01bf11").token("4248ff654eb9437cb6c6c02386ec9dad").start()) {
			      // Sending a simple Text Message
			      MtBatchTextSmsResult batch =
			          conn.createBatch(
			              SinchSMSApi.batchTextSms()
			                  .sender("+447537454593")
			                  .addRecipient(number)
			                  .body(message)
			                  .build());
               
			      System.out.println("Successfully sent batch " + batch.id());
			      Toolkit.getDefaultToolkit().beep();
			      return 1;
			      
			    } catch (Exception e) {    
			      System.out.println("Batch send failed: " + e.getMessage());
			      return 0;
			    }
		 
	 }

}
