//=============================================================================
// PROGRAMMER: Cristian Bencomo
// PANTHER ID: 6044774
//
// CLASS: COP3337
// SECTION: RVDC
// SEMESTER: 1205
// CLASSTIME: Online
//
// Project: Project 4
// 
// CERTIFICATION: I understand FIU’s academic policies, and I certify that this work is my 
//                own and that none of it is the work of any other person.
//=============================================================================

package app;

import analyze.DataAnalyzer;
import util.StopWatch;
import java.util.Stack;
import java.util.TreeMap;
import java.util.Map;
import java.util.Iterator;


public class Controller {

    
    public static void main(String[] args) {
        
        DataAnalyzer dataAnalyzer = new DataAnalyzer();
        
        for(int n = 1; n<=35; n++){
            
            Stack<String> stack = new Stack<>();
            StopWatch stopWatch = new StopWatch();
            
            stopWatch.start();
            
            
            int fibValue = fib(n, stack);
            
            Map <String, Integer> map = new TreeMap <String, Integer>();
            
            
            for(int i=1; i<=n; i++){
                Iterator<String> stackIterator = stack.iterator();

                    
                while(stackIterator.hasNext()){

                    String currentfib = stack.pop();
                   
                    if (!map.containsKey(currentfib) ) {
                        map.put(currentfib, 0);
                    }

                    map.put(currentfib, (map.get(currentfib)) + 1);
                    
                }
        
                
           }
            
            stopWatch.stop();
            ExecutionInfo executionInfo = new ExecutionInfo(map, n, fibValue, stopWatch.getElapsedTime());
            dataAnalyzer.getData().add(executionInfo);
 
        }
        
        for(ExecutionInfo data : dataAnalyzer.getData()) {
            data.displayInfo();
        }
        
        dataAnalyzer.findGrowthRate();

    }
    
    public static int fib(int n, Stack<String> stack){
        
        stack.push("fib(" + n + ")");
        
        
        if(n == 1 ) {
            return 1;
        }
        if(n == 2 ) {
            return 2;
        }
        
        return fib(n-1,stack) +  fib(n-2,stack);
    }
    
}
