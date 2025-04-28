package prj5;

import student.TestCase;

/**
 * // -------------------------------------------------------------------------
 * /** Class to test SocialMediaInfluencer
 * 
 * @author aanchalp
 * @version 12/6/24
 * @author Shantanu Shukla
 * @version 11-18-2024
 */

public class MediaStatsTest
    extends TestCase
{
    private MediaStats sMI;
    private MediaStats wrongSMI;
    private MediaStats rightSMI;
    private String e;

    /**
     * Sets up SMI object for testing
     */

    public void setUp()
    {
        sMI = new MediaStats(
            "January",
            "aafootball",
            "allaboutfootball",
            "ES",
            "Sports",
            22876452,
            333,
            4650272,
            518,
            170095);
        wrongSMI = new MediaStats(
            "January",
            "aafootball",
            "allaboutfootball",
            "ES",
            "Sports",
            422876452,
            333,
            4650272,
            518,
            170095);
        rightSMI = new MediaStats(
            "January",
            "aafootball",
            "allaboutfootball",
            "ES",
            "Sports",
            22876452,
            333,
            4650272,
            518,
            170095);
        e = "";
    }


    /**
     * Tests the getMonth() method
     */

    public void testGetMonth()
    {
        assertEquals("January", sMI.getMonth());
    }


    /**
     * Tests the getUserName() method
     */

    public void testGetUserName()
    {
        assertEquals("aafootball", sMI.getUserName());
    }


    /**
     * Tests the getChannelName() method
     */

    public void testGetChannelName()
    {
        assertEquals("allaboutfootball", sMI.getChannelName());
    }


    /**
     * Tests the getCountry() method
     */

    public void testGetCountry()
    {
        assertEquals("ES", sMI.getCountry());
    }


    /**
     * Tests the getMainTopic() method
     */

    public void testGetMainTopic()
    {
        assertEquals("Sports", sMI.getMainTopic());
    }


    /**
     * Tests the getLikes() method
     */

    public void testGetLikes()
    {
        assertEquals(22876452, sMI.getLikes(), 0.1);
    }


    /**
     * Tests the getPosts() method
     */

    public void testGetPosts()
    {
        assertEquals(333, sMI.getPosts(), 0.1);
    }


    /**
     * Tests the getFollowers() method
     */

    public void testGetFollowers()
    {
        assertEquals(4650272, sMI.getFollowers(), 0.1);
    }


    /**
     * Tests the getComments() method
     */

    public void testGetComments()
    {
        assertEquals(518, sMI.getComments(), 0.1);
    }


    /**
     * Tests the getViews() method
     */

    public void testGetViews()
    {
        assertEquals(170095, sMI.getViews(), 0.1);
    }


    /**
     * Tests the setEngagementRate() method
     */

    public void testSetEngagementRate()
    {
        sMI.setEngagementRate(4);
        assertEquals(4, sMI.getEngagementRate(), 0.1);
    }


    /**
     * Tests the getEngagementRate() method
     */

    public void testGetEngagementRate()
    {
        assertEquals(0.0, sMI.getEngagementRate(), 0.1);
    }


    /**
     * Tests the getReachEngagementRate() method
     */

    public void testGetReachEngagementRate()
    {
        assertEquals(0.0, sMI.getReachEngagementRate(), 0.1);
    }


    /**
     * Tests the setReachEngagementRate() method
     */

    public void testSetReachEngagementRate()
    {
        sMI.setReachEngagementRate(2.0);
        assertEquals(2.0, sMI.getReachEngagementRate(), 0.1);
    }


    /**
     * Tests the toString() method
     */

    public void testToString()
    {
        assertEquals(
            "January aafootball allaboutfootball ES Sports 2.2876452E7 "
                + "333.0 4650272.0 518.0 170095.0",
            sMI.toString());
    }


    /**
     * Tests the equals() method
     */

    public void testEquals()
    {
        assertFalse(sMI.equals(null));
        assertFalse(sMI.equals(e));
        assertTrue(sMI.equals(sMI));
        assertFalse(sMI.equals(wrongSMI));
        assertTrue(sMI.equals(rightSMI));
    }


    /**
     * Tests the compareTo() method
     */

    public void testCompareTo()
    {
        assertEquals(0, sMI.compareTo(rightSMI));
    }
    
    /**
     * Tests the compareToReach() method
     */
    public void testCompareToReach()
    {
        assertEquals(0, sMI.compareToReach(rightSMI));
    }
}
