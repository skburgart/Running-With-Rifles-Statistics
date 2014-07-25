package com.skburgart.rwr.vo;

import com.skburgart.rwr.vo.Rank.RankType;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
public class RankNGTest {

    @Test
    public void getRankTest() {

        Assert.assertEquals(Rank.getRank(0), RankType.PRIVATE);
        Assert.assertEquals(Rank.getRank(1500), RankType.CORPORAL);
        Assert.assertEquals(Rank.getRank(6500), RankType.LIEUTENANT2);
        Assert.assertEquals(Rank.getRank(25000), RankType.COLONEL);
        Assert.assertEquals(Rank.getRank(1000000), RankType.GENERALOFTHEARMY );
    }
}
