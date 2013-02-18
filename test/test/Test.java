package test;

import love.cq.domain.Forest;
import love.cq.domain.Value;
import love.cq.library.Library;
import love.cq.splitWord.GetWord;

public class Test {
	public static void main(String[] args) {
		Forest forest = new Forest() ;
		Library.insertWord(forest,"AA") ;
		Library.insertWord(forest, "bb") ;
		
		GetWord gw = new GetWord(forest, "aa bb AA BB") ;
		String temp = null ;
		while((temp=gw.getFrontWords())!=null)
			System.out.println(temp);
		
	}
}
