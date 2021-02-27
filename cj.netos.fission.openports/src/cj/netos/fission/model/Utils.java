package cj.netos.fission.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    private static final double EARTH_RADIUS = 6371393; // 平均半径,单位：m

    /**
     * 通过AB点经纬度获取距离
     *
     * @param pointA A点(经，纬)
     * @param pointB B点(经，纬)
     * @return 距离(单位 ： 米)
     */
    public static double getDistance(LatLng pointA, LatLng pointB) {
        // 经纬度（角度）转弧度。弧度用作参数，以调用Math.cos和Math.sin
        double radiansAX = Math.toRadians(pointA.longitude()); // A经弧度
        double radiansAY = Math.toRadians(pointA.latitude()); // A纬弧度
        double radiansBX = Math.toRadians(pointB.longitude()); // B经弧度
        double radiansBY = Math.toRadians(pointB.latitude()); // B纬弧度

        // 公式中“cosβ1cosβ2cos（α1-α2）+sinβ1sinβ2”的部分，得到∠AOB的cos值
        double cos = Math.cos(radiansAY) * Math.cos(radiansBY) * Math.cos(radiansAX - radiansBX)
                + Math.sin(radiansAY) * Math.sin(radiansBY);
//        System.out.println("cos = " + cos); // 值域[-1,1]
        double acos = Math.acos(cos); // 反余弦值
//        System.out.println("acos = " + acos); // 值域[0,π]
//        System.out.println("∠AOB = " + Math.toDegrees(acos)); // 球心角 值域[0,180]
        return EARTH_RADIUS * acos; // 最终结果
    }

    public static String parseDateTime(String time) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        Date date = format.parse(time);
        SimpleDateFormat format1 = new SimpleDateFormat("MM月dd日 HH:mm:ss");
        return format1.format(date);
    }
    public static String timeToStr(long time){
        Date date=new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return format.format(date);
    }
}
