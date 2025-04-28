package prj5;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * // -------------------------------------------------------------------------
 * Runs the program, calls all the necessary classes and functions to display
 * GUI
 * 
 * @author aanchalp
 * @version 12/4/24
 */

public class ProjectRunner
{

    /**
     * Main method that calls InputFileReader and returns data to the console
     */

    public static void main(String[] args)
        throws IOException
    {
        InputFileReader filer;
        String filename;
        boolean showConsole = true;
        boolean showGUI = true;
        Double[] traditionalEngagementRateByChannel = { 0.0, 0.0, 0.0, 0.0 };
        Double[] reachEngagementRateByChannel = { 0.0, 0.0, 0.0, 0.0 };
        int[] comments = { 0, 0, 0, 0 };
        int[] likes = { 0, 0, 0, 0 };
        int[] views = { 0, 0, 0, 0 };
        int[] followers = { 0, 0, 0, 0 };
        int[] posts = { 0, 0, 0, 0 };
        MediaStats chQtr1Stats;
        DoublyLinkedList<MediaStats> stats;

        if (args.length > 0)
        {
            filename = args[0];
        }
        else
        {
            filename = "SampleInput1_2023.csv";
        }

        filer = new InputFileReader(filename);
        stats = filer.readInputFile();

        if (showConsole)
        {
            DoublyLinkedList<MediaStats> ams =
                new DoublyLinkedList<MediaStats>();
            ams = filer.sortByChannel(stats);
            String[] channelName = new String[4];
            int j = 0;

            if (!ams.isEmpty())
            {
                channelName[0] = ams.getEntry(0).getChannelName();
            }

            for (int i = 0; i < ams.getLength(); i++)
            {
                if (ams.getEntry(i).getChannelName()
                    .equalsIgnoreCase(channelName[j]))
                {
                    if (ams.getEntry(i).getMonth().equalsIgnoreCase("january")
                        || ams.getEntry(i).getMonth()
                            .equalsIgnoreCase("february")
                        || ams.getEntry(i).getMonth().equalsIgnoreCase("march"))
                    {
                        comments[j] += ams.getEntry(i).getComments();
                        likes[j] += ams.getEntry(i).getLikes();
                        views[j] += ams.getEntry(i).getViews();
                        posts[j] += ams.getEntry(i).getPosts();
                    }

                    if (ams.getEntry(i).getMonth().equalsIgnoreCase("march"))
                    {
                        followers[j] = (int)ams.getEntry(i).getFollowers();
                    }
                }

                else
                {
                    if (followers[j] != 0)
                    {
                        traditionalEngagementRateByChannel[j] =
                            ((double)(comments[j] + likes[j]) / followers[j])
                                * 100;
                    }
                    else
                    {
                        traditionalEngagementRateByChannel[j] = 0.0;
                    }

                    if (views[j] != 0)
                    {
                        reachEngagementRateByChannel[j] =
                            ((double)(comments[j] + likes[j]) / views[j]) * 100;
                    }

                    else
                    {
                        reachEngagementRateByChannel[j] = 0.0;
                    }

                    chQtr1Stats = new MediaStats(
                        "Q1",
                        "",
                        channelName[j],
                        "",
                        "",
                        likes[j],
                        posts[j],
                        followers[j],
                        comments[j],
                        views[j]);

                    chQtr1Stats.setEngagementRate(
                        traditionalEngagementRateByChannel[j]);
                    chQtr1Stats.setReachEngagementRate(
                        reachEngagementRateByChannel[j]);

                    stats.add(chQtr1Stats);

                    j++;
                    channelName[j] = ams.getEntry(i).getChannelName();
                    comments[j] += ams.getEntry(i).getComments();
                    likes[j] += ams.getEntry(i).getLikes();
                    views[j] += ams.getEntry(i).getViews();

                }
            }

            if (followers[j] != 0)
            {
                traditionalEngagementRateByChannel[j] =
                    ((double)(comments[j] + likes[j]) / followers[j]) * 100;
            }
            else
            {
                traditionalEngagementRateByChannel[j] = 0.0;
            }

            if (views[j] != 0)
            {
                reachEngagementRateByChannel[j] =
                    ((double)(comments[j] + likes[j]) / views[j]) * 100;
            }

            else
            {
                reachEngagementRateByChannel[j] = 0.0;
            }

            chQtr1Stats = new MediaStats(
                "Q1",
                "",
                channelName[j],
                "",
                "",
                likes[j],
                posts[j],
                followers[j],
                comments[j],
                views[j]);

            chQtr1Stats
                .setEngagementRate(traditionalEngagementRateByChannel[j]);
            chQtr1Stats.setReachEngagementRate(reachEngagementRateByChannel[j]);

            stats.add(chQtr1Stats);

        }

        if (showGUI)
        {

            GUIwindow window = new GUIwindow(stats);

        }
    }
}
