package cj.netos.fission.service;

import cj.netos.fission.ISnatchEnvelopeAlgorithm;
import cj.studio.ecm.annotation.CjService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@CjService(name = "snatchEnvelopeAlgorithm")
public class SnatchEnvelopeAlgorithm implements ISnatchEnvelopeAlgorithm {

    //二倍均值法
    @Override
    public long snatchEnvelopeStatic(long amount, long desiredPeopleCount) {
        int min = 1;//1分
        long upBound = amount / desiredPeopleCount * 2;
        double rand = new Random().nextDouble();
        long v = (long) ((upBound - min) * rand) + min;
        return v;
    }

    //二倍均值法
    @Override
    public long snatchEnvelopeDynamic(long averageLine, double amplitudeFactor) {
        //amplitudeFactor=0时表示振幅按均线固定[1,averageLine*2]
        //amplitudeFactor<1时表示振幅大于均值基线浮动
        //amplitudeFactor>1时表示振幅小于均值基线浮动
        //amplitudeFactor=1时表示振幅在均值基线浮动
        int min = 1;//1分，必须是一分
        averageLine = (long) (new Random().nextDouble() * amplitude(averageLine, amplitudeFactor) + baseLine(averageLine, amplitudeFactor));//100-125,200-250
        long upBound = averageLine * 2;
        double rand = new Random().nextDouble();
        long v = (long) ((upBound - min) * rand) + min;
        return v;
    }

    @Override
    //均值基线
    public long baseLine(long averageLine, double amplitudeFactor) {
        return (long) ((amplitudeFactor == 0 ? averageLine : averageLine / amplitudeFactor));
    }

    @Override
    //振幅
    public long amplitude(long averageLine, double amplitudeFactor) {
        return (long) ((averageLine * amplitudeFactor));
    }

    @Override
    //上边界，上边界大于等于当前总输入金额等同于把所有钱都放到一个红包
    public long upMaxBound(long averageLine, double amplitudeFactor) {
        return ((amplitude(averageLine, amplitudeFactor) + baseLine(averageLine, amplitudeFactor)) * 2);
    }

    @Override
    //算法1示例，固定用户数，固定金额
    public void staticAssessCount(long fixedAmount, int peopleCount) {
        long remain = fixedAmount;
        int i = 1;
        long total = 0;
        while (peopleCount > 1) {
            long amount = snatchEnvelopeStatic(remain, peopleCount);
            remain -= amount;
            total += amount;
            peopleCount--;
//            peopleCount=(int)(remain/30);
            System.out.println(String.format("%s %s", i, new BigDecimal(amount).divide(new BigDecimal(100), 2, RoundingMode.DOWN)
            ));
//            System.out.println(String.format("%s %s %s", i, new BigDecimal(amount).divide(new BigDecimal(100), 2, RoundingMode.DOWN),
//                    new BigDecimal(total).divide(new BigDecimal(100), 2, RoundingMode.DOWN)));
            i++;
        }
        //把最后一个尾单打印
        System.out.println(String.format("%s %s %s", i, new BigDecimal(remain).divide(new BigDecimal(100), 2, RoundingMode.DOWN),
                new BigDecimal(total + remain).divide(new BigDecimal("100.00"), 2, RoundingMode.DOWN)));
    }

    @Override
    //算法2示例，指定均线，指定振幅因子
    public int dynamicAssessCount(long remain, long averageLine, double amplitudeFactor) {
        int i = 1;
        long total = 0;
        while (true) {
            long amount = snatchEnvelopeDynamic(averageLine, amplitudeFactor);
            if (remain < amount) {
                break;
            }
            remain -= amount;
            total += amount;
//            System.out.println(String.format("%s %s %s", i, new BigDecimal(amount).divide(new BigDecimal(100)), new BigDecimal(total).divide(new BigDecimal(100))));
            i++;
        }
        //把最后一个尾单打印
//        System.out.println(String.format("%s %s %s", i, new BigDecimal(remain).divide(new BigDecimal(100)), new BigDecimal(total + remain).divide(new BigDecimal(100))));
        return i;
    }

    public static void main(String[] args) throws InterruptedException {
//二倍均值法

        /**
         这种算法限制是：min最小必须是1分，或0.01元，如果大于1则在随机区间会溢出。如果想限定抢红包至少多少钱，可以总金/想要的最小值，求得总人数，那么抢红包的金额就会在此均值附近游动。实际上最小值仍是1分，但效果与期望的最小致是一致的
         */
//        while (true) {

//            doubleMeanMethod(10000, 1, 334);
//            List<Integer> amountList = divideRedPackage(1, 10000, 334);
//            int i = 1;
//            int total = 0;
//            for (Integer amount : amountList) {
//                total += amount;
//                System.out.println(i + "抢到金额：" + new BigDecimal(amount).divide(new BigDecimal(100)) /*+ " 统计：" + new BigDecimal(total).divide(new BigDecimal(100))*/);
//                i++;
//            }
//            Thread.sleep(100);
//        }

        SnatchEnvelopeAlgorithm algorithm = new SnatchEnvelopeAlgorithm();
//        algorithm.staticAssessCount(10000, 234);
        long averageLine = 30;
        double amplitudeFactor = 2;
        System.out.println(String.format("边界:[0.01,%s],(%s+[0,%s])*2",
                new BigDecimal(algorithm.upMaxBound(averageLine, amplitudeFactor)).divide(new BigDecimal(100), 2, RoundingMode.DOWN),
                new BigDecimal(algorithm.baseLine(averageLine, amplitudeFactor)).divide(new BigDecimal(100), 2, RoundingMode.DOWN),
                new BigDecimal(algorithm.amplitude(averageLine, amplitudeFactor)).divide(new BigDecimal(100), 2, RoundingMode.DOWN)

        ));
//        while (true) {
//            int count=  algorithm.dynamicAssessCount(10000,averageLine,amplitudeFactor);
//            System.out.println("评估红包数："+count);
//            Thread.sleep(1000);
//        }
    }


    public static List doubleMeanMethod(int money, int min, int number) {
        List result = new ArrayList();
        if (money < 0 && number < 1)
            return null;
        int amount, sum = 0;
        int remainingNumber = number;
        int i = 1;
        while (remainingNumber > 1) {
            int max = 2 * (money / remainingNumber);
            amount = nextDouble(min, max);
            sum += amount;
            System.out.println("第" + i + "个人领取的红包金额为：" + format(amount));
            money -= amount;
            remainingNumber--;
            result.add(amount);
            i++;

        }
        result.add(money);
        System.out.println("第" + i + "个人领取的红包金额为：" + format(money));
        sum += money;
        System.out.println("验证发出的红包总金额为：" + format(sum));

        return result;
    }

    //生成min到max范围的浮点数
    public static int nextDouble(final int min, final int max) {
        Random random = new Random();
//        int s = random.nextInt(max-min)+ min;
        long s = (long) (min + ((max - min) * random.nextDouble()));
        return (int) s;
    }

    public static String format(int value) {
        return new java.text.DecimalFormat("0.00").format(value / 100.00); // 保留两位小数
    }

    // 发红包算法，金额参数以分为单位
    public static List<Integer> divideRedPackage(int min, Integer totalAmount,
                                                 Integer totalPeopleNum) {

        List<Integer> amountList = new ArrayList<Integer>();

        Integer restAmount = totalAmount;

        Integer restPeopleNum = totalPeopleNum;

        Random random = new Random();
        for (int i = 0; i < totalPeopleNum - 1; i++) {

            // 随机范围：[min，剩余人均金额的两倍)，左闭右开
            int amount = random.nextInt(restAmount / restPeopleNum * 2 - min) + min;
            restAmount -= amount;
            restPeopleNum--;
            amountList.add(amount);
        }
        amountList.add(restAmount);

        return amountList;
    }
}
