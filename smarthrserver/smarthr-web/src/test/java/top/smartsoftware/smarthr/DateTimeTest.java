package top.smartsoftware.smarthr;

import top.smartsoftware.smarthr.utils.ToolDateTime;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * @Author xjx
 * @Date 2020-12-04
 */
public class DateTimeTest {


    public static void main(String[] args) {
        SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
        SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
        DecimalFormat decimalFormat = new DecimalFormat("##.00");
        Date beginContract = ToolDateTime.StringToDate("2018-01-01");
        Date endContract = ToolDateTime.StringToDate("2023-04-13");
        double month = (Double.parseDouble(yearFormat.format(endContract)) - Double.parseDouble(yearFormat.format(beginContract))) * 12 + (Double.parseDouble(monthFormat.format(endContract)) - Double.parseDouble(monthFormat.format(beginContract)));
        System.out.println(Double.parseDouble(decimalFormat.format(month / 12)));

        String between = ToolDateTime.getBetween(beginContract, endContract);
        System.out.println(between);
        Double day = new Double(1928/365);
        System.out.println(day);
    }
}
