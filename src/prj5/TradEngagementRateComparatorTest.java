package prj5;

// -------------------------------------------------------------------------
/**
 * This is the test class for the TradEngagementRateComparator class
 * 
 * @author aanchalp
 * @version Dec 6, 2024
 */
public class TradEngagementRateComparatorTest
    extends student.TestCase
{
    // ~ Fields ................................................................
    private TradEngagementRateComparator comp;

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

    /**
     * setUp comp
     */
    public void setUp()
    {
        comp = new TradEngagementRateComparator();
    }


    /**
     * Test for the compare method
     */
    public void testCompare()
    {
        MediaStats o1 = new MediaStats(
            "March",
            "Aanchal",
            "channel1",
            "France",
            "Dogs",
            592,
            683,
            928,
            384,
            592);
        MediaStats o2 = new MediaStats(
            "March",
            "Aanchal",
            "channel1",
            "France",
            "Dogs",
            592,
            683,
            928,
            384,
            592);
        assertEquals(comp.compare(o1, o2), 0);
        o2.setEngagementRate(15);
        assertEquals(comp.compare(o2, o1), 1);
        o1.setEngagementRate(64);
        o2.setEngagementRate(4.3);
        assertEquals(comp.compare(o2, o1), -1);
    }
}
