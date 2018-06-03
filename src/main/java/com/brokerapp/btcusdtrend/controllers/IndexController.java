package com.brokerapp.btcusdtrend.controllers;


import com.brokerapp.btcusdtrend.ResponseObject;
import com.brokerapp.btcusdtrend.ResponseObjectManipulators;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.print.attribute.standard.Media;
import java.util.*;

@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping(path = {"/index","/"},method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView index(Model model)
    {
        //System.out.println(resulBt);
        return new ModelAndView("index");
    }
    @RequestMapping(path="/chart",method = RequestMethod.POST)
    public ResponseEntity<Map<String,Map<String,String>>> chart(@RequestParam("startDate") String startDate, @RequestParam("currencies[]") ArrayList<String> currencies, @RequestParam("granularity") String granularity)
    {
        Map<String,Map<String, String>> map = new LinkedHashMap<>();
        List<ResponseObject> data = new ArrayList<>();
        System.out.println(startDate+" "+currencies.toString());

        String basicURL = "https://apiv2.bitcoinaverage.com/indices/global/history/";
        for(String currency : currencies)
        {
            String specificURL = basicURL;
            specificURL += currency;
            specificURL += "?";
            specificURL += "period=alltime";
            specificURL += "&?";
            specificURL += "format=json";
            RestTemplate restTemplate = new RestTemplate();
            data = Arrays.asList( restTemplate.getForObject(specificURL,ResponseObject[].class));
            map.put(currency,ResponseObjectManipulators.filterList(data,startDate, granularity));
        }
        return new ResponseEntity(map,HttpStatus.OK);
    }

}
