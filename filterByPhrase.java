
/**
 * Write a description of filterByPhrase here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class filterByPhrase {
    public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData,String where,String phrase){
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe:quakeData){
            if(satisfies(qe,where,phrase)){
                answer.add(qe);
            }
        }
        return answer;
    }
    
    public void quakesByPhrase(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list1 = parser.read(source);
        System.out.println("# quakes read: " + list1.size()); 
        ArrayList<QuakeEntry> listOut=filterByPhrase(list1,"end","Alaska");
        for(QuakeEntry qe:listOut){
            System.out.println(qe);            
        }
        System.out.println("# quakes found: " + listOut.size());
    }
    
    public boolean satisfies(QuakeEntry qe,String where,String phrase){
        if(where.equals("start")){
                return qe.getInfo().startsWith(phrase);
        }
        if(where.equals("any")){
                return qe.getInfo().contains(phrase);
        }
        if(where.equals("end")){
                return qe.getInfo().endsWith(phrase);
        }
        return false;
    }
}

