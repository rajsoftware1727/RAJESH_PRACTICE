package UTILITIES;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {
	
	public static Object getData(String key) throws IOException
	{
		String path=System.getProperty("user.dir")+"//PropertyFile//PropertyFileData";
		FileInputStream fi=new FileInputStream(path);
		Properties p=new Properties();
		p.load(fi);
		return p.get(key);
	}

}
