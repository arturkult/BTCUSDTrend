package com.brokerapp.btcusdtrend;

import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import org.springframework.cglib.core.Local;
import org.thymeleaf.expression.Lists;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class ResponseObjectManipulators {
    public static Map<String,String> filterList(List<ResponseObject> list,String startDate,String granularity)
    {
        Collections.reverse(list);
        LocalDate date = LocalDate.parse(startDate);
        Map<String,String> result= new LinkedHashMap<>();
        LocalDateTime currDate;
        boolean add = false;
        for(ResponseObject object : list)
        {
            currDate = LocalDateTime.parse(object.getTime(),dateFormatter);
            if(!currDate.toLocalDate().isBefore(date))
            {
                switch(granularity)
                {

                    case "monthly":
                        add = (currDate.getDayOfMonth() == currDate.toLocalDate().lengthOfMonth());
                        break;
                    case "weekly":
                        add = currDate.getDayOfWeek() == DayOfWeek.SUNDAY;
                        break;
                    case "daily":
                        add = (currDate.getHour() == 0 && currDate.getMinute() == 0);
                        break;

                }
                if(add)
                    result.put(object.getTime(),object.getAverage().toString());
            }

        }
        return result;
    }

    public static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
}
