package prj5;

import java.util.Scanner;
import student.IOHelper;
import java.io.File;

/**
 * // -------------------------------------------------------------------------
 * Reads the input file and creates an instance MediaStats
 * 
 * @author aanchalp
 * @version 12/6/24
 * @author Shantanu Shukla
 * @version 11-20-2024
 */

public class InputFileReader
{
    private String filename;

    /**
     * Constructs MediaStats from the input file as a string parameter
     */

    public InputFileReader(String s)
    {
        filename = s;
    }


    public DoublyLinkedList<MediaStats> readInputFile()
    {
        DoublyLinkedList<MediaStats> dll = new DoublyLinkedList<MediaStats>();
        MediaStats mst = null;
        Scanner inStream = IOHelper.createScanner(filename);
        inStream.nextLine();
        Double traditionalEngagementRateByChannel = 0.0;
        Double reachEngagementRateByChannel = 0.0;

        while (inStream.hasNextLine())
        {
            String line = inStream.nextLine().replaceAll(" ", "");
            String[] values = line.split(",");
            String month = values[0];
            String username = values[1];
            String channel = values[2];
            String country = values[3];
            String mainTopic = values[4];
            int likes = Integer.parseInt(values[5]);
            int posts = Integer.parseInt(values[6]);
            int followers = Integer.parseInt(values[7]);
            int comments = Integer.parseInt(values[8]);
            int views = Integer.parseInt(values[9]);

            mst = new MediaStats(
                month,
                username,
                channel,
                country,
                mainTopic,
                likes,
                posts,
                followers,
                comments,
                views);
            if (followers != 0)
            {
                traditionalEngagementRateByChannel =
                    ((double)(comments + likes) / followers) * 100;
            }
            else
            {
                traditionalEngagementRateByChannel = 0.0;
            }

            if (views != 0)
            {
                reachEngagementRateByChannel =
                    ((double)(comments + likes) / views) * 100;
            }

            else
            {
                reachEngagementRateByChannel = 0.0;
            }
            mst.setEngagementRate(traditionalEngagementRateByChannel);
            mst.setReachEngagementRate(reachEngagementRateByChannel);
            dll.add(mst);

        }

        inStream.close();
        return dll;
    }


    /**
     * Getter for dll sorted by channel name
     * 
     * @return sorted dll
     */
    public static DoublyLinkedList<MediaStats> sortByChannel(
        DoublyLinkedList<MediaStats> dll)
    {
        Object[] stats = dll.toArray();
        for (int i = 1; i < stats.length; i++)
        {

            MediaStats comp = (MediaStats)stats[i];

            String name = comp.getChannelName();
            int j = i - 1;
            while (j >= 0 && ((MediaStats)stats[j]).getChannelName()
                .compareToIgnoreCase(name) > 0)
            {

                MediaStats temp = comp;
                stats[j + 1] = stats[j];
                stats[j] = temp;
                j--;
            }
        }
        DoublyLinkedList<MediaStats> sorted =
            new DoublyLinkedList<MediaStats>();
        for (int i = 0; i < stats.length; i++)
        {
            sorted.add((MediaStats)stats[i]);
        }
        return sorted;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * 
     * @param s
     *            the list we want to sort
     * @return the sorted list
     */
    public static DoublyLinkedList<MediaStats> sortByTrad(
        DoublyLinkedList<MediaStats> list)
    {
        Object[] stats = list.toArray();
        TradEngagementRateComparator rate = new TradEngagementRateComparator();
        for (int i = 1; i < stats.length; i++)
        {
            MediaStats comp = (MediaStats)stats[i];
            int j = i - 1;
            while (j >= 0 && rate
                .compare((MediaStats)stats[j + 1], (MediaStats)stats[j]) > 0)
            {
                MediaStats temp = comp;
                stats[j + 1] = stats[j];
                stats[j] = temp;
                j--;
            }
        }
        DoublyLinkedList<MediaStats> sorted =
            new DoublyLinkedList<MediaStats>();
        for (int i = 0; i < stats.length; i++)
        {
            sorted.add((MediaStats)stats[i]);
        }
        return sorted;
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * 
     * @param s
     *            the list we want to sort
     * @return the sorted version of the list
     */
    public static DoublyLinkedList<MediaStats> sortByReach(
        DoublyLinkedList<MediaStats> list)
    {
        Object[] stats = list.toArray();
        ReachEngagementRateComparator rate =
            new ReachEngagementRateComparator();
        for (int i = 1; i < stats.length; i++)
        {
            MediaStats comp = (MediaStats)stats[i];
            int j = i - 1;
            while (j >= 0 && rate
                .compare((MediaStats)stats[j + 1], (MediaStats)stats[j]) > 0)
            {
                MediaStats temp = comp;
                stats[j + 1] = stats[j];
                stats[j] = temp;
                j--;
            }
        }
        DoublyLinkedList<MediaStats> sorted =
            new DoublyLinkedList<MediaStats>();
        for (int i = 0; i < stats.length; i++)
        {
            sorted.add((MediaStats)stats[i]);
        }
        return sorted;
    }


    /**
     * filter by month
     * 
     * @param month
     *            String takes month
     * @return list of data for a specific month
     */
    public static
        DoublyLinkedList<MediaStats>
        filterByMonth(String month, DoublyLinkedList<MediaStats> list)
    {
        DoublyLinkedList<MediaStats> filterList =
            new DoublyLinkedList<MediaStats>();
        Object[] obj;
        MediaStats media;
        if (!month.isEmpty() && (list.getLength() > 0))
        {

            obj = list.toArray();
            for (int i = 0; i < obj.length; i++)
            {
                media = (MediaStats)obj[i];
                if (media.getMonth().equalsIgnoreCase(month))
                {
                    filterList.add(media);
                }
            }
        }
        return filterList;
    }

}
