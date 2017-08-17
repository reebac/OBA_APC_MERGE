package OBA_APC_MERGE;

import org.json.simple.JSONObject;

public class mergeProcess
{
	@SuppressWarnings("unchecked")
	public static JSONObject mergeData(JSONObject Ob1, JSONObject Ob2) 
	{
		Ob2.putAll(Ob1);
	//	System.out.print(Ob2);;
		return Ob2;
	}
}