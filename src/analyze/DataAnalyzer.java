package analyze;

import app.ExecutionInfo;
import java.util.ArrayList;

public class DataAnalyzer {
    
    private ArrayList<ExecutionInfo> data; 

    public DataAnalyzer() {
        
        data = new ArrayList<>();
    }

    public ArrayList<ExecutionInfo> getData() {
        return data;
    }
    
    public void findGrowthRate(){
          System.out.println("");
          
         System.out.println("-------------------------------------------------");
         System.out.println("Data Analyzer Growth Rate");
         System.out.println("-------------------------------------------------");
         
         
        for(int i=0; i < data.size(); i++) {
            double exponent = Math.log(data.get(i).getTotalMethodCalls());
            
            System.out.printf("%-7s %-10d %-10s %-15d %-7s %-15.0f %-10s %-15.3f", "Index:", data.get(i).getFibIndex() , "FibValue:", data.get(i).getFibValue(), "Calls:", data.get(i).getTotalMethodCalls(), "Exponent:", exponent);
            System.out.println();
        }
    }
    
}
