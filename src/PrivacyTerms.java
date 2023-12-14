import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PrivacyTerms {

    public int[] solution(String today, String[] terms, String[] privacies) {

        List<String> list = new ArrayList<>();

        for(int i=0; i<privacies.length; i++){
            String[] privacies_arr= privacies[i].split(" ");

            for(int j=0; j<terms.length; j++){
                String[] terms_arr = terms[j].split(" ");

                if(privacies_arr[1].equals(terms_arr[0])){
                    String returnYyMMdd=calc(today, terms_arr[1], privacies_arr[0]);
                    list.add(returnYyMMdd);
                }
            }
        }

        List<Integer> return_list = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            return_list.add(compDate(today, list, i));
        }
        return return_list.stream().mapToInt(i->i).filter(i->i!=-1).toArray();
    }


    private String calc(String today, String terms, String privacy ){

        int privacy_year = Integer.parseInt(privacy.substring(0,4));
        int privacy_month = Integer.parseInt(privacy.substring(5,7));
        int privacy_day = Integer.parseInt(privacy.substring(8,10));

        int year=privacy_year;
        int month=privacy_month;
        int day=privacy_day;

        for(int i=1; i<Integer.parseInt(terms)*28;  i++){
            day=day +1;
            if(day>28){
                month = month+1;
                day =1;
            }

            if(month>12){

                year =year+1;
                month = 1;
                day = 1;
            }
        }

        String return_day =""+day;
        String return_month=""+month;
        String return_year =""+year;

        if(day<10){
            return_day="0"+return_day;
        }

        if(month<10){
            return_month="0"+return_month;
        }
        return return_year+"."+return_month+"."+return_day;
    }

    private int  compDate(String today,  List<String >  list, int idx){

        int today_year = Integer.parseInt(today.substring(0,4));
        int today_month = Integer.parseInt(today.substring(5,7));
        int today_day = Integer.parseInt(today.substring(8,10));

        int return_year = Integer.parseInt(list.get(idx).substring(0,4));
        int return_month = Integer.parseInt(list.get(idx).substring(5,7));
        int return_day = Integer.parseInt(list.get(idx).substring(8,10));

        Date today_date = new Date(today_year,today_month,today_day);
        Date return_date = new Date(return_year, return_month, return_day);
        if(today_date.after(return_date)){
            return idx+1;
        }else {
            return -1;
        }
    }
}