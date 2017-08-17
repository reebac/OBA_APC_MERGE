package OBA_APC_MERGE;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class obacontroller
{
	 @RequestMapping("/opaapc")
	 @ResponseBody
	 public static String opaapc () 
	 {
		String res=null;
		JSONParser parser = new JSONParser();  
		try 
		{
			Object obj1 = parser.parse(new FileReader("/home/reeba/Documents/workspace-sts-3.9.0.RELEASE/demo/src/test/resource/obazmq_sample.json"));
			Object obj2 = parser.parse(new FileReader("/home/reeba/Documents/workspace-sts-3.9.0.RELEASE/demo/src/test/resource/apc_sample.json"));
			JSONObject jsonObject1 = (JSONObject) obj1;
			JSONObject jsonObject2 = (JSONObject) obj2;
			System.out.println(jsonObject1);
			System.out.println(jsonObject2);
			if(obj1 != null )
			{
				JSONObject result = mergeProcess.mergeData(jsonObject1, jsonObject2);
				System.out.println("Merged JSON: " +result);
				res = result.toJSONString();
				System.out.println(res); 
			}
 	
		}
 	   	catch (FileNotFoundException e) {
 	         e.printStackTrace();
 	 		} catch (IOException e) {
 	         e.printStackTrace();
 	 		} catch (ParseException e) {
 	         e.printStackTrace();
 	 		}  
		return (res);
	 }
}