package com.skburgart.rwr.vo;

/**
 *
 * @author Steven Burgart <skburgart@gmail.com>
 */
public class Rank {

    public enum RankType {

        PRIVATE(0, "Private"),
        PRIVATE1ST(500, "Private 1st Class"),
        CORPORAL(1000, "Corporal"),
        SERGEANT(2000, "Sergeant"),
        STAFFSERGEANT(3000, "Staff Sergeant"),
        STAFFSERGEANT1ST(4000, "Staff Sergeant 1st Class"),
        LIEUTENANT2(6000, "2nd Lieutenant"),
        LIEUTENANT(8000, "Lieutenant"),
        CAPTAIN(10000, "Captain"),
        MAJOR(12000, "Major"),
        LIEUTENANTCOLONEL(14000, "Lieutenant Colonel"),
        COLONEL(20000, "Colonel"),
        BRIGADIERGERNAL(30000, "Brigadier General"),
        MAJORGENERAL(50000, "Major General"),
        LIEUTENANTGERNERAL(100000, "Lieutenant General"),
        GENERAL(200000, "General"),
        GENERALOFTHEARMY(500000, "General of the Army");

        private final int xp;
        private final String title;

        private RankType(int xp, String title) {
            this.xp = xp;
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    public static RankType getRank(int xp) {
        for (int i = RankType.values().length - 1; i >= 0; --i) {
            RankType r = RankType.values()[i];
            if (xp >= r.xp) {
                return r;
            }
        }

        return null;
    }
}
