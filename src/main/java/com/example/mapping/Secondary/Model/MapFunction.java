package com.example.mapping.Secondary.Model;

import com.example.mapping.Error.DesignationNotFound;
import com.example.mapping.Error.GenderNotFound;
import com.example.mapping.Primary.Model.Main;

import java.util.List;

public class MapFunction {

    public List<Main> update(List<MapClass> a, List<Main> b, Integer c)//, Set<String> c)
    {

        for (Main main : b) {
                if (a.get(c).getMapper().get("gender").containsKey(main.getGender()))
                    main.setGender(a.get(c).getMapper().get("gender").get(main.getGender()));

                else
                    throw new GenderNotFound(a.get(c).getMapper().get("gender").keySet());


                if (a.get(c).getMapper().get("designation").containsKey(main.getDesignation()))
                    main.setDesignation(a.get(c).getMapper().get("designation").get(main.getDesignation()));

                else
                    throw new DesignationNotFound(a.get(c).getMapper().get("designation").keySet());

                if (a.get(c).getMapper().get("employment").containsKey(main.getEmployment()))
                    main.setEmployment(a.get(c).getMapper().get("employment").get(main.getEmployment()));

                else
                    main.setEmployment(a.get(c).getMapper().get("employment").get("default"));;
        }

        return b;
    }
}
