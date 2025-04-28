package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * This is the comparator class
 * 
 * @author jackw
 * @version Dec 4, 2024
 */
public class ReachEngagementRateComparator
    implements Comparator<MediaStats>
{
    /**
     * constructor for this class
     */
    public ReachEngagementRateComparator()
    {
        super();
    }


    @Override
    public int compare(MediaStats o1, MediaStats o2)
    {
        if (o1.getReachEngagementRate() - o2.getReachEngagementRate() > 0)
        {
            return 1;
        }
        else if (o1.getReachEngagementRate() - o2.getReachEngagementRate() == 0)
        {
            return 0;
        }
        else
        {
            return -1;
        }
    }
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................

}
