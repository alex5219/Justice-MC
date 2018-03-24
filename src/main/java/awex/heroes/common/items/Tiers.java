package awex.heroes.common.items;

public class Tiers {
    private static final double TIER_6 = 98.5D;
    private static final double TIER_7 = 99.0D;
    private static final double TIER_8 = 99.5D;
    private static final double TIER_9 = 99.75D;
    private static final double TIER_10 = 99.99D;

    public Tiers() {
    }

    public static double getProtection(int tier) {
        return (new double[]{98.5D, 99.0D, 99.5D, 99.75D, 99.99D})[tier - 1] / 100.0D;
    }
}
