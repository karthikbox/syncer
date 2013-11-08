import java.io.IOException;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import java.util.regex.*;

public class Driver{

	public Document connect(){
		Document doc=null;
		try{
			doc=Jsoup.connect("http://172.16.100.125/bits-cms").get();
			//System.out.println(doc.title());
		}
		catch(IOException e){
			e.printStackTrace();
			System.exit(0);
		}
		return doc;
		

	}
	public String getCourseLink(String courseName){
		
	}

	public static void main(String...x){
		Driver key = new Driver();
		Document doc=key.connect();
		Elements links = doc.select("a[href]");
		for(Element link:links){
			System.out.println("\nlink : " + link.attr("abs:href"));
			System.out.println("text : " + link.text());
			if(link.text().matches("IS F311(.*)")){
				System.out.println("is f311 found");
				break;
			}
			/*
			Pattern pattern=Pattern.compile("IS F311(.*)",Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(link.text());
			if(matcher.groupCount()==0){
				//error
				System.out.println("no pattern matched");
			}
			else{
				System.out.println(matcher.group());
				break;
			}*/
		}
	
	}


}
