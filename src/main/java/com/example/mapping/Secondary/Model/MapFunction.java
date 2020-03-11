package com.example.mapping.Secondary.Model;

import com.example.mapping.Error.CustomHandler;
import com.example.mapping.Primary.Model.Main;
import com.example.mapping.TelegramBot.Bot;

import java.util.List;

public class MapFunction {

    public Object update(List<MapClass> a, List<Main> b, Integer c)//, Set<String> c)
    {

        for (Main main : b) {
            if (a.get(c).getMapper().get("gender").containsKey(main.getGender()))
                main.setGender(a.get(c).getMapper().get("gender").get(main.getGender()));

            else if (a.get(c).getMapper().get("gender").containsKey("default"))
                main.setEmployment(a.get(c).getMapper().get("gender").get("default"));

            else {
                Bot.sendToTelegram("Loan request failed for id :"+a.get(c).id+" with error: "+ new CustomHandler.Error(a.get(c).getMapper().get("gender").keySet()).toString());
                //Bot.sendToTelegram("Loan request failed for id :"+a.get(c).id+" with error: "+ new CustomHandler.GenderNotFound(a.get(c).getMapper().get("gender").keySet()).toString());
                throw new CustomHandler.GenderNotFound(a.get(c).getMapper().get("gender").keySet());
            }

            if (a.get(c).getMapper().get("designation").containsKey(main.getDesignation()))
                main.setDesignation(a.get(c).getMapper().get("designation").get(main.getDesignation()));

            else if (a.get(c).getMapper().get("designation").containsKey("default"))
                main.setEmployment(a.get(c).getMapper().get("designation").get("default"));

            else {
                Bot.sendToTelegram("Loan request failed for id :"+a.get(c).id+" with error: "+new CustomHandler.Error(a.get(c).getMapper().get("designation").keySet()).toString());
                throw new CustomHandler.DesignationNotFound(a.get(c).getMapper().get("designation").keySet());
            }


            if (a.get(c).getMapper().get("employment").containsKey(main.getEmployment()))
                main.setEmployment(a.get(c).getMapper().get("employment").get(main.getEmployment()));

            else if (a.get(c).getMapper().get("employment").containsKey("default"))
                main.setEmployment(a.get(c).getMapper().get("employment").get("default"));

            else {
                Bot.sendToTelegram("Loan request failed for id :"+a.get(c).id+" with error: "+new CustomHandler.Error(a.get(c).getMapper().get("employment").keySet()).toString());
                throw new CustomHandler.EmploymentTypeNotFound(a.get(c).getMapper().get("employment").keySet());
            }
        }

        return b;
    }
}
