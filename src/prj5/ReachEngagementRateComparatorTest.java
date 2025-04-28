package prj5;

// -------------------------------------------------------------------------
/**
 * The test class for the ReachEngagementRateComparator class
 * 
 * @author aanchalp
 * @version Dec 6, 2024
 */
public class ReachEngagementRateComparatorTest
    extends student.TestCase
{
    private ReachEngagementRateComparator comp;
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    /**
     * setUp comp
     */
    public void setUp()
    {
        comp = new ReachEngagementRateComparator();
    }


    /**
     * Test method for compare()
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
        o2.setReachEngagementRate(15);
        assertEquals(comp.compare(o2, o1), 1);
        o1.setReachEngagementRate(64);
        o2.setReachEngagementRate(4.3);
        assertEquals(comp.compare(o2, o1), -1);
    }
}
