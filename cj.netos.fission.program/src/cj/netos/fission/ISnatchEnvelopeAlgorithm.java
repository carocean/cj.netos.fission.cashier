package cj.netos.fission;

public interface ISnatchEnvelopeAlgorithm {
    long snatchEnvelopeStatic(long amount, long desiredPeopleCount);
    /**
     * 动态计算金额<br>
     * @param averageLine 均线，单位为分。当amplitudeFactor=0时remainder/averageLine=预估红包个数<br>
     * @param amplitudeFactor 振幅因子，并不等同于振幅，用于调整每个红包的最大上限<br>
     */
    long snatchEnvelopeDynamic(long averageLine, double amplitudeFactor);

    //均值基线
    long baseLine(long averageLine, double amplitudeFactor);

    //振幅
    long amplitude(long averageLine, double amplitudeFactor);

    //上边界，上边界大于等于当前总输入金额等同于把所有钱都放到一个红包
    long upMaxBound(long averageLine, double amplitudeFactor);

    /**
     *  算法1示例，固定用户数，固定金额
     */
    void staticAssessCount(long fixedAmount, int peopleCount);

    /**
     * 算法2示例，指定均线，指定振幅因子<br>
     * @param remainder 剩余金额
     * @param averageLine 均线，单位为分。当amplitudeFactor=0时remainder/averageLine=预估红包个数<br>
     * @param amplitudeFactor 振幅因子，并不等同于振幅，用于调整每个红包的最大上限<br>
     *
     */
    int dynamicAssessCount(long remainder, long averageLine, double amplitudeFactor);
}
