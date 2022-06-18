package UseCases;

import Entities.User.Admin;
import Entities.User.Customer;
import Entities.User.User;
import Entities.User.UserTracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Load {

    public Load(BufferedReader br) throws IOException, ParseException {
        String line;
        while((line = br.readLine())!= null) {
            User newuser = lineToUser(line);
            UserTracker.addUser(newuser);
        }
    }

    public User lineToUser(String line) throws ParseException {
        User newuser;
        String [] userinfo = line.split(",");
        if (userinfo[9].equals("true")){
            newuser = new Admin(userinfo[0], userinfo[1], Integer.parseInt(userinfo[2]),
                    Integer.parseInt(userinfo[3]), Integer.parseInt(userinfo[4]), userinfo[5],
                    Boolean.parseBoolean(userinfo[6]));
        } else {
            newuser = new Customer(userinfo[0], userinfo[1], Integer.parseInt(userinfo[2]),
                    Integer.parseInt(userinfo[3]), Integer.parseInt(userinfo[4]), userinfo[5],
                    Boolean.parseBoolean(userinfo[6]));
        }
        newuser.changeAddress(userinfo[7]);
        String[] previousdates = userinfo[8].split("\\|");
        newuser.setDateList(loginDatesReader(previousdates));
        return newuser;
    }
    public List<Date> loginDatesReader(String[] previousdates) throws ParseException {
        List<Date> datelist = new ArrayList<>();
        for(String str: previousdates){
            Date d = new SimpleDateFormat("dd/MM/yyyy").parse(str);
            datelist.add(d);
        }
        return datelist;
    }
}
