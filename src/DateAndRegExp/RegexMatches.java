package DateAndRegExp;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class RegexMatches {
	public static void main(String args[]){
		String line = "this order was placed for QT3000!OK?";
		String pattern = "(.*)(\\d+)(.*)";
		Pattern p = Pattern.compile(pattern);
		Matcher matcher = p.matcher(line);
		if(matcher.find()){
			System.out.println("the group count is:"+matcher.groupCount());
			System.out.println("Found value:"+matcher.group(0));
			System.out.println("Found value:"+matcher.group(1));
			System.out.println("Found value:"+matcher.group(2));
			System.out.println("Found value:"+matcher.group(3));
			//System.out.println("Found value:"+matcher.group(4)); //this will throws an IndexOutOfBoundsException
		}
		else{
			System.out.println("No matcher");
		}
		RegexMatches rm = new RegexMatches();
		rm.MatcherAndLookingAt();
		
		rm.ReplacingTheMatchedString();
		
		rm.AppendReplacement();
	}
	
	public void MatcherAndLookingAt(){
		String line = "fooooooooooooooooooooo";
		String pattern = "foo";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(line);
		//requiring the partially String has to be matched
		System.out.println("lookingAt() is:"+m.lookingAt());
		//requiring the whole String has to be matched
		System.out.println("matches() is:"+m.matches());
		
	}
	
	public void ReplacingTheMatchedString(){
		String line = "The dog says meow. "+ "All dogs say meow.";
		String pattern = "dog";
		String replacement = "cat";
		
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(line);
		line = m.replaceAll(replacement);
		System.out.println("the replaced string is:"+line);
		}
	
	public void AppendReplacement(){
		String line = "aabfooaabfooabfoob";
		String pattern = "a*b";
		String replacement = "-";
		StringBuffer sb = new StringBuffer();
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(line);
		while(m.find()){
			m.appendReplacement(sb,replacement);
		}
		m.appendTail(sb);
		System.out.println(sb.toString());
	}
}
