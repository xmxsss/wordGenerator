package net.antra.wordGenerator.service;

import net.antra.wordGenerator.po.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class wordGeneratorService {
    public Results results=new Results();
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if(digits==null) return ans;
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for(int i =0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i){
                String t = ans.remove();
                for(char s : mapping[x].toCharArray())
                    ans.add(t+s);
            }
        }
        results.setResults(ans);
        return ans;
    }
    public List<String> letterPage(int page){
        List<String> total=results.getResults();
        List<String> newList = new ArrayList<String>();
        for(int i=(page-1)*10*5;i<total.size()&&i<page*10*5;i++){
            newList.add(total.get(i));
        }
        return newList;
    }
    public int totalPage(String digits){
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int total= 1;
        map.put(0,1);
        map.put(1,1);
        map.put(2,3);
        map.put(3,3);
        map.put(4,3);
        map.put(5,3);
        map.put(6,3);
        map.put(7,4);
        map.put(8,3);
        map.put(9,4);
        for(int i=0;i<digits.length();i++){
            total*= map.get(digits.charAt(i)-'0');
        }
        return total%50==0?total/50:total/50+1;
    }
}
