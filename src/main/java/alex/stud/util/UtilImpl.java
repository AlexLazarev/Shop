package alex.stud.util;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class UtilImpl implements Util {


    @Override
    public Date formatDate(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

}
