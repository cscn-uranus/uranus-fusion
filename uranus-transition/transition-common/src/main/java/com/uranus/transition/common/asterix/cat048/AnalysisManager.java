package com.uranus.transition.common.asterix.cat048;


import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 2019/3/31.
 */
@Component
public class AnalysisManager {


    public List<Object> readSMode(){
        List<Object> cats = new ArrayList<>();

        String filePath = "C:\\Users\\PC\\Desktop\\modeS\\20190315.rad29";
        File file = new File(filePath);
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader(file));
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
        String line = "";
        String everyLine = "";
            String code = "";
            byte[] value = new byte[100];
        try {
            while ((line = br.readLine()) != null) // 读取到的内容给line变量
            {
                cat48DTO cat48 = new cat48DTO();
                cat34DTO cat34 = new cat34DTO();
                everyLine = line;
                String[] item = everyLine.split(" ");
                code = item[1].trim().substring(4,item[1].trim().length());
                String fspecCode = "";
                String cat = code.substring(0,2);
                String fspec = code.substring(6,8);
                String s = ByteUtil.f(fspec);
                int i = 0 ;
                while(s.charAt(s.length()-1) == '1'){
                    s = ByteUtil.f(code.substring(8+i,10+i));
                    fspec += code.substring(8+i,10+i);
                    i = i+2;
                }
                fspecCode = ByteUtil.f(fspec);
                String catBehindfspec = code.substring(8+i,code.length());
                if(cat.equals("22")){
                    cats.add(ByteUtil.analysisFrom34FSPEC(fspecCode,catBehindfspec,cat34));
                }
                if(cat.equals("30")){
                    cats.add(ByteUtil.analysisFrom48FSPEC(fspecCode,catBehindfspec,cat48)) ;
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return cats;

    }


}
