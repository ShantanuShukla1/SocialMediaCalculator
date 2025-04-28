package prj5;

import java.util.Comparator;

// -------------------------------------------------------------------------
/**
 * comparator for traditional engagement rate sorting
 * 
 * @author jackw
 * @version Dec 4, 2024
 */
public class TradEngagementRateComparator
    implements Comparator<MediaStats>
{
    // ----------------------------------------------------------
    /**
     * Constructor
     */
    public TradEngagementRateComparator()
    {
        super();
    }


    @Override
    public int compare(MediaStats o1, MediaStats o2)
    {
        if (o1.getEngagementRate() - o2.getEngagementRate() > 0)
        {
            return 1;
        }
        else if (o1.getEngagementRate() - o2.getEngagementRate() == 0)
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
