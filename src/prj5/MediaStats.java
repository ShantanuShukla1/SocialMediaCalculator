package prj5;

import java.text.DecimalFormat;

/**
 * // -------------------------------------------------------------------------
 * /** Class that represents a social media influencer's statistics per month
 * 
 * @author Shantanu Shukla
 * @version 11-18-2024
 */

public class MediaStats
{
    private String month;
    private String userName;
    private String channelName;
    private String country;
    private String mainTopic;
    private double likes;
    private double posts;
    private double followers;
    private double comments;
    private double views;
    private double engagementRate;
    private double reachEngagementRate;

    /**
     * Constructor to create social media object
     * 
     * @param m
     *            Month of stats being analyzed
     * @param un
     *            User of influencer
     * @param cn
     *            Influencer's channel name
     * @param cou
     *            Country influencer is from
     * @param mt
     *            Main topic that influencer covers
     * @param l
     *            Total likes received in given month
     * @param p
     *            Number of posts influencer has in given month
     * @param f
     *            Number of followers
     * @param com
     *            Total comments received in given month
     * @param v
     *            Total views recieved in given month
     */

    public MediaStats(
        String m,
        String un,
        String cn,
        String cou,
        String mt,
        int l,
        int p,
        int f,
        int com,
        int v)
    {
        month = m;
        userName = un;
        channelName = cn;
        country = cou;
        mainTopic = mt;
        likes = l;
        posts = p;
        followers = f;
        comments = com;
        views = v;
        DecimalFormat df = new DecimalFormat("#.#");
        engagementRate = 0;
        reachEngagementRate = 0;
    }


    /**
     * Method that returns month
     * 
     * @return month Month being focused on
     */

    public String getMonth()
    {
        return month;
    }


    /**
     * Method that returns userName
     * 
     * @return userName userName of influencer
     */

    public String getUserName()
    {
        return userName;
    }


    /**
     * Method that returns channelName
     * 
     * @return channelName Influencer's channel's name
     */

    public String getChannelName()
    {
        return channelName;
    }


    /**
     * Method that returns country
     * 
     * @return country country that the influencer is from
     */

    public String getCountry()
    {
        return country;
    }


    /**
     * Method that returns mainTopic
     * 
     * @return mainTopic main topic that the influencer covers
     */

    public String getMainTopic()
    {
        return mainTopic;
    }


    /**
     * Method that returns number of likes
     * 
     * @return likes likes the influencer got this month as an int
     */

    public double getLikes()
    {
        return likes;
    }


    /**
     * Method that returns number of posts
     * 
     * @return posts posts the influencer posted this month as an int
     */

    public double getPosts()
    {
        return posts;
    }


    /**
     * Method that returns number of followers
     * 
     * @return followers followers the influencer gained this month as an int
     */

    public double getFollowers()
    {
        return followers;
    }


    /**
     * Method that returns number of comments
     * 
     * @return comments comments the influencer got this month as an int
     */

    public double getComments()
    {
        return comments;
    }


    /**
     * Method that returns number of views
     * 
     * @return views views the influencer got this month as an int
     */

    public double getViews()
    {
        return views;
    }


    // ----------------------------------------------------------
    /**
     * Sets the EngagementRate of the MediaStats Object
     * 
     * @param e
     *            the engagement rate to be set
     */
    public void setEngagementRate(double e)
    {
        engagementRate = e;
    }


    // ----------------------------------------------------------
    /**
     * Sets the reach engagement rate
     * 
     * @param e
     *            the engagement rate to be set
     */
    public void setReachEngagementRate(double e)
    {
        reachEngagementRate = e;
    }


    // ----------------------------------------------------------
    /**
     * Returns the EngagementRate.
     * 
     * @return the EngagementRate
     */
    public double getEngagementRate()
    {
        return engagementRate;
    }


    // ----------------------------------------------------------
    /**
     * Returns the reachEngagementRate.
     * 
     * @return the reachEngagementRate
     */
    public double getReachEngagementRate()
    {
        return reachEngagementRate;
    }


    /**
     * Converts SocialMediaInfluencer object in string representation
     * 
     * @return s All components of influencer in a string
     */

    public String toString()
    {
        String s = month + " " + userName + " " + channelName + " " + country
            + " " + mainTopic + " " + likes + " " + posts + " " + followers
            + " " + comments + " " + views;
        return s;
    }


    /**
     * Compares two objects to see if they have all same components
     * 
     * @param obj
     *            Object being compared against
     * @return true if the objects are equal, otherwise false
     */

    public boolean equals(Object obj)
    {
        if (obj == null || this.getClass() != obj.getClass())
        {
            return false;
        }
        if (this == obj)
        {
            return true;
        }
        return this.toString().equals(obj.toString());
    }


    /**
     * Compares two objects to see which obj has a greater engagement rate
     * 
     * @param other
     *            Object being compared against
     * @return positive if this has greater engagement rate
     */

    public int compareTo(MediaStats other)
    {
        return Double
            .compare(this.getEngagementRate(), other.getEngagementRate());
    }


    /**
     * Compares two objects to see which obj has a greater reach engagement rate
     * 
     * @param other
     *            Object being compared against
     * @return positive if this has greater engagement rate
     */

    public int compareToReach(MediaStats other)
    {
        return Double.compare(
            this.getReachEngagementRate(),
            other.getReachEngagementRate());
    }
}
