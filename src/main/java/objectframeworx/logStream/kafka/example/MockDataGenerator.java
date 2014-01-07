package objectframeworx.logStream.kafka.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MockDataGenerator implements Serializable{
	 Random _rand;
	 
	 LinkedHashMap<String,String[]> values = new LinkedHashMap<String,String[]>();

	  
	  public MockDataGenerator(LinkedHashMap<String, String[]> values) {
		super();
		this.values = values;
	}

	  public MockDataGenerator() {
			super();
			 _rand = new Random();
			this.loadMockData();
		}
	  
	  public List<String> getFieldNames() {
		  List<String> fieldNames = new ArrayList<String>();
		  Set set = values.keySet();
		  Iterator iterator = set.iterator();
		  while (iterator.hasNext()) {
			  fieldNames.add((String) iterator.next());
		  }
		  return fieldNames;
	  }

	  public List<Object> getStream() {
		  List<Object> stream = new ArrayList();
		  Set set = values.keySet();
		  int count = 0;
		  Iterator iterator = set.iterator();
		  while (iterator.hasNext()) {
			 Object key = iterator.next();
			 Object value = this.getMockData((String) key);
			  stream.add(value);
		  }
		  return stream;
	  }
	  
	  
	  public String getCsvStream() {
		  String commaDelimitedValues = "";
		  List<Object> values = this.getStream();
		  for (Object value: values) {
			  commaDelimitedValues = commaDelimitedValues + (String) value+","; 	  
		  }
		  int lastComma = commaDelimitedValues.length()-1;
		  String s = commaDelimitedValues.substring(0, lastComma);
		  return commaDelimitedValues;
		  
	  }
	  
	  
	  public String getMockData(int anIndex) {
		  
		  Set set = this.values.keySet();
		  String[] all = (String[]) set.toArray();
		  if (all[anIndex] != null){
			  String fieldName= all[anIndex];
			  return(this.getMockData(fieldName));
		  }
	
		  return "anIndex"+"NotPresent";
	  }
	  
	  public String getMockData(String aFieldName) {
		  String[] allValues = this.values.get(aFieldName);
		  if (allValues != null) {
			  return(allValues[_rand.nextInt(allValues.length)]);
		  }
		  return "aFieldName"+"NotPresent";
	  }
	  
	  
	  
	private void loadMockData() {
		  //[0]
		  this.values.put("exportTransactionId",  
				new String[]{ "1", "2",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  //[1]
		  this.values.put("exportTimestamp",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  //[2]
		  this.values.put("exportSequenceNumber",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  //[3]
		  this.values.put("exportSiteId",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  //[4]
		  this.values.put("exportPartitionId",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  //[5]
		  this.values.put("_id",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		    // "","","","",
		  //[6]
		  this.values.put("reservationId",  
				new String[]{ "1", "2",
		        "3", "4", "5"});
		  //[7]
		  this.values.put("sequence",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  //[8]
		  this.values.put("balanceIdFrom",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  
		  //[9]
		  this.values.put("balanceIdTo",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  //       "","","",
		  //[10]
		  this.values.put("balanceFromStartingAmount",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  
		  //[11]
		  this.values.put("balanceFromEndingAmount",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  
		  //[12]
		  this.values.put("balanceToStartingAmount",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  //[13]
		  
		  //","","",",
		  this.values.put("balanceToEndingAmount",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  //[14]
		  this.values.put("accountIdFrom",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  //[15]
		  this.values.put("accountIdTo",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  //[16]
		  this.values.put("exportTransactionId",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  //[17]
		  this.values.put("bankAccountFromId",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  //[18]
		  this.values.put("exportTransactionId",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  
		  
		  //                 "","","","","",
		  
		  //[19]
		  this.values.put("bankAccountToId",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  //[20]
		  this.values.put("contractId",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  
		  //[21]
		  this.values.put("currency",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  
		  //[22]
		  this.values.put("transferAmount",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  
		  //[23]
		  this.values.put("transferTypeId",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  

	     // "","","","","",
		  //[24]
		  this.values.put("description",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  //[25]
		  this.values.put("confirmationCode",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  
		  //[26]
		  this.values.put("ipAddress",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  
		  //[27]
		  this.values.put("accountId",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  
		  //[27]
		  this.values.put("createTimestamp",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  // "","","","",
		  //[29]
		  this.values.put("updateTimestamp",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  //[30]
		  this.values.put("transferCategoryId",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  
		  //[31]
		  this.values.put("transferCategoryName",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  
		  //[32]
		  this.values.put("balanceTypeFromId",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  
		  //"","","","","engagementId"
		  //[33]
		  this.values.put("balanceTypeToId",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  
		  //[34]
		  this.values.put("balanceTypeFromName",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  //[35]
		  this.values.put("balanceTypeToName",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  
		  //[36]
		  this.values.put("context",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
		  
		  //[37]
		  this.values.put("engagementId",  
				new String[]{ "Fred", "Sam",
		        "Mary", "Homer", "Ernie","Lori","Cathy","Barbara","Sally","Trish","Bert","Jeff","Dan","Dave"});
	  	  
	  }

}
