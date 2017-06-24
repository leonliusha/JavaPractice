package Practise;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface PopSinger{
	void singASong(String songName);
	void goHome();
}

class Singer implements PopSinger{
	public void singASong(String songName){
		System.out.println("Start sing "+songName);
	}
	public void goHome(){
		System.out.println("Take a car go home");
	}
}

class AgentJob implements InvocationHandler{
	private Object singer;
	
	public AgentJob(Object singer){
		this.singer = singer;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		if(method.getName().equalsIgnoreCase("singASong")){
			System.out.println("Agent got an arrangement for concert in Shanghai");
			method.invoke(singer, args);
			System.out.println("Agent get money for concert");
		}
		if(method.getName().equalsIgnoreCase("goHome")){
			System.out.println("Agent book a car");
			method.invoke(singer, args);
		}
		return null;
	}
	
	
}

public class SingerAgentProxyTest {
	public static void main(String args[]){
	PopSinger singerAgent = (PopSinger)Proxy.newProxyInstance(PopSinger.class.getClassLoader(), 
													new Class[]{PopSinger.class}, 
													new AgentJob(new Singer()));
	singerAgent.singASong("Umbrella");
	singerAgent.goHome();
	}
	
}
